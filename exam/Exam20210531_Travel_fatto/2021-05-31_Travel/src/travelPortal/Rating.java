package travelPortal;

import java.util.LinkedHashMap;
import java.util.Map;

public class Rating {

	private Proposal proposal;
	private Map<Participant, Integer> evalutations = new LinkedHashMap<>();
	
	public Rating(Proposal proposal, Map<Participant, Integer> evalutations) {
		super();
		this.proposal = proposal;
		this.evalutations = evalutations;
	}
	public Proposal getProposal() {
		return proposal;
	}
	public void setProposal(Proposal proposal) {
		this.proposal = proposal;
	}
	public Map<Participant, Integer> getEvalutations() {
		return evalutations;
	}
	public void setEvalutations(Map<Participant, Integer> evalutations) {
		this.evalutations = evalutations;
	}
	
	@Override
	public String toString() {
		
		String res = "";
		
		for(Map.Entry<Participant, Integer> entry: evalutations.entrySet()) {
			
			String name = entry.getKey().getName();
			int value = entry.getValue();
			res = res + name+":"+value+", ";
		}
		
		return res.substring(0, res.length() - 2);
		
	}
	
	public Integer getEvalutationForParticipant(String name) {
		
		for(Map.Entry<Participant, Integer> entry: evalutations.entrySet()) {
			
			if(entry.getKey().getName().equals(name)) return entry.getValue();
			
		}
		
		return 0;
	}
	
}
