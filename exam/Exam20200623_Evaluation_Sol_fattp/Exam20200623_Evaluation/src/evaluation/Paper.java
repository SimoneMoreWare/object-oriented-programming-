package evaluation;

import java.util.List;

public class Paper {
	private String title;
	private Rivista rivista;
	private List<String> autori;
	private int punteggio;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Rivista getRivista() {
		return rivista;
	}
	public void setRivista(Rivista rivista) {
		this.rivista = rivista;
	}
	public Paper(String title, Rivista rivista) {
		super();
		this.title = title;
		this.rivista = rivista;
	}
	public void addAutori(List<String> asList) {
		this.autori=asList;
	}
	public boolean containsAutore(String autore) {
		// TODO Auto-generated method stub
		return autori.contains(autore);
	}
	public void setPunteggio(int point) {
		this.punteggio=point;
		
	}
	public int getPunteggio() {
		// TODO Auto-generated method stub
		return punteggio;
	}
	
	

}
