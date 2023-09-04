package orari;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class Orari {

  private Map<String,Percorso> percorsi = new TreeMap<String,Percorso>();	
	
  public Percorso creaPercorso(String codice, String categoria) {
	  Percorso p = new Percorso(codice, categoria);
	  percorsi.put(codice, p);
	  return p;
  }

  public Collection<Percorso> getPercorsi() {
      return percorsi.values();   // Mappe e collezioni non sono la stessa cosa
	    						  // Non posso fare il cast, la mappa non è una collezione
	    						  // di singoli elementi: devo quindi usare values()
  }

  public Percorso getPercorso(String codice) {
	  return percorsi.get(codice);  // Molto meno codice che non con una lista
    							    // Oltre che più efficiente
  }

  public Treno nuovoTreno(String codice, int giorno, int mese, int anno) 
  	  throws PercorsoNonValido {
	
	  Percorso p = this.getPercorso(codice); // E poi passo non il codice, ma l'oggetto
									         // Oppure, equivalentemente, Percorso p = percorsi.get(codice);
	  if(p==null)
		  throw new PercorsoNonValido();
	
	  // Treno t = new Treno(codice, giorno, mese, anno);	
	  Treno t = new Treno(p, giorno, mese, anno);  
	
	  p.aggiungiTreno(t);
	
	  return t;
  }
  
}
