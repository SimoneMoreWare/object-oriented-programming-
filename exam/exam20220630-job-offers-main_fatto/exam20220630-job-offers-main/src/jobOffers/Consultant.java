package jobOffers;

import java.util.LinkedList;
import java.util.List;

public class Consultant {

	private String name;
	private List<Skill> skills = new LinkedList<>();
	
	public Consultant(String name) {
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
	public int getSizeSkills() {
		return skills.size();
	}
}
