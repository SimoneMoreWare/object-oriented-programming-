package generics;

import java.util.function.Consumer;

public class EsGenerics2 {

	public static void main(String[] args) {
		
		Lista<Integer> li = new Lista<>();
		
		Lista<String> ls = new Lista<>();
		
		ls.aggiungi("Alla");
		ls.aggiungi("fiera");
		ls.aggiungi("dell'");
		ls.aggiungi("est");
		ls.aggiungi("per");
		ls.aggiungi("due");
		ls.aggiungi("soldi");

		ls.forEach( s -> System.out.println(s));
		
		ls.forEach( System.out::println );
		
		class Sommatore implements Consumer<Integer> {
			int somma=0;
			public void accept(Integer i) {
				somma+=i;
			}
		}
		
		//ls.forEach(new Sommatore());
		
		li.aggiungi(1);
		li.aggiungi(2);
		li.aggiungi(3);
		li.aggiungi(4);
		Sommatore s = new Sommatore();
		li.forEach(s);
		System.out.println(s.somma);
		
		int[] produttoria = {1};
		li.forEach( i -> produttoria[0]*=i );
		System.out.println(produttoria[0]);
		
		//---
		
		Lista l = new Lista();
		// EQUIVALE A
		Lista<Object> lo = new Lista<>();
		
		
		String[] lettere = {"a","b"};
		sort(lettere);
		
		ACaso[] acaso = {};
		sort(acaso);
		
		ACasaccio[] acasaccio = {};
		sort(acasaccio);
		
		stampaLista(ls); // Lista<String>
		// i tipi generici sono invarianti
		//
		// String --> Object =/=> Lista<String> --> List<Object>
	}
	
	static void stampaLista(Lista<?> l) {
//		Object o = Integer.valueOf(1);
//		l.aggiungi(o);
		l.forEach( System.out::println );
	}
	
	static class ACaso implements Comparable<ACaso> {
		@Override
		public int compareTo(ACaso o) {
			// TODO Auto-generated method stub
			return 0;
		}
	}
	
	static class ACasaccio extends ACaso {
		
	}
	
	public static <T extends Comparable<T>> void sort(T[] a) {
		// bubble sort
		for (int j = 1; j < a.length; ++j) {
			for (int i = 0; i < a.length - j; ++i) {
				// Mi aspetto che Persona implementi un'interfaccia
				// che definisce il metodo compareTo()
				Comparable<T> p1 = (Comparable<T>) a[i];
				// if(persone[i] > persone[i+1]) { // test
				if (p1.compareTo(a[i + 1]) > 0) {
					// swap
					T tmp = a[i];
					a[i] = a[i + 1];
					a[i + 1] = tmp;
				}
			}
		}
	}


}
