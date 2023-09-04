package orari;

public class Passaggio {
	
	// String nomeStazione
	private Fermata fermata;
	private int ora;
	private int minuti;
	
	public Passaggio(Fermata fermata, int ora, int minuti) {
		this.fermata = fermata;
		this.ora = ora;
		this.minuti = minuti;
	}

	public String getStazione() {
		return fermata.getStazione();
	}

	public int getOra() {
		return ora;
	}

	public int getMinuti() {
		return minuti;
	}

	public int ritardo() {
		// orario teorico fermata.getOre() fermata.getMinuti()
		// orario effettivo this.ora e this.minuti
		
		return 60 * (ora-fermata.getOre()) + minuti - fermata.getMinuti();
	}

}
