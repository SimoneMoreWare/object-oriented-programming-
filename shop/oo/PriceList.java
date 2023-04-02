package shop.oo;

public class PriceList {
	/**
	 * maximum number of products that can be managed
	 */
	static final int MAX_LIST = 100; 
	// constant, similar to: #define MAX_LIST 100

	private Product[] products = new Product[MAX_LIST];

	public PriceList() {
		products[1] = new Product("Garlic 4pc", 1.5); 

		products[2] = new Product("Olive Oil 1L", 8.5); 
		
		products[3] = new Product("Pepper 500g", 3.5); 
		
		products[4] = new Product("Potato 5Kg", 11.2); 

	}
	
	public Product findProduct(int code) {
		return products[code];
	}
	
}
