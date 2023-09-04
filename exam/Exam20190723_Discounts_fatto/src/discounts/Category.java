package discounts;

import java.util.LinkedList;
import java.util.List;

public class Category {
	
	private String id;
	private List<Product> products = new LinkedList<>();
	private Discount discount;
	
	public Category(String id) {
		super();
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public List<Product> getProducts() {
		return products;
	}
	
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public void newProduct(Product product) {
		products.add(product);
	}

	public int getAvgPrice() {
		
		double res = 0.0;
		
		for(Product product: products) {
			res = res + product.getPrice();
		}
		
		return (int) Math.ceil(res/products.size()-0.5);
	}

	public Discount getDiscount() {
		return discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}
	
}
