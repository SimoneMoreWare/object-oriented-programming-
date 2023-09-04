package Library;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Utente {

	private int codice;
	private String nome;
	private String cognome;
	private List<Libro> libriPrestati = new LinkedList<>();
	
	public Utente (int codice, String nome , String cognome ){
		this.codice = codice;
		this.nome = nome;
		this.cognome = cognome;
	}
		
	public List<Libro> prestiti() {
		return libriPrestati.stream().sorted(Comparator.comparing(Libro::getAutore)).collect(Collectors.toList());
	}
	
	public String toString() {
		return codice+" "+nome+" "+cognome;
	}

	public int getCodice() {
		return codice;
	}

	public void setCodice(int codice) {
		this.codice = codice;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setLibriPrestati(List<Libro> libriPrestati) {
		this.libriPrestati = libriPrestati;
	}

	public List<Libro> getLibriPrestati() {
		return libriPrestati;
	}
	
	public void newLibroPrestato(Libro libro) {
		libriPrestati.add(libro);
	}

	public void removeLibroPrestato(Libro libro) {
		
		libriPrestati.remove(libro);
		
	}
	
	
	
}
