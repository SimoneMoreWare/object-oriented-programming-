
public class Car {
	private String color;
	private String brand;
	private boolean turnedOn;
	
	public Car (String color, String brand) {
		this.color = color; //Copia la referenza di color in this.color
		this.brand = brand;
		this.turnedOn = false;
	}
	
	public Car (String color) {
		this.color = color; //Copia la referenza di color in this.color
		this.brand = "ferrari";
		this.turnedOn = false;	
	}
	
	
	public void turnOn() {
		turnedOn=true;
	}
	
	public void turnOff() {
		turnedOn=false;
	}
	
	public void paint (String newcol) {
		this.color = newcol;
	}
	
	public void printState() {
		System.out.println("Car "+ brand + " " + color);
		System.out.print("The engin is ");
		if (turnedOn == true) {
			System.out.println("On");
		} else {
			System.out.println("Off");
		}
	}
}
