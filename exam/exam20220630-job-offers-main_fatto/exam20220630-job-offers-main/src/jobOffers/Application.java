package jobOffers;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Application {

	private Candidate candidate;
	private List<Position> positions = new LinkedList<>();
	
	public Application(Candidate candidate) {
		super();
		this.candidate = candidate;
	}
	public Candidate getCandidate() {
		return candidate;
	}
	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}
	public List<Position> getPositions() {
		return positions;
	}
	public void setPositions(List<Position> positions) {
		this.positions = positions;
	}
	
	public void newPosition(Position position) {
		positions.add(position);
	}

	public List<String> getApplications(){
		List<String> res = new LinkedList<>();
		for(Position position: positions) {
			res.add(candidate.getName()+":"+position.getPosition());
		}
		Collections.sort(res);
		return res;
	}
	
	public boolean isCandidateCompatibleLevelForPosition() {
		
		Map<Skill,Integer> skillsRating = candidate.getSkillsRating();
		
		for(Position position: positions) {
			Map<Skill,Integer> skillLevels = position.getSkillLevels();
			
			for(Map.Entry<Skill, Integer> entryCandidate: skillsRating.entrySet()) {
				Skill skillCandidate = entryCandidate.getKey();
				Integer levelCandidate = entryCandidate.getValue();
				for(Map.Entry<Skill, Integer> entryPosition: skillLevels.entrySet()) {
					Skill skillPosition = entryPosition.getKey();
					Integer levelPosition = entryPosition.getValue();
					
					if(skillCandidate.getName().equals(skillPosition.getName())) {
						if(levelCandidate<levelPosition) return false;
					}
					
				}
			}
			
		}
		
		return true;
		
	}
	
	public List<String> getDiscardApplications() {
		
		List<String> res = new LinkedList<>();
		
		Map<Skill,Integer> skillsRating = candidate.getSkillsRating();
		
		for(Position position: positions) {
			Map<Skill,Integer> skillLevels = position.getSkillLevels();
			
			if(skillsRating.size()!=0) {
				for(Map.Entry<Skill, Integer> entryCandidate: skillsRating.entrySet()) {
					Skill skillCandidate = entryCandidate.getKey();
					Integer levelCandidate = entryCandidate.getValue();
					for(Map.Entry<Skill, Integer> entryPosition: skillLevels.entrySet()) {
						Skill skillPosition = entryPosition.getKey();
						Integer levelPosition = entryPosition.getValue();
						
						if(skillCandidate.getName().equals(skillPosition.getName())) {
							if(levelCandidate<levelPosition) res.add(candidate.getName()+":"+position.getPosition());
						}
						
					}
				}
			} else {
				res.add(candidate.getName()+":"+position.getPosition());
				System.out.println(candidate.getName()+":"+position.getPosition());
			}
			
		}
		Collections.sort(res);
		return res;
		
	}
	
}
