package delivery;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import delivery.Delivery.OrderStatus;

public class Order {
	
	private Customer customer;
	private int id;
	private Map<MenuItem,Integer> items = new HashMap<>();
    private Delivery.OrderStatus status;
    
    public Order(Customer customer, int id) {
    	this.customer = customer;
    	this.id = id;
    	this.status = OrderStatus.NEW;
    }
    
    public void addItem(MenuItem item, Integer quantity) {
    	if(items.get(item)==null) items.put(item, quantity);
    	else items.put(item, items.get(item)+quantity);
    }
    
    public int getQuantityForElemet(MenuItem item) {
    	return items.get(item);
    }
    
    public List<String> getElements(){
    	
    	List<String> res = new LinkedList<>();
    	
    	for(Map.Entry<MenuItem, Integer> entry : items.entrySet()) {

    		MenuItem item = entry.getKey();
    		Integer qty = entry.getValue();
        	System.out.print(item.getDescription());
        	System.out.println(qty);
    		res.add(item.getDescription() + ", " + qty);
    	}

    	return res;
    	
    }

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Map<MenuItem, Integer> getItems() {
		return items;
	}

	public void setItems(Map<MenuItem, Integer> items) {
		this.items = items;
	}

	public Delivery.OrderStatus getStatus() {
		return status;
	}

	public void setStatus(Delivery.OrderStatus status) {
		this.status = status;
	}
	
	public double getTotalAmount() {
		
		double res = 0.0;
		
		for(Map.Entry<MenuItem,Integer> entry: items.entrySet()) {
			
			MenuItem item = entry.getKey();
			Integer qty = entry.getValue();
			
			res = res + (double) qty * item.getPrice();
			
		}
		
		return res;
		
	}
	
	public int getDeliveryTime(int delay, int transportation) {
		
		int res = 0;
		
		int maxPrep = 0;
		
		for(Map.Entry<MenuItem,Integer> entry: items.entrySet()) {
			
			MenuItem item = entry.getKey();
			
			if(item.getPrepTime() > maxPrep) maxPrep = item.getPrepTime();
			
		}
		
		res = delay + maxPrep + transportation;
		
		return res;
		
	}
    
	public int getDeliveryTime(int transportation) {
		
		int res = 0;
		
		int maxPrep = 0;
		
		for(Map.Entry<MenuItem,Integer> entry: items.entrySet()) {
			
			MenuItem item = entry.getKey();
			
			if(item.getPrepTime() > maxPrep) maxPrep = item.getPrepTime();
			
		}
		
		res = maxPrep + transportation;
		
		return res;
		
	}
}
