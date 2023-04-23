package base;
@SuppressWarnings("unused")

public class ExObjectReference {

	public static void main(String[] args) {
		Car a1, a2; 
		a1 = new Car();
		a1.paint("yellow");
		a2 = a1; 
		a1 = null;
		a2 = null;
	}

}
