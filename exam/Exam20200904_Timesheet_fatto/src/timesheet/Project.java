package timesheet;

import java.util.LinkedList;
import java.util.List;

public class Project {
	
	private String name;
	private int maxHours;
	private List<Activity> activities = new LinkedList<>();
	
	public Project(String name, int maxHours) {
		super();
		this.name = name;
		this.maxHours = maxHours;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMaxHours() {
		return maxHours;
	}
	public void setMaxHours(int maxHours) {
		this.maxHours = maxHours;
	}
	
	@Override
	public String toString() {
		return name+": "+maxHours;
	}
	
	public void newActivity(Activity activity) {
		activities.add(activity);
	}

	public List<Activity> getActivities() {
		return activities;
	}

}
