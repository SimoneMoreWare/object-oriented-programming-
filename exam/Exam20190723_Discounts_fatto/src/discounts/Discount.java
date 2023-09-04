package discounts;

public class Discount {
	
	private Category category;
	private int percentage;
	
	public Discount(Category category, int percentage) {
		super();
		this.category = category;
		this.percentage = percentage;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getPercentage() {
		return percentage;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}
	
}
