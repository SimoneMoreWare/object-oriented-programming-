package ticketing;

/**
 * Class representing the ticket linked to an issue or malfunction.
 * 
 * The ticket is characterized by a severity and a state.
 */
public class Ticket {
	
	private String username;
	private String componentPath;
	private String description;
	private Severity severity;
	private int id;
	private State state;
	private String usernameMaintainer;
	private String descriptionSolution;
    
    /**
     * Enumeration of possible severity levels for the tickets.
     * 
     * Note: the natural order corresponds to the order of declaration
     */
    public enum Severity { Blocking, Critical, Major, Minor, Cosmetic };
    
    /**
     * Enumeration of the possible valid states for a ticket
     */
    public static enum State { Open, Assigned, Closed }
    
    public Ticket(String username, String componentPath, String description, Severity severity, int id) {
		this.username = username;
		this.componentPath = componentPath;
		this.description = description;
		this.severity = severity;
		this.id = id;
		this.state = State.Open;
	}

	public int getId(){
        return id;
    }

    public String getDescription(){
        return description;
    }
    
    public Severity getSeverity() {
        return severity;
    }

    public String getAuthor(){
        return username;
    }
    
    public String getComponent(){
        return componentPath;
    }
    
    public State getState(){
        return state;
    }
    
    public void setState(State state) {
    	this.state = state;
    }
    
    public void setUsernameMaintainer(String usernameMaintainer) {
    	this.usernameMaintainer = usernameMaintainer;
    }
    
    public void setDescriptionSolution(String descriptionSolution) {
    	this.descriptionSolution = descriptionSolution;
    }
    
    public String getSolutionDescription() throws TicketException {
    	
    	if(this.state != State.Closed) throw new TicketException();
    	
        return descriptionSolution;
    }
    
    public String getMaintainer() {
    	return usernameMaintainer;
    }
}
