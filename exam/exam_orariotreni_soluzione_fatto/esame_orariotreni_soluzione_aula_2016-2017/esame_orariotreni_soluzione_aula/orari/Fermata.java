package orari;

public class Fermata implements Comparable<Fermata>{
	private String nomeStazione;
	private int ore;
	private int minuti;
	
	public Fermata(String nomeStazione, int ore, int minuti) {
		super();
		this.nomeStazione = nomeStazione;
		this.ore = ore;
		this.minuti = minuti;
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

	@Override
	public int compareTo(Fermata altra) {
		int diffOre = this.ore - altra.getOre();
		
		if (diffOre != 0)
			return diffOre;
		
		return this.minuti - altra.minuti;
	}
 
	public String toString(){
		return nomeStazione + " "+ore+ " "+minuti;
	}
	
	
	
	
	
}
