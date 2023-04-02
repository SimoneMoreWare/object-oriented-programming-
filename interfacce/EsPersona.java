package interfacce;

import java.util.Arrays;
import java.util.Comparator;

public class EsPersona {

	public static void main(String[] args) {

		Persona[] persone = { 
				new Persona("Salvo", "Matteini"), 
				new Persona("Melo", "Giorgioni"),
				new Persona("Jane", "Smith"),
				new Persona("John", "Smith") };
		Arrays.toString(persone);

		// Comparator cmp = new ComparaDecrescente();

		class InnerComparator implements Comparator {  // LOCAL INNER CLASS
			@Override
			public int compare(Object o1, Object o2) {
				Persona p1 = (Persona)o1;
				Persona p2 = (Persona)o2;
				
				int cmpCognome = p2.getCognome().compareTo(p1.getCognome());
				if(cmpCognome != 0 ) return cmpCognome;
				
				return p2.getNome().compareTo(p1.getNome());
				
			}
		};
		
		Comparator cmp = new Comparator() {  // ANONYMOUS LOCAL INNER CLASS
			@Override
			public int compare(Object o1, Object o2) {
				Persona p1 = (Persona)o1;
				Persona p2 = (Persona)o2;
				
				int cmpCognome = p2.getCognome().compareTo(p1.getCognome());
				if(cmpCognome != 0 ) return cmpCognome;
				
				return p2.getNome().compareTo(p1.getNome());
				
			}
		};
		Arrays.sort(persone, cmp);
		
		Arrays.sort(persone, (o1,o2) -> {  // LAMBDA EXPRESSION
				Persona p1 = (Persona)o1;
				Persona p2 = (Persona)o2;
				
				int cmpCognome = p2.getCognome().compareTo(p1.getCognome());
				if(cmpCognome != 0 ) return cmpCognome;
				
				return p2.getNome().compareTo(p1.getNome());
				
			});
		Comparator cc = (Object o1, Object o2) -> {  // LAMBDA EXPRESSION
			Persona p1 = (Persona)o1;
			Persona p2 = (Persona)o2;
			
			int cmpCognome = p2.getCognome().compareTo(p1.getCognome());
			if(cmpCognome != 0 ) return cmpCognome;
			
			return p2.getNome().compareTo(p1.getNome());
			
		};
		sort(persone, cc);

		sort(persone, (Comparator) ( o1, o2) -> {  // LAMBDA EXPRESSION
			Persona p1 = (Persona)o1;
			Persona p2 = (Persona)o2;
			
			int cmpCognome = p2.getCognome().compareTo(p1.getCognome());
			if(cmpCognome != 0 ) return cmpCognome;
			
			return p2.getNome().compareTo(p1.getNome());
			
		});

		for (Persona p : persone) {
			System.out.println(p);
		}
		// OPPURE
		Arrays.toString(persone);
		
		
		// ----------
		Arrays.sort(persone);
		int[] contatori = {0, 0};
		int numeroComparazioni = 0;
		sort(persone, cmp, new SortTracer() {

			@Override
			public void fattoComparazione() {
				System.out.println("Fatto una comparazione");
				contatori[0]++;
				//numeroComparazioni++;
			}

			@Override
			public void fattoScambio() {
				System.out.println("Fatto uno scambio");
				contatori[1]++;
			}
			
		});
		
		System.out.println("In totale: " + contatori[0] + " comparazioni");
		System.out.println("In totale: " + contatori[1] + " scambi");
		
	}

	public static void sort(Object[] a) {
		// bubble sort
		for (int j = 1; j < a.length; ++j) {
			for (int i = 0; i < a.length - j; ++i) {
				// Mi aspetto che Persona implementi un'interfaccia
				// che definisce il metodo compareTo()
				Comparable p1 = (Comparable) a[i];
				// if(persone[i] > persone[i+1]) { // test
				if (p1.compareTo(a[i + 1]) > 0) {
					// swap
					Object tmp = a[i];
					a[i] = a[i + 1];
					a[i + 1] = tmp;
				}
			}
		}
	}

	public static void sort(Object[] a, Comparator cmp) {
		// bubble sort
		for (int j = 1; j < a.length; ++j) {
			for (int i = 0; i < a.length - j; ++i) {
				// Mi aspetto che l'ggetto cmp sia in grado
				// di confrontare due oggetti dell'array
				// if(persone[i] > persone[i+1]) { // test
				if (cmp.compare(a[i], a[i + 1]) > 0) {
					// swap
					Object tmp = a[i];
					a[i] = a[i + 1];
					a[i + 1] = tmp;
				}
			}
		}
	}

	public static void sort(Object[] a, Comparator cmp, SortTracer tracer) {
		for (int j = 1; j < a.length; ++j) {
			for (int i = 0; i < a.length - j; ++i) {
				if (cmp.compare(a[i], a[i + 1]) > 0) {
					// swap
					Object tmp = a[i];
					a[i] = a[i + 1];
					a[i + 1] = tmp;
					tracer.fattoScambio();
				}
				tracer.fattoComparazione();
			}
		}
	}

	public static void sort(Object[] a, ComparatorRompiscatole cmp) {
		
	}

	
	static class ComparaDecrescente implements Comparator {

		@Override
		public int compare(Object o1, Object o2) {
			Persona p1 = (Persona)o1;
			Persona p2 = (Persona)o2;
			
			int cmpCognome = p2.getCognome().compareTo(p1.getCognome());
			if(cmpCognome != 0 ) return cmpCognome;
			
			return p2.getNome().compareTo(p1.getNome());
			
		}
		
	}
	
	interface ComparatorRompiscatole {
		int quasiCompare(Object o1, Object o2);
	}
	
	interface SortTracer {
		void fattoComparazione();
		void fattoScambio();
	}
}
