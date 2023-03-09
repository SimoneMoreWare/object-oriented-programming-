package it.polito.oop23.array;

public class EsempiArray {

	public static void main(String[] args) {

		int[] ai;//array di interi, creazione riferimento all'oggetto array di interi
		
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
		
	}
}
