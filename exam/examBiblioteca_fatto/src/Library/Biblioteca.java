package Library;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

public class Biblioteca {

	private String name;
	private Map<String, Libro> libri = new HashMap<>();
	private Map<Integer, Utente> utenti = new HashMap<>();
	
	public Biblioteca (String n) {
		this.name = n;
	}
	
	public void addLibro(Libro lib) throws InvalidIsbn {
		
		if(libri.containsKey(lib.getIsbn())) throw new InvalidIsbn();
		
		libri.put(lib.getIsbn(), lib);
		
	}
	
	public Libro getLibro(String isbn){
	    return libri.get(isbn);
	}

	
	public List<Libro> libriPerAutore(){
		return libri.values().stream()
				.sorted(Comparator.comparing(Libro::getAutore))
				.collect(Collectors.toList())
				;
	}
	
	public void addUtente(Utente ut) throws InvalidCode{
		
		if(utenti.containsKey(ut.getCodice())) throw new InvalidCode();
		
		utenti.put(ut.getCodice(), ut);
		
	}
	
	public List<Utente> utenti(){
		return utenti.values().stream().sorted(Comparator.comparing(Utente::getCodice)).collect(Collectors.toList());
	}
	
	public Libro prestito(int cu, String isbn) throws InvalidCode, InvalidIsbn {
		
		if(!utenti.containsKey(cu)) throw new InvalidCode();
		if(!libri.containsKey(isbn)) throw new InvalidIsbn();
		
		if(!libri.get(isbn).isLoaned()) {
			libri.get(isbn).setLoaned(true);
			libri.get(isbn).setUtente(utenti.get(cu));
			utenti.get(cu).newLibroPrestato(libri.get(isbn));
			return libri.get(isbn);
		}
		
		if(libri.get(isbn).getUtente().getCodice()==cu) return null;
		
		if(libri.get(isbn).getUtente().getCodice()!=cu) {
			libri.get(isbn).newRichiestaUtentePrestito(utenti.get(cu));
			return null;
		}
		
		return null;
	}
	
	public Libro restituzione(int cu, String isbn) throws InvalidCode, InvalidIsbn {
		
		if(!utenti.containsKey(cu)) throw new InvalidCode();
		if(!libri.containsKey(isbn)) throw new InvalidIsbn();

		if(libri.get(isbn).getUtente().getCodice()!=cu) {
			return null;
		}
	
		libri.get(isbn).setLoaned(false);
		libri.get(isbn).setUtente(null);
		utenti.get(cu).removeLibroPrestato(libri.get(isbn));
		if(!libri.get(isbn).getRichiestePrestitiUtenti().isEmpty()) {
			this.prestito(libri.get(isbn).getRichiestePrestitiUtenti().poll().getCodice(), isbn);
		}
		return libri.get(isbn);
	}
	
	public Queue<Utente> getRichieste(Libro l) {
		return l.getRichiestePrestitiUtenti();
	}
	
	public List<Libro> elencoPrestiti() {
		return utenti.values().stream()
				.flatMap(u->u.getLibriPrestati().stream())
				.sorted(Comparator.comparing(Libro::getAutore))
				.collect(Collectors.toList())
				;
	}
	
	public List<Libro> elencoRichieste() {
		return libri.values().stream()
				.filter(l->!l.getRichiestePrestitiUtenti().isEmpty())
				.sorted(Comparator.comparing(Libro::getAutore))
				.collect(Collectors.toList())
				;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, Libro> getLibri() {
		return libri;
	}

	public void setLibri(Map<String, Libro> libri) {
		this.libri = libri;
	}

	public Map<Integer, Utente> getUtenti() {
		return utenti;
	}

	public void setUtenti(Map<Integer, Utente> utenti) {
		this.utenti = utenti;
	}
	
	
}
