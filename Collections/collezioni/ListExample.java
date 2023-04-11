package collezioni;
import java.util.*;
public class ListExample {
	public static void main(String args[]) { 
		List<String> list = new ArrayList<String>(); 
		list.add("Bernadine"); list.add("Elizabeth"); list.add("Gene"); 
		list.add("Elizabeth"); list.add("Clara"); 
		System.out.println(list); // [Bernadine, Elizabeth, Gene, Elizabeth, Clara] 
		System.out.println("2: " + list.get(2)); // 2: Gene
		System.out.println("0: " + list.get(0)); //  0: Bernadine 
		LinkedList<String> queue = new LinkedList<String>(); 
		queue.addFirst("Bernadine"); queue.addFirst("Elizabeth"); 
		queue.addFirst("Gene"); queue.addFirst("Elizabeth"); queue.addFirst("Clara"); 
		System.out.println(queue); // [Clara, Elizabeth, Gene, Elizabeth, Bernadine]
		queue.removeLast(); queue.removeLast(); 
		System.out.println(queue); // [Clara, Elizabeth, Gene]
		for (ListIterator<String> i=queue.listIterator(queue.size()); i.hasPrevious();)
			System.out.println(i.previous()); // Gene 		Elizabeth 		Clara
		// replacing names starting with E
		for (ListIterator<String> i=queue.listIterator(); i.hasNext();)
			if(i.next().startsWith("E")) i.remove();
		System.out.println(queue); //[Clara, Gene]
		// swapping the two elements
		String s = queue.get(0); queue.set(0,queue.get(1)); queue.set(1,s); 
		System.out.println(queue); // [Gene, Clara]
	}
}
