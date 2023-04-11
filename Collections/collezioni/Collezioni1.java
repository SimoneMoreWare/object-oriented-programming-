package collezioni;
import java.util.*;
public class Collezioni1 {
	public static void main(String[] args) {
		Set<String> hs; hs = new HashSet<String>(); 	
		Set<String> ripetuti = new TreeSet<String>(); 
		String[] v = {"alfa", "beta", "alfa", "delta", "beta"};
		for (String s:v) 
			if (!hs.add(s)) ripetuti.add(s);
		System.out.println(hs + " " + ripetuti); // [alfa, delta, beta] [alfa, beta]
		System.out.println(hs.contains("gamma")); // false
		System.out.println(hs.containsAll(ripetuti)); // true
		Object[] v1 = hs.toArray();
		System.out.println(Arrays.toString(v1)); // [alfa, delta, beta]
		String[] v2 = new String[hs.size()];
		hs.toArray(v2);
		System.out.println(Arrays.toString(v2)); // [alfa, delta, beta]
		Set<String> hs1; hs1 = new HashSet<String>(); 
		hs1.addAll(Arrays.asList(v2));
		System.out.println(hs1); // [alfa, delta, beta]
		// iterazioni su set
		for (String s: hs) System.out.println(s);
		for (Iterator<String> it = hs.iterator(); it.hasNext();) 
			System.out.println(it.next());
		System.out.println(hs.remove("alfa")); // true
		Set<Integer> is = new HashSet<Integer>(); is.add(10);
		System.out.println(hs.remove(is)); // false
		
	}
}
