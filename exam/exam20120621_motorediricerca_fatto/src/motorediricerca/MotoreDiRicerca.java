package motorediricerca;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MotoreDiRicerca {
	
	private Map<String, Pagina> pagine = new HashMap<>();

	public Pagina aggiungiPagina(String indirizzo, String html){
		
		if(pagine.containsKey(indirizzo)) {
			pagine.get(indirizzo).setTime(System.currentTimeMillis());
			pagine.get(indirizzo).setHtml(html);
		}else {
			Pagina pagina = new Pagina(indirizzo, html, System.currentTimeMillis());
			pagine.put(indirizzo, pagina);
		}
		
		return pagine.get(indirizzo);
	}
	
	public Collection<Pagina> elencoPagine(){
		return pagine.values().stream().sorted(Comparator.comparing(Pagina::getTime,Collections.reverseOrder())).collect(Collectors.toList());
	}
	
	public void aggiungiCollegamentoUscente(String indirizzoSorgente, String indirizzoDestinazione){
		
		if(pagine.containsKey(indirizzoDestinazione) && pagine.containsKey(indirizzoDestinazione)) {
			pagine.get(indirizzoSorgente).newPagina(pagine.get(indirizzoDestinazione));
		}
		
	}
	
	public Collection<Pagina>cerca(String query){
		return null;
	}
}
