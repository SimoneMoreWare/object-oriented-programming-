package managingProperties;

public class Request {
	
	/**
     * Enumeration of possible severity levels for the tickets.
     * 
     * Note: the natural order corresponds to the order of declaration
     */
    public enum State { Pending, Assigned, Completed};
	
	private Owner owner;
	private Appartement appartement;
	private Profession profession;
	private State state;
	private int id;
	private Professional professional;
	private int amount;
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Request(Owner owner, Appartement appartement, Profession p, State state, int idRequest) {
		this.owner = owner;
		this.appartement = appartement;
		this.profession = p;
		this.state = state;
		this.id = idRequest;
	}
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	public Appartement getAppartement() {
		return appartement;
	}
	public void setAppartement(Appartement appartement) {
		this.appartement = appartement;
	}
	public Profession getProfession() {
		return profession;
	}
	public void setProfession(Profession profession) {
		this.profession = profession;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Professional getProfessional() {
		return professional;
	}
	public void setProfessional(Professional professional) {
		this.professional = professional;
	}
	
}
