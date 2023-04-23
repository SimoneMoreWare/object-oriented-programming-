package generics;

public class CoVariance {

	public static void main(String[] args) {
		
		
		Pair<Integer> pi = new Pair<>(0,1);
//		Pair<Object> pn = pi;  // <-- Type mismatch: cannot convert from Pair<Integer> to Pair<Object>
//		pn.set1st("0.5");
//		Integer i = pi.first();  // <-- so that this cannot happen!

	
		
		
		String[] as = new String[10];
		Object[] ao;
		ao = as; // this is ok because arrays are covariant
//		ao[1] = new Integer(1); // --> ArrayStoreException: java.lang.Integer

		
		printPair(pi);
		
		
	}

	static <T> void printPairG(Pair<T> p) {
		  System.out.println(p.first()+ "-" + 
		                     p.second());
		}
	// EQUIVALENT TO
	static void printPair(Pair<?> p) {
		  System.out.println(p.first()+ "-" + 
		                     p.second());
		}

	static void nullFirst(Pair<?> p) {
//		  p.set1st("");  // <-- The method set1st(?) in the type Pair<?> is not applicable for the arguments (String)
	}

}
