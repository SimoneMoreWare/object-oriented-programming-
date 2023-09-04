package sports;

public class Rating {
	
	private Product product;
	private String userName;
	private int numStars;
	private String comment;
	private int id;
	
	public Rating(Product product, String userName, int numStars, String comment, int id) {
		super();
		this.product = product;
		this.userName = userName;
		this.numStars = numStars;
		this.comment = comment;
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getNumStars() {
		return numStars;
	}

	public void setNumStars(int numStars) {
		this.numStars = numStars;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return numStars+" : "+comment;
	}
	

}
