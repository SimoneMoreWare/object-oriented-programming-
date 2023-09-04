package warehouse;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Warehouse {
	
	private HashMap<String,Product> products = new HashMap<>();
	private HashMap<String,Supplier> suppliers = new HashMap<>();
	private HashMap<String,Order> orders = new HashMap<>();
	private int idOrder = 1;
	private String ORD = "ORD";
	
	public Product newProduct(String code, String description){
		Product product = new Product(code,description);
		products.put(code,product);
		return product;
	}
	
	public Collection<Product> products(){
		return products.values();
	}

	public Product findProduct(String code){
		return products.get(code);
	}

	public Supplier newSupplier(String code, String name){
		Supplier supplier = new Supplier(code, name);
		suppliers.put(code, supplier);
		return supplier;
	}
	
	public Supplier findSupplier(String code){
		return suppliers.get(code);
	}

	public Order issueOrder(Product prod, int quantity, Supplier supp)
		throws InvalidSupplier {
		
		if(supp.isValidProduct(prod)==false) throw new InvalidSupplier();
		
		String code = ORD + idOrder++;
		Order order = new Order(prod,quantity,supp,code);
		orders.put(code, order);
		
		prod.newOrder(order);
		supp.newOrder(order);
		
		return order;
		
	}

	public Order findOrder(String code){
		return orders.get(code);
	}
	
	public List<Order> pendingOrders(){
		return orders.values().stream().filter( o -> !o.delivered()).sorted(Comparator.comparing(Order::getProductCode)).collect(Collectors.toList());
	}

	public Map<String,List<Order>> ordersByProduct(){
	    return orders.values().stream().
	    		collect(Collectors.groupingBy(
	    										Order::getProductCode
	    									  )
	    				)
	    		;
	}
	
	public Map<String,Long> orderNBySupplier(){
	    return orders.values().stream().
	    		filter( o -> o.delivered() ).
	    		collect(Collectors.groupingBy(
	    										Order::getSupplierName,
	    										TreeMap::new,
	    										Collectors.counting()
	    									 )
	    			   )
	    		;
	}
	
	public List<String> countDeliveredByProduct(){
	    return orders.values().stream().
	    		filter( o -> o.delivered() ).
	    		collect(Collectors.groupingBy(
	    										Order::getProductCode,
	    										HashMap::new,
	    										Collectors.counting()
	    									 )
	    			   ).
	    		entrySet().stream().
	    		map( entry -> entry.getKey() + " - " + entry.getValue()).
	    		collect(Collectors.toList()).stream(). 
                sorted((str1, str2) -> {
                    String[] parts1 = str1.split(" - ");
                    String[] parts2 = str2.split(" - ");
                    
                    int value1 = Integer.parseInt(parts1[1]);
                    int value2 = Integer.parseInt(parts2[1]);

                    if (value1 != value2) {
                        return Integer.compare(value2, value1); // Sort by value in decrease order
                    }
                    return parts1[0].compareTo(parts2[0]); // If values are equal, sort by name in alphabetical order
                }). 
                collect(Collectors.toList());
	    		
	}
}
