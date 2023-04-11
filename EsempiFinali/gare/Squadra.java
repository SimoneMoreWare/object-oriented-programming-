package gare;
public class Squadra implements ElementoDiClassifica, Comparable<Squadra> {
	private String nome; private int punti;
	public Squadra(String nome) {this.nome = nome;}
	// impl. ElementoDiClassifica
	public String getNome() {return nome;}
	public int getValore() {return punti;}
	void addPunteggio(int i) {punti += i;}
	public int compareTo(Squadra s) {
		if (this.punti == s.punti) nome.compareTo(s.nome);
		return s.punti - this.punti;
	}
}
