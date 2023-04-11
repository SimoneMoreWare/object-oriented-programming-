package esempi;

public class AppEsempio {

	public static void main(String[] args) {

		Studente s = new Studente("100","Mario","Rossi");
		
		System.out.println( s );
		// EQUIVALE
		//System.out.println( s.toString(Studente.HTML) );
		
		Studente s1 = new Studente("100","Marco","Gilli");
		Studente s2 = new Studente("100","Marco","Gilli");
		
		if( s1 == s2 ){
			// sicuramente falso
		}else{
			System.out.println(" s1 e s2 non puntono allo stesso oggetto");
		}
		
		if( s1.equals(s2) ){
			System.out.println(" s1 e s2 sono uguali");
		}else{
			System.out.println(" s1 e s2 diversi");

		}
		
		Object[] array= new Object[2];
		
		array[0] = s;
		array[1] = s1;
		
		boolean presente = presenteIn(s2,array);
		System.out.println("Presente? " + presente);
		

	}
	
	
	public static boolean presenteIn(Object o,Object[] a){
		for(Object element : a){
			if( o.equals(element)) return true;
		}
		return false;
	}

}
