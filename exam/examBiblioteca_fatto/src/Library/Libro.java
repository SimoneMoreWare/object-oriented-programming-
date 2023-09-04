package Library;

import java.util.LinkedList;
import java.util.Queue;

public class Libro {

	private String autore;
	private String titolo;
	private String editore;
	private String isbn;
	private boolean loaned;
	private Utente utente;
	private Queue<Utente> richiestePrestitiUtenti = new LinkedList<>();
	
	public Libro (String autore, String titolo, String editore, String isbn) {
		this.autore = autore;
		this.titolo = titolo;
		this.editore = editore;
		this.isbn = isbn;
		this.loaned = false;
		this.utente = null;
	}
	
	public String toString() {
		return autore+" "+titolo+" "+editore+" "+isbn;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getEditore() {
		return editore;
	}

	public void setEditore(String editore) {
		this.editore = editore;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public boolean isLoaned() {
		return loaned;
	}

	public void setLoaned(boolean loaned) {
		this.loaned = loaned;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Queue<Utente> getRichiestePrestitiUtenti() {
		return richiestePrestitiUtenti;
	}

	public void setRichiestePrestitiUtenti(Queue<Utente> richiestePrestitiUtenti) {
		this.richiestePrestitiUtenti = richiestePrestitiUtenti;
	}
	
	public void newRichiestaUtentePrestito(Utente utente) {
		richiestePrestitiUtenti.add(utente);
	}
	
}
