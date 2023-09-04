package travelPortal;

import java.util.LinkedList;
import java.util.List;

public class ActivityTypes {
	
	private String name;
	private List<TravelAgency> travelAgencies = new LinkedList<>();
	private List<Activity> activities = new LinkedList<>();
	
	public ActivityTypes(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<TravelAgency> getTravelAgencies() {
		return travelAgencies;
	}

	public void setTravelAgencies(List<TravelAgency> travelAgencies) {
		this.travelAgencies = travelAgencies;
	}
	
	public void newTravelAgency(TravelAgency travelAgency) {
		travelAgencies.add(travelAgency);
	}
	public int getSizeTravelAgencies() {
		return travelAgencies.size();
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}
	
	public void newActivity(Activity activity) {
		activities.add(activity);
	}
	public int getSizeActivities() {
		return activities.size();
	}
}
