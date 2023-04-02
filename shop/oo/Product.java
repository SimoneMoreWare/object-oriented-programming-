package shop.oo;

public class Product {
	// by default all attributes are private
	private double price;
	private String description;
	
	// constructor
	Product(String d, double p){
		description = d;
		price = p;
	}
	
	// getter method
	double getPrice() {
		return price;
	}
	
	String toStr() {
		return description + "\t" + price;
	}
}

