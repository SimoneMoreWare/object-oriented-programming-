package orari;


public class Passaggio {

  private Fermata fermata;
  private int ore;
  private int minuti;
  
  public Passaggio(Fermata f, int ore, int minuti) {
    this.fermata = f;
    this.ore = ore;
    this.minuti = minuti;
  }

  public String getStazione() {
    return fermata.getStazione();
  }

  public int getOra() {
    return ore;
  }

  public int getMinuti() {
    return minuti;
  }

  public int ritardo() {
    return 60*(this.ore-fermata.getOre())+
    		this.minuti-fermata.getMinuti();
  }

}
