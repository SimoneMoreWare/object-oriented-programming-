package competenze;

import java.util.*; 
public class Competenze {
private Map<String,Competenza> competenze = new HashMap<String,Competenza>();
private Map<String,Attivit�> attivit� = new HashMap<String,Attivit�>();
private Map<String,Utente> utenti = new HashMap<String,Utente>();
public void newCompetenza(String nome) 
throws CompEccezione {
	if (competenze.containsKey(nome)) 
		throw new CompEccezione("competenza duplicata:" + nome);
	Competenza c = new Competenza(nome); 
	competenze.put(nome, c);}
public void newAttivit�(String nome, String... v) 
throws CompEccezione {
	TreeSet<String> s = new TreeSet<String>();
	if (attivit�.containsKey(nome)) 
		throw new CompEccezione("attivit� duplicata:" + nome);
	for (String c:v){
		if (competenze.get(c) == null) 
			throw new CompEccezione("competenza inesistente:" + c);
		else if (!s.add(c))
			throw new CompEccezione("competenza duplicata:" + c);
	}
	for (String c:v){
		competenze.get(c).incrNA();
	}
	Attivit� a = new Attivit�(nome, s);
	attivit�.put(nome, a);}
public void newUtente(String nome, String... v) 
throws CompEccezione {
	TreeSet<String> s = new TreeSet<String>();
	if (utenti.containsKey(nome)) 
		throw new CompEccezione("utente duplicato:" + nome);	
	for (String c:v){
		if (competenze.get(c) == null) 
			throw new CompEccezione("competenza inesistente:" + c);
		else if (!s.add(c))
			throw new CompEccezione("competenza duplicata:" + c);
	}
	for (String c:v){
		competenze.get(c).incrNU();
	}
	Utente u = new Utente(nome, s);
	utenti.put(nome, u);}
public Attivit� getAttivit� (String nome) throws CompEccezione {
	Attivit� a = attivit�.get(nome);
	if(a == null) throw new CompEccezione("attivit� inesistente:" + nome);
	else return a;
}
public Utente getUtente (String nome) throws CompEccezione {
	Utente u = utenti.get(nome);
	if(u == null) throw new CompEccezione("utente inesistente:" + nome);
	else return u;
}
public String elencoCompetenzeRichieste() {
	Comparator<Competenza> comparator = new Comparator<Competenza>() {
		public int compare(Competenza c1, Competenza c2) {
		if (c2.getNA() == c1.getNA()) 
			return c1.getNome().compareTo(c2.getNome());
		if (c2.getNA() > c1.getNA()) return 1; else return -1;
		}};
	List<Competenza> l1 = new ArrayList<Competenza>(competenze.values());
	Collections.sort (l1, comparator); return l1.toString();}
public String elencoCompetenzePossedute() {
	Comparator<Competenza> comparator = new Comparator<Competenza>() {
		public int compare(Competenza c1, Competenza c2) {
		if (c2.getNU() == c1.getNU()) 
			return c1.getNome().compareTo(c2.getNome());
		if (c2.getNU() > c1.getNU()) return 1; else return -1;
		}};
		List<Competenza> l1 = new ArrayList<Competenza>(competenze.values());
	Collections.sort (l1, comparator); return l1.toString();}
	}

