import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class EsempiListe {
	public static void main(String[] args) {
		List<String> parole = new LinkedList<>();
		
		parole.add("Una");
		parole.add("x");
		parole.add("parola");
		parole.add("nella");
		parole.add("lista");
		
		for( String p : parole) {
			System.out.println(p);
		}
		
		parole.add(3,"nostra");
		
		for( String p : parole) {
			System.out.println(p);
		}
		
		parole.remove(0); //indice
		
		int pos = parole.indexOf("parola"); //contenuto
		System.out.println("Posizione di parola: "+pos);
		
		pos = parole.indexOf("Non c'e");
		System.out.println("Posizone di non c'e: "+pos);
		
		for(int i=0; i<parole.size();++i) {
			System.out.println(parole.get(i));
		}
		
		Collections.sort(parole);
		System.out.println(parole);
		
		List<String> copia = new LinkedList<>( parole ); //copio lista, riferimenti gli stessi
		System.out.println(copia);
		
		copia.remove(0);
		System.out.println(copia);
		System.out.println(parole);
		
		Collections.sort(parole, (a,b)->a.length()-b.length());
		System.out.println(parole);
		
	}
}
