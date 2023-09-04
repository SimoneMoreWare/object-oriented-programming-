package applications;

import java.util.*;

public class Position {

	private String name;
	private List<Skill> skills = new LinkedList<>();
	
	
	
	public Position(String name) {
		super();
		this.name = name;
	}



	public String getName() {
		return name;
	}
	
	
	
	public void setName(String name) {
		this.name = name;
	}



	public List<Skill> getSkills() {
		return skills;
	}



	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public void newSkill(Skill skill) {
		skills.add(skill);
	}

	public List<String> getApplicants() {
		return null;
	}
	
	public String getWinner() {
		return null; 
	}
}