package liste;

public class ListaInteri { //qui è public perchè è la parte del package che è visibile all'esterno e utiizziamo per accedere alle funzionalità dell'insieme di classi che si trovano nel package

	//creiamo la classe nodo che rappresenta i singoli elementi di questa lista
	private Nodo testa = null;
	private int conteggio = 0;
	//il compilatore inizializza la classe e gli attributi in automatico
	//non ho messo il costruttore perchè ho sfruttato il fatto che gli attributi sono inizializzati in automatico in 0 (int ecc...) e null i riferimenti
	public void add(int i) {
		//Nodo nuovo = new Nodo();
		//nuovo.prossimo = testa;
		//nuovo.setProssimo(testa); posso definire un costruttore che li inizializza in un colpo solo, set non è piu necessario, il valore una volta impostato non lo cambio, almeno per queste funzionalità che abbiamo deciso di adottare
		//nuovo.valore = i;
		//nuovo.setValore(i); l'obiettivo del costruttore è quello di rendere l'oggetto qualcosa di sensato
		//testa = nuovo;
		testa = new Nodo(i,testa); //costruttore mi fa automaticamente la definizione di i e valore
									//vantaggio: non devo sapere che dentro il nodo ci sono i due valori da impostare
		conteggio++;
	}

	public int testa() {
		//int valore = testa.valore;
		int valore = testa.getValore();
		return valore;
	}

	public int quanti() { 
		return conteggio;
	}
	
	public String comeStringa() {
		String res = "[";
		
		//1. for
//		for(Nodo corrente = testa;corrente!=null;corrente=corrente.getProssimo()) {
//			//Variabile limitata al costrutto for
//			res+= (corrente==testa ? "":", ");
//			res+=corrente.getValore();
//		} ho bisogno di sapere come è fatto il nodo
		//2. while
//		Nodo tmp = testa;
//		while(tmp.getProssimo()!=null) {
//			res += tmp.getValore() + ",";
//			tmp=tmp.getProssimo();
//		}
//		res += tmp.getValore() + "]";
		if(testa!=null) {
			//lista non vuota
			res += testa.comeStringa();//chiamo comeStringa sulla testa ricorsivamente, cosi non tocco altri attributi di altre classi (lo faccio il meno possibile), listainteri in questo modo può anche non conoscere il nodo, chiusura dettagli non necessari, PRINCIPIO DELEGA AL NODO CHE DEVE PRENDERE SE STESSO E CONOSCE IL SUCCESSIVO
			//I comeStringa sono separati tra loro, hanno stesso nome ma classi diverse
		}
		res += "]";
		
		//in generale è bene che una classe sappia delle altre classi il meno possibile, il fatto che c'è un attributo che si chiama prossimo potrebbe non essere ideale, un altro modo è quello di definire un metodo nella classe nodo, visto che conosce prossimo
		
		return res;
	}

}
