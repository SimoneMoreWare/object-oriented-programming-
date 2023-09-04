package orari;

import java.util.LinkedList;
import java.util.List;

public class Treno {
	
	private Percorso percorso;
	private int giorno;
	private int mese;
	private int anno;
	private List<Passaggio> passaggi = new LinkedList<>();
	
  public Treno(Percorso percorso, int giorno, int mese, int anno) {
		super();
		this.percorso = percorso;
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
  
  public Passaggio registraPassaggio(String stazione, int ore, int minuti) 
  	throws StazioneNonValida {
	  
	  if(!percorso.isStazioneInFermate(stazione)) throw new StazioneNonValida();
	  
	  int ritardo = ore*60 + minuti - (percorso.getFermata(stazione).getOre()*60 + percorso.getFermata(stazione).getMinuti());
	  
	  Passaggio passaggio = new Passaggio(stazione, ore , minuti, ritardo);
	  passaggi.add(passaggio);
	  
	  
	  
    return passaggio;
  }

  public boolean arrivato() {
	  
	  for(Passaggio passaggio: passaggi) {
		  if(passaggio.getStazione().equals(percorso.getLastFermata().getStazione())) return true;
	  }
	  
    return false;
  }

  public int ritardoMassimo() {
     return passaggi.stream().mapToInt(Passaggio::ritardo).max().orElse(0);
  }

  public int ritardoFinale() {
     Passaggio passaggioFinale = null;
     for(Passaggio passaggio: passaggi) passaggioFinale = passaggio;
     return passaggioFinale.ritardo();
  }

}
