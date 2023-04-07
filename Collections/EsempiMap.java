import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EsempiMap {
	public static void main(String[] args) {
		Map<String,Integer> numeri = new HashMap<>();
		numeri.put("I",1);
		numeri.put("II",2);
		numeri.put("III",3);
		numeri.put("IV",4);
		numeri.put("V",5);
		numeri.put("VI",6);
		numeri.put("VII",7);
		numeri.put("VIII",8);
		numeri.put("IX",9); 
		numeri.put("X",10);
		int n = numeri.get("IV");
		System.out.println(n);
		System.out.println(numeri.containsKey("C"));
		
		Set<String> chiavi = numeri.keySet();
		System.out.println("Chiavi: "+chiavi);
		
		Collection<Integer> valori = numeri.values();
		System.out.println("Valori: "+valori);
	}
}
