package frequentFlyers;

import java.util.LinkedList;
import java.util.List;

public class Flight {

	private String id;
	private Airline airline;
	private int price;
	private int nOfMiles;
	private List<Journey> journeys = new LinkedList<>();
	
	public Flight(String id, Airline airline, int price, int nOfMiles) {
		super();
		this.id = id;
		this.airline = airline;
		this.price = price;
		this.nOfMiles = nOfMiles;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Airline getAirline() {
		return airline;
	}

	public void setAirline(Airline airline) {
		this.airline = airline;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getnOfMiles() {
		return nOfMiles;
	}

	public void setnOfMiles(int nOfMiles) {
		this.nOfMiles = nOfMiles;
	}
	public List<Journey> getJourneys() {
		return journeys;
	}
		
	public void newJourney(Journey journey) {
		journeys.add(journey);
	}
	
	public int getNJourneys() {
		return journeys.size();
	}
	
}
