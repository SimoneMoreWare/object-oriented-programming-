package transactions;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Region {
	
	private String name;
	private Set<String> placeNames = new TreeSet<>();
	private List<Carrier> carriers = new LinkedList<>();
	
	public Region(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public void addNamePlace(String namePlace) {
		this.placeNames.add(namePlace);
	}
	
	public List<String> getPlaceNames(){
		return placeNames.stream().collect(Collectors.toList());
	}
	
	public void addCarrier(Carrier carrier) {
		carriers.add(carrier);
	}
	
	public List<String> getCarriers(){
		return carriers.stream().sorted(Comparator.comparing(Carrier::getName)).map(Carrier::getName).collect(Collectors.toList());
	}
	
	public boolean regionHavePlace(String placeName) {
		return placeNames.contains(placeName);
	}

}
