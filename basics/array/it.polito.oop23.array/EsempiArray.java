package it.polito.oop23.array;

import java.util.Arrays;

public class EsempiArray {

	public static void main(String[] args) {

		int[] ai;//array di interi, creazione riferimento all'oggetto array di interi
		//sono oggetti mutabili, non posso modificare la dimensione
		
		ai = new int[10]; //dimensione per creare oggetto (celle memoria occupate)
		//valore celle inizializzate a 0 in questo caso
		
		for(int i=0;i<10;++i) {
			System.out.println(i + " : " + ai[i]); //tutti 0, per la cosa detta prima
		}
		
		System.out.println(""); 

		//ai è un oggetto, ha metodi e attributi
		for(int i=0;i<ai.length;++i) {//lunghezza dentro l'oggetto
			System.out.println(i + " : " + ai[i]); //tutti 0, per la cosa detta prima
		}
		
		System.out.println(""); 

		//for each, qui sicuro non posso sbagliarmi con gli indice
		//ogni possibile 'e' nell'array ai esegui il corpo seguente:
		//viene fatto un ciclo, ad ogni iterazione 'e' assume il valore dell'elemento successivo all'interno dell array
		for(int e:ai) {
			System.out.println(e); //tutti 0, per la cosa detta prima
		}
		
		for(int i=0;i<ai.length;++i) {//lunghezza dentro l'oggetto
			ai[i]=10-i; //tutti 0, per la cosa detta prima
		}
		
		//classe Arrays permette di avere vari metodi da utilizzare
		System.out.println(Arrays.toString(ai)); //[10, 9, 8, 7, 6, 5, 4, 3, 2, 1]

		Arrays.sort(ai); //quick sort, nlogn, n^2 nel caso peggiore
		System.out.println(Arrays.toString(ai)); //[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

		//------------------
		
		String[] parole; //parole riferimento ad array di stringhe
		parole = new String[10]; //ogni cella è inizializzata a null, ogni cella è un riferimento
		parole[0]="Primo";
		parole[1]="secondo";
		parole[2]="terzo";
		parole[3]="quarto";
		parole[4]="quinto";
		parole[5]="sesto";
		parole[6]="settimo";
		parole[7]="ottavo";
		parole[8]="nono";
		parole[9]="decimo";
		System.out.println(Arrays.toString(parole));
		
		String[] nomi = {"ema","simo","giovannino","giacomino","emilio","hassane","vincenzo","padrepio"}; //inizializzazione statica, dimensione inserita in automatico dal compilatore
		System.out.println(Arrays.toString(nomi));
		
		parole = new String[] {"Alla","fiera","dell'est","per","due","soldi"}; //parole punta al nuovo oggetto, il vecchio oggetto non ha nessun riferimento e quindi l'oggetto è irragiungibile
		System.out.println(Arrays.toString(parole));
		//--------
		
		
	}
}
