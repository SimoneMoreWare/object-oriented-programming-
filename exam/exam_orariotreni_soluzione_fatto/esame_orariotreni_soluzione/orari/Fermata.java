package orari;

public class Fermata implements Comparable<Fermata>{

  private String nomeStazione;
  private int ore;
  private int minuti;
	
  public Fermata(String nomeStazione, int ore, int minuti) {
	  this.nomeStazione=nomeStazione;
	  this.ore=ore;
	  this.minuti=minuti;
  }

  public String getStazione() {
	  return nomeStazione;
  }

  public int getOre() {
	  return ore;
  }

  public int getMinuti() {
	  return minuti;
  }

  //implements Comparable, è come se avessi scritto Comparable<Object>
  //public int compareTo(Object altra)
  
  public int compareTo(Fermata altra) {
  
	  // Confronto tra due parametri, pattern/struttura standard (ult. estendibile)
	  int diffOre = this.ore - altra.getOre();
	  if(diffOre != 0)
		  return diffOre;
	  return this.minuti - altra.getMinuti();
  }
  
  public String toString(){
	  return nomeStazione;
  }
 
}
