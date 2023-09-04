package it.polito.oop.milliways;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;


public class Restaurant {
	
	private HashMap<String,Race> races = new HashMap<>();
	private List<Party> parties = new LinkedList<>();
	private HashMap<Integer,Hall> halls = new LinkedHashMap<>();
	
    public Restaurant() {
	}
	
	public Race defineRace(String name) throws MilliwaysException{
	    
		if(races.get(name)!=null) throw new MilliwaysException();
		
		Race race = new Race(name);
		
		races.put(name,race);
		
		return race;
		
	}
	
	public Party createParty() {
		Party party = new Party();
		parties.add(party);
	    return party;
	}
	
	public Hall defineHall(int id) throws MilliwaysException{
		
		if(halls.get(id)!=null) throw new MilliwaysException();
		
		Hall hall = new Hall(id);
		
		halls.put(id, hall);
		
	    return hall;
	}

	public List<Hall> getHallList() {
		return halls.values().stream().collect(Collectors.toList());
	}

	public Hall seat(Party party, Hall hall) throws MilliwaysException {
		
		if(hall.isSuitable(party)==false) throw new MilliwaysException();
		
		party.setHall(hall);
		hall.newParty(party);
		
        return hall;
	}

	public Hall seat(Party party) throws MilliwaysException {
		
		for(Hall hall: halls.values()) {
			if(hall.isSuitable(party)==true) {
				party.setHall(hall);
				hall.newParty(party);
				return hall;
			}
		}
		
		throw new MilliwaysException();
	}

	public Map<Race, Integer> statComposition() {
		return halls.values().stream().
				flatMap(h->h.getParties().stream()).
				flatMap(p -> p.getTableCompanions().entrySet().stream()).
				collect(Collectors.groupingBy(Map.Entry::getKey, HashMap::new, Collectors.summingInt(Map.Entry::getValue)));
				
	}

	public List<String> statFacility() {
        return halls.values().stream().
        		flatMap(h->h.getFacilities().stream()).
        		collect(Collectors.groupingBy(String::toString,TreeMap::new,Collectors.counting())).
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
                        return Integer.compare(value2, value1); // Sort by value in discending order
                    }
                    return parts1[0].compareTo(parts2[0]); // If values are equal, sort by name in alphabetical order
                }). 
                map( s -> s.split(":")[0]).
                collect(Collectors.toList());
        		
	}
	
	public Map<Integer,List<Integer>> statHalls() {
        return halls.values().stream().
        		collect(Collectors.groupingBy(
        										h -> h.getFacilities().size(), 
        										TreeMap::new, 
        										Collectors.mapping(
        															Hall::getId, 
        															Collectors.collectingAndThen(
        																							Collectors.toList(),
        																							list -> list.stream()
        																                            .sorted()
        																                            .collect(Collectors.toList())
        																						)
        															)
        										)
        				);
	}

}
