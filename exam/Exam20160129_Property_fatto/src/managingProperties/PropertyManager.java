package managingProperties;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

import managingProperties.Request.State;

public class PropertyManager {
	
	private HashMap<String,Building> buildings = new HashMap<>();
	private HashMap<String,Owner> owners = new HashMap<>();
	private HashMap<String,Owner> appartements = new HashMap<>();
	private HashMap<String,Appartement> mapAppartements = new HashMap<>();
	private List<String> listAppartements = new LinkedList<>();
	private HashMap<String,Profession> professionals = new HashMap<>();
	private HashMap<String,Professional> mapProfessionals = new HashMap<>();
	private List<Profession> professions = new LinkedList<>();
	private int idRequest = 1;
	private ArrayList<Request> requests = new ArrayList<>();
 	/**
	 * Add a new building 
	 */
	public void addBuilding(String building, int n) throws PropertyException {
		
		if(buildings.get(building)!=null) throw new PropertyException();
		if(n<1 || n>100) throw new PropertyException();
		
		Building b = new Building(building,n);
		
		buildings.put(building, b);
		
	}

	public void addOwner(String owner, String... apartments) throws PropertyException {
		
		if(owners.get(owner)!=null) throw new PropertyException();
		
		Owner o = new Owner(owner);
		
		for(String appartement: apartments) {
			
			if(appartements.get(appartement)!=null) throw new PropertyException();
			
			String arrayStringAppartements[] = appartement.split(":");
			
			String building = arrayStringAppartements[0];
			if(buildings.get(building)==null) throw new PropertyException();
			
			Integer n = Integer.parseInt(arrayStringAppartements[1]);
			if(n<1 || n>buildings.get(building).getNumberAppartements()) throw new PropertyException();

			Appartement a = new Appartement(buildings.get(building),n,o);
			o.addAppartement(a);
			buildings.get(building).addAppartement(a);
			
			listAppartements.add(appartement);
			
			appartements.put(appartement, o);
			mapAppartements.put(appartement, a);
		}
		
		owners.put(owner, o);
		
	}

	/**
	 * Returns a map ( number of apartments => list of buildings ) 
	 * 
	 */
	public SortedMap<Integer, List<String>> getBuildings() {
		SortedMap<Integer, List<String>> res = buildings.values().stream().
												sorted(Comparator.comparing(Building::getNumberAppartements)).
												sorted(Comparator.comparing(Building::getId)).
												collect(Collectors.groupingBy(Building::getNumberAppartements,TreeMap::new,Collectors.mapping( b -> b.getId(), Collectors.toList())));
				;
		
		return res;
	}

	public void addProfessionals(String profession, String... professionals) throws PropertyException {
		
		int flag = 0;
		
		for(Profession prof: professions) {
			System.out.println(prof.getName());
			if(prof.getName().equals(profession)) flag = 1;
		}
		
		if(flag==1) throw new PropertyException();
		
		Profession newProfession = new Profession(profession);
		
		professions.add(newProfession);
		
		for(String p: professionals) {
		
			if(this.professionals.get(p)!=null) throw new PropertyException();
			
			Professional newProfessional = new Professional(p,newProfession);
			newProfession.addProfessional(newProfessional);
			
			this.professionals.put(p, newProfession);
			mapProfessionals.put(p, newProfessional);
			
		}
		
		
		
	}

	/**
	 * Returns a map ( profession => number of workers )
	 *
	 */
	public SortedMap<String, Integer> getProfessions() {
		
		return professions.stream().
				sorted(Comparator.comparing(Profession::getName)).
				collect(Collectors.toMap(Profession::getName,Profession::getNumberProfessional,(p1,p2) -> p1,TreeMap::new));
	}

	public int addRequest(String owner, String apartment, String profession) throws PropertyException {
		
		if(owners.get(owner)==null) throw new PropertyException();
		if(listAppartements.contains(apartment)==false) throw new PropertyException();
		
		int flag = 0;
		
		for(Profession prof: professions) {
			if(prof.getName().equals(profession)) flag = 1;
		}
		
		if(flag==0) throw new PropertyException();
		
		if(owners.get(owner).ownerHaveAppartement(apartment) == false) throw new PropertyException();
		
		Profession p = null; 
		
		for(Profession prof: professions) {
			if(prof.getName().equals(profession)) {
				p = prof;
				break;
			}
		} 
		
		Request request = new Request(owners.get(owner), mapAppartements.get(apartment), p,State.Pending,idRequest);
		
		requests.add(request);
		
		return idRequest++;
	}

	public void assign(int requestN, String professional) throws PropertyException {
		
		if(requestN >= idRequest) throw new PropertyException();
		if(requests.get(requestN-1).getState()!=State.Pending) throw new PropertyException();
		if( (professionals.get(professional).getName()).equals(requests.get(requestN-1).getProfession().getName()) == false ) throw new PropertyException();
		
		requests.get(requestN-1).setProfessional(mapProfessionals.get(professional));
		requests.get(requestN-1).setState(State.Assigned);
		
	}

	public List<Integer> getAssignedRequests() {
		
		return requests.stream().filter(r->r.getState()==State.Assigned).map(Request::getId).collect(Collectors.toList());
	}

	
	public void charge(int requestN, int amount) throws PropertyException {
		
		if(amount<0 || amount>1000) throw new PropertyException();
		if(requestN >= idRequest)  throw new PropertyException();
		if(requests.get(requestN-1).getState()!=State.Assigned) throw new PropertyException();
		
		requests.get(requestN-1).setAmount(amount);
		requests.get(requestN-1).setState(State.Completed);
		
	}

	/**
	 * Returns the list of request ids
	 * 
	 */
	public List<Integer> getCompletedRequests() {
		
		return requests.stream().filter( r -> r.getState()==State.Completed).map(Request::getId).collect(Collectors.toList());
	}
	
	/**
	 * Returns a map ( owner => total expenses )
	 * 
	 */
	public SortedMap<String, Integer> getCharges() {
		
		return requests.stream().
				filter( r -> r.getState()==State.Completed).
				collect(Collectors.groupingBy(r -> r.getOwner().getId(), TreeMap::new, Collectors.summingInt(Request::getAmount)));
				
	}

	/**
	 * Returns the map ( building => ( profession => total expenses) ).
	 * Both buildings and professions are sorted alphabetically
	 * 
	 */
	public SortedMap<String, Map<String, Integer>> getChargesOfBuildings() {
		
		return requests.stream().filter(r->r.getState()==State.Completed).
				collect(Collectors.groupingBy(
						r -> r.getAppartement().getBuilding().getId(),
						TreeMap::new,
						Collectors.groupingBy(r->r.getProfessional().getId(),TreeMap::new,Collectors.summingInt(Request::getAmount))
						)
						);
	}

}
