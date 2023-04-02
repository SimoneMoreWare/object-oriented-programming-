package generics;

public class CoVarianza {

	public static void main(String[] args) {
		
		Integer[] interi = {Integer.valueOf(1), Integer.valueOf(2)};
		
		// array in Java sono CO-VARIANTI
		
		Object[] array = interi;
		
		array[0] = "Pippo";  // <----
		
		int somma = interi[0] + interi[1];

	}

}
