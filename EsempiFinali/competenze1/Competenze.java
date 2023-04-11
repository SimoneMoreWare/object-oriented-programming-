package competenze1;

import java.util.*; 
public class Competenze {
private Map<String,Competenza> competenze = new HashMap<String,Competenza>();
private Map<String,Attività> attività = new HashMap<String,Attività>();
private Map<String,Utente> utenti = new HashMap<String,Utente>();
public void newCompetenza(String nome) throws CompEccezione {
	if (competenze.containsKey(nome)) throw new CompEccezione("competenza duplicata:" + nome);
	Competenza c = new Competenza(nome); competenze.put(nome, c);}
private	TreeSet<Competenza> getCompetenze(String[] v) throws CompEccezione {
	TreeSet<Competenza> s = new TreeSet<Competenza>();
	for (String c:v){
		Competenza comp = competenze.get(c);
		if (comp == null) throw new CompEccezione("competenza inesistente:" + c);
		else if (!s.add(comp)) throw new CompEccezione("competenza duplicata:" + c);
	}	
	return s;}
public void newAttività(String nome, String... v) throws CompEccezione {
	if (attività.containsKey(nome)) throw new CompEccezione("attività duplicata:" + nome);
	Attività a = new Attività(nome); attività.put(nome, a);
	for (Competenza c: getCompetenze(v)) {a.addCompetenza(c); c.addAttività(a);}
}
public void newUtente(String nome, String... v) throws CompEccezione {
	if (utenti.containsKey(nome)) throw new CompEccezione("utente duplicato:" + nome);	
	Utente u = new Utente(nome); utenti.put(nome, u);
	for (Competenza c: getCompetenze(v)) {u.addCompetenza(c); c.addUtente(u);}
}
public Attività getAttività (String nome) throws CompEccezione {
	Attività a = attività.get(nome);
	if(a == null) throw new CompEccezione("attività inesistente:" + nome);
	else return a;
}
public Utente getUtente (String nome) throws CompEccezione {
	Utente u = utenti.get(nome);
	if(u == null) throw new CompEccezione("utente inesistente:" + nome);
	else return u;
}
public Competenza getCompetenza (String nome) throws CompEccezione {
	Competenza c = competenze.get(nome);
	if(c == null) throw new CompEccezione("competenza inesistente:" + nome);
	else return c;
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

