package class_object;

public class EsempiPrimitivi {
	
	
	
	public static void main(String[] args) {
		
		int i = 42;  // alloca la memoria per il valore intero
		
		Intero I;  // alloca la memoria per il **reference** a un oggetto Intero
		
		i = 42;
		System.out.println(i);
		
		I = new Intero();  // alloca la memoria e la azzera
		
		//System.out.println(I.valore);
		I.stampa();
		
//		Intero j = new Intero();
//		j.valore=1;
		Intero j = new Intero(1);
		
		//System.out.println(j.valore);
		
		j.stampa();
		
		Intero k = j;  // ALIASING, Attenzione: copia del riferimento NON dell'oggetto!!
		
//		j.valore = 2;
		j.setValore(2);
		
		k.stampa();
		k.stampa(3);
		
		// ---
		
		FluentInt f = new FluentInt();
		
		int risultato = f.inzializzaA(6).
						  ePoiSomma(4).
						  aQuestoPuntoSottrai(8).
						  eInfineAggiungi(40);
		
		if(risultato == 42) {
			System.out.println("OK");
		}else {
			System.out.println("Mi aspettavo 42 ma ho ottenuto: " + risultato);
		}
	}

}
