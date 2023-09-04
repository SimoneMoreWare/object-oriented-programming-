package proposals;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Operator {

	private String name;
	private Set<Destination> destinationNames = new HashSet<>();
	private List<Proposal> proposals = new LinkedList<>();
	private List<Quote> quotes = new LinkedList<>();
	private List<Choice> choices = new LinkedList<>();
	
	public Operator(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Set<String> getDestinationNames() {
		return destinationNames.stream().map(Destination::getName).collect(Collectors.toSet());
	}

	public void newDestination(Destination destination) {
		destinationNames.add(destination);
	}
	
	public void newProposal(Proposal proposal) {
		proposals.add(proposal);
	}
	
	public boolean isDestinationCompatible(Destination destination) {
		for(Destination destinationName: destinationNames) {
			if(destinationName.getName().equals(destination.getName())) return true;
		}
		return false;
	}
	
	public void newQuote(Quote quote) {
		quotes.add(quote);
	}
	
	public Quote getQuote(Proposal proposal) {
		
		for(Quote quote: quotes) {
			if(quote.getProposalName().equals(proposal.getName())) return quote;
		}
		
		return null;
		
	}
	
	public void newChoice(Choice choice) {
		choices.add(choice);
	}
	
	public int getNquotes() {
		return quotes.size();
	}
	
}
