package jobOffers; 
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;


public class JobOffers  {

	private Map<String, Skill> skills = new HashMap<>();
	private Map<String, Position> positions = new HashMap<>();
	private Map<String, Candidate> candidates = new HashMap<>();
	private List<Application> applications = new LinkedList<>();
	private Map<String, Consultant> consultants = new HashMap<>();
//R1
	public int addSkills (String... skills) {
		
		for(String nameSkill: skills) {
			if(!this.skills.containsKey(nameSkill)) this.skills.put(nameSkill, new Skill(nameSkill));
		}
		
		return this.skills.size();
	}
	
	public int addPosition (String position, String... skillLevels) throws JOException {
		
		if(positions.containsKey(position)) throw new JOException("position is present");
		for(String skillLevel: skillLevels) {
			String skillLevelPart[] = skillLevel.split(":");
			String nameSkill = skillLevelPart[0];
			Integer level = Integer.parseInt(skillLevelPart[1]);
			if(!skills.containsKey(nameSkill)) throw new JOException("skill not present");
			if(level<4 || level>8) throw new JOException("value not compatible");
		}
		
		Position p = new Position(position);
		
		for(String skillLevel: skillLevels) {
			String skillLevelPart[] = skillLevel.split(":");
			String nameSkill = skillLevelPart[0];
			Integer level = Integer.parseInt(skillLevelPart[1]);
			p.newSkillLevel(skills.get(nameSkill), level);
		}
		
		positions.put(position, p);
		
		return p.getAvgLevel();
	}
	
//R2	
	public int addCandidate (String name, String... skills) throws JOException {
		
		if(candidates.containsKey(name)) throw new JOException("candidate is present");
		for(String nameSkill: skills) if(!this.skills.containsKey(nameSkill)) throw new JOException("skill not present");
		
		Candidate candidate = new Candidate(name);
		
		for(String nameSkill: skills) candidate.newSkill(this.skills.get(nameSkill));
		
		candidates.put(name, candidate);
		
		return candidate.getSizeSkill();
	}
	
	public List<String> addApplications (String candidate, String... positions) throws JOException {
		
		if(!candidates.containsKey(candidate)) throw new JOException("candidate is not present");
		for(String position: positions) if(!this.positions.containsKey(position)) throw new JOException("position is not define");
		Set<String> candidateSkills = candidates.get(candidate).getSkills().stream().map(s->s.getName()).collect(Collectors.toSet());
		for(String position: positions) {
			Set<String> positionSkills = this.positions.get(position).getSkills().stream().map(s->s.getName()).collect(Collectors.toSet());
			if(!candidateSkills.containsAll(positionSkills)) throw new JOException("candidate not compatible skill for position");
		}
		
		Application application = new Application(candidates.get(candidate));
		
		for(String position: positions) {
			application.newPosition(this.positions.get(position));
			this.positions.get(position).newApplication(application);
		}
		
		candidates.get(candidate).newApplication(application);
		applications.add(application);
		
		return application.getApplications();
	} 
	
	public TreeMap<String, List<String>> getCandidatesForPositions() {
		return positions.values().stream()
				.filter(p->p.getSizeApplications()>0)
				.collect(Collectors.groupingBy(
												Position::getPosition,
												TreeMap::new,
												Collectors.flatMapping(p->p.getApplications().stream().map(a->a.getCandidate().getName()).sorted(), Collectors.toList())
						                      )
						)
				;
	}
	
	
//R3
	public int addConsultant (String name, String... skills) throws JOException {
		if(consultants.containsKey(name)) throw new JOException("consultant is present");
		for(String skillName: skills) if(!this.skills.containsKey(skillName)) throw new JOException("skill not present");
		
		Consultant consultant = new Consultant(name); 
		
		for(String skillName: skills) {
			consultant.newSkill(this.skills.get(skillName));
		}
		
		consultants.put(name, consultant);
		
		return consultant.getSizeSkills();
	}
	
	public Integer addRatings (String consultant, String candidate, String... skillRatings)  throws JOException {
		
		if(!consultants.containsKey(consultant)) throw new JOException("Consultant is not present");
		if(!candidates.containsKey(candidate)) throw new JOException("Candidate is not present");
		Set<String> skillsConsultant = consultants.get(consultant).getSkills().stream().map(s->s.getName()).collect(Collectors.toSet());
		Set<String> skillsCandidate = candidates.get(candidate).getSkills().stream().map(s->s.getName()).collect(Collectors.toSet()); 
		if(!skillsConsultant.containsAll(skillsCandidate)) throw new JOException("incompatible skills");
		for(String skillRating: skillRatings) {
			String skillRatingSplit[] = skillRating.split(":");
			Integer level = Integer.parseInt(skillRatingSplit[1]);
			if(level<4 || level>10) throw new JOException("level not compatible");
		}
		
		for(String skillRating: skillRatings) {
			String skillRatingSplit[] = skillRating.split(":");
			String skillName = skillRatingSplit[0];
			Integer level = Integer.parseInt(skillRatingSplit[1]);
			candidates.get(candidate).newSkillRating(this.skills.get(skillName), level);
		}
		
		return candidates.get(candidate).getAvgLevels();
	}
	
//R4
	public List<String> discardApplications() {
		return applications.stream().flatMap(a->a.getDiscardApplications().stream()).sorted().collect(Collectors.toList());
	}
	
	 
	public List<String> getEligibleCandidates(String position) {
		return null;
	}
	

	
}

		
