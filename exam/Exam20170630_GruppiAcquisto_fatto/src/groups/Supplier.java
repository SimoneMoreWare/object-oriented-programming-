package groups;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Supplier {
	
	private String name;
	private List<Group> groups = new LinkedList<>();
	private List<Product> products = new LinkedList<>();
	private List<Bid> bids = new LinkedList<>();
	
	public Supplier(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getNumberBids() {
		return bids.size();
	}
	
	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<Bid> getBids() {
		return bids;
	}

	public void setBids(List<Bid> bids) {
		this.bids = bids;
	}

	public void addProduct(Product product) {
		products.add(product);
	}
	
	public List<String> getNameProducts(){
		
		List<String> res = new LinkedList<>();
		
		for(Product product: products) {
			res.add(product.getTypeName());
		}
		
		Collections.sort(res);
		
		return res;
		
	}
	
	public void addGroup(Group group) {
		groups.add(group);
	}
	
	public boolean haveProduct(Product product) {
		return products.contains(product);
	}
	
	public boolean inGroup(Group group) {
		return groups.contains(group);
	}

	public void addBid(Bid bid) {
		bids.add(bid);
	}
	
	public boolean hasBid(Group group) {
		
		for(Bid bid: bids) {
			if(this.getName().equals(bid.getNameSupplier())==true) return true;
		}
		return false;
	}
}
