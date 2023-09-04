package transactions;

public class Request {

	private String id;
	private String placeName;
	private String productId;
	
	public Request(String id, String placeName, String productId) {
		super();
		this.id = id;
		this.placeName = placeName;
		this.productId = productId;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	
	
}
