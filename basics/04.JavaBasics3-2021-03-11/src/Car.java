
public class Car {
	private String nome;
	public static int countCars = 0; 
	
	public Car(String n) {
		nome = n;
		countCars++;
	}
	public String getCar() {
		return nome;
	}
}
