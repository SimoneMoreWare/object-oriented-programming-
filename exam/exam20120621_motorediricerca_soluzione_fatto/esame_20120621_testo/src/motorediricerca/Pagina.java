package motorediricerca;

import java.util.*;

public class Pagina{
	private String indirizzo;
	private String html;
	private long data;
	private int punteggio;
	
	List<ElementoMultimediale> elementi = new LinkedList<ElementoMultimediale>();
	List<Pagina> collegamentiUscenti = new LinkedList<Pagina>();
	List<String> parole = new LinkedList<String>();
	
	public Pagina (String indirizzo, String html){
		this.indirizzo = indirizzo;
		this.html = html;
		data = System.currentTimeMillis();
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
	
	public int getPunteggio(){
		return punteggio;
	}
	
	private boolean cercaElementoMultimediale(String nome){
		for (int i =0; i<elementi.size(); i++)
			if (elementi.get(i).getNome().compareTo(nome)==0)
				return true;
		return false;
	}
		
	public void aggiungiImmagine(String nome, float dimensione){
		if (!cercaElementoMultimediale(nome)){
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
	
	public void aggiungiCollegamentoUscente(Pagina destinazione){
		collegamentiUscenti.add(destinazione);
	}

	private boolean cercaParola(String parola){
		for (int i=0; i<parole.size(); i++){
			if (parole.get(i).compareTo(parola)==0)
				return true;
		}
		return false;
	}
	
	public void aggiungiParolaChiave(String parola) throws ParolaChiaveDuplicataException{
		if (!cercaParola(parola))
			parole.add(parola);
		else
			throw new ParolaChiaveDuplicataException();
	}
	
	
	public String[] elencoParoleChiave(){
		String array[] = new String[parole.size()];
		for (int i =0; i<parole.size(); i++)
			array[i] = parole.get(i);
		return array;
	}

	public void setHtml(String html) {
		this.html = html;
	}
	
	public void aggiornaData(){
		this.data = System.currentTimeMillis();
	}

	public void calcolaPunteggio(String[] queryArray,
			Collection<Pagina> pagine) {
		int parole =0; 
		int collegamentiEntranti =0;
		
		// 1: calcola il numero di parole chiave che matchano
		for (int i=0; i<queryArray.length; i++){
			if (this.cercaParola(queryArray[i]))
				parole ++;
		}
		
		// 2: calcola il numero di collegamenti entranti
		for (int i =0; i<pagine.size(); i++){
			List<Pagina> temp = ((List<Pagina>)pagine).get(i).collegamentiUscenti;
			for (int j=0; j<temp.size(); j++){
				if (temp.get(j).getIndirizzo().compareTo(this.indirizzo)==0)
					collegamentiEntranti++;
			}
		}
		this.punteggio = parole + collegamentiEntranti;
		
		
	}
	
}







