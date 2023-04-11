package it.polito.oop23.array;

public class Esempio2 {
	public static void main(String[] args) {
		
		Persona p = new Persona(1,"Maria","Drago");
		
		Persona[] d = { //dipendenti
				new Persona(2,"Renzo","Mattei"),
				new Persona(3,"Salvini","Matteini"),
				new Persona(4,"Pako","Candido")
		};
		
		Azienda a = new Azienda("ACME",p,d);
		
		a.stampa();
		
		Persona p2 = new Persona(5,"Meloni","Giorgio");
		a.aggiungiDipendente(p2);
		
		a.stampa();

	}
}
