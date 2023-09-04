package applications;

import java.util.Map;
import java.util.TreeMap;

public class Applicant {
	
	private String name;
	private Map<Skill, Integer> capabilities = new TreeMap<>();
	
	public Applicant(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<Skill, Integer> getCapabilities() {
		return capabilities;
	}

	public void setCapabilities(Map<Skill, Integer> capabilities) {
		this.capabilities = capabilities;
	}
	
	public void newCapatibility(Skill skill, Integer level) {
		capabilities.put(skill, level);
	}
	@Override
	public String toString() {
		StringBuffer res = new StringBuffer();
		
		for(Map.Entry<Skill, Integer> entry: capabilities.entrySet()) {
			String nameSkill = entry.getKey().getName();
			Integer level = entry.getValue();
			
			res.append(nameSkill).append(":").append(level).append(",");
			
		}
		
		res.substring(0, res.length()-2);
		return res.toString();
	}
	
	
}
