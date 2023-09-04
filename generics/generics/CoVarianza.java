package generics;

public class CoVarianza {
	/*
	 * CT per cui CT<T> è il tipo costruito a partire da T tramite il definitore/costruttore CT
	 * 
	 * se CT è ARRAY e T è String : ARRAY<STRING>  è definito in Java come String[]
	 * 
	 * Un CT è co-variante se
	 * 
	 *  A -> B  ==>  CT<A> -> CT<B>
	 *  
	 *  String -> Object ==> ARRAY<STRING> -> ARRAY<OBJECT>
	 * 
	 */

	public static void main(String[] args) {
		
		Integer[] interi = {Integer.valueOf(1), Integer.valueOf(2)};
		
		// array in Java sono CO-VARIANTI
		
		Object[] array = interi;
		
		array[0] = "Pippo";  // <----
		
		int somma = interi[0] + interi[1];
		
		//----
		
		Wrapper w = new IntWrapper();
		Number n = Double.valueOf(3.14);
		w.setValore(n);
		

	}
	
	static class Wrapper{
		Number valore;
		public Number getValore() {
			return valore;
		}
		public void setValore(Number n) {
			valore = n;
		}
	}
	
	static class IntWrapper extends Wrapper {
		@Override
		public Integer getValore() {  // il tipo di ritorno è co-variante
			return valore.intValue();
		}
//		@Override
		public void setValore(Object n) {  // contro-variante (ma non in Java)
			//valore = n;
		}
}

}
