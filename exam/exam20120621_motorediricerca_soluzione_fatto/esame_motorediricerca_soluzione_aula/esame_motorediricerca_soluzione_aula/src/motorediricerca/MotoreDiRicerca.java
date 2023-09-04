package motorediricerca;

import java.util.*;

public class MotoreDiRicerca {
	Map<String, Pagina> pagine = new HashMap<String, Pagina>();

	public Pagina aggiungiPagina(String indirizzo, String html){
		Pagina p = pagine.get(indirizzo);
		if (p != null){
			// la pagina esiste gia'
			// aggiornare l'html
			p.aggiornaHtml(html);
			// aggiornare la data
			p.aggiornaData();
			return p;
		}else{
			// la pagina non esiste
			p = new Pagina(indirizzo, html);
			pagine.put(indirizzo, p);
			return p;
		}
	}
	
	public Collection<Pagina> elencoPagine(){
		List<Pagina> temp = new LinkedList<Pagina>(pagine.values());
		Collections.sort(temp, new PaginaDataComparator());
		return temp;
	}
	
	public void aggiungiCollegamentoUscente(String indirizzoSorgente, 
			String indirizzoDestinazione){
		Pagina sorgente = pagine.get(indirizzoSorgente);
		Pagina destinazione = pagine.get(indirizzoDestinazione);
		
		if (sorgente != null && destinazione != null && !sorgente.equals(destinazione))
			sorgente.aggiungiCollegamentoUscente(destinazione);
	}
	
	public Collection<Pagina>cerca(String query){
		
		List<Pagina> temp = new LinkedList<Pagina>(pagine.values());
		String queryArray[] = query.split(" ");
		
		for (Pagina p : temp){
			p.calcolaPunteggio(queryArray, temp);
		}
		
		
		Collections.sort(temp, new PaginaPunteggioComparator());
		
		return temp;
	}
}
