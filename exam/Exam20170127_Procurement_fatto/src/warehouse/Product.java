package warehouse;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Product {

	private String code;
	private String description;
	private int quantity;
	private List<Supplier> suppliers = new LinkedList<>();
	private List<Order> orders = new LinkedList<>();
	
	public Product(String code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public String getCode(){
		return this.code;
	}

	public String getDescription(){
		return this.description;
	}
	
	public void setQuantity(int quantity){
		this.quantity = quantity;
	}

	public void decreaseQuantity(){
		this.quantity = this.quantity - 1;
	}

	public int getQuantity(){
		return this.quantity;
	}
	
	public void newSupplier(Supplier supplier) {
		suppliers.add(supplier);
	}

	public List<Supplier> suppliers(){
		return suppliers.stream().sorted(Comparator.comparing(Supplier::getNome)).collect(Collectors.toList());
	}
	
	public void newOrder(Order order) {
		orders.add(order);
	}

	public List<Order> pendingOrders(){
		return orders.stream().filter( o -> !o.delivered()).sorted(Comparator.comparing(Order::getQuantity).reversed()).collect(Collectors.toList());
	}
}
