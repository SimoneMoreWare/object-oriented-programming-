package shop.procedural;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShopRegister {
	/**
	 * maximum number of products that can be managed
	 */
	static final int MAX_LIST = 100; 
	// constant, similar to: #define MAX_LIST 100
	
	/**
	 * maximum number of items that can be added to a receipt
	 */
	static final int MAX_RCPT = 20; 
	// constant, similar to: #define MAX_RCPT 20

	/**
	 * prices of the products
	 */	
	static double prices[] = new double[MAX_LIST];
	// declaration	 definition/allocation
	
	/**
	 * description of the products
	 */	
	static String[] names = new String[MAX_LIST];
	// circa: char* names[MAX_LIST];
	
	/**
	 * codes of the items in the receipt
	 */	
	static int receipt[] = new int[MAX_RCPT];
	// analogo a: int receipt[MAX_RCPT];

	/**
	 * number of items currently added in the receipt
	 */
	static int n_items;

	/**
	 * The main application that loops until a product with code 0 is entered and then prints the receipt
	 * @param args
	 */
	public static void main(String[] args) {
		init();
		int code;
		while ((code = read()) != 0) {
			add(code);
		}
		print();
	}
	
	/**
	 * 
	 * Initializes all data structures
	 */
	static void init() {
		n_items = 0;
		
		names[0] = "End of products!"; // fake product
		prices[0] = 0.0;
		names[1] = "Garlic 4pc";
		prices[1] = 1.5;
		names[2] = "Olive Oil 1L";
		prices[2] = 8.5;
		names[3] = "Pepper 500g";
		prices[3] = 3.5;
		names[4] = "Potato 5Kg";
		prices[4] = 11.2;
		// ...
		System.out.println("Please enter product codes: ");
	}
	
	static void add(int product) {
		receipt[n_items++] = product;
	}

	static void print() {
		double total = 0.0;
		System.out.println("Receipt:");
		for(int i=0; i<n_items; ++i) {
			double price = prices[receipt[i]];
			System.out.println(names[receipt[i]] + "\t" + price);
			total+=price;
		}
		System.out.println("-------");
		System.out.println("Number of items: " + n_items);
		System.out.println("Total: " + total);
	}
	
	//--------------------------------------
	// Nasty Java details below here...
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	
	static int read() {
		try {
			return Integer.parseInt(input.readLine());
		} catch (IOException e) {
			e.printStackTrace();
			return -1;
		}
	}


}
