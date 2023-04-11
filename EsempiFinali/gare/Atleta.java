package gare;
import java.util.*;
public class Atleta implements ElementoDiClassifica, Comparable<Atleta> {
	private String nome; private Squadra squadra; 
	private int punti; //attributo derivato
	Comparator<Punteggio> comp = new Comparator<Punteggio>() { //serve per ordinare i punteggi
		public int compare(Punteggio p1, Punteggio p2) {
			if(p1.getValore() == p2.getValore()) 
				return p1.getGara().getNome().compareTo(p2.getGara().getNome());
			return p2.getValore() - p1.getValore();
		}
	};
	private TreeSet<Punteggio> punteggi = new TreeSet<Punteggio>(comp);
	public Atleta(String nome, Squadra squadra) {
		this.nome = nome; this.squadra = squadra;
	}
	public void addPunteggio(Punteggio p) {
		punteggi.add(p); punti += p.getValore(); squadra.addPunteggio(p.getValore());
	}
	// impl. ElementoDiClassifica
	public String getNome() {return nome;}
	public int getValore() {return punti;}
	// impl. Comparable<Atleta>
	public int compareTo(Atleta a) {
		if (punti == a.punti) return nome.compareTo(a.nome);
		return a.punti - punti;
	}
	public String getPiazzamenti() {
		StringBuffer b = new StringBuffer("piazzamenti di " + nome+ ":");
		for (Punteggio p: punteggi) b.append(" " +p.getGara().getNome()+"."+p.getValore());
		return b.toString();
	}
}
