package travelPortal;

import java.util.LinkedList;
import java.util.List;

public class TravelAgency {
	
	private String name;
	private List<ActivityTypes> activitiesTypes = new LinkedList<>();
	private List<Proposal> proposals = new LinkedList<>();
	
	public TravelAgency(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<ActivityTypes> getActivitiesTypes() {
		return activitiesTypes;
	}
	public void setActivitiesTypes(List<ActivityTypes> activitiesTypes) {
		this.activitiesTypes = activitiesTypes;
	}
	public void newActivityTypes(ActivityTypes activityTypes) {
		activitiesTypes.add(activityTypes);
	}
	public int getSizeActivityTypes() {
		return activitiesTypes.size();
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

}
