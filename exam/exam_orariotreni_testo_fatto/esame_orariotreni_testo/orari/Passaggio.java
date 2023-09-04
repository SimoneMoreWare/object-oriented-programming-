package orari;

public class Passaggio {
	
	private String nomeStazione;
	private int ora;
	private int minuti;
	private int ritardo;

  public Passaggio(String nomeStazione, int ora, int minuti, int ritardo) {
		super();
		this.nomeStazione = nomeStazione;
		this.ora = ora;
		this.minuti = minuti;
		this.ritardo = ritardo;
	}

public String getStazione() {
    return nomeStazione;
  }

  public int getOra() {
    return ora;
  }

  public int getMinuti() {
    return minuti;
  }

  public int ritardo() {
    return ritardo;
  }

}
