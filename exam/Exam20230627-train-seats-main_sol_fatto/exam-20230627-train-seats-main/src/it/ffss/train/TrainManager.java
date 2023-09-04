package it.ffss.train;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TrainManager {

//R1
	Set<String> classes=new TreeSet<>();
	Map<String,Car> cars=new TreeMap<>();
	private List<String> stops=new LinkedList<>();
	private Map<String,Booking> books=new TreeMap<>();
	/**
	 * add a set of travel classes to the list of classes
	 * offered in the train.
	 * Method can be invoked multiple times.
	 * Possible duplicates are ignored.
	 * 
	 * @param classes the classes
	 */
	public void addClasses(String... classes) {
		for(String c: classes)
			this.classes.add(c);
	}

	/**
	 * retrieves the list of classes defined for the train
	 * 
	 * @return list of classes
	 */
	public Collection<String> getClasses() {
		return classes;
	}
	
	/**
	 * adds a new car to train
	 * The car has a unique id, a given number of rows
	 * and for each row the seats go from 'A' to the {@code lastSeat}
	 * 
	 * @param id		unique id of car
	 * @param rows		name of car
	 * @param lastSeat	lastLetter of car
	 * @param klass 	class of the car
	 * @return number of available seats on the train car
	 * @throws TrainException in case of duplicate id or non-existing class
	 */
	public int addCar(String id, int rows, char lastSeat, String klass) throws TrainException {
		if (!classes.contains(klass))
			throw new TrainException("no class");
		if(cars.containsKey(id))
			throw new TrainException("duplicate id");
		int availableSeats=rows*(Character.getNumericValue(lastSeat)-Character.getNumericValue('A')+1);
		
		cars.put(id, new Car(id,rows,lastSeat,klass,availableSeats));
		return availableSeats;
	}

	/**
	 * retrieves the list of cars with the given class
	 * 
	 * @param klass required class
	 * @return the list of car ids
	 */
	public Collection<String> getCarsByClass(String klass) {
		return cars.values().stream().filter((el)->{
			if(klass.equals(el.getKlass()))
				return true;
			return false;
			}).map(Car::getId).collect(Collectors.toList());
	}

	/**
	 * retrieves the number of seats in the car with the given code
	 * 
	 * @param id id of the car 
	 * @return number of seats
	 */
	public int getNumSeats(String id) {
		if(cars.containsKey(id))
			return cars.get(id).getAvailableSeats();
		return 0;
	}

	/**
	 * Define the stop stations for a train.
	 * Stops define the segments that are the part of the
	 * train path between two consecutive stops. 
	 * 
	 * @param stops		stops of the train
	 * @return the number of segments defined
	 */
	public int defineStops(String... stops) {
		for(String s:stops)
			this.stops.add(s);
		return stops.length-1;
	}
	
	/**
	 * retrieves the available seats on a given trip from source to destination.
	 * The returned map contains an entry for each car that has seats
	 * available for the specific class and in all the segments from begin to end.
	 * The map contains a list of seats "#X", where # is the row number and X is the seat
	 * e.g. "8A" is the seat in row 8 position A.
	 * The method return only the available seats (i.e. those that are not booked)
	 * 
	 * @param begin		initial stop
	 * @param end		final stop
	 * @param klass 	car class
	 * @return the available seats by car
	 */
	public Map<String, List<String>> findSeats(String begin, String end, String klass) {
		List <Car> l=cars.values().stream().filter((el)->{
			if(el.getKlass().equals(klass))
				return true;
			return false;
		}).collect(Collectors.toList());
		//map((el)->{return el.getSeats().entrySet();}).flatMap(Stream::of).
		int i=0;
		boolean trovato;
		Map<String, List<String>> ret =new TreeMap<>();
		for(Car c: l)
		{
			
			for(Entry<String,List<Integer>> b:c.getSeats().entrySet())
			{
				trovato=true;
				for(i=stops.indexOf(begin); i<stops.indexOf(end);i++)
				{
					if(b.getValue().contains(i))
						trovato=false;
				}
				if(trovato &&  ret.containsKey(c.getId()))
				{
					List<String> lll=ret.get(c.getId());
					lll.add(b.getKey());
				}else if(trovato)
				{
					List<String> lll=new ArrayList<>();
					lll.add(b.getKey());
					ret.put(c.getId(), lll);
				}
			}
			
				
		}
		return ret;
	}

	/**
	 * Book a seat for a person from begin station to end station
	 * on a given car
	 * 
	 * @param ssn		SSN of the passenger
	 * @param name		name of the passenger
	 * @param surname	surname of the passenger
	 * @param begin		initial stop
	 * @param end		final stop
	 * @param car		car id
	 * @param seat		seat number
	 * @return a unique booking code
	 * @throws TrainException in case the car or seat are not valid,
	 * 						  the stops are not valid, 
	 * 						  or the seat is not available for all the segments of the trip
	 */
	public String bookSeat(String ssn, String name, String surname, 
						   String begin, String end, String car, String seat) throws TrainException {
		if (!cars.containsKey(car))
			throw new TrainException("no car");
		
		if(!stops.contains(begin) || !stops.contains(end) || stops.indexOf(end)<=stops.indexOf(begin))
			throw new TrainException();
		Car c=cars.get(car);
		if(!c.getSeats().containsKey(seat))
			throw new TrainException();
		
		List<Integer> bookedStops=c.getSeats().get(seat);
		boolean trovato=true;
		int i;
		for(i=stops.indexOf(begin); i<stops.indexOf(end);i++)
		{
			if(bookedStops.contains(i))
				trovato=false;
		}
		if(!trovato)
			throw new TrainException("already booked");
		String s=String.valueOf(books.size());
		books.put(s, new Booking(s,ssn,name,surname,begin,end,car,seat,c.getKlass()));
		c.book(seat,stops.indexOf(begin),stops.indexOf(end));
		return s;
	}

	/**
	 * retrieves the car of a given booking
	 * 
	 * @param booking 	id of booking
	 * @return car id
	 */
	public String getBookingCar(String booking) {
		return books.get(booking).getCar();
	}

	/**
	 * retrieves the SSN of the booked person
	 * 
	 * @param bookingID id of booking
	 * @return  booked person's SSN
	 */
	public String getBookingPassenger(String bookingID) {
		return books.get(bookingID).getSsn();
	}

	/**
	 * retrieves the seat for a booking
	 * 
	 * @param bookingID id of booking
	 * @return the seat
	 */
	public String getBookingSeat(String bookingID) {
		return books.get(bookingID).getSeat();
	}

	/**
	 * retrieves the trip for a booking.
	 * A trip is described as the initial and final stop, separated by a "-",
	 * e.g. "Turin-Milan"
	 * 
	 * @param bookingID id of booking
	 * @return trip
	 */
	public String getBookingTrip(String bookingID) {
		String b=books.get(bookingID).getBegin();
		String e=books.get(bookingID).getEnd();
		String ret="";
		int i;
		for(i=stops.indexOf(b); i<stops.indexOf(e);i++)
		{
			ret+=stops.get(i)+"-";
		}
		ret+=e;
		return ret;
	}

	/**
	 * retrieves the list bookings for a given seat.
	 * Bookings are reported as string with the format "begin-end:SSN"
	 * 
	 * @param car car id
	 * @param seat seat
	 * @return list of bookings
	 */
	public Collection<String> listBookings(String car, String seat) {
		return books.values().stream().filter((el)->{
			if(el.getCar().equals(car)&& el.getSeat().equals(seat))
				return true;
			else
				return false;
		}).map((el)->{
			return el.getBegin()+"-"+el.getEnd()+":"+el.getSsn();
		}).collect(Collectors.toList());
	}

	/**
	 * Define the last station the train stopped at.
	 * this information will be used to understand which bookings
	 * are valid for a seat.
	 * 
	 * @param stop name of the latest stop
	 * @return the number of total people booked on the train after the stop
	 */
	String lastStop;
	public int setLastStop(String stop) {
		lastStop=stop;
		int indexStop=stops.indexOf(stop);
		
		Long l= books.values().stream().filter((el)->{
			if(stops.indexOf(el.getEnd())>indexStop &&indexStop>=stops.indexOf(el.getBegin()))
					return true;
			return false;
		}).count();
		
		return l.intValue();
	}


	/**
	 * check the booking id of a given seat.
	 * It takes into consideration the last stop, for a given
	 * seat the booking starting at or before the last stop
	 * and not yet terminated is considered.
	 * Returns null if no such booking is available.
	 * Mark the specific booking as checked.
	 * 
	 * @param car	id of the car
	 * @param seat 	seat code
	 * @return booking id
	 */
	public String checkSeat(String car, String seat) {
		int indexStop=stops.indexOf(lastStop);
		
		List<String> sid=books.values().stream().filter((el)->{
			if(stops.indexOf(el.getEnd())>indexStop &&indexStop>=stops.indexOf(el.getBegin()) && el.getSeat().equals(seat))
					return true;
			return false;
		}).map(Booking::getID).collect(Collectors.toList());
		if(sid.size()>0)
		{
			books.get(sid.get(0)).mark();
			return sid.get(0);
		}
		return null;
	}


	/**
	 * computes the fill ratio for all the seat of the given class.
	 * It is computed dividing the number of seats (of the class in any car)
	 * that have at least a booking, by the number of seats (of the class in any car)
	 *  
	 * @param klass		class
	 * @return	fill ratio
	 */
	public double showFillRatio(String klass) {
		long booked=books.values().stream().filter((el)->{
			if(el.getKlass().equals(klass))
				return true;
			return false;
		}).map((el)->{
			return el.getCar()+el.getSeat();
		}).distinct().count();
		
		long total=cars.values().stream().filter((el)->{
			if(el.getKlass().equals(klass))
				return true;
			return false;
		}).collect(Collectors.summingInt(Car::getAvailableSeats));
		
		return (double)booked/total;
	}

	/**
	 * computes the check count per class.
	 * The result map reports, for each class, the number of
	 * booking that have been checked.
	 *
	 * @return the map class : check count
	 */
	public Map<String, Long> checkCoverage() {
		Map<String, Long> m=new TreeMap<>();
		for(String cls: cars.values().stream().map(Car::getKlass).distinct().collect(Collectors.toList())) {
			m.put(cls, (long)0);
		}
		Long l;
		for(Booking b:books.values())
		{
			if(b.isMarked())
			{
				l=m.get(b.getKlass())+1;
				m.put(b.getKlass(),l);
			}
		}
		
		return	m;
		//books.values().stream().filter(Booking::isMarked).collect(Collectors.groupingBy(Booking::getKlass,Collectors.counting()));
		
		//return null;
	}

	/**
	 * computes the occupation ratio for all the seat of the given class and for each segment of the train path.
	 * It is computed dividing the number of seats occupied in each segment by 
	 * the number of seats multiplied by number of segments.
	 * This method is similar to {@link #showFillRatio} but consider all the slots represented by
	 * a seat in a given segment (path between two consecutive stops), the result is the proportion
	 * of slots covered by a booking (divided per class).
	 *  
	 * @param klass		class
	 * @return	occupation ratio
	 */
	public double showOccupationRatio(String klass) {
		long booked=books.values().stream().filter((el)->{
			if(el.getKlass().equals(klass))
				return true;
			return false;
		}).collect(Collectors.summingInt((el)->{
			
			return stops.indexOf(el.getEnd())-stops.indexOf(el.getBegin());
		}));
				
				
		long total=cars.values().stream().filter((el)->{
			if(el.getKlass().equals(klass))
				return true;
			return false;
		}).collect(Collectors.summingInt(Car::getAvailableSeats));
		
		total*=(stops.size()-1);
		
		return (double)booked/total;
	}

}
