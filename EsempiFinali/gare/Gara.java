package gare;
import java.util.*;
public class Gara {
	private String nome; 
	Comparator<Punteggio> comp = new Comparator<Punteggio>() {//serve per ordinare i punteggi
		public int compare(Punteggio p1, Punteggio p2) {
			return p2.getValore() - p1.getValore();
		}
	};
	private TreeSet<Punteggio> punteggi = new TreeSet<Punteggio>(comp);
	public void addPunteggio(Punteggio p) {punteggi.add(p);}
	public Gara(String nomeGara) {nome = nomeGara;}
	public Collection<? extends ElementoDiClassifica> getClassifica() {
		return punteggi;}
	public String getNome() {return nome;}
}
