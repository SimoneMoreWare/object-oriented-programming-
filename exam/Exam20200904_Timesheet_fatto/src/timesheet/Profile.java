package timesheet;

import java.util.LinkedList;
import java.util.List;

public class Profile {

	private List<Integer> workHours = new LinkedList<>();
	private String id;
	
	public Profile(String id) {
		super();
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<Integer> getWorkHours() {
		return workHours;
	}
	
	public void newWorkHour(int workHour) {
		workHours.add(workHour);
	}
	
	@Override
	public String toString() {
		return 	"Sun: " + workHours.get(0) + "; " +
				"Mon: " + workHours.get(1) + "; " +
				"Tue: " + workHours.get(2) + "; " + 
				"Wed: " + workHours.get(3) + "; " +
				"Thu: " + workHours.get(4) + "; " +
				"Fri: " + workHours.get(5) + "; " +
				"Sat: " + workHours.get(6);
	}
	
	public boolean isCompatibleEntry(int weekDay, int workedHours) {
		return workHours.get(weekDay) <= workedHours;
	}
}
