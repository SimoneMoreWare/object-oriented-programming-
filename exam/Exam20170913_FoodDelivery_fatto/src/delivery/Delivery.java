package delivery;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Delivery {
	
	private int idCustomer = 1;
	private HashMap<String,Customer> mailCustomers = new HashMap<>();
	private HashMap<Integer,Customer> idCustomers = new HashMap<>();
	private HashMap<String,MenuItem> menuItems = new HashMap<>();
	private int idOrder = 1;
	private HashMap<Integer,Order> orders = new HashMap<>();
    public static enum OrderStatus { NEW, CONFIRMED, PREPARATION, ON_DELIVERY, DELIVERED } 
    
    /**
     * Creates a new customer entry and returns the corresponding unique ID.
     * 
     * The ID for the first customer must be 1.
     * 
     * 
     * @param name name of the customer
     * @param address customer address
     * @param phone customer phone number
     * @param email customer email
     * @return unique customer ID (positive integer)
     */
    public int newCustomer(String name, String address, String phone, String email) throws DeliveryException {
        
    	if(mailCustomers.get(email)!=null) throw new DeliveryException();
    	
    	Customer customer = new Customer(name, address, phone, email, idCustomer);
    	
    	mailCustomers.put(email, customer);
    	idCustomers.put(idCustomer,customer);
    	
    	return idCustomer++;
    }
    
    /**
     * Returns a string description of the customer in the form:
     * <pre>
     * "NAME, ADDRESS, PHONE, EMAIL"
     * </pre>
     * 
     * @param customerId
     * @return customer description string
     */
    public String customerInfo(int customerId){
        return idCustomers.get(customerId).toString();
    }
    
    /**
     * Returns the list of customers, sorted by name
     * 
     */
    public List<String> listCustomers(){
        return idCustomers.values().stream().sorted(Comparator.comparing(Customer::getName)).map(Customer::toString).collect(Collectors.toList());
    }
    
    /**
     * Add a new item to the delivery service menu
     * 
     * @param description description of the item (e.g. "Pizza Margherita", "Bunet")
     * @param price price of the item (e.g. 5 EUR)
     * @param category category of the item (e.g. "Main dish", "Dessert")
     * @param prepTime estimate preparation time in minutes
     */
    public void newMenuItem(String description, double price, String category, int prepTime){
        
    	MenuItem menuItem = new MenuItem(description,price,category,prepTime);
    	
    	menuItems.put(description, menuItem);
    	
    }
    
    /**
     * Search for items matching the search string.
     * The items are sorted by category first and then by description.
     * 
     * The format of the items is:
     * <pre>
     * "[CATEGORY] DESCRIPTION : PRICE"
     * </pre>
     * 
     * @param search search string
     * @return list of matching items
     */
    public List<String> findItem(String search){
    	
    	List<String> res = new LinkedList<>();
    	
    	for (Map.Entry<String, MenuItem> entry : menuItems.entrySet()) {
    	    String key = entry.getKey();
    	    MenuItem value = entry.getValue();   	    
    	    if(key.toLowerCase().contains(search.toLowerCase())==true) res.add(value.toString());
    	    
    	}
    	
    	Collections.sort(res);
    	
        return res;
        
    }
    
    /**
     * Creates a new order for the given customer.
     * Returns the unique id of the order, a progressive
     * integer number starting at 1.
     * 
     * @param customerId
     * @return order id
     */
    public int newOrder(int customerId){
    	Order order = new Order(idCustomers.get(customerId), idOrder);
        orders.put(idOrder,order);
    	return idOrder++;
    }
    
    /**
     * Add a new item to the order with the given quantity.
     * 
     * If the same item is already present in the order is adds the
     * given quantity to the current quantity.
     * 
     * The method returns the final total quantity of the item in the order. 
     * 
     * The item is found through the search string as in {@link #findItem}.
     * If none or more than one item is matched, then an exception is thrown.
     * 
     * @param orderId the id of the order
     * @param search the item search string
     * @param qty the quantity of the item to be added
     * @return the final quantity of the item in the order
     * @throws DeliveryException in case of non unique match or invalid order ID
     */
    public int addItem(int orderId, String search, int qty) throws DeliveryException {
    	
    	if(orders.get(orderId)==null) throw new DeliveryException();
    	int countItem = 0;
    	for (Map.Entry<String, MenuItem> entry : menuItems.entrySet()) {
    	    String key = entry.getKey();
    	    if(key.toLowerCase().contains(search.toLowerCase())==true) {
    	    	countItem ++;
    	    }
    	}
    	if(countItem!=1) throw new DeliveryException();
    	
    	for (Map.Entry<String, MenuItem> entry : menuItems.entrySet()) {
    		
    	    String key = entry.getKey();
    	    MenuItem value = entry.getValue();
    	   
    	    if(key.toLowerCase().contains(search.toLowerCase())==true) {

    	    	orders.get(orderId).addItem(value, qty);
    	        return orders.get(orderId).getQuantityForElemet(value);
    	    }
    	    
    	}
    	
    	return -1;
    }
    
    /**
     * Show the items of the order using the following format
     * <pre>
     * "DESCRIPTION, QUANTITY"
     * </pre>
     * 
     * @param orderId the order ID
     * @return the list of items in the order
     * @throws DeliveryException when the order ID in invalid
     */
    public List<String> showOrder(int orderId) throws DeliveryException {
    	
    	if(orders.get(orderId)==null) throw new DeliveryException();
    	
        return orders.get(orderId).getElements();
    }
    
    /**
     * Retrieves the total amount of the order.
     * 
     * @param orderId the order ID
     * @return the total amount of the order
     * @throws DeliveryException when the order ID in invalid
     */
    public double totalOrder(int orderId) throws DeliveryException {
    	
    	if(orders.get(orderId)==null) throw new DeliveryException();

    	
        return orders.get(orderId).getTotalAmount();
    }
    
    /**
     * Retrieves the status of an order
     * 
     * @param orderId the order ID
     * @return the current status of the order
     * @throws DeliveryException when the id is invalid
     */
    public OrderStatus getStatus(int orderId) throws DeliveryException {
    	if(orders.get(orderId)==null) throw new DeliveryException();
        return orders.get(orderId).getStatus();
    }
    
    /**
     * Confirm the order. The status goes from {@code NEW} to {@code CONFIRMED}
     * 
     * Returns the delivery time estimate computed as the sum of:
     * <ul>
     * <li>start-up delay (conventionally 5 min)
     * <li>preparation time (max of all item preparation time)
     * <li>transportation time (conventionally 15 min)
     * </ul>
     * 
     * @param orderId the order id
     * @return delivery time estimate in minutes
     * @throws DeliveryException when order ID invalid to status not {@code NEW}
     */
    public int confirm(int orderId) throws DeliveryException {
    	if(orders.get(orderId)==null) throw new DeliveryException();
    	if(orders.get(orderId).getStatus()!=OrderStatus.NEW) throw new DeliveryException();
    	
    	orders.get(orderId).setStatus(OrderStatus.CONFIRMED);
    	
        return orders.get(orderId).getDeliveryTime(5,15);
    }

    /**
     * Start the order preparation. The status goes from {@code CONFIRMED} to {@code PREPARATION}
     * 
     * Returns the delivery time estimate computed as the sum of:
     * <ul>
     * <li>preparation time (max of all item preparation time)
     * <li>transportation time (conventionally 15 min)
     * </ul>
     * 
     * @param orderId the order id
     * @return delivery time estimate in minutes
     * @throws DeliveryException when order ID invalid to status not {@code CONFIRMED}
     */
    public int start(int orderId) throws DeliveryException {
    	
    	if(orders.get(orderId)==null) throw new DeliveryException();
    	if(orders.get(orderId).getStatus()!=OrderStatus.CONFIRMED) throw new DeliveryException();
    	
    	orders.get(orderId).setStatus(OrderStatus.PREPARATION);
    	
        return orders.get(orderId).getDeliveryTime(15);
    }

    /**
     * Begins the order delivery. The status goes from {@code PREPARATION} to {@code ON_DELIVERY}
     * 
     * Returns the delivery time estimate computed as the sum of:
     * <ul>
     * <li>transportation time (conventionally 15 min)
     * </ul>
     * 
     * @param orderId the order id
     * @return delivery time estimate in minutes
     * @throws DeliveryException when order ID invalid to status not {@code PREPARATION}
     */
    public int deliver(int orderId) throws DeliveryException {
    	
    	if(orders.get(orderId)==null) throw new DeliveryException();
    	if(orders.get(orderId).getStatus()!=OrderStatus.PREPARATION) throw new DeliveryException();
    	
    	orders.get(orderId).setStatus(OrderStatus.ON_DELIVERY);

        return 15;

    }
    
    /**
     * Complete the delivery. The status goes from {@code ON_DELIVERY} to {@code DELIVERED}
     * 
     * 
     * @param orderId the order id
     * @return delivery time estimate in minutes
     * @throws DeliveryException when order ID invalid to status not {@code ON_DELIVERY}
     */
    public void complete(int orderId) throws DeliveryException {
    	
    	if(orders.get(orderId)==null) throw new DeliveryException();
    	if(orders.get(orderId).getStatus()!=OrderStatus.ON_DELIVERY) throw new DeliveryException();
    	
    	orders.get(orderId).setStatus(OrderStatus.DELIVERED);

    }
    
    /**
     * Retrieves the total amount for all orders of a customer.
     * 
     * @param customerId the customer ID
     * @return total amount
     */
    public double totalCustomer(int customerId){
        return orders.values().stream().
                filter(o->o.getStatus()!=OrderStatus.NEW).
        		filter( o -> o.getCustomer().getId() == customerId).
        		mapToDouble(Order::getTotalAmount).sum()
        		;
    }
    
    /**
     * Computes the best customers by total amount of orders.
     *  
     * @return the classification
     */
    public SortedMap<Double,List<String>> bestCustomers(){
    	 Map<String,Double> totals = orders.values().stream().
                 filter(o->o.getStatus()!=OrderStatus.NEW).
                 collect(Collectors.groupingBy(o->o.getCustomer().toString(),Collectors.summingDouble(Order::getTotalAmount)));
    
    	 return totals.entrySet().stream().
    			 collect(Collectors.groupingBy(entry->entry.getValue(),
    					 					   ()->new TreeMap<Double,List<String>>(Collections.reverseOrder()),
    					 					   Collectors.mapping(entry->entry.getKey().toString(), Collectors.toList())
    					 					  )
    					 )
    			 ;
    }
    
// NOT REQUIRED
//
//    /**
//     * Computes the best items by total amount of orders.
//     *  
//     * @return the classification
//     */
//    public List<String> bestItems(){
//        return null;
//    }
//    
//    /**
//     * Computes the most popular items by total quantity ordered.
//     *  
//     * @return the classification
//     */
//    public List<String> popularItems(){
//        return null;
//    }

}
