package ricerca;
import java.util.*;
@SuppressWarnings("unused")
public class Rivista implements Comparable <Rivista>{
	private String issn; private String title; private double impactFactor;
	ArrayList<Articolo> articoli = new ArrayList<Articolo>();
	Rivista (String issn, String title, double impactFactor) {
		this.issn = issn; this.title = title; this.impactFactor = impactFactor;}
    public String getTitolo(){return title;}
    public double getIF(){return impactFactor;}
    
    public Articolo addArticolo(String titolo, Ricercatore ricercatore) {
		Articolo a = new Articolo(titolo, ricercatore, this);
		articoli.add(a);
		ricercatore.addArticolo(a);
        return a;}

    public Articolo addArticolo(String titolo, Ricercatore ricercatore, int n) {
		Articolo a = new Articolo(titolo, ricercatore, this, n);
		articoli.add(a);
		ricercatore.addArticolo(a);
        return a;}
    
    public Articolo addArticolo(String titolo, Ricercatore[] ricercatori) {
		Articolo a = new Articolo(titolo, ricercatori, this);
		articoli.add(a);
		for (Ricercatore r: ricercatori) r.addArticolo(a);
        return a;}
	public int compareTo(Rivista r) {
		if (this.impactFactor == r.impactFactor) return 0;
		else if (this.impactFactor < r.impactFactor) return 1; else return -1;
	}

}
