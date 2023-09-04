package travelPortal;

import java.util.LinkedList;
import java.util.List;

public class Participant {
	
	private String name;
	private List<Proposal> proposals = new LinkedList<>();
	private List<Rating> ratings = new LinkedList<>();
	
	public Participant(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<Proposal> getProposals() {
		return proposals;
	}

	public void setProposals(List<Proposal> proposals) {
		this.proposals = proposals;
	}
	
	public void newProposal(Proposal proposal) {
		proposals.add(proposal);
	}
	
	public boolean isCompatibleProposal(Proposal proposal) {
		
		String splitPeriod[] = proposal.getPeriod().split(":");
		
		Integer m = Integer.parseInt(splitPeriod[0]);
		
		String daySpilt[] = splitPeriod[1].split("-");
		
		Integer i = Integer.parseInt(daySpilt[0]);
		Integer f = Integer.parseInt(daySpilt[1]);
		
		for(Proposal p: proposals) {
			

			
			if(!p.getCode().equals(proposal.getCode())) {
				String splitPeriod1[] = p.getPeriod().split(":");
				
				Integer m1 = Integer.parseInt(splitPeriod1[0]);
				
				String daySpilt1[] = splitPeriod1[1].split("-");
				
				Integer i1 = Integer.parseInt(daySpilt1[0]);
				Integer f1 = Integer.parseInt(daySpilt1[1]);
				
		
				
				if(m1==m) if(i<f1 && i1<f) {
					return false;
				}
			
			}
			
		}
		
		
		return true;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}
	public void newRating(Rating rating) {
		ratings.add(rating);
	}
	public int getSizeRatings() {
		return ratings.size();
	}
	
	public int getSizeProposals() {
		return proposals.size();
	}
}
