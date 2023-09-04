package proposals;

import java.util.LinkedList;
import java.util.List;

public class User {

	private String name;
	private List<Choice> choices = new LinkedList<>();

	public User(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public void newChoice(Choice choice) {
		choices.add(choice);		
	}

	public List<Choice> getChoices() {
		return choices;
	}

	public void setChoices(List<Choice> choices) {
		this.choices = choices;
	}
	
	
	
}
