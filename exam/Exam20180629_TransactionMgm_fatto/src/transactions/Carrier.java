package transactions;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Carrier {
	
	private String name;
	private List<Region> regions = new LinkedList<>();
	
	public Carrier(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addRegion(Region region) {
		if(regions.contains(region)==false) regions.add(region); 
	}
	
	public List<String> getRegions(){
		return regions.stream().sorted(Comparator.comparing(Region::getName)).map(Region::getName).collect(Collectors.toList());
	}
	
	public boolean carrierServePlace(String namePlace) {
		
		for(Region region: regions) {
			if(region.regionHavePlace(namePlace)==true) return true;
		}
		
		return false;
		
	}

}
