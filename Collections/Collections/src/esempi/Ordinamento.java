package esempi;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class Ordinamento {

	public static void main(String[] args) {
		
		List<Persona> l = new LinkedList<Persona>();
		
		l.add(new Persona("ABC","Mario","Rossi"));
		l.add(new Persona("GVV","Giuseppe","Verdi"));
		l.add(new Persona("JSM","John","Smith"));
		
		
		//sort(l);
		Collections.sort(l); 
		
		
		Collections.sort(l,new MioComparatore());
		
		Collections.sort(l, new Comparator<Persona>(){ //ANONYMOUS INNER CLASS
			public int compare(Persona primo, Persona secondo) {
				//return primo.getCognome().compareTo(secondo.getCognome());
				
				int cfrCognomi = primo.getCognome().compareTo(secondo.getCognome());
				if( cfrCognomi != 0 ) return cfrCognomi;
				
				int cfrNomi = primo.getNome().compareTo(secondo.getNome());
				if( cfrNomi != 0 ) return cfrNomi;
				
				return primo.getCf().compareTo(secondo.getCf());
 			}
		});
		
		SortedSet<Persona> ss = new TreeSet<Persona>(l);
		
		SortedSet<Persona> ss1 = new TreeSet<Persona>(new MioComparatore());
		ss1.addAll(l);
		

	}
	
	static class MioComparatore implements Comparator<Persona>{
		public int compare(Persona primo, Persona secondo) {
			return primo.getCognome().compareTo(secondo.getCognome());
		}
		
	}
	
	
	public static <T extends Comparable<? super T>> void sort(List<T> l){
		
		int i,j;
		i=0;
		j=1;
		//...
		T primo = l.get(i);
		T secondo = l.get(j);
//		if( primo > secondo){
		if( primo.compareTo(secondo) > 0){
			// SCAMBIO
			l.set(j, primo);
			l.set(i, secondo);
		}
		
		//..
	}
	
	class Numero implements Comparable<Numero>{
		public int compareTo(Numero o) {
			// TODO Auto-generated method stub
			return 0;
		}
	}
	
	class Intero extends Numero {}
	
	class Reale extends Numero {}
	
	
	
	
	
	
	
	
	
	

}
