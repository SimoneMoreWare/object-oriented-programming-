package sports;

import java.util.LinkedList;
import java.util.List;

public class Category {

	private String name;
	private List<Activity> activities = new LinkedList<>();
	private List<Product> products = new LinkedList<>();
	 
	public Category(String name) {
		super();
		this.name = name;
	}
	
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Activity> getActivities() {
		return activities;
	}
	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}
	public void newActivity(Activity activity) {
		activities.add(activity);
	}
	public void newProduct(Product product) {
		products.add(product);
	}
	
}
