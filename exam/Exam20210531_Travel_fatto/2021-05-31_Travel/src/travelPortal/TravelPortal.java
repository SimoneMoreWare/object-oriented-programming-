package travelPortal;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class TravelPortal {
	
	private Map<String, ActivityTypes> activitiesTypes = new HashMap<>();
	private Map<String, TravelAgency> travelAgencies = new HashMap<>();
	private Map<String, Proposal> proposals = new HashMap<>();
	private Map<String, Participant> participants = new HashMap<>();
	private Map<String, Rating> ratings = new HashMap<>();

//R1
	public List<String> addActivityTypes(String... names) {
		
		for(String name: names) {
			if(!activitiesTypes.containsKey(name)) activitiesTypes.put(name, new ActivityTypes(name));
		}
		
		return activitiesTypes.values().stream().sorted(Comparator.comparing(ActivityTypes::getName)).map(ActivityTypes::getName).collect(Collectors.toList());
	}

	public int AddTravelAgency(String name, String... activityTypes) throws TPException {
		
		if(travelAgencies.containsKey(name)) throw new TPException();
		for(String activityType: activityTypes) if(!activitiesTypes.containsKey(activityType)) throw new TPException();
		
		TravelAgency travelAgency = new TravelAgency(name);
		
		for(String activityType: activityTypes) {
			travelAgency.newActivityTypes(activitiesTypes.get(activityType));
			activitiesTypes.get(activityType).newTravelAgency(travelAgency);
		}
		
		travelAgencies.put(name, travelAgency);
		
		return travelAgency.getSizeActivityTypes();
	}

	public SortedMap<String, List<String>> getAgenciesForActivityTypes() {
		return activitiesTypes.values().stream()
				.filter(a->a.getSizeTravelAgencies()>0)
				.collect(Collectors.groupingBy(
												ActivityTypes::getName,
												TreeMap::new,
												Collectors.flatMapping(
																	a->a.getTravelAgencies().stream().map(t->t.getName()).sorted() ,
																	Collectors.toList()
																   )
						                      )
						)
				;
	}

//R2
	public int addProposal(String code, String agency, String destination, String period, int minNP, int maxNP,
			int price) throws TPException {
		
		if(proposals.containsKey(code)) throw new TPException();
		if(!travelAgencies.containsKey(agency)) throw new TPException();
		
		Proposal proposal = new Proposal(code, travelAgencies.get(agency), destination, period, minNP, maxNP, price);
		
		travelAgencies.get(agency).newProposal(proposal);
		
		proposals.put(code, proposal);
		
		return proposal.getLenghtTravel();
	}

	public int addActivity(String code, String activityType, String description, int price) throws TPException {
		
		List<String> activitiesTravelAgency = proposals.get(code).getAgency().getActivitiesTypes().stream().map(a->a.getName()).collect(Collectors.toList());
		if(!activitiesTravelAgency.contains(activityType)) throw new TPException();
		
		Activity activity = new Activity(proposals.get(code), activitiesTypes.get(activityType), description, price);
		
		proposals.get(code).newActivity(activity);
		activitiesTypes.get(activityType).newActivity(activity);
		return proposals.get(code).getPriceActivities();
	}

	public int getProposalPrice(String code) throws TPException {
		
		if(!proposals.containsKey(code)) throw new TPException();
		

		
		return proposals.get(code).getPriceProposal();
	}

//R3
public List<String> addParticipants (String code, String... names) throws TPException {
	
	for(String name: names) {
		if(!participants.containsKey(name)) {
			Participant participant = new Participant(name);
			participant.newProposal(proposals.get(code));
			proposals.get(code).newParticipant(participant);
			participants.put(name,participant);
		}else {
			if(participants.get(name).isCompatibleProposal(proposals.get(code))) {
				participants.get(name).newProposal(proposals.get(code));
				proposals.get(code).newParticipant(participants.get(name));
			}
		}
	}
	
	if( proposals.get(code).getSizeParticipants()<proposals.get(code).getMinNP() || proposals.get(code).getSizeParticipants()>proposals.get(code).getMaxNP()) throw new TPException();
	
	return proposals.get(code).getNamesParticipants();
}

	public int getIncome(String code) {
		return proposals.get(code).getIncome();
	}

//R4
	public String addRatings(String code, int... evaluations) throws TPException {
		
		if(evaluations.length != proposals.get(code).getSizeParticipants()) throw new TPException();
		
		List<Participant> participants = proposals.get(code).getParticipants();
		Map<Participant, Integer> ev = new LinkedHashMap<>();
		
		int i;
		int len = participants.size();
		
		for(i=0;i<len;i++) {
			Participant participant = participants.get(i);
			Integer evalutation = evaluations[i];
			ev.put(participant, evalutation);
			
		}
		
		Rating rating = new Rating(proposals.get(code), ev);
		
		for(Participant partecipant: participants) {
			partecipant.newRating(rating);
		}
		proposals.get(code).setRating(rating);
		ratings.put(code, rating);
		
		return rating.toString();
	}

	public SortedMap<String, Integer> getTotalRatingsForParticipants() {
		return participants.values().stream()
				.filter(p->p.getSizeRatings()>0)
				.collect(Collectors.toMap(
												Participant::getName,
												p->p.getRatings().stream().mapToInt(r->r.getEvalutationForParticipant(p.getName())).sum(),
												(p1,p2)->p1,
												TreeMap::new
											  )
						)
				;
	}

//R5
	public SortedMap<String, Integer> incomeForActivityTypes() {
		return activitiesTypes.values().stream()
				.filter(at->at.getSizeActivities()>0)
				.collect(Collectors.toMap(
											ActivityTypes::getName,
											at->at.getActivities().stream().mapToInt(a->a.getPrice()).sum(),
											(at1,at2)->at1,
											TreeMap::new
										 )
						)	
				;
	}

	public SortedMap<Integer, List<String>> participantsWithSameNofProposals() {
		return participants.values().stream()
				.collect(Collectors.toMap(Participant::getName, Participant::getSizeProposals, (p1,p2)->p1,HashMap::new))
				.entrySet().stream()
				.collect(Collectors.groupingBy(
												Map.Entry::getValue,
												TreeMap::new,
												Collectors.mapping(Map.Entry::getKey, Collectors.collectingAndThen(Collectors.toList(), list->list.stream().sorted().collect(Collectors.toList())))
											  )
						)
				;
	}
}
