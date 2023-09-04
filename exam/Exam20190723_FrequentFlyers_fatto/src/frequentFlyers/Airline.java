package frequentFlyers;

import java.util.LinkedList;
import java.util.List;

public class Airline {
	
	private String name;
	private Alliance alliance;
	private List<Flight> flights = new LinkedList<>();
	
	public Airline(String name) {
		super();
		this.name = name;
		this.alliance = null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Alliance getAlliance() {
		return alliance;
	}

	public void setAlliance(Alliance alliance) {
		this.alliance = alliance;
	}

	public List<Flight> getFlights() {
		return flights;
	}
	
	public void newFlight(Flight flight) {
		flights.add(flight);
	}
	
	public int getNFlights() {
		return flights.size();
	}
	
	

}
