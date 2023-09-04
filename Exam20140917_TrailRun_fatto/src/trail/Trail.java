package trail;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Trail {
	
	private Map<Integer, Runner> runners = new HashMap<>();
	private int idRunner = 1;
	private Map<String, Location> locations = new LinkedHashMap<>();
	private Map<Integer, Location> locationsOrderNum = new LinkedHashMap<>();
	private int orderNum = 0;
	private Map<String, Delegate> delegates = new HashMap<>();
	private List<Passage> passages = new LinkedList<>();
	
    public int newRunner(String name, String surname){
        
    	runners.put(idRunner, new Runner(name, surname, idRunner));
    	
    	return idRunner++;
    }
    
    public Runner getRunner(int bibNumber){
        return runners.get(bibNumber);
    }
    
    public Collection<Runner> getRunner(String surname){
        return runners.values().stream().filter(r->r.getSurname().equals(surname)).sorted(Comparator.comparing(Runner::getBibNumber)).collect(Collectors.toList());
    }
    
    public List<Runner> getRunners(){
        return runners.values().stream().sorted(Comparator.comparing(Runner::getBibNumber)).collect(Collectors.toList());
    }

    public List<Runner> getRunnersByName(){
        return runners.values().stream().sorted(Comparator.comparing(Runner::getSurname).thenComparing(Runner::getName).thenComparing(Runner::getBibNumber)).collect(Collectors.toList());
    }
    
    public void addLocation(String location){
    	
    	Location l = new Location(location, orderNum);
    	locations.put(location, l);
    	locationsOrderNum.put(orderNum++,l);
        
    }
//    public void addLocation(String name, double lat, double lon, double elevation){
//        
//    }

    public Location getLocation(String location){
        return locations.get(location);
    }

    public List<Location> getPath(){
        return locationsOrderNum.values().stream().sorted(Comparator.comparing(Location::getOrderNum)).collect(Collectors.toList());
    }
    
    public void newDelegate(String name, String surname, String id){
        delegates.put(id, new Delegate(name, surname, id));
    }

    public List<String> getDelegates(){
        return delegates.values().stream().sorted(Comparator.comparing(Delegate::toString)).map(Delegate::toString).collect(Collectors.toList());
    }
    

    public void assignDelegate(String location, String delegate) throws TrailException {
    	
    	if(!delegates.containsKey(delegate)) throw new TrailException();
    	if(!locations.containsKey(location)) throw new TrailException();
    	
    	locations.get(location).newDelegate(delegates.get(delegate));
    	delegates.get(delegate).newLocation(locations.get(location));
       
    }
 
    public List<String> getDelegates(String location){
        return locations.get(location).getDelegates().stream().sorted(Comparator.comparing(Delegate::toString)).map(Delegate::toString).collect(Collectors.toList());
    }
    
    public long recordPassage(String delegate, String location, int bibNumber) throws TrailException {
    	
    	if(!delegates.containsKey(delegate)) throw new TrailException();
    	if(!locations.containsKey(location)) throw new TrailException();
    	if(!runners.containsKey(bibNumber)) throw new TrailException();
    	if(!delegates.get(delegate).isDelegateCompatibleLocation(location)) throw new TrailException();
    	
    	long time = System.currentTimeMillis();
    	Passage passage = new Passage(delegates.get(delegate), locations.get(location), runners.get(bibNumber), time);
    	
    	passages.add(passage);
    	delegates.get(delegate).newPassage(passage);
    	runners.get(bibNumber).newPassage(passage);
    	locations.get(location).newPassage(passage);
    	
        return time;
    }
    
    public long getPassTime(String position, int bibNumber) throws TrailException {
    	if(!locations.containsKey(position)) throw new TrailException();
    	if(!runners.containsKey(bibNumber)) throw new TrailException();
    	return runners.get(bibNumber).getPassTime(position);
    }
    
    public List<Runner> getRanking(String location){
        return locations.get(location).getPassages().stream().sorted(Comparator.comparing(Passage::getTime)).map(Passage::getRunner).collect(Collectors.toList());
    }

    public List<Runner> getRanking(){
        return runners.values().stream()
        		.sorted(Comparator.comparing(Runner::getLastPassageOrderNum,Collections.reverseOrder()).thenComparing(Runner::getLastPassageTime))
        		.collect(Collectors.toList())
        		;
    }
}
