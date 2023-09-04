package orari;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Orari {
	
	private Map<String, Percorso> percorsi = new HashMap<>();
	
	public Percorso creaPercorso(String codice, String categoria) {
		
		  Percorso percorso = new Percorso(codice, categoria);
		  
		  percorsi.put(codice, percorso);
		  
		  return percorso;
	  }
	
	  public Collection<Percorso> getPercorsi() {
	    return percorsi.values();
	  }
	
	  public Percorso getPercorso(String codice) {
	    return percorsi.get(codice);
	  }
	
	  public Treno nuovoTreno(String codice, int giorno, int mese, int anno) 
	  	throws PercorsoNonValido {
		  
		  if(!percorsi.containsKey(codice)) throw new PercorsoNonValido();
		  
		  Treno treno = new Treno(percorsi.get(codice), giorno, mese, anno); 
		  
		  percorsi.get(codice).newTreno(treno);
		  
	    return treno;
	  }
	  
}
