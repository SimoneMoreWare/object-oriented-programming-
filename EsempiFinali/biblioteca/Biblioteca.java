package biblioteca;

import java.util.*;
public class Biblioteca {
private Map<String,Libro> libri = new HashMap<String,Libro>(); 
private Map<String,Utente> utenti = new HashMap<String,Utente>();
private Map<Integer,Volume> prestiti = new HashMap<Integer,Volume>();
private int nuovoCodice = 100;

public Libro newLibro(String titolo, int nVolumi) throws BiblioEccezione {
	if (titolo == null || nVolumi <= 0) throw new BiblioEccezione 
		("newLibro: dati errati - " + titolo + " " + nVolumi);
	if (libri.containsKey(titolo)) throw new BiblioEccezione
		("newLibro: libro duplicato - " + titolo);
	Libro l = new Libro(titolo, nVolumi, nuovoCodice); nuovoCodice += nVolumi;
	libri.put(titolo, l); return l;}
public Utente newUtente(String nome, int maxVolumi) throws BiblioEccezione {
	if (nome == null || maxVolumi <= 0) throw new BiblioEccezione 
		("newUtente: dati errati - " + nome + " " + maxVolumi);
	if (utenti.containsKey(nome)) throw new BiblioEccezione 
		("newUtente: utente duplicato - " + nome);
	Utente u = new Utente(nome, maxVolumi);utenti.put(nome, u); return u;}
public int newPrestito(String utente, String titolo) throws BiblioEccezione {
	if (titolo == null || utente == null)	throw new BiblioEccezione 
		("newPrestito: dati errati - " + titolo + " " + utente);
	Utente u = utenti.get(utente);
	if (u == null) throw new BiblioEccezione 
		("newPrestito: utente non definito - " + utente);
	if (!u.prestitoAmmissibile()) throw new BiblioEccezione 
		("newPrestito: max prestiti per " + utente);
	Libro l = libri.get(titolo);
	if (l == null) throw new BiblioEccezione
		("newPrestito: dati errati - " + titolo);
	Volume v = l.getVolume();
	if (v == null) throw new BiblioEccezione 
		("newPrestito: volume non disponibile - " + titolo);
	u.addVolume(v); v.setUtente(u);
	int c = v.getCodice(); prestiti.put(c, v);
	return c;}
public void restituzione(String utente, int codice) throws BiblioEccezione {
	Utente u = utenti.get(utente);
	if (u == null) throw new BiblioEccezione
		("restituzione: dati errati - " + utente);
	Volume v = prestiti.get(codice);
	if (v == null || u != v.getUtente()) throw new BiblioEccezione 
		("restituzione: dati errati");
	v.clearUtente(); u.removeVolume(v);
	prestiti.remove(codice);
}
public String graduatoriaLibri() {
	Comparator<Libro> ordine = new Comparator<Libro>() {
		public int compare(Libro l1, Libro l2) {
		if (l2.getNPrestiti() == l1.getNPrestiti()) 
			return l1.getTitolo().compareTo(l2.getTitolo());
		if (l2.getNPrestiti() > l1.getNPrestiti()) return 1;
		else return -1;
		}};
	List<Libro> list1 = new ArrayList<Libro>(libri.values());
	Collections.sort(list1, ordine); return list1.toString();}	

public String prestitiInCorso(){
	List<Volume> list1 = new ArrayList<Volume>(prestiti.values());
	Collections.sort(list1); return list1.toString();}	
}

