package carShare;

public class Reserve {

	private Subscriber subscriber;
	private Parking parking;
	private Car car;
	private double amount;
	private Parking endParking;
	
	public Reserve(Subscriber subscriber, Parking parking, Car car) {
		super();
		this.subscriber = subscriber;
		this.parking = parking;
		this.car = car;
		this.amount = 0.0;
	}
	public Subscriber getSubscriber() {
		return subscriber;
	}
	public void setSubscriber(Subscriber subscriber) {
		this.subscriber = subscriber;
	}
	public Parking getParking() {
		return parking;
	}
	public void setParking(Parking parking) {
		this.parking = parking;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	
	public String getLicensePlateCar() {
		return car.getLicencePlate();
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public Parking getEndParking() {
		return endParking;
	}
	public void setEndParking(Parking endParking) {
		this.endParking = endParking;
	}
	@Override
	public String toString() {
		return subscriber.getCard()+":"+car.getLicencePlate()+":"+amount+":"+parking.getName()+":"+endParking.getName();
	}
	

}
