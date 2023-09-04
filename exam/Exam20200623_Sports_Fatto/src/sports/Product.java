package sports;

import java.util.LinkedList;
import java.util.List;

public class Product {
	
	private String name;
	private Activity activity;
	private Category category;
	private List<Rating> ratings = new LinkedList<>();
	
	public Product(String name, Activity activity, Category category) {
		super();
		this.name = name;
		this.activity = activity;
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Activity getActivity() {
		return activity;
	}
	public void setActivity(Activity activity) {
		this.activity = activity;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public List<Rating> getRatings() {
		return ratings;
	}
	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}
	public void newRating(Rating rating) {
		ratings.add(rating);
	}
	public int getNumRatings() {
		return ratings.size();
	}
	public double getAvgNumStars() {
		return ratings.stream().mapToDouble(Rating::getNumStars).average().orElse(0.0);
	}
}
