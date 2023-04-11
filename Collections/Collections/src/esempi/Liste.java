package esempi;

import java.util.Collection;
import java.util.Iterator;

public class Liste {

	public static void main(String[] args) {
		Collection<String> c = null;
		
		c.add("Primo");
		
		for(String o : c){
			System.out.println(o);
		}
		
		Iterator<String> it = c.iterator();
		while(it.hasNext()){
			String s = it.next();
			System.out.println(s);
		}
		
		for (Iterator<String> iterator = c.iterator(); iterator.hasNext();) {
			String string = iterator.next();
			System.out.println(string);
		}

	}

}
