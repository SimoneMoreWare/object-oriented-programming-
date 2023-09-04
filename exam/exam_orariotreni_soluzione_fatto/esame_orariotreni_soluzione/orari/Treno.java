package orari;

import java.util.LinkedList;
import java.util.List;

public class Treno implements Comparable<Treno>{
	
  //private String codice;
  private Percorso percorso;	
  private int giorno;
  private int mese;
  private int anno;
  
  private List<Passaggio> passaggi = new LinkedList<Passaggio>();
  
  public Treno(Percorso p, int giorno, int mese, int anno) {
	  //this.codice=codice;
	  this.percorso=p;     // Sempre meglio memorizzare il riferimento
     					   // Diversamente dalle basi di dati, collegamento per chiavi/valori
	  this.giorno=giorno;
	  this.mese=mese;
	  this.anno=anno;
  }

  public Percorso getPercorso() {
	  //return codice;
	  //return Orari.getPercorso(codice);
	  return percorso;  
  }

  public String getCodice(){
	  return percorso.getCodice();
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
  
  public Passaggio registraPassaggio(String stazione, int ore, int minuti) 
  	  throws StazioneNonValida {
	  
	  // List<Fermata> fermate = percorso.getFermate();  
	  // E scandisco tutte le fermate
	  // Altra soluzione: visto che devo fare un accesso tramite chiave, inserisco
	  // una mappa delle fermate, la cui chiave è la stazione
	
	  Fermata f = percorso.getFermata(stazione);
	  if(f==null)
		  throw new StazioneNonValida();
	
	  Passaggio p = new Passaggio(f,ore,minuti);
	
	  passaggi.add(p);
	
	  return p;
  }

  public boolean arrivato() {  // Arrivato, ovvero passato per stazione con ora più grande
	  List<Fermata> fermate = percorso.getFermate(); // Ordine temporale
	  Fermata ultimaFermata = fermate.get(fermate.size()-1);
	 
	  Passaggio ultimoPassaggio = passaggi.get(passaggi.size()-1);
     
	  if(ultimoPassaggio.getStazione().equals(ultimaFermata.getStazione()))
		  return true;
	  else
		  return false;
  }

  public int ritardoMassimo() {
	  int max = 0;
	  for(Passaggio p : passaggi){
		  if(p.ritardo() > max){
			  max = p.ritardo();
	      }
	  }
	  return max;
  }

  public int ritardoFinale() {
	  Passaggio ultimoPassaggio = passaggi.get(passaggi.size()-1);
	  return ultimoPassaggio.ritardo();
  }

  public int compareTo(Treno altro) {
	  //int diffAnno=this.anno-altro.getAnno(); //Crescente 
	  int diffAnno=altro.getAnno()-this.anno;   //Decrescente
	  if(diffAnno != 0) return diffAnno;
	
	  int diffMese=altro.getMese()-this.mese;
	  if(diffMese!=0) return diffMese;
	
	  return altro.getGiorno()-this.giorno;
  }

}
