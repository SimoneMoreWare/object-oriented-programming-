package it.polito.oop.milliways;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Race {
	
	private String name;
	private List<String> requirements = new LinkedList<>();
	
	public Race(String name) {
		this.name = name;
	}
    
	public void addRequirement(String requirement) throws MilliwaysException {
		
		if(requirements.contains(requirement)==true) throw new MilliwaysException();
		
		requirements.add(requirement);
		
	}
	
	public List<String> getRequirements() {
		Collections.sort(requirements);
        return requirements;
	}
	
	public String getName() {
        return this.name;
	}
}
