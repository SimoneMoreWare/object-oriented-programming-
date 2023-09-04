package applications;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;

public class HandleApplications {

	private Map<String, Skill> skills = new HashMap<>();
	private Map<String, Position> positions = new HashMap<>();
	private Map<String, Applicant> applicants = new HashMap<>();
	
	public void addSkills(String... names) throws ApplicationException {
		
		for(String name: names) {
			if(!skills.containsKey(name)) {
				Skill skill = new Skill(name);
				skills.put(name, skill);
			}else {
				System.out.println(skills.get(name));
				throw new ApplicationException();
			}
		}
		
	}
	public void addPosition(String name, String... skillNames) throws ApplicationException {
		
		if(positions.containsKey(name)) throw new ApplicationException();
		for(String skillName: skillNames) if(!skills.containsKey(skillName)) throw new ApplicationException();
		
		Position position = new Position(name);
		
		for(String skillName: skillNames) {
			position.newSkill(skills.get(skillName));
			skills.get(skillName).newPosition(position);
		}
		
		positions.put(name, position);
		
	}
	public Skill getSkill(String name) {
		return skills.get(name);
	}
	
	public Position getPosition(String name) {
		return positions.get(name);
	}
	
	public void addApplicant(String name, String capabilities) throws ApplicationException {
		String capabilities1 = capabilities;
		if(applicants.containsKey(name)) {
			throw new ApplicationException();
		}
		String splitCapabilities[] = capabilities.split(",");
		for(String capability: splitCapabilities) {
			String splitCapability[] = capability.split(":");
			String nameSkill = splitCapability[0];
			Integer level = Integer.parseInt(splitCapability[1]);

			if(!skills.containsKey(nameSkill)) {
				throw new ApplicationException();
			}
			if(level<1 || level>10) {
				throw new ApplicationException();
			}
			
		}
		
		Applicant applicant = new Applicant(name);
		String splitCapabilities1[] = capabilities1.split(",");
		System.out.println(splitCapabilities1.length);
		for(String capability1: splitCapabilities1) {
			String splitCapability1[] = capability1.split(":");
			String nameSkill1 = splitCapability1[0];
			Integer level1 = Integer.parseInt(splitCapability1[1]);
			
			System.out.println(capability1);
			applicant.newCapatibility(skills.get(nameSkill1), level1);
			skills.get(nameSkill1).newApplicant(applicant);
		}
		
		applicants.put(name, applicant);
		
		
	}
	public String getCapabilities(String applicantName) throws ApplicationException {
		
		if(!applicants.containsKey(applicantName)) throw new ApplicationException();
		
		return applicants.get(applicantName).toString();
	}
	
	public void enterApplication(String applicantName, String positionName) throws ApplicationException {
		
	}
	
	public int setWinner(String applicantName, String positionName) throws ApplicationException {
		return 0;
	}
	
	public SortedMap<String, Long> skill_nApplicants() {
		return null;
	}
	public String maxPosition() {
		return null;
	}
}

