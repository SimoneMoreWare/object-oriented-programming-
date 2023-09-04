package ticketing;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

import ticketing.Ticket.State;

public class IssueManager {
	
	
    /**
     * Eumeration of valid user classes
     */
    public static enum UserClass {
        /** user able to report an issue and create a corresponding ticket **/
        Reporter, 
        /** user that can be assigned to handle a ticket **/
        Maintainer }
    
	private HashMap<String,Set<UserClass>> users = new HashMap<>();
	private HashMap<String,Component> components = new HashMap<>();
    private int idTicket = 1;
    private List<Ticket> tickets = new LinkedList<>();
    /**
     * Creates a new user
     * 
     * @param username name of the user
     * @param classes user classes
     * @throws TicketException if the username has already been created or if no user class has been specified
     */
    public void createUser(String username, UserClass... classes) throws TicketException {
    	
    	if(users.get(username)!=null) throw new TicketException();
    	if(classes.length==0) throw new TicketException();
    	
    	Set<UserClass> value = new TreeSet<>();
    	
    	for(UserClass u: classes) {
    		value.add(u);
    	}
    	
    	users.put(username, value);
    	
    }

    /**
     * Creates a new user
     * 
     * @param username name of the user
     * @param classes user classes
     * @throws TicketException if the username has already been created or if no user class has been specified
     */
    public void createUser(String username, Set<UserClass> classes) throws TicketException {
    
    	if(users.get(username)!=null) throw new TicketException();
    	if(classes.size()==0) throw new TicketException();
    	
    	users.put(username, classes);
    }
   
    /**
     * Retrieves the user classes for a given user
     * 
     * @param username name of the user
     * @return the set of user classes the user belongs to
     */
    public Set<UserClass> getUserClasses(String username){
    	return users.get(username);
    }
    
    /**
     * Creates a new component
     * 
     * @param name unique name of the new component
     * @throws TicketException if a component with the same name already exists
     */
    public void defineComponent(String name) throws TicketException {
        	
    		if(components.get(name)!=null) throw new TicketException();
    		
    		Component component = new Component(name);
    		    		
    		components.put(name, component);
    }
    
    /**
     * Creates a new sub-component as a child of an existing parent component
     * 
     * @param name unique name of the new component
     * @param parentPath path of the parent component
     * @throws TicketException if the the parent component does not exist or 
     *                          if a sub-component of the same parent exists with the same name
     */
    public void defineSubComponent(String name, String parentPath) throws TicketException {
        
    	if(components.get(name)!=null) throw new TicketException();
    	
    	String parentComponents[] = parentPath.split("/");
    	
    	int len = parentComponents.length;
    	

    	for(String parentComponent: parentComponents) if(parentComponent!="") if(components.get(parentComponent)==null) throw new TicketException();
    	
     	Component subComponent = new Component(name);
     	subComponent.addParent(components.get(parentComponents[len-1]));
     	
     	components.put(name,subComponent);
     	
     	components.get(parentComponents[len-1]).addSUbComponent(subComponent);
    	
    }
    
    /**
     * Retrieves the sub-components of an existing component
     * 
     * @param path the path of the parent
     * @return set of children sub-components
     */
    public Set<String> getSubComponents(String path){
        
    	String parentComponents[] = path.split("/");
    	
    	return components.get(parentComponents[parentComponents.length - 1]).getSubComponents();
    }

    /**
     * Retrieves the parent component
     * 
     * @param path the path of the parent
     * @return name of the parent
     */
    public String getParentComponent(String path){
        String parentComponents[] = path.split("/");
        
        Component child = components.get(parentComponents[parentComponents.length - 1]);
        
    	return child.getParentName();
    }

    /**
     * Opens a new ticket to report an issue/malfunction
     * 
     * @param username name of the reporting user
     * @param componentPath path of the component or sub-component
     * @param description description of the malfunction
     * @param severity severity level
     * 
     * @return unique id of the new ticket
     * 
     * @throws TicketException if the user name is not valid, the path does not correspond to a defined component, 
     *                          or the user does not belong to the Reporter {@link IssueManager.UserClass}.
     */
    public int openTicket(String username, String componentPath, String description, Ticket.Severity severity) throws TicketException {
        
    	if(users.get(username)==null) throw new TicketException();
    	if(users.get(username).contains(UserClass.Reporter)==false) throw new TicketException();
    	
    	String pathComponents[] = componentPath.split("/");
    	
    	for(String pathComponent: pathComponents) {
    		if(pathComponent!="") {
    			if(components.get(pathComponent)==null) throw new TicketException();
    		}
    	}
    	
    	Ticket ticket = new Ticket(username,componentPath,description,severity,idTicket);
    	tickets.add(ticket);
    	return idTicket++;
    }
    
    /**
     * Returns a ticket object given its id
     * 
     * @param ticketId id of the tickets
     * @return the corresponding ticket object
     */
    public Ticket getTicket(int ticketId){
    	
    	if(ticketId >= idTicket) return null;
        return tickets.get(ticketId-1);
    }
    
    /**
     * Returns all the existing tickets sorted by severity
     * 
     * @return list of ticket objects
     */
    public List<Ticket> getAllTickets(){
    	Collections.sort(tickets, Comparator.comparing(Ticket::getSeverity));
        return tickets;
    }
    
    /**
     * Assign a maintainer to an open ticket
     * 
     * @param ticketId  id of the ticket
     * @param username  name of the maintainer
     * @throws TicketException if the ticket is in state <i>Closed</i>, the ticket id or the username
     *                          are not valid, or the user does not belong to the <i>Maintainer</i> user class
     */
    public void assingTicket(int ticketId, String username) throws TicketException {
        
    	if(ticketId >= idTicket) throw new TicketException();
    	if(users.get(username)==null) throw new TicketException();
    	if(users.get(username).contains(UserClass.Maintainer)==false) throw new TicketException();
    	if(tickets.get(ticketId-1).getState()==State.Closed) throw new TicketException();
    	tickets.get(ticketId-1).setUsernameMaintainer(username);
    	tickets.get(ticketId-1).setState(State.Assigned);
    	
    }

    /**
     * Closes a ticket
     * 
     * @param ticketId id of the ticket
     * @param description description of how the issue was handled and solved
     * @throws TicketException if the ticket is not in state <i>Assigned</i>
     */
    public void closeTicket(int ticketId, String description) throws TicketException {
        
    	if(tickets.get(ticketId-1).getState() != State.Assigned) throw new TicketException();
    	
    	tickets.get(ticketId-1).setDescriptionSolution(description);
    	tickets.get(ticketId-1).setState(State.Closed);
    	
    }

    /**
     * returns a sorted map (keys sorted in natural order) with the number of  
     * tickets per Severity, considering only the tickets with the specific state.
     *  
     * @param state state of the tickets to be counted, all tickets are counted if <i>null</i>
     * @return a map with the severity and the corresponding count 
     */
    public SortedMap<Ticket.Severity,Long> countBySeverityOfState(Ticket.State state){
        if(state==null) {
        	return tickets.stream().
        			collect(Collectors.groupingBy(Ticket::getSeverity,TreeMap::new,Collectors.counting()))
        			;
        }else {
        	return tickets.stream().
        			filter( t -> t.getState() == state).
        			collect(Collectors.groupingBy(Ticket::getSeverity,TreeMap::new,Collectors.counting()))
        			;
        	
        	
        }
    }

    /**
     * Find the top maintainers in terms of closed tickets.
     * 
     * The elements are strings formatted as <code>"username:###"</code> where <code>username</code> 
     * is the user name and <code>###</code> is the number of closed tickets. 
     * The list is sorter by descending number of closed tickets and then by username.

     * @return A list of strings with the top maintainers.
     */
    public List<String> topMaintainers(){
        return tickets.stream().
        		filter( t -> t.getState() == State.Closed).
        		collect(Collectors.groupingBy(Ticket::getMaintainer,Collectors.counting())).
        		entrySet().
        		stream(). 
        		map( entry -> entry.getKey() + ":" + entry.getValue()).
                collect(Collectors.toList()).
                stream(). 
                sorted((str1, str2) -> {
                    String[] parts1 = str1.split(":");
                    String[] parts2 = str2.split(":");
                    
                    int value1 = Integer.parseInt(parts1[1]);
                    int value2 = Integer.parseInt(parts2[1]);

                    if (value1 != value2) {
                        return Integer.compare(value2, value1); // Sort by value in descending order
                    }
                    return parts1[0].compareTo(parts2[0]); // If values are equal, sort by name in alphabetical order
                }). 
                collect(Collectors.toList());
    }

}
