package orari;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Orari {
	private Map<String, Percorso> percorsi = new HashMap<String, Percorso>();

	public Percorso creaPercorso(String codice, String categoria) {
		Percorso p = new Percorso(codice, categoria);
		percorsi.put(codice, p);
		return p;
	}

	public Collection<Percorso> getPercorsi() {
		
		return percorsi.values(); // percorsi.keySet()
	}

	public Percorso getPercorso(String codice) {
		return percorsi.get(codice);
	}

	
	
	
	public Treno nuovoTreno(String codice, int giorno, int mese, int anno) 
			throws PercorsoNonValido {
		
		// recupero il percorso dato il suo codice
		// percorsi.get(codice);
		Percorso p = this.getPercorso(codice);
		
		if (p == null)
			throw new PercorsoNonValido();
		
		Treno t = new Treno(p, giorno, mese, anno);
		
		// aggiungo il treno al percorso
		p.aggiungiTreno(t);
		
		return t;
	}
	
	
	
	
	
	
	
	
  
}
