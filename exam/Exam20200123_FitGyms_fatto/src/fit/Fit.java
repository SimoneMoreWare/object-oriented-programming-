package fit;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;


public class Fit {
    
    public static int MONDAY    = 1;
    public static int TUESDAY   = 2;
    public static int WEDNESDAY = 3;
    public static int THURSDAY  = 4;
    public static int FRIDAY    = 5;
    public static int SATURDAY  = 6;
    public static int SUNDAY    = 7;
    
    private HashMap<String,Gym> gyms = new HashMap<>();
    private List<Instructor> instructors = new LinkedList<>();
    private int idCustomer = 1;
    private HashMap<Integer,Customer> customers = new HashMap<>();
    private List<Reservation> reservations = new LinkedList<>();
	// R1 
	
	public void addGymn (String name) throws FitException {
		if(gyms.get(name)!=null) throw new FitException();
		Gym gym = new Gym(name);
		gyms.put(name, gym);
	}
	
	public int getNumGymns() {
		return gyms.size();
	}
	
	//R2

	public void addLessons (String gymnname, 
	                        String activity, 
	                        int maxattendees, 
	                        String slots, 
	                        String ...allowedinstructors) throws FitException{
		
		if(gyms.get(gymnname)==null) throw new FitException();
		
		Gym gym = gyms.get(gymnname);
		String slotsSplit[] = slots.split(",");
		for(String slotSplit: slotsSplit) {
			
			String splitDayAndHour[] = slotSplit.split("\\.");
						
			int day = Integer.parseInt(splitDayAndHour[0]);
			int startHour = Integer.parseInt(splitDayAndHour[1]);
			
			if(day<1 || day>7) throw new FitException();
			if(startHour<8 || startHour>20) throw new FitException();
			
			
			String sh = "";
			String eh = "";
			
			int endHour = startHour + 1;
			
			if(startHour<10) sh = "0" + startHour;
			else sh = sh + startHour;
			if(endHour<10) eh = "0" + endHour;
			else eh = eh + endHour;
			
			sh = sh + ":00";
			eh = eh + ":00";
			
			//controllo slot liberi
			if(gym.slotIsFree(sh,eh,day)==false) throw new FitException();
			
			Lesson lesson = new Lesson(gym, activity, maxattendees, sh, eh, day);
			
			for(String allowedinstructor: allowedinstructors) {
				Instructor instructor = new Instructor(allowedinstructor);
				instructors.add(instructor);
				lesson.newInstructor(instructor);
				
			}
			
			gym.newLesson(lesson);
			
		}

	    
	}
	
	//R3
	public int addCustomer(String name) {
		
		Customer customer = new Customer(name, idCustomer);
		customers.put(idCustomer, customer);
		
		return idCustomer++;
	}
	
	public String getCustomer (int customerid) throws FitException{
		
		if(customerid>idCustomer) throw new FitException();
		
	    return customers.get(customerid).getName();
	}
	
	//R4
	
	public void placeReservation(int customerid, String gymnname, int day, int slot) throws FitException{
		
		if(customerid>idCustomer) throw new FitException();
		if(gyms.get(gymnname)==null) throw new FitException();
		//controllo slot liberi
		String sh = "";
		String eh = "";
		int endHour = slot + 1;
		if(slot<10) sh = "0" + slot;
		else sh = sh + slot;
		if(endHour<10) eh = "0" + endHour;
		else eh = eh + endHour;
		sh = sh + ":00";
		eh = eh + ":00";
		if(gyms.get(gymnname).getLesson(sh,eh,day)==null) throw new FitException();
		//il cliente è già registrato alla lezione.
		Lesson lesson = gyms.get(gymnname).getLesson(sh,eh,day);
		if(lesson.customerInLesson(customers.get(customerid))==true) throw new FitException();
		//non ci sono ancora posti liberi nella lezione
		if(lesson.getCustomersSize() + 1 > lesson.getMaxattendees()) throw new FitException();
		
		Reservation reservation = new Reservation(customers.get(customerid), gyms.get(gymnname), day, sh, eh, lesson);
		
		reservations.add(reservation);
		customers.get(customerid).newReservation(reservation);
		lesson.newCustomer(customers.get(customerid));
		customers.get(customerid).newGym(gyms.get(gymnname));
		

	}
	
	public int getNumLessons(int customerid) {
		return customers.get(customerid).getReservationsSize();
	}
	
	
	//R5
	
	public void addLessonGiven (String gymnname, int day, int slot, String instructor) throws FitException{
		
		if(gyms.get(gymnname)==null) throw new FitException("a");
		String sh = "";
		String eh = "";
		int endHour = slot + 1;
		if(slot<10) sh = "0" + slot;
		else sh = sh + slot;
		if(endHour<10) eh = "0" + endHour;
		else eh = eh + endHour;
		sh = sh + ":00";
		eh = eh + ":00";
		if(gyms.get(gymnname).getLesson(sh,eh,day)==null) throw new FitException("b");
		
		Lesson lesson = gyms.get(gymnname).getLesson(sh,eh,day);

		Instructor ins = null;
		for(Instructor i: instructors) {
			if(i.getName().equals(instructor)) {
				ins = i;
				break;
			}
		}
		
		if(lesson.instructorInLesson(ins)==false) throw new FitException("c");
		
		ins.newLessonGiven(lesson);

	}
	
	public int getNumLessonsGiven (String gymnname, String instructor) throws FitException {
		
		if(gyms.get(gymnname)==null) throw new FitException();
		
		Instructor ins = null;
		for(Instructor i: instructors) {
			if(i.getName().equals(instructor)) {
				ins = i;
				break;
			}
		}
		
		return ins.getNumLessonGiven(gymnname);
	}
	//R6
	
	public String mostActiveGymn() {
		return gyms.values().stream().max(Comparator.comparing(Gym::getNumLessons)).map(Gym::getName).orElse(null);
	}
	
	public Map<String, Integer> totalLessonsPerGymn() {		
		return gyms.values().stream().collect(Collectors.toMap(Gym::getName,Gym::getNumLessons,(g1,g2)->g1,HashMap::new));
	}
	
	public SortedMap<Integer, List<String>> slotsPerNofParticipants(String gymnname) throws FitException{
	    
		List<Lesson> lessons = new LinkedList<>();
		
		lessons = gyms.get(gymnname).getLessons();
		
		return lessons.stream().
				collect(Collectors.toMap(Lesson::toString,Lesson::getCustomersSize,(g1,g2)->g1,HashMap::new)).
				entrySet().stream().
				collect(Collectors.groupingBy( Map.Entry::getValue , ()->new TreeMap<Integer, List<String>>(),  Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
				;
	}
	

	
	
	
	


}
