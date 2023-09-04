package groups;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Customer {
	
	private String name;
	private List<Group> groups = new LinkedList<>();
	
	public Customer(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addGroup(Group group) {
		groups.add(group);
	}
	
	public List<String> getGroupsName(){
		
		List<String> res = new LinkedList<>();
		
		for(Group group: groups) {
			res.add(group.getName());
		}
		
		Collections.sort(res);
		
		return res;
		
	}
	
	public boolean inGroup(Group group) {
		return groups.contains(group);
	}

}
