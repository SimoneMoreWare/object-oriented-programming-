package carShare;



public class Subscriber {

	private String card;
	private Reserve reserve;

	public Subscriber(String card) {
		super();
		this.card = card;
		this.reserve = null;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public Reserve getReserve() {
		return reserve;
	}

	public void setReserve(Reserve reserve) {
		this.reserve = reserve;
	}


	
}
