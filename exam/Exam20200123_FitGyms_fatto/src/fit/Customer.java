package fit;

import java.util.LinkedList;
import java.util.List;

public class Customer {
	
	private String name;
	private int id;
	private List<Reservation> reservations = new LinkedList<>();
	private List<Gym> gyms = new LinkedList<>();
	
	public Customer(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void newReservation(Reservation reservation) {
		reservations.add(reservation);
	}
	
	public void newGym(Gym gym) {
		gyms.add(gym);
	}
	
	public int getReservationsSize() {
		return this.reservations.size();
	}

}
