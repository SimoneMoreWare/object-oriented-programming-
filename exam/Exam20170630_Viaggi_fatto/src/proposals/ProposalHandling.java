package proposals;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class ProposalHandling {
	
	private Map<String, User> users = new HashMap<>();
	private Map<String, Operator> operators = new HashMap<>();
	private List<Destination> destinations = new LinkedList<>();
	private Map<String, Proposal> proposals = new HashMap<>();
	
	public Map<String, User> getUsersMap() {
        return users;
    }
	
	public Map<String, Operator> getOperatorsMap() {
        return operators;
    }

    //R1
	public int addUsers(String... userNames) {
		
		for(String userName: userNames) {
			if(users.containsKey(userName)==false) {
				users.put(userName, new User(userName));
			}
		}
		
		return users.size();
	}
	
	public void addOperator(String operatorName, String... destinationNames) throws ProposalException {			
		
		if(operators.containsKey(operatorName)==true) throw new ProposalException();
		
		Operator operator = new Operator(operatorName);
		
		for(String destinationName: destinationNames) {
			Destination destination = new Destination(destinationName);
			destinations.add(destination);
			operator.newDestination(destination);
		}
		
		operators.put(operatorName, operator);
		
	}

	public List<String> getDestOperators(String destinationName) {
		return operators.values().stream()
				.filter( o -> o.getDestinationNames().contains(destinationName))
				.sorted(Comparator.comparing(Operator::getName))
				.map(Operator::getName)
				.collect(Collectors.toList());
	}
//R2
	public Proposal newProposal(String name, String destinationName) throws ProposalException {
		Destination d = null;
		if(proposals.containsKey(name)==true) throw new ProposalException();
		int flag=1; 
		for(Destination destination: destinations) {
			if(destination.getName().equals(destinationName)) {
				d = destination;
				flag=0;
			}
		}
		if(flag==1) throw new ProposalException();
		
		
		Proposal proposal = new Proposal(name, d, this.getUsersMap(), this.getOperatorsMap());
		
		proposals.put(name, proposal);
		
		return proposal;
	}
	
//R3

	public List<Quote> getUserQuotes (String userName) {
        	return users.get(userName).getChoices().stream().
        			map(Choice::getQuote).collect(Collectors.toList());
	}
	
//R5
	public SortedMap<String, Integer> totalAmountOfQuotesPerDestination() {
		return destinations.stream()
				.filter(d->d.getNquotes()>0)
				.collect(Collectors.toMap(
												Destination::getName,
												Destination::getAmountQuotes,
												(d1,d2)->d1,
												TreeMap::new
											)
						);	}
	
	public SortedMap<Integer, List<String>> operatorsPerNumberOfQuotes() {
        
		
		return operators.values().stream()
        			.filter(o->o.getNquotes()>0)
        			.collect(Collectors.toMap(
        											Operator::getName,
        											Operator::getNquotes,
        											(o1,o2) -> o1,
        											TreeMap::new
        						                  )
        					)
        			.entrySet().stream().
        			collect(Collectors.groupingBy(
        											Map.Entry::getValue,
        											() -> new TreeMap<Integer,List<String>>(Collections.reverseOrder()),
        											Collectors.mapping(
        													           Map.Entry::getKey, Collectors.collectingAndThen(Collectors.toList(), list->list.stream().sorted().collect(Collectors.toList()))
        													          )
        											
        										 )
        					)
        			;
	}

	public SortedMap<String, Long> numberOfUsersPerDestination() {
		return destinations.stream().
			   filter(d->d.getNusers()>0)
			   .collect(Collectors.toMap(
					   						Destination::getName,
					   						Destination::getNusers,
					   						(d1,d2)->d1,
					   						TreeMap::new
					   					)
					   );
	}
	
	public SortedMap<Integer, List<String>> proposalsPerNumberOfQuotes() {
        	return proposals.values().stream().
        			collect(Collectors.toMap(
        											Proposal::getName,
        											Proposal::getNquotes,
        											(p1, p2) -> p1,
        											HashMap::new
        										 )
        					)
        			.entrySet().stream().
        			collect(Collectors.groupingBy(
							Map.Entry::getValue,
							() -> new TreeMap<Integer,List<String>>(Collections.reverseOrder()),
							Collectors.mapping(
									           Map.Entry::getKey, Collectors.collectingAndThen(Collectors.toList(), list->list.stream().sorted().collect(Collectors.toList()))
									          )
							
						 )
	)        			;
	}
}
