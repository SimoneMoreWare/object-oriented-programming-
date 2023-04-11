package it.polito.oop23.array;
//come posso per dichiarare una variabile di tipo Persona?
public class Persona {
	//attributi, spesso sono dichiarati come privati per il principio di incapuslamento
	private int matricola; 
	private String nome;
	private String cognome;
	//...
	
	//metodi, "funzione" che opera sull'oggetto
	
	public void stampa() {
		System.out.println("Persona: ("+matricola+") "+nome+" "+cognome); //per concatenare le stringe uso il +
	}
	//tutte le variabili e attributi devono essere inizializzati 
	//gli attributi nel momento in cui chiami new vi è una inizializzazione automatica
	
	
	//costruttori, mi permette di inizializzare l'oggetto e attributi, stesso nome della clase, NON DEVE ESSERCI IL TIPO DI RITORNO
	public Persona() {
		matricola=-1;
		nome="<NON DEFINITO>";
		cognome="<NON DEFINITO>";
	}
	//distruttori, non ce ne sono, free automatiche
	
	//voglio inizializzare i miei attributi con un qualcosa di più siginificativo, creo costruttore con i parametri
	public Persona(int matr, String n,String c) {
		matricola=matr;
		nome=n;
		cognome=c;
	}
	
	//di solito si chiama getMatricola
	public int leggiMatricola() {
		return matricola;
	}
	//di solito si chiama setMatricola
	public void modificaMatricola(int nuovaMatricola) {
		if(nuovaMatricola<0) {
			System.out.println("Errore di inserimento valore matricola");
			return;
		}
		this.matricola=nuovaMatricola;
	}
	
	//qui abbiamo due costruttori con gli stessi nomi, ma i parametri sono diversi, java lo permette, si chiama overloading, i parametri devono essere diversi e java capisce dai parametri passati quale metodo/costruttore chiamare
	/*public Persona(int matricola, String n,String c) { this è un riferimento predefinito sull'oggetto corrente su cui sto eseguendo il metodo
		this.matricola=matricola; loggettocorrentedicuistoeseguendoalmomentoilmetodo.attributo
		in generale un identificatore si riferisce alla dichiarazione più prossima
		nome=n;
		cognome=c;
	}*/
	
	public String comeStringa() {
		return matricola + " - " + cognome + ", " + nome;
	}
}
