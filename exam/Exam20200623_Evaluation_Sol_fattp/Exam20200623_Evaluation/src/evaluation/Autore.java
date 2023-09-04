package evaluation;

import java.util.ArrayList;
import java.util.List;

public class Autore {
	
	private String name;
	private List<Paper> articoli = new ArrayList<>();
	private int punteggioTotaleArticoli;
	private Gruppo gruppo;
	public Gruppo getGruppo() {
		return gruppo;
	}
	public void setGruppo(Gruppo gruppo) {
		this.gruppo = gruppo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Paper> getArticoli() {
		return articoli;
	}
	public void setArticoli(List<Paper> articoli) {
		this.articoli = articoli;
	}
	public int getPunteggioTotaleArticoli() {
		return punteggioTotaleArticoli;
	}
	
	public Autore(String name) {
		super();
		this.name = name;
	}
	
	
	public void addArticolo(Paper p) {
		articoli.add(p);
	}
	
	public void addPunti(int d) {
		this.punteggioTotaleArticoli+=d;
	}

}
