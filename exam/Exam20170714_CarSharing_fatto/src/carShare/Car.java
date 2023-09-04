package carShare;

import java.util.LinkedList;
import java.util.List;

import carShare.CarService.Status;

public class Car {

	private Parking parking;
	private String licencePlate;
	private double minRate;
	private double kmRate;
	private Status status;
	private List<Reserve> reserves = new LinkedList<>();
	
	public Car(Parking parking, String licencePlate, double minRate, double kmRate) {
		super();
		this.parking = parking;
		this.licencePlate = licencePlate;
		this.minRate = minRate;
		this.kmRate = kmRate;
		this.status = Status.AVAILABLE;
	}
	
	public Parking getParking() {
		return parking;
	}
	public void setParking(Parking parking) {
		this.parking = parking;
	}
	public String getLicencePlate() {
		return licencePlate;
	}
	public void setLicencePlate(String licencePlate) {
		this.licencePlate = licencePlate;
	}
	public double getMinRate() {
		return minRate;
	}
	public void setMinRate(double minRate) {
		this.minRate = minRate;
	}
	public double getKmRate() {
		return kmRate;
	}
	public void setKmRate(double kmRate) {
		this.kmRate = kmRate;
	}
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<Reserve> getReserves() {
		return reserves;
	}
	
	public void newReserve(Reserve reserve) {
		reserves.add(reserve);
	}
	
	public void deleteReserve(Reserve reserve) {
		reserves.remove(reserve);
	}
	
}
