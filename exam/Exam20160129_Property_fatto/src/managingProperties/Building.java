package managingProperties;

import java.util.LinkedList;
import java.util.List;

public class Building {
	
	private String id;
	private int numberAppartements;
	private List<Appartement> appartements = new LinkedList<>();
	
	public Building(String id, int numberAppartements) {
		super();
		this.id = id;
		this.numberAppartements = numberAppartements;
	}

	public int getNumberAppartements() {
		return numberAppartements;
	}

	public void setNumberAppartements(int numberAppartements) {
		this.numberAppartements = numberAppartements;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public void addAppartement(Appartement appartement) {
		appartements.add(appartement);
	}
	

}
