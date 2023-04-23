package inheritance;

public class ElectricCar extends Car {

	boolean cellsAreCharged;

	void recharge() {
		cellsAreCharged = true;
	}

	void turnOn() {
		if(cellsAreCharged) {
			turnedOn = true;
		}
	}
}
