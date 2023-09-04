package transactions;

public class Transaction {
	
	private String id;
	private Carrier carrier;
	private Request request;
	private Offer offer;
	private int score;
	
	
	public Transaction(String id, Carrier carrier, Request request, Offer offer) {
		super();
		this.id = id;
		this.carrier = carrier;
		this.request = request;
		this.offer = offer;
		this.score = 0;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Carrier getCarrier() {
		return carrier;
	}
	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
	}
	public Request getRequest() {
		return request;
	}
	public void setRequest(Request request) {
		this.request = request;
	}
	public Offer getOffer() {
		return offer;
	}
	public void setOffer(Offer offer) {
		this.offer = offer;
	}
	public String getProductId() {
		return this.request.getProductId();
	}
	public String getCarrierName() {
		return this.carrier.getName();
	}


}
