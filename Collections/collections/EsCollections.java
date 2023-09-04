package collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import static java.util.Comparator.*;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EsCollections {

	public static void main(String[] args) {
		
		Collection<String> c;
		
		List<String> lista;
		
		lista = new LinkedList<>();
		lista = new ArrayList<>(); 
		
		c = lista;
		
		c.add("primo");
		c.add("secondo");
		c.add("terzo");
		c.add("quarto");
		
		boolean c_e_primo = c.contains("primo");
		
		int totale = 0;
		for( String s : c) {
			System.out.println(s);
			totale += s.length();
		}
		
		totale = 0;
		c.forEach( s -> {
			System.out.println(s);
			// totale += s.length();  // deve essere final!!
		});
		
		c.removeIf( s -> s.length()>6 );
		// EQUIVALE A
		c.removeIf( (String s) -> {
			return s.length()>6;
		} );
		// EQUIVALE A
		c.removeIf(new Predicate<String>() {
			public boolean test(String s){
			  return s.length()>6;
			}
		});
		
		System.out.println(c);
		
		Collections.sort(lista);
		
		System.out.println(lista);
		
		lista.add("uno");
		lista.add("zero");
		
		Collections.sort(lista, 
				(s1,s2) -> s1.length()-s2.length());
		// ordinati per lunghezza crescente
		System.out.println(lista);

//		Comparator<String> perLunghezza = 
//				comparatoreDiInteri(s->s.length());
//		
		Comparator<String> perLunghezza = 
				comparatoreDiInteri(String::length);
		
		Collections.sort(lista,perLunghezza);
		System.out.println(lista);
		
		Collections.sort(lista,
				comparingInt(String::length).
				reversed(). 
				thenComparing(naturalOrder()));
		// FUNZIONALMENTE EQUIVALENTE A
		Collections.sort(lista, (s1,s2) -> {
				int dl = s1.length() - s2.length();
				if(dl!=0) return - dl;
				return s1.compareTo(s2);
		});

	}
	
	static <T> Comparator<T> comparatoreDiInteri( 
			Function<T,Integer> inBaseA){
		return (T a, T b) -> -(inBaseA.apply(a) - inBaseA.apply(b));
	}
	
//	interface Function<T,R> {
//		R apply(T e);
//	}
//	
//	interface Comparator<T>{
//		int compare(T a, T b);
//	}

}
