package restaurantChain;

public class Reserve {
	
	public enum Status {BOOKED, ORDERED};
	public enum PayStatus {NO, YES};
	
	private String name;
	private int persons;
	private Status status;
	private PayStatus payStatus;
	private double pay;
	
	public Reserve(String name, int persons) {
		super();
		this.name = name;
		this.persons = persons;
		this.status = Status.BOOKED;
		this.payStatus = PayStatus.NO;
		this.pay = 0.0;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPersons() {
		return persons;
	}
	public void setPersons(int persons) {
		this.persons = persons;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public PayStatus getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(PayStatus payStatus) {
		this.payStatus = payStatus;
	}
	public double getPay() {
		return pay;
	}
	public void setPay(double pay) {
		this.pay = pay;
	}
	


}
