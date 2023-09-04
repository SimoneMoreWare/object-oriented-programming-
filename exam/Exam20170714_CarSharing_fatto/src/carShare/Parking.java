package carShare;

import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import carShare.CarService.Status;

public class Parking {

	private String name;
	private List<Car> cars = new LinkedList<>();
	private List<Reserve> reserves = new LinkedList<>();

	public Parking(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Car> getCars() {
		return cars;
	}
	
	public void newCar(Car car) {
		cars.add(car);
	}

	public SortedSet<String> getAvaibleCars() {
		
		SortedSet<String> res = new TreeSet<>();
		
		for(Car car: cars) {
			if(car.getStatus()==Status.AVAILABLE) res.add(car.getLicencePlate());
		}
		
		return res;
	}

	public List<Reserve> getReserves() {
		return reserves;
	}
	
	public void newReserve(Reserve reserve) {
		reserves.add(reserve);
	}
	
	public String getFirstAvaibleCar() {
		
		SortedSet<String> res = new TreeSet<>();
		
		for(Car car: cars) {
			if(car.getStatus()==Status.AVAILABLE) res.add(car.getLicencePlate());
		}
		if(res.size()==0) return null;
		return res.first();
		
	}
	public void deleteReserve(Reserve reserve) {
		reserves.remove(reserve);
	}

	public void deleteCar(Car car) {
		cars.remove(car);
	}
	
}
