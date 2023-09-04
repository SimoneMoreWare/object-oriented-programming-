package groups;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;


public class GroupHandling {
	
	private HashMap<String,Product> products = new HashMap<>();
	private HashMap<String,Supplier> suppliers = new HashMap<>();
	private HashMap<String,Group> groups = new HashMap<>();
	private HashMap<String,Customer> customers = new HashMap<>();
	private HashMap<String,Bid> bids = new HashMap<>();
	private List<Vote> votes = new LinkedList<>();
	//R1	
	public void addProduct (String productTypeName, String... supplierNames) 
			throws GroupHandlingException {
		
		if(products.get(productTypeName)!=null) throw new GroupHandlingException();
		
		Product product = new Product(productTypeName);
		
		for(String supplierName: supplierNames) {
			Supplier s = null;
			if(suppliers.get(supplierName)==null) {
				s = new Supplier(supplierName);
			}else {
				s = suppliers.get(supplierName);
			}
			product.addSupplier(s);
			s.addProduct(product);
			suppliers.put(supplierName, s);
		}
		
		products.put(productTypeName, product);
		
		
		
	}
	
	public List<String> getProductTypes (String supplierName) {
		return suppliers.get(supplierName).getNameProducts();
	}
	
//R2	
	public void addGroup (String name, String productName, String... customerNames) 
			throws GroupHandlingException {
		
		if(products.get(productName)==null) throw new GroupHandlingException("unknown product");
		if(groups.get(name)!=null)  throw new GroupHandlingException();
		
		Group group = new Group(name,products.get(productName));
		
		for(String customerName: customerNames) {
			
			Customer customer = null;
			if(customers.get(customerName)==null) {
				customer = new Customer(customerName);
			}else {
				customer = customers.get(customerName);
			}
			
			customer.addGroup(group);
			group.addCustomer(customer);
			customers.put(customerName,customer);
		}
		
		groups.put(name, group);
		
	}
	
	public List<String> getGroups (String customerName) {
        return customers.get(customerName).getGroupsName();
	}

//R3
	public void setSuppliers (String groupName, String... supplierNames)
			throws GroupHandlingException {
		
		for(String supplierName: supplierNames) {
			
			if( suppliers.get(supplierName) == null) throw new GroupHandlingException();
			if( suppliers.get(supplierName).haveProduct(groups.get(groupName).getProduct()) == false ) throw new GroupHandlingException();
			
			groups.get(groupName).addSupplier(suppliers.get(supplierName));
			suppliers.get(supplierName).addGroup(groups.get(groupName));
		}
		
	}
	
	public void addBid (String groupName, String supplierName, int price)
			throws GroupHandlingException {
		
		if(suppliers.get(supplierName).inGroup(groups.get(groupName))==false) throw new GroupHandlingException();
		
		Bid bid = new Bid(groups.get(groupName), suppliers.get(supplierName), price);
		
		groups.get(groupName).addBid(bid);
		suppliers.get(supplierName).addBid(bid);
		
		bids.put(groupName,bid);
		
	}
	
	public String getBids (String groupName) {
        return groups.get(groupName).getBids();
	}
	
	
//R4	
	public void vote (String groupName, String customerName, String supplierName)
			throws GroupHandlingException {
		
		if(customers.get(customerName).inGroup(groups.get(groupName))==false) throw new GroupHandlingException();
		if(suppliers.get(supplierName).hasBid(groups.get(groupName))==false) throw new GroupHandlingException();
		
		Bid bid =  groups.get(groupName).getBid(supplierName);
		Vote vote = new Vote(groups.get(groupName), customers.get(customerName), suppliers.get(supplierName), bid);
		bid.setnVotes();
		votes.add(vote);
	}
	
	public String  getVotes (String groupName) {
        return groups.get(groupName).getVotes();
	}
	
	public String getWinningBid (String groupName) {
        return groups.get(groupName).getWinningBid();
	}
	
//R5
	public SortedMap<String, Integer> maxPricePerProductType() { //serve toMap
		return bids.values().stream()
		.collect(Collectors.toMap(Bid::getNameProduct, Bid::getPrice, 
			(p1,p2) -> {return p1 >= p2 ? p1:p2;}, TreeMap::new));
	}
	
	public SortedMap<Integer, List<String>> suppliersPerNumberOfBids() {
		return suppliers.values().stream()
	            .filter(s -> !s.getBids().isEmpty())
	            .collect(Collectors.groupingBy(
	                Supplier::getNumberBids,
	                () -> new TreeMap<>(Collections.reverseOrder()),
	                Collectors.collectingAndThen(
	                    Collectors.mapping(Supplier::getName, Collectors.toList()),
	                    list -> {
	                        Collections.sort(list);
	                        return list;
	                    }
	                )
	            ));
	}
	
	public SortedMap<String, Long> numberOfCustomersPerProductType() {
        return groups.values().stream().
        		filter(g->!g.getCustomers().isEmpty()).
        		collect(Collectors.groupingBy(Group::getProductName,TreeMap::new,Collectors.summingLong(Group::getNumberCustomers)) );
	}
	
}
