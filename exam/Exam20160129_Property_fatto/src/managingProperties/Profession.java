package managingProperties;

import java.util.LinkedList;
import java.util.List;

public class Profession {
	
	private String name;
	private List<Professional> professionals = new LinkedList<>();
	
	public Profession(String name) {
		this.name = name;
	}
	
	public void addProfessional(Professional professional) {
		professionals.add(professional);
	}
	
	public String getName() {
		return this.name;
	}
	
	public Integer getNumberProfessional() {
		return professionals.size();
	}

}
