package orari;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Percorso {
	private String codice;
	private String categoria;
	private boolean straordinario;
	
	private List<Fermata> fermate = new LinkedList<Fermata>();
	private List<Treno> treni = new LinkedList<Treno>();
	private Map<String, Fermata> fermatePerStazione = new TreeMap<String, Fermata>();
	
  public Percorso(String codice, String categoria) {
		this.codice = codice;
		this.categoria = categoria;
		this.straordinario = false;
	}

public String getCodice() {
    return codice;
  }

  public String getCategoria() {
    return categoria;
  }

  public boolean isStraordinario() {
    return straordinario;
  }

  public void setStraordinario(boolean b) {
	  this.straordinario = b;
  }
  
  public Fermata aggiungiFermata(String nomeStazione, int ore, int minuti) {
	  Fermata f = new Fermata(nomeStazione, ore, minuti);
	  fermate.add(f);
	  fermatePerStazione.put(nomeStazione, f);
	  return f;
  }

  public List<Fermata> getFermate() {
	  Collections.sort(fermate);
	  return fermate;
  }

  public List<Treno> getTreni() {
	  Collections.sort(treni);
	  return treni;
  }
  
  public int ritardoMassimo() {
	  int max = 0; 
	  
	  for (Treno t : treni)
		  if (t.ritardoFinale() > max)
			  max = t.ritardoFinale();
	  
	  return max;
  }

  public int ritardoMedio() {
	  int somma = 0;
	  
	  for (Treno t : treni)
		  somma += t.ritardoFinale();
	  
	  return somma/treni.size();
  }
  
  

public void aggiungiTreno(Treno t) {
	treni.add(t);
}

public Fermata getFermataParticolare(String stazione) {
	return fermatePerStazione.get(stazione);
	
}









}
