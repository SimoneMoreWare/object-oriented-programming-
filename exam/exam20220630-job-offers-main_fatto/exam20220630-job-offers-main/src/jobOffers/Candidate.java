package jobOffers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Candidate {

	private String name;
	private List<Skill> skills = new LinkedList<>();
	private List<Application> applications = new LinkedList<>();
	private Map<Skill,Integer> skillsRating = new HashMap<>();
	
	public Candidate(String name) {
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
	public int getSizeSkill() {
		return skills.size();
	}
	public List<Application> getApplications() {
		return applications;
	}
	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}
	public void newApplication(Application application) {
		applications.add(application);
	}
	public Map<Skill, Integer> getSkillsRating() {
		return skillsRating;
	}
	public void setSkillsRating(Map<Skill, Integer> skillsRating) {
		this.skillsRating = skillsRating;
	}
	public void newSkillRating(Skill skill, Integer rating) {
		skillsRating.put(skill, rating);
	}
	public Integer getAvgLevels() {
		int sum = 0;
		int n = skillsRating.size();
		for(Integer level: skillsRating.values()) sum = sum + level;
		return (int) sum/n;
	}
}
