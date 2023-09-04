package motorediricerca;

import java.util.*;

public class Pagina{
	private String indirizzo;
	private String html;
	private long data;
	private int punteggio;
	
	private List<ElementoMultimediale> elementi = new LinkedList<ElementoMultimediale>();
	private List<String> parole = new LinkedList<String>();
	private List<Pagina> collegamentiUscenti = new LinkedList<Pagina>();
	
	public Pagina(String indirizzo, String html) {
		this.indirizzo = indirizzo;
		this.html = html;
		this.data = System.currentTimeMillis();
	}

	public String getIndirizzo(){
		return indirizzo;
	}
	
	public String getHtml(){
		return html;
	}
	
	public long getData(){
		return data;
	}
	
	public void aggiornaHtml(String html){
		this.html = html;
	}
	
	public void aggiornaData(){
		this.data = System.currentTimeMillis();
	}
	
	public int getPunteggio(){
		return punteggio;
	}
	
	private boolean cercaElementoMultimediale(String nome){
		for (ElementoMultimediale e : elementi)
			if (e.getNome().compareTo(nome) == 0)
				return true;
		return false;
	}
		
	public void aggiungiImmagine(String nome, float dimensione){
		if (cercaElementoMultimediale(nome) == false){
			ElementoMultimediale em = new Immagine(nome, dimensione);
			elementi.add(em);
		}
	}

	public void aggiungiVideo(String nome, float dimensione,int durata){
		if (!cercaElementoMultimediale(nome)){
			ElementoMultimediale em = new Video(nome, dimensione, durata);
			elementi.add(em);
		}
	}
	

	public Collection<ElementoMultimediale> elencoElementiMultimediali(){
		Collections.sort(elementi);
		return elementi;
	}
	
	private boolean cercaParola(String parola){
		for (String s : parole)
			if (s.toLowerCase().compareTo(parola.toLowerCase()) == 0)
				return true;
		return false;
	}
	

	public void aggiungiParolaChiave(String parola) 
			throws ParolaChiaveDuplicataException{
		
		if (cercaParola(parola) == false)
			parole.add(parola);
		else
			throw new ParolaChiaveDuplicataException();
	}
	
	public String[] elencoParoleChiave(){
		String array[] = new String[parole.size()];
		
		for (int i = 0; i<parole.size(); i++)
			array[i] = parole.get(i);
		
		return array;
	}
	
	public void aggiungiCollegamentoUscente(Pagina destinazione){
		collegamentiUscenti.add(destinazione);
	}
	
	public void calcolaPunteggio(String[] queryArray, List<Pagina> pagine){
		int parole = 0;
		int collegamentiEntranti = 0;
		
		// per parole chiave
		for (String s: queryArray)
			if (cercaParola(s)) // == true
				parole++;
				
		// per collegamenti entranti
		// ciclo la lista di pagine
		for (Pagina p : pagine){
			List<Pagina> temp = p.collegamentiUscenti;
			for (Pagina pag : temp){
				if (pag.getIndirizzo().compareTo(this.getIndirizzo()) == 0)
					collegamentiEntranti++;
			}
		}
		
		this.punteggio = parole + collegamentiEntranti;
	}
	
}







