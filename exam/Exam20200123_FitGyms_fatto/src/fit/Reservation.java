package fit;

public class Reservation {
	
	private Customer customer;
	private Gym gym;
	private int day;
	private String startHour;
	private String endHour;
	private Lesson lesson;
	
	public Reservation(Customer customer, Gym gym, int day, String startHour, String endHour, Lesson lesson) {
		super();
		this.customer = customer;
		this.gym = gym;
		this.day = day;
		this.startHour = startHour;
		this.endHour = endHour;
		this.lesson = lesson;
	}

	public Lesson getLesson() {
		return lesson;
	}

	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Gym getGym() {
		return gym;
	}

	public void setGym(Gym gym) {
		this.gym = gym;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
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
	
	

}
