package orari;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Treno implements Comparable {

  private List passaggi = new ArrayList();
  private Percorso percorso;
  private int giorno;
  private int mese;
  private int anno;

  public Treno(Percorso p, int giorno, int mese, int anno) {
  	this.percorso = p;
  	this.giorno = giorno;
  	this.mese = mese;
  	this.anno = anno;
  }

  public Percorso getPercorso() {
    return percorso;
  }

  public int getGiorno() {
    return giorno;
  }

  public int getMese() {
    return mese;
  }

  public int getAnno() {
    return anno;
  }

  public Passaggio registraPassaggio(String codice, int ore, int minuti) 
  	throws StazioneNonValida {
  	Fermata f = null;
  	for (Iterator iter = percorso.getFermate().iterator(); iter.hasNext();) {
      Fermata element = (Fermata) iter.next();
      if(element.getStazione().equals(codice)){
      	f = element;
      }
    }
    if(f==null) throw new StazioneNonValida();
  	Passaggio p = new Passaggio(f,ore,minuti);
  	passaggi.add(p);
    return p;
  }

  public boolean arrivato() {
  	Passaggio lastPass = (Passaggio)passaggi.get(passaggi.size()-1);
  	Fermata lastFerm = (Fermata)percorso.getFermate().get(percorso.getFermate().size()-1);
    return lastPass.getStazione().equals(lastFerm.getStazione());
  }

  public int ritardoMassimo() {
  	int max = 0;
  	for (Iterator iter = passaggi.iterator(); iter.hasNext();) {
      Passaggio element = (Passaggio) iter.next();
      if(element.ritardo()>max){
      	max = element.ritardo();
      }
    }
    return max;
  }

  public int ritardoFinale() {
    return ((Passaggio)passaggi.get(passaggi.size()-1)).ritardo();
  }

  public int compareTo(Object arg0) {
  	Treno other = (Treno)arg0;
  	
  	int dY = this.anno - other.anno;
  	if(dY!=0) return -dY;
  	int dM = this.mese - other.mese;
  	if(dM!=0) return -dM;
  	int dD = this.giorno - other.giorno;
  	if(dD!=0) return -dD;
	return 0;
  }

}
