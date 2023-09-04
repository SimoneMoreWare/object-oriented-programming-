package sports;

import java.util.LinkedList;
import java.util.List;

public class Activity {
	
	public String name;
	private List<Category> categories = new LinkedList<>();
	private List<Product> products = new LinkedList<>();

	public Activity(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public void newCategory(Category category) {
		categories.add(category);
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
	
	public boolean isAvailable() {
		
		for(Product product: products) {
			if(product.getNumRatings()!=0) return true;
		}
		
		return false;
		
	}
	
	public double getAvgStarsProducts() {
		return products.stream().flatMap(p->p.getRatings().stream()).mapToDouble(p->p.getNumStars()).average().orElse(0.0);
	}

}
