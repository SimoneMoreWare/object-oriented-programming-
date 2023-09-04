package discounts;

public class Item {
	
	private Product product;
	private int n;
	
	public Item(Product product, int n) {
		super();
		this.product = product;
		this.n = n;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}
	
	

}
