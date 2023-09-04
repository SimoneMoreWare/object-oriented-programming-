package frequentFlyers;

import java.util.LinkedList;
import java.util.List;

public class Journey {
	
	private FrequentFlyer frequentFlyer;
	private List<Flight> flights = new LinkedList<>();
	private int id;
	private int point;
	private int price; 
	
	public Journey(FrequentFlyer frequentFlyer, int id) {
		super();
		this.frequentFlyer = frequentFlyer;
		this.id = id;
		this.point = 0;
		this.price = 0;
	}

	public FrequentFlyer getFrequentFlyer() {
		return frequentFlyer;
	}

	public void setFrequentFlyer(FrequentFlyer frequentFlyer) {
		this.frequentFlyer = frequentFlyer;
	}

	public List<Flight> getFlights() {
		return flights;
	}
	
	public int getNFlights() {
		return flights.size();
	}
	
	public void newFlight(Flight flight) {
		flights.add(flight);
		this.point = this.point + flight.getnOfMiles();
		this.price = this.price + flight.getPrice();
	}
	
	public void newFlight(Flight flight, int point, int price) {
		flights.add(flight);
		this.point = this.point + point;
		this.price = this.price + price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	

}
