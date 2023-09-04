package groups;

public class Vote {
	
	private Group group;
	private Customer customer;
	private Supplier supplier;
	private Bid bid;
	
	

	public Bid getBid() {
		return bid;
	}

	public void setBid(Bid bid) {
		this.bid = bid;
	}

	public Vote(Group group, Customer customer, Supplier supplier, Bid bid) {
		super();
		this.group = group;
		this.customer = customer;
		this.supplier = supplier;
		this.bid = bid;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}	
	
}
