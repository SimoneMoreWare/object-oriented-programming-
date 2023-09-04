package managingProperties;

public class Appartement {
	
	private Building building;
	private int n;
	private Owner owner;

	public Appartement(Building building, int n) {
		super();
		this.building = building;
		this.n = n;
	}
	
	public Appartement(Building building, int n, Owner owner) {
		super();
		this.building = building;
		this.n = n;
		this.owner = owner;
	}

	public Building getBuilding() {
		return building;
	}
	
	public void setBuilding(Building building) {
		this.building = building;
	}
	
	public int getN() {
		return n;
	}
	
	public void setN(int n) {
		this.n = n;
	}
	
	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	
	@Override
	public String toString() {
		return this.building.getId() + ":" + this.n;
	}
}
