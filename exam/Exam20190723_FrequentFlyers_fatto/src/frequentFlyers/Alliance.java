package frequentFlyers;

import java.util.LinkedList;
import java.util.List;

public class Alliance {
	
	private String name;
	private List<Airline> airlines = new LinkedList<>();
	private int multiplier;
	private List<FrequentFlyer> frequentFlyers = new LinkedList<>();


	public Alliance(String name) {
		super();
		this.name = name;
		this.multiplier = 10;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void newAirline(Airline airline) {
		airlines.add(airline);
	}

	public List<Airline> getAirlines() {
		return airlines;
	}

	public int getMultiplier() {
		return multiplier;
	}

	public void setMultiplier(int multiplier) {
		this.multiplier = multiplier;
	}

	public void setAirlines(List<Airline> airlines) {
		this.airlines = airlines;
	}
	

	public List<FrequentFlyer> getFrequentFlyers() {
		return frequentFlyers;
	}
	
	public void newFrequentFlyer(FrequentFlyer frequentFlyer) {
		frequentFlyers.add(frequentFlyer);
	}
	

}
