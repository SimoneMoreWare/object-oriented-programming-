package frequentFlyers;

import java.util.LinkedList;
import java.util.List;

public class FrequentFlyer {
	
	private String id;
	private List<Alliance> alliances = new LinkedList<>();
	private List<Journey> journeys = new LinkedList<>();
	private int point;
	
	public FrequentFlyer(String id) {
		super();
		this.id = id;
		this.point = 0;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<Alliance> getAlliances() {
		return alliances;
	}

	public void newAlliance(Alliance alliance) {
		alliances.add(alliance);
	}

	public List<Journey> getJourneys() {
		return journeys;
	}
		
	public void newJourney(Journey journey) {
		journeys.add(journey);
		this.point = this.point + journey.getPoint();
	}

	public int getPoint() {
		return point;
	}
	
	public boolean isCompatibleAlliance(Alliance alliance) {
		
		for(Alliance a: alliances) {
			if(a.getName().equals(alliance.getName())) return true;
		}
		
		
		return false;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	
}
