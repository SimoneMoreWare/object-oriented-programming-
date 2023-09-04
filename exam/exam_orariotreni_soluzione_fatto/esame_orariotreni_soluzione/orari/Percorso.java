package orari;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
 
public class Percorso {

  private String codice;
  private String categoria;
  private boolean straordinario = false;
	
  private List<Fermata> fermate = new LinkedList<Fermata>();
  private List<Treno> treni = new LinkedList<Treno>();

  private Map<String,Fermata> fermatePerStazione = new TreeMap<String,Fermata>();

  // aggiunta per gestire i passaggi
  // potrei decidere di tenere solo la Mappa, ma per ordinare dovrei 
  // creare la linkedlist al volo con
  // LinkedList<Fermata> fermate =
  //    new LinkedList<Fermata>(fermataPerStazione.values());

  public Percorso(String codice, String categoria) {
	this.codice=codice;
	this.categoria=categoria;
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
	  this.straordinario=b;
  }
  
  public Fermata aggiungiFermata(String nomeStazione, int ore, int minuti) {
	  Fermata f = new Fermata(nomeStazione, ore, minuti);
	  fermate.add(f);
	  fermatePerStazione.put(nomeStazione,f); // Aggiunto per mappa
	  return f;
  }

  public void aggiungiTreno(Treno t){
	  treni.add(t);
  }
  
  public Fermata getFermata(String codice)
  {
	  return fermatePerStazione.get(codice);
  }
  
  
  public List<Fermata> getFermate() {
	     							// Non abbiamo un accesso per chiave
		 							// Possiamo usare una lista
		 							// Ordinamento per orario (coppia ore/minuti)
		 							// Sarebbe difficile usare una TreeMap
		 							// L'ordinamento in quel caso verrebbe naturale
	  Collections.sort(fermate);    // Avrei potuto creare un'altra lista e ordinarla
	  return fermate;
  }

  public List<Treno> getTreni() {

	  Collections.sort(treni);
	  return treni;
  }
  
  public int ritardoMassimo() {
	  int max = 0;
	  	for(Treno t : treni){
	  		if(t.ritardoFinale() > max){
		    max = t.ritardoFinale();
		}
	  }
	  return max;
  }

  public int ritardoMedio() {
	  int media = 0;
	  	for(Treno t : treni){
		  media += t.ritardoFinale();
	  }
	  return media / treni.size();
  }

}
