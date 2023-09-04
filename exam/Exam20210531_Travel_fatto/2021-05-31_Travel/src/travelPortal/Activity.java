package travelPortal;

public class Activity {
	
	private Proposal proposal;
	private ActivityTypes activityTypes;
	private String description;
	private int price;
	
	public Activity(Proposal proposal, ActivityTypes activityTypes, String description, int price) {
		super();
		this.proposal = proposal;
		this.activityTypes = activityTypes;
		this.description = description;
		this.price = price;
	}
	
	public Proposal getProposal() {
		return proposal;
	}
	public void setProposal(Proposal proposal) {
		this.proposal = proposal;
	}
	public ActivityTypes getActivityTypes() {
		return activityTypes;
	}
	public void setActivityTypes(ActivityTypes activityTypes) {
		this.activityTypes = activityTypes;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	

}
