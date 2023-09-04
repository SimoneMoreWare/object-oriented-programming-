package warehouse;

public class Order {
	
	private Product product;
	private int quantity;
	private Supplier supplier;
	private String code;
	private boolean delivered;
	
	public Order(Product product, int quantity, Supplier supplier, String code) {
		super();
		this.product = product;
		this.quantity = quantity;
		this.supplier = supplier;
		this.code = code;
		this.delivered = false;
	}

	public String getCode(){
		return code;
	}
	
	public boolean delivered(){
		return delivered;
	}

	public void setDelivered() throws MultipleDelivery {
		
		if(this.delivered) throw new MultipleDelivery();
		
		this.delivered = true;
		product.setQuantity( product.getQuantity() + quantity);
	}
	
	public String toString(){
		return "Order " + code + " for " + quantity + " of " + product.getCode() + " : " + product.getDescription() + " from " + supplier.getNome();
	}
	
	public String getProductCode() {
		return this.product.getCode();
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	public String getSupplierName() {
		return this.supplier.getNome();
	}
}
