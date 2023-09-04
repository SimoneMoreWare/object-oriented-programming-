package orari;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Percorso {
	
	private String codice;
	private String categoria;
	public boolean staordinario;
	private Map<String, Fermata> fermate = new LinkedHashMap<>();
	private List<Treno> treni = new LinkedList<>();
	
  public Percorso(String codice, String categoria) {
		super();
		this.codice = codice;
		this.categoria = categoria;
		this.staordinario = false;
  }

public String getCodice() {
    return codice;
  }

  public String getCategoria() {
    return categoria;
  }

  public boolean isStraordinario() {
    return staordinario;
  }

  public void setStraordinario(boolean b) {
	  this.staordinario = b;
  }
  
  public Fermata aggiungiFermata(String nomeStazione, int ore, int minuti) {
	  
	  Fermata fermata = new Fermata(nomeStazione, ore, minuti);
	  
	  fermate.put(nomeStazione, fermata);
	  
	  
	  return fermata;
  }

  public List<Fermata> getFermate() {
	  return fermate.values().stream().sorted(Comparator.comparing(Fermata::getOre).thenComparing(Fermata::getMinuti)).collect(Collectors.toList());
  }
  
  

  public List<Treno> getTreni() {
	  return treni.stream().sorted(Comparator.comparing(Treno::getAnno,Collections.reverseOrder()).thenComparing(Treno::getMese,Collections.reverseOrder()).thenComparing(Treno::getGiorno,Collections.reverseOrder())).collect(Collectors.toList());
  }
  
  public int ritardoMassimo() {
	  return treni.stream().mapToInt(Treno::ritardoFinale).max().orElse(0);
  }

  public int ritardoMedio() {
	  return (int) treni.stream().mapToDouble(Treno::ritardoFinale).average().orElse(0);
  }

public boolean isStaordinario() {
	return staordinario;
}

public void setStaordinario(boolean staordinario) {
	this.staordinario = staordinario;
}

public void setCodice(String codice) {
	this.codice = codice;
}

public void setCategoria(String categoria) {
	this.categoria = categoria;
}

public void setFermate(Map<String, Fermata> fermate) {
	this.fermate = fermate;
}

public void setTreni(List<Treno> treni) {
	this.treni = treni;
}
  
  
  public void newTreno(Treno treno) {
	  treni.add(treno);
  }
  
 
  public boolean isStazioneInFermate(String nomeStazione) {
	  return fermate.containsKey(nomeStazione);
  }

  public Fermata getFermata(String nomeStazione) {
	  return fermate.get(nomeStazione);
  }

  public Fermata getLastFermata() {
	  Fermata fermata = null;
	  for(Fermata f: fermate.values()) {
		  fermata = f;
	  }
	  
	  return fermata;
  }
}
