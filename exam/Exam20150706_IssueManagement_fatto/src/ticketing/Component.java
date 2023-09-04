package ticketing;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Component {
	
	private String name;
	private List<Component> subComponents = new LinkedList<>();
	private Component parent;
	
	public Component(String name) {
		this.name = name;
		this.parent = null;
	}
	
	public String getName() {
		return name;
	}
	
	public void addSUbComponent(Component component) {
		subComponents.add(component);
	}
	
	public Set<String> getSubComponents(){
		
		Set<String> res = new TreeSet<>();
		
		for(Component subComponent: subComponents) {
			res.add(subComponent.getName());
		}
		
		return res;
		
	}
	
	public void addParent(Component component) {
		this.parent = component;
	}
	
	public String getParentName() {
		if(parent==null) return null;
		return parent.getName();
	}

}
