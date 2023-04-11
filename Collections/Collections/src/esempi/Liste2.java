package esempi;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Liste2 {


	public static void main(String[] args) {
		
		List<String> l = new LinkedList<String>();
		
		l.add("Primo");
		l.add("Secondo");
		l.add("Ancora uno");
		
		String s = l.get(2);
		System.out.println(s);
		
		l.set(1, "Era il secondo");
		
		
		System.out.println("Prima: " + l);
		Collections.sort(l);
		System.out.println("Dopo: " + l);
		
		


	}

}
