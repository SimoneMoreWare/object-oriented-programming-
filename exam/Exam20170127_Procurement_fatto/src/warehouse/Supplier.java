package warehouse;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Supplier {
	
	private String code;
	private String name;
	private List<Product> products = new LinkedList<>();
	private List<Order> orders = new LinkedList<>();
	
	public Supplier(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCodice(){
		return this.code;
	}

	public String getNome(){
		return this.name;
	}
	
	public void newSupply(Product product){
		product.newSupplier(this);
		products.add(product);
	}
	
	public List<Product> supplies(){
		return products.stream().sorted(Comparator.comparing(Product::getDescription)).collect(Collectors.toList());
	}
	
	public boolean isValidProduct(Product product) {
		return products.contains(product);
	}
	
	public void newOrder(Order order) {
		orders.add(order);
	}
}
