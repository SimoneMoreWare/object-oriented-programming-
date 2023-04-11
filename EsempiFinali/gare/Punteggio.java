package gare;
public class Punteggio implements ElementoDiClassifica {
	private Gara gara; private Atleta atleta; private int p;
	public Punteggio(Gara gara, Atleta atleta, int p) {
		this.gara = gara; this.atleta = atleta; this.p = p;
	}
	//public Atleta getAtleta() {return atleta;}
	public Gara getGara() {return gara;}
	//impl. ElementoDiClassifica
	public String getNome() {return atleta.getNome();}
	public int getValore() {return p;}
}
