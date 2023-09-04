package jobOffers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Position {
	
	private String position;
	private Map<Skill,Integer> skillLevels = new HashMap<>();
	private List<Application> applications = new LinkedList<>();
	
	public Position(String position) {
		super();
		this.position = position;
	}
	
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Map<Skill, Integer> getSkillLevels() {
		return skillLevels;
	}
	public void setSkillLevels(Map<Skill, Integer> skillLevels) {
		this.skillLevels = skillLevels;
	}
	public void newSkillLevel(Skill skill, Integer level) {
		skillLevels.put(skill, level);
	}
	public int getAvgLevel() {
		
		int sum = 0;
		int n = skillLevels.size();
		
		for(Integer level: skillLevels.values()) sum = sum + level;
		
		return (int) sum/n;
		
	}
	public List<Skill> getSkills(){
		return skillLevels.keySet().stream().collect(Collectors.toList());
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
	public int getSizeApplications() {
		return applications.size();
	}
}
