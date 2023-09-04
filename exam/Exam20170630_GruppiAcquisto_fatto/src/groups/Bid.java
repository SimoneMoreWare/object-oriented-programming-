package groups;

public class Bid {
	
	private Group group;
	private Supplier supplier;
	private int price;
	private int nVotes;
	

	public Bid(Group group, Supplier supplier, int price) {
		super();
		this.group = group;
		this.supplier = supplier;
		this.price = price;
		this.nVotes = 0;
	}
	
	public int getnVotes() {
		return nVotes;
	}

	public void setnVotes() {
		this.nVotes++;
	}

	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getNameSupplier() {
		return this.supplier.getName();
	}
	
	public String getNameProduct() {
		return this.group.getProduct().getTypeName();
	}
	
}
