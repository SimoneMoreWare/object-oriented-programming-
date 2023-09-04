package it.polito.oop.milliways;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Party {
	
	private HashMap<Race,Integer> tableCompanions = new HashMap<>();
	private Hall hall;

    public void addCompanions(Race race, int num) {
    	if(tableCompanions.get(race)==null) tableCompanions.put(race, num);
    	else tableCompanions.put(race, tableCompanions.get(race) + num);
	}

	public int getNum() {
        return tableCompanions.values().stream().mapToInt(Integer::intValue).sum();
	}

	public int getNum(Race race) {
	    return tableCompanions.get(race);
	}

	public List<String> getRequirements() {
        Set<String> res = tableCompanions.keySet().stream().flatMap(r->r.getRequirements().stream()).collect(Collectors.toSet());
        List<String> listRes = new LinkedList<>(res);
		Collections.sort(listRes);
        return listRes;
	}

    public Map<String,Integer> getDescription(){
        return tableCompanions.entrySet().stream().collect(Collectors.toMap(e->e.getKey().getName(),Map.Entry::getValue));
    }

    public HashMap<Race, Integer> getTableCompanions() {
		return tableCompanions;
	}

	public void setHall(Hall hall) {
    	this.hall = hall;
    }

	public Hall getHall() {
		return hall;
	}
    
}
