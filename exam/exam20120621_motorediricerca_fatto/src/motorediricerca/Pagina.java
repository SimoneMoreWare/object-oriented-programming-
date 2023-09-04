package motorediricerca;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Pagina{
	
	private String indirizzo;
	private String html;
	private long time;
	private Map<String, ElementoMultimediale> elementiMultimediali = new HashMap<>();
	private List<Pagina> collegamentiUscenti = new LinkedList<>();
	private Set<String> paroleChiavi = new LinkedHashSet<>();

	public Pagina(String indirizzo, String html, long time) {
		super();
		this.indirizzo = indirizzo;
		this.html = html;
		this.time = time;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	public String getIndirizzo(){
		return indirizzo;
	}
	
	public String getHtml(){
		return html;
	}
	
	public long getData(){
		return time;
	}
	
	public int getPunteggio(){
		return -1;
	}
		
	public void aggiungiImmagine(String nome, float dimensione){
		if(!elementiMultimediali.containsKey(nome)) {
			Immagine immagine = new Immagine(nome, dimensione, "immagine");
			elementiMultimediali.put(nome, immagine);
		}
	}

	public void aggiungiVideo(String nome, float dimensione,int durata){
		if(!elementiMultimediali.containsKey(nome)) {
			Video video = new Video(nome, dimensione, "video", durata);
			elementiMultimediali.put(nome, video);
		}
    }
	

	public Collection<ElementoMultimediale> elencoElementiMultimediali(){
		return elementiMultimediali.values().stream()
				.sorted(Comparator.comparing(ElementoMultimediale::getDimensione).thenComparing(ElementoMultimediale::getNome))
				.collect(Collectors.toList());
	}

	public void aggiungiParolaChiave(String parola) throws ParolaChiaveDuplicataException{
		if(paroleChiavi.contains(parola)) throw new ParolaChiaveDuplicataException();
		paroleChiavi.add(parola);
	}
	
	public String[] elencoParoleChiave(){
		return paroleChiavi.toArray(new String[paroleChiavi.size()]);
	}

	public void newPagina(Pagina pagina) {
		collegamentiUscenti.add(pagina);		
	}
	
}







