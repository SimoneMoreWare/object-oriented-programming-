package nested;

import nested.Lista.Iteratore;

public class EsempioLista {

	public static void main(String[] args) {
		
		//Lista l = new Lista();
		Lista l = new ListaOrdinata();
		
		l.aggiungi(42);
		l.aggiungi(3);
		l.aggiungi(99);
		
		l.stampa();
		
		System.out.println("---");
		
		Iteratore it = l.iteratore();
		while(it.hasNext()) {
			it.prossimo();
			System.out.println(it.getValore());
		}
		
		//Iteratore x = new Iteratore();
		
	}

	static double somma(Number[] n) {
		double somma=0.0;
		for(Number i : n) {
			somma += i.doubleValue();  // dynamic binding
		}
		return somma;
	}
}



