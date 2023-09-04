package carShare;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class CarService {
	
	private Map<String, Parking> parkings = new HashMap<>();
	private Map<String, Car> cars = new HashMap<>();
	private Map<String, Subscriber> subscribers = new HashMap<>();
	private List<Reserve> reserves = new LinkedList<>();
	public enum Status {AVAILABLE, BOOKED, DELIVERED, TERMINATED};
	private List<String> charges = new LinkedList<>();
	 
	public void addParking(String name) throws InvalidName{
		
		if(parkings.containsKey(name)) throw new InvalidName();
		
		Parking parking = new Parking(name);
		
		parkings.put(name, parking);
		
	}

	public void addCar(String parking, String licencePlate, double minRate, double kmRate) throws InvalidName{
		
		if(parkings.containsKey(parking)==false) throw new InvalidName();
		if(cars.containsKey(licencePlate)) throw new InvalidName();
		
		Car car = new Car(parkings.get(parking), licencePlate, minRate, kmRate);
		parkings.get(parking).newCar(car);
		
		cars.put(licencePlate, car);
		
	}
		
	public SortedSet<String> getAvailableCars(String parking) throws InvalidName{
		
		if(parkings.containsKey(parking)==false) throw new InvalidName();
		
		return parkings.get(parking).getAvaibleCars();
		
	}
	
	public void addSubscriber(String card) throws InvalidName{
		
		if(subscribers.containsKey(card)) throw new InvalidName();
		
		Subscriber subscriber = new Subscriber(card);
		
		subscribers.put(card, subscriber);
		
	}
	
	public List<String> getSubscribers(){
		return subscribers.values().stream().sorted(Comparator.comparing(Subscriber::getCard)).map(Subscriber::getCard).collect(Collectors.toList());
	}
	
	public String reserve(String card, String parking) throws InvalidName{
		
		if(subscribers.containsKey(card)==false) throw new InvalidName();
		if(parkings.containsKey(parking)==false) throw new InvalidName();
		
		if(subscribers.get(card).getReserve()!=null) return null;
		
		String plate =  parkings.get(parking).getFirstAvaibleCar();
		if(plate==null) return null;
		Car car = cars.get( plate );
		
		car.setStatus(Status.BOOKED);
		
		Reserve reserve = new Reserve(subscribers.get(card), parkings.get(parking), car);
		car.newReserve(reserve);
		subscribers.get(card).setReserve(reserve);
		parkings.get(parking).newReserve(reserve);
		reserves.add(reserve);
		return plate;
	}
	
	public String release(String card, String plate) throws InvalidName{
		
		if(subscribers.containsKey(card)==false) throw new InvalidName();
		if(cars.containsKey(plate)==false) throw new InvalidName();
		
		for(Reserve reserve: reserves) {
			if( reserve.getCar().getLicencePlate().equals(plate) && reserve.getSubscriber().getCard().equals(card) ) {
				cars.get(plate).setStatus(Status.AVAILABLE);
				reserve.getParking().deleteReserve(reserve);
				cars.get(plate).deleteReserve(reserve);
				subscribers.get(card).setReserve(null);
				reserves.remove(reserve);
				return plate;
			}
		}
		
		return null;
	}
	
	public Set<String> getReserved(String parking) throws InvalidName{
		
		if(parkings.containsKey(parking)==false) throw new InvalidName();

		
		List<String> res = parkings.get(parking).getReserves().stream().sorted(Comparator.comparing(Reserve::getLicensePlateCar)).map(Reserve::getLicensePlateCar).collect(Collectors.toList());
	
		Set<String> sortedSet = new TreeSet<>(res);
		
		return sortedSet;
	}
	
	public String useCar(String card, String plate) throws InvalidName{
		
		if(subscribers.containsKey(card)==false) throw new InvalidName();
		if(cars.containsKey(plate)==false) throw new InvalidName();
		
		for(Reserve reserve: reserves) {
			if( reserve.getCar().getLicencePlate().equals(plate) && reserve.getSubscriber().getCard().equals(card) ) {
				
				cars.get(plate).setStatus(Status.DELIVERED);
				reserve.getParking().deleteReserve(reserve);
				reserve.getParking().deleteCar(cars.get(plate));
				return plate;
			}
		}
		
		return null;
	}
	
	public String terminate(String card, String plate, String parking, int min, int km) throws InvalidName{
	
		if(subscribers.containsKey(card)==false) throw new InvalidName();
		if(parkings.containsKey(parking)==false) throw new InvalidName();
		
		for(Reserve reserve: reserves) {

			if( reserve.getCar().getLicencePlate().equals(plate) && reserve.getSubscriber().getCard().equals(card) ) {
				
				this.release(card, plate);
				
				parkings.get(parking).newCar(cars.get(plate));
				reserve.setEndParking(parkings.get(parking));
				double amount = min * cars.get(plate).getMinRate() + km * cars.get(plate).getKmRate();
				
				reserve.setAmount(amount);
				
				charges.add(reserve.toString());
				return reserve.toString();
			}
			
		}
		return null;
	}

	public List<String> charges() {
		return charges.stream().sorted((str1, str2) -> {
											            String[] parts1 = str1.split(":");
											            String[] parts2 = str2.split(":");
											            
											            double value1 = Double.parseDouble(parts1[2]);
											            double value2 = Double.parseDouble(parts2[2]);
											
											            if (value1 != value2) {
											                return Double.compare(value2, value1); // Sort by value in discending order
											            }
											            return parts1[0].compareTo(parts2[0]); // If values are equal, sort by name in alphabetical order
											        })
				.collect(Collectors.toList());
				
			
	}
		
	public List<String> subscriberCharges(String card) throws InvalidName{
		
		if(!subscribers.containsKey(card)) throw new InvalidName();
		
 		return charges.stream().filter(c->c.split(":")[0].equals(card)).collect(Collectors.toList());
	}
	
	public double averageCharge() {
		return charges.stream()
				.mapToDouble(c->Double.parseDouble(c.split(":")[2]))
				.average().orElse(0.0)
				;
	}
	
	public long departuresFrom(String parking) throws InvalidName{
		
		if(parkings.containsKey(parking)==false) throw new InvalidName();
		
		return charges.stream()
				.filter( c -> c.split(":")[3].equals(parking) )
				.count();
	}
}
