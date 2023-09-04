package trail;

import java.util.LinkedList;
import java.util.List;

public class Delegate {
	
	private String name;
	private String surname;
	private String ssn;
	private List<Location> locations = new LinkedList<>();
	private List<Passage> passages = new LinkedList<>();
		
	public Delegate(String name, String surname, String ssn) {
		super();
		this.name = name;
		this.surname = surname;
		this.ssn = ssn;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	@Override
	public String toString() {
		return surname+", "+name+", "+ssn;
	}

	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}
	public void newLocation(Location location) {
		locations.add(location);
	}

	public List<Passage> getPassages() {
		return passages;
	}

	public void setPassages(List<Passage> passages) {
		this.passages = passages;
	}
	
	public void newPassage(Passage passage) {
		passages.add(passage);
	}
	
	public boolean isDelegateCompatibleLocation(String location) {
		
		for(Location l: locations) {
			if(l.getName().equals(location)) return true;
		}
		
		return false;
	}

}
