package travelPortal;

import java.util.LinkedList;
import java.util.List;

public class Proposal {
	
	private String code;
	private TravelAgency agency;
	private String destination;
	private String period;
	private int minNP;
	private int maxNP;
	private int price;
	private List<Activity> activities = new LinkedList<>();
	private List<Participant> participants = new LinkedList<>();
	private Rating rating;
	
	public Proposal(String code, TravelAgency agency, String destination, String period, int minNP, int maxNP,
			int price) {
		super();
		this.code = code;
		this.agency = agency;
		this.destination = destination;
		this.period = period;
		this.minNP = minNP;
		this.maxNP = maxNP;
		this.price = price;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public TravelAgency getAgency() {
		return agency;
	}

	public void setAgency(TravelAgency agency) {
		this.agency = agency;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public int getMinNP() {
		return minNP;
	}

	public void setMinNP(int minNP) {
		this.minNP = minNP;
	}

	public int getMaxNP() {
		return maxNP;
	}

	public void setMaxNP(int maxNP) {
		this.maxNP = maxNP;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getLenghtTravel() {
		
		String splitPeriod[] = period.split(":");
		
		String daySpilt[] = splitPeriod[1].split("-");
		
		Integer i = Integer.parseInt(daySpilt[0]);
		Integer f = Integer.parseInt(daySpilt[1]);
		
		return f-i;
		
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

	public void newActivity(Activity activity) {
		activities.add(activity);
	}
	
	public int getPriceActivities() {
		return activities.stream().mapToInt(Activity::getPrice).sum();
	}
	
	public int getPriceProposal() {
		if(activities.size()>0) return this.getPriceActivities() + this.price;
		return this.price;
	}

	public List<Participant> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Participant> participants) {
		this.participants = participants;
	}
	
	public void newParticipant(Participant participant) {
		participants.add(participant);
	}
	
	public int getSizeParticipants() {
		return participants.size();
	}

	public List<String> getNamesParticipants() {
		List<String> res = new LinkedList<>();
		
		for(Participant participant: participants) {
			res.add(participant.getName());
		}
		
		return res;
		
	}
	
	public int getIncome() {
		return this.getPriceProposal()*this.getSizeParticipants();
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}
	
	
}
