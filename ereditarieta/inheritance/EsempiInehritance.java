package inheritance;

import nested.Lista;
import nested.ListaOrdinata;

public class EsempiInehritance {

	public static void main(String[] args) {
		Lista rl = new Lista(); // riferimento e oggetto di tipo Lista
		Lista rl2 = (Lista) new ListaOrdinata(); // riferimento Lista e oggetto ListaOrdinata
		// perchè ListaOrdinata "extends" Lista
		// LO è un sottotipo di L
		
		Number[] numeri = new Number[3];
		numeri[0] = Integer.valueOf(1);
		numeri[1] = Double.valueOf(2);
		numeri[2] = Long.valueOf(3);
		
		double s = somma(numeri);
		
		ListaOrdinata lo = (ListaOrdinata) rl2;  // DOWN-cast
		ListaOrdinata lo2 = (ListaOrdinata) rl;
		
		int i = 10;
		double d = (double)10;
		
		//Number n = (Number)"42";
		
		Object o = "42";
		
		boolean uguali = o.equals("4"+"2");
		
		"42".equals("42");
	}


	static double somma(Number[] n) {
		double somma=0.0;
		for(Number i : n) {
			somma += i.doubleValue();  // dynamic binding
		}
		return somma;
	}
}
