package groups;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Group {
	
	private String name;
	private Product product;
	private List<Customer> customers = new LinkedList<>();
	private List<Supplier> suppliers = new LinkedList<>();
	private List<Bid> bids = new LinkedList<>();
	
	public Group(String name, Product product) {
		this.name = name;
		this.product = product;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public void addCustomer(Customer customer) {
		customers.add(customer);
	}
	
	public void addSupplier(Supplier supplier) {
		suppliers.add(supplier);
	}
	
	public void addBid(Bid bid) {
		bids.add(bid);
	}
	
	public String getBids() {
		
		List<String> generateList = bids.stream().
				collect(Collectors.groupingBy(Bid::getNameSupplier,Collectors.summingInt(Bid::getPrice))).
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
                        return Integer.compare(value1, value2); // Sort by value in ascending order
                    }
                    return parts1[0].compareTo(parts2[0]); // If values are equal, sort by name in alphabetical order
                }). 
                collect(Collectors.toList());
				
				
       StringBuffer res = new StringBuffer();;
       
       for(String bid: generateList) {
    	   res.append(bid).append(",");
       }
       res.deleteCharAt(res.length() - 1);

       return res.toString();
	}
	
	public Bid getBid(String supplierName) {
		for(Bid bid: bids) {
			if( (bid.getNameSupplier()).equals(supplierName) == true ) return bid;
		}
		return null;
	}
	
	public List<Bid> getListBid() {
		return bids;
	}
	
	public String getVotes() {
		
		List<String> generateList = bids.stream().
				collect(Collectors.groupingBy(Bid::getNameSupplier,Collectors.summingInt(Bid::getnVotes))).
				entrySet().
        		stream(). 
        		filter( entry -> entry.getValue()!=0).
        		map( entry -> entry.getKey() + ":" + entry.getValue()).
                collect(Collectors.toList()).
                stream(). 
                sorted((str1, str2) -> {
                    String[] parts1 = str1.split(":");
                    String[] parts2 = str2.split(":");
                    
                    int value1 = Integer.parseInt(parts1[1]);
                    int value2 = Integer.parseInt(parts2[1]);

                    if (value1 != value2) {
                        return Integer.compare(value1, value2); // Sort by value in ascending order
                    }
                    return parts1[0].compareTo(parts2[0]); // If values are equal, sort by name in alphabetical order
                }). 
                collect(Collectors.toList());;
				
				
       StringBuffer res = new StringBuffer();;
       
       for(String bid: generateList) {
    	   res.append(bid).append(",");
       }
       res.deleteCharAt(res.length() - 1);

       return res.toString();
	}
	
	public String getWinningBid() {
		
		Bid bid = bids.stream().
				collect(Collectors.maxBy(Comparator.comparing(Bid::getnVotes).thenComparing(Comparator.comparing(Bid::getPrice).reversed()))).orElse(null)
				;
		
		if(bid==null) return null;
		
		String res = "";
		
		res = res + bid.getNameSupplier() + ":" + bid.getnVotes();
		
		return res;
		
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public List<Supplier> getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(List<Supplier> suppliers) {
		this.suppliers = suppliers;
	}

	public void setBids(List<Bid> bids) {
		this.bids = bids;
	}

	public String getProductName() {
		return this.product.getTypeName();
	}
	
	public Long getNumberCustomers() {
		return (long) customers.size();
	}
}
