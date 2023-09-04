package orari;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Orari {

  private Map percorsi = new HashMap();

  public Percorso creaPercorso(String codice, String categoria) {
    Percorso p = new Percorso(codice,categoria);
    percorsi.put(codice,p);
    return p;
  }

  public Collection getPercorsi() {
    return percorsi.values();
  }

  public Percorso getPercorso(String codice) {
    return (Percorso)percorsi.get(codice);
  }

  public Treno nuovoTreno(String codice, int giorno, int mese, int anno) 
  	throws PercorsoNonValido {
  	Percorso p = getPercorso(codice);
  	if(p==null) throw new PercorsoNonValido();
    Treno t = new Treno(p,giorno,mese,anno);
    p.addTreno(t);
    return t;
  }

}
