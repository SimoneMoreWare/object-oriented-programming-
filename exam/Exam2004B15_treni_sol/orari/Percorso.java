package orari;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class Percorso {

  private List fermate = new ArrayList();
  private String codice;
  private String categoria;
  private boolean straordinario;
  private List treni = new ArrayList();


  
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

  public void setStraordinario(boolean newValue) {
  	straordinario = newValue;
  }

  public Fermata aggiungiFermata(String nomeStazione, int ore, int minuti) {
    Fermata f = new Fermata(nomeStazione,ore,minuti);
    fermate.add(f);
    return f;
  }

	public List getTreni() {
		return treni;
	}

  public List getFermate() {
    return fermate;
  }

  public int ritardoMassimo() {
  	int max = 0;
  	for (Iterator iter = treni.iterator(); iter.hasNext();) {
    	Treno element = (Treno) iter.next();
    	if(element.ritardoFinale()>max){
    		max = element.ritardoFinale();
    	}
  	}
    return max;
  }

  public int ritardoMedio() {
		int sum = 0;
		for (Iterator iter = treni.iterator(); iter.hasNext();) {
			Treno element = (Treno) iter.next();
			sum += element.ritardoFinale();
		}
		return sum/treni.size();
  }

  public void addTreno(Treno t) {
  	treni.add(t);
  	Collections.sort(treni);
  }

}

