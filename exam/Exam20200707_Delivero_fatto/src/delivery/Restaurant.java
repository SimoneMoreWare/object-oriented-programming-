package delivery;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Restaurant {
	
	private String name;
	private String category;
	private List<Dish> dishes = new LinkedList<>();
	
	public Restaurant(String name, String category) {
		this.name = name;
		this.category = category;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public void addDish(String nameDish, float price) {
		dishes.add(new Dish(nameDish, price));
	}
	
	public List<String> dishCompatible(float minprice, float maxprice){
		List<String> value = new LinkedList<>();
		for(Dish dish: dishes) {
			if(minprice<=dish.getPrice() && dish.getPrice()<=maxprice) value.add(dish.getName());
		}
		return value;
	}
	
	public List<String> getNameDishesSort(){
		
		List<String> value = new LinkedList<>();
		
		for(Dish dish: dishes) {
			value.add(dish.getName());
		}
		
		Collections.sort(value);
		
		return value;
	}

	public boolean hasDish(String name) {
		for(Dish dish: dishes) {
			if(dish.getName()==name) return true;
		}
		return false;
	}
}
