package orari;

import java.util.LinkedList;
import java.util.List;

public class Treno implements Comparable<Treno>{
	
	private Percorso percorso;
	private int giorno;
	private int mese;
	private int anno;
	private List<Passaggio> passaggi = new LinkedList<Passaggio>();
	
	public Treno(Percorso percorso, int giorno, int mese, int anno) {
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
		
		// chiedo al percorso di restituirmi l'oggetto fermata corrispondente (al codice)
		Fermata f = percorso.getFermataParticolare(stazione);
		
		if (f == null)
			throw new StazioneNonValida();
		
		Passaggio p = new Passaggio(f, ore, minuti);
		passaggi.add(p);
		return p;
	}

	public boolean arrivato() {
		List<Fermata> fermate = percorso.getFermate();
		
		// Ultima fermata
		
		Fermata ultimaFermata = fermate.get(fermate.size()-1);
		Passaggio ultimoPassaggio = passaggi.get(passaggi.size()-1);
		
		if (ultimaFermata.getStazione().compareTo(ultimoPassaggio.getStazione()) == 0)
			return true;
		return false;
	}

	
	public int ritardoMassimo() {
		int max = 0;
		
		for (Passaggio p : passaggi)
			if (p.ritardo() > max)
				max = p.ritardo();
		
		return max;
	}

	
	public int ritardoFinale() {
		Passaggio ultimoPassaggio = passaggi.get(passaggi.size()-1);
		return ultimoPassaggio.ritardo();
	}

	@Override
	public int compareTo(Treno altro) {
		// ordine crescente
		//int diffAnno = this.anno - altro.anno;
		
		int diffAnno = altro.getAnno() - this.anno;
		if (diffAnno != 0)
			return diffAnno;
		
		int diffMese = altro.getMese() - this.mese;
		if (diffMese != 0)
			return diffMese;
		
		return altro.getGiorno()-this.giorno;
	}
	
	
	
	

}
