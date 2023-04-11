package biblioteca;
public class Volume implements Comparable<Volume>{
	private int codice; 
	private Libro libro;
	private Utente utente;
	
Volume(Libro l, int nuovoCodice){libro = l; codice = nuovoCodice;}
void setUtente(Utente u) {utente = u;}
void clearUtente() {utente = null;}
boolean getDisp () {return utente == null;}
int getCodice(){return codice;}
Libro getLibro() {return libro;}
Utente getUtente() {return utente;}
public int compareTo(Volume v) {
	if (codice == v.codice) return 0;
	int r = getLibro().getTitolo().compareTo(v.getLibro().getTitolo());
	if (r == 0) 
		if (codice > v.codice) r = 1;
		else r = -1;
	return r;}	
public String toString(){return getLibro().getTitolo() + ":" + codice
	+ "(" + utente.getNome() + ")";}
}
