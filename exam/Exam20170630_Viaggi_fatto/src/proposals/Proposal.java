package proposals;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.stream.Collectors;


public class Proposal {
	
	private String name;
	private Destination destination;
    private Map<String, User> mapUsers;
    private List<User> users = new LinkedList<>();
    private Map<String, Operator> mapOperators;
    private List<Operator> operators = new LinkedList<>();
    private List<Quote> quotes = new LinkedList<>();
    private List<Choice> choices = new LinkedList<>();
	
	public Proposal(String name, Destination destination, Map<String, User> mapUsers, Map<String, Operator> mapOperators) {
		this.name = name;
		this.destination = destination;
		this.mapUsers = mapUsers;
		this.mapOperators = mapOperators;
	}

	public String getDestination(){
		return destination.getName();
	}

	public List<String> setUsers(String... userNames) {
		
		List<String> res = new LinkedList<>();
	
		for(String userName: userNames) {
			if(mapUsers.containsKey(userName)) {
				users.add(mapUsers.get(userName));
				destination.newUser(mapUsers.get(userName));
			}else {
				res.add(userName);
			}
		}
		
		Collections.sort(res);
		
		return res;
		
	}


	public void setName(String name) {
		this.name = name;
	}

	public SortedSet<String> getUsers() {
		return (SortedSet<String>) users.stream().sorted(Comparator.comparing(User::getName)).map(User::getName).collect(Collectors.toSet());
	}
	
	public List<String> setOperators(String... operatorNames) {
		
		List<String> res = new LinkedList<>();
		
		for(String operatorName: operatorNames) {
			if(mapOperators.containsKey(operatorName)) {
				if(mapOperators.get(operatorName).isDestinationCompatible(destination)) {
					operators.add(mapOperators.get(operatorName));
					mapOperators.get(operatorName).newProposal(this);
				}else {
					res.add(operatorName);
				}
			}else {
				res.add(operatorName);
			}
		}
		Collections.sort(res);
		return res;
	}
	
	public SortedSet<String> getOperators() {
		return (SortedSet<String>) operators.stream().sorted(Comparator.comparing(Operator::getName)).map(Operator::getName).collect(Collectors.toSet());
	}
	
	public void addQuote(String operatorName, int amount) throws ProposalException {
		int flag = 0;
		for(Operator operator: operators) {
			if(operator.getName().equals(operatorName)) {
				flag = 1;
			}
		}
		if(flag==0) throw new ProposalException();
		
		Quote quote = new Quote(mapOperators.get(operatorName), amount, this);
		mapOperators.get(operatorName).newQuote(quote);
		destination.newQuote(quote);
		quotes.add(quote);
		
	}

	public List<Quote> getQuotes() {
		return quotes.stream().sorted( Comparator.comparing(Quote::getAmount).reversed().thenComparing(Quote::getOperatorName)).collect(Collectors.toList());
	}
	
	//R4
		public void makeChoice (String userName, String operatorName) throws ProposalException {
			int flag = 0;
			for(User user: users) {
				if(user.getName().equals(userName)) flag = 1;
			}
			if(flag==0) throw new ProposalException();
			
			if(mapOperators.get(operatorName).getQuote(this)==null) throw new ProposalException(); 
			
			Quote quote = mapOperators.get(operatorName).getQuote(this);
			
			Choice choice = new Choice(mapUsers.get(userName), mapOperators.get(operatorName), quote, this);
			this.choices.add(choice);
			mapOperators.get(operatorName).newChoice(choice);
			quote.newChoice(choice);
			mapUsers.get(userName).newChoice(choice);
			
			
		}
		
		public Quote getWinningQuote () {
			return quotes.stream()
					.max(Comparator.comparing(Quote::getNChoices).thenComparing(Comparator.comparing(Quote::getAmount).reversed())).orElse(null);
		}


		public String getName() {
			return name;
		}	
		
		public int getNquotes() {
			return quotes.size();
		}
}
