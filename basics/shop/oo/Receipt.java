package shop.oo;

public class Receipt {
	/**
	 * maximum number of items that can be added to a receipt
	 */
	static final int MAX_RCPT = 20; 

	/**
	 * references to the items in the receipt
	 */	
	static Product items[] = new Product[MAX_RCPT];

	/**
	 * number of items currently added in the receipt
	 */
	static int n_items;

	public void add(Product item) {
		items[n_items++] = item;
	}

	public void print() {
		double total = 0.0;
		System.out.println("Receipt:");
		for(int i=0; i<n_items; ++i) {
			double price = items[i].getPrice();
			System.out.println(items[i].toStr());
			total+=price;
		}
		System.out.println("-------");
		System.out.println("Number of items: " + n_items);
		System.out.println("Total: " + total);
	}
}
