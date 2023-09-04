package proposals;

import java.util.LinkedList;
import java.util.List;

public class Quote {
	
	private Operator operator;
	private int amount;
	private Proposal proposal;
	private List<Choice> choices = new LinkedList<>();
	
	
	public Quote(Operator operator, int amount, Proposal proposal) {
		super();
		this.operator = operator;
		this.amount = amount;
		this.proposal = proposal;
	}

	public int getAmount() {
		return amount;
	}
	
	public String getProposalName() {
	       	return proposal.getName();
	}
	public String getOperatorName() {
	       	return operator.getName();
	}
	
	public int getNChoices() {
	       	return choices.size();
	}
	
	public void newChoice(Choice choice) {
		choices.add(choice);
	}

	
}
