package it.polito.oop23.array;

import java.util.Arrays;

public class Azienda {

		private String nome;
		private Persona capo;
		
		
		// dipendenti
		private Persona[] dipendenti;
		
		public Azienda(String nome, Persona capo, Persona[] dipendenti) {
			this.nome=nome;
			this.capo=capo;
			this.dipendenti = dipendenti;
		}
		
		public void stampa() {
			System.out.println(nome + " capo -> " + capo.comeStringa());
			System.out.println("Dipendenti: ");
			for(Persona d: dipendenti) {
				System.out.println("\t"+d.comeStringa()); 
			}
		}

		public void aggiungiDipendente(Persona nuovoDipendente) {
			//come aggiungo un nuovo elemento? creo un nuovo array e aggiungiamo l'ultimo
			
			//1
//			Persona[] nuovi = new Persona[dipendenti.length+1];
//			for(int i=0;i<dipendenti.length;++i) {
//				nuovi[i]=dipendenti[i];
//			}
//			nuovi[dipendenti.length]=nuovoDipendente;
//			dipendenti = nuovi;
			
			//2, raddoppio sempre la dimensione e tengo traccia degli elementi effettivamente utilizzati
			
			//3 nella classe Arrays c'è copyOf
			Persona[] nuovi = Arrays.copyOf(dipendenti,dipendenti.length+1);
			nuovi[dipendenti.length]=nuovoDipendente;
			dipendenti=nuovi;
		}
}
