package motorediricerca;

import java.util.*;

public class MotoreDiRicerca {
	Map<String, Pagina> pagine = new HashMap<String, Pagina>(); 
	

	public Pagina aggiungiPagina(String indirizzo, String html){
		Pagina p;
		if ((p=getPagina(indirizzo))!=null){
			// aggiorno le informazioni della pagina
			// aggiorno l'html
			p.setHtml(html);
			// aggiorno la data
			p.aggiornaData();
			return p;
		}
		else{
			p = new Pagina(indirizzo, html);
			pagine.put(indirizzo, p);
			return p;
		}
	}
	
	private Pagina getPagina(String indirizzo){
		return pagine.get(indirizzo);
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
		sorgente.aggiungiCollegamentoUscente(destinazione);
	}
	
	public Collection<Pagina>cerca(String query){
		List<Pagina> temp = new LinkedList<Pagina>(pagine.values());
		String queryArray[] = query.split(" ");
		for (int i=0; i<temp.size(); i++){
			Pagina p = temp.get(i);
			// calcolo il punteggio
			p.calcolaPunteggio(queryArray, this.elencoPagine());
		}
		
		Collections.sort(temp, new PaginaPunteggioComparator());
		
		return temp;
	}
}