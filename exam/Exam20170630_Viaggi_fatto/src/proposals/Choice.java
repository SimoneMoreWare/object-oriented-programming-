package proposals;

public class Choice {

	private User user;
	private Operator operator;
	private Quote quote;
	private Proposal proposal;
	
	public Choice(User user, Operator operator, Quote quote, Proposal proposal) {
		super();
		this.user = user;
		this.operator = operator;
		this.quote = quote;
		this.proposal = proposal;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Operator getOperator() {
		return operator;
	}
	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	public Quote getQuote() {
		return quote;
	}
	public void setQuote(Quote quote) {
		this.quote = quote;
	}
	public Proposal getProposal() {
		return proposal;
	}
	public void setProposal(Proposal proposal) {
		this.proposal = proposal;
	}
	
	
	
}
