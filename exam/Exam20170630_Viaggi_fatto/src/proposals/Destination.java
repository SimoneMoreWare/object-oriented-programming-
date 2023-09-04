package proposals;

import java.util.LinkedList;
import java.util.List;

public class Destination {

	private String name;
	private List<Quote> quotes = new LinkedList<>();
	private List<User> users = new LinkedList<>();

	public Destination(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void newQuote(Quote quote) {
		quotes.add(quote);
	}
	
	public int getNquotes() {
		return quotes.size();
	}
	
	public int getAmountQuotes() {
		
		int res = 0;
		
		for(Quote quote: quotes) {
			res = res + quote.getAmount();
		}
		System.out.println(name+":"+res);
		return res;
		
	}

	public void newUser(User user) {
		users.add(user);
	}
	
	public long getNusers() {
		return users.size();
	}
}
