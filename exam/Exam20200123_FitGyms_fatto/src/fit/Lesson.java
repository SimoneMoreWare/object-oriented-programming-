package fit;

import java.util.LinkedList;
import java.util.List;

public class Lesson {
	
	private Gym gym;
	private String activity;
	private int maxattendees;
	private String startHour;
	private String endHour;
	private int day;
	private List<Instructor> instructors = new LinkedList<>();
	private List<Customer> customers = new LinkedList<>();
	
	public Lesson(Gym gym, String activity, int maxattendees, String startHour, String endHour, int day) {
		super();
		this.gym = gym;
		this.activity = activity;
		this.maxattendees = maxattendees;
		this.startHour = startHour;
		this.endHour = endHour;
		this.day = day;
	}

	public Gym getGym() {
		return gym;
	}

	public void setGym(Gym gym) {
		this.gym = gym;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public int getMaxattendees() {
		return maxattendees;
	}

	public void setMaxattendees(int maxattendees) {
		this.maxattendees = maxattendees;
	}

	public String getStartHour() {
		return startHour;
	}

	public void setStartHour(String startHour) {
		this.startHour = startHour;
	}

	public String getEndHour() {
		return endHour;
	}

	public void setEndHour(String endHour) {
		this.endHour = endHour;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}
	
	public void newInstructor(Instructor instructor) {
		instructors.add(instructor);
	}

	public List<Instructor> getInstructors() {
		return instructors;
	}
	
	public void newCustomer(Customer customer) {
		customers.add(customer);
	}
	
	public int getCustomersSize() {
		return this.customers.size();
	}
	
	public boolean customerInLesson(Customer customer) {
		return customers.contains(customer);
	}
	
	public boolean instructorInLesson(Instructor instructor) {

		for(Instructor i: instructors) {
			if(i.getName().equals(instructor.getName())) return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		String splitSlot[] = startHour.split(":");
		Integer slot = Integer.parseInt(splitSlot[0]);
		return day+"."+slot;
	}
	

}
