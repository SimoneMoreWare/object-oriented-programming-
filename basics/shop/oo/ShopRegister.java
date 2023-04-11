package shop.oo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShopRegister {
	
	static PriceList priceList = new PriceList();
	
	/**
	 * The main application that loops until a product with code 0 
	 * is entered and then prints the receipt
	 * 
	 */
	public static void main(String[] args) {
		//init();
		Receipt r = new Receipt();

		System.out.println("Please enter product codes: ");

		int code;
		while ((code = read()) != 0) {
			r.add(priceList.findProduct(code));
		}
		r.print();
	}
	
	/**
	 * 
	 * Initializes all data structures
	 */

	static void init() {
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
