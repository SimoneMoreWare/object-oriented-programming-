package it.polito.oop.milliways;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Hall {
	
	private int id;
	private List<String> facilities = new LinkedList<>();
	private List<Party> parties = new LinkedList<>();
	
	public Hall(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public void addFacility(String facility) throws MilliwaysException {
		
		if(facilities.contains(facility)==true) throw new MilliwaysException();
		
		facilities.add(facility);
		
	}

	public List<String> getFacilities() {
		Collections.sort(facilities);
        return facilities;
	}
	
	int getNumFacilities(){
        return facilities.size();
	}

	public boolean isSuitable(Party party) {
		
		List<String> partyRequirements = new LinkedList<>();
		partyRequirements = party.getRequirements();
		
		for(String partyRequirement: partyRequirements) {
			if(facilities.contains(partyRequirement)==false) return false;
		}
		
		return true;
	}

	public void newParty(Party party) {
		parties.add(party);
	}

	public List<Party> getParties() {
		return parties;
	}
	
	
}
