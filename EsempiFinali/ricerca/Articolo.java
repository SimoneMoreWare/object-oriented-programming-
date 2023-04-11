package ricerca;
import java.util.*;
public class Articolo implements Comparable <Articolo> {
	private String titolo; 	private int n = 0;	private Rivista r;
	Collection<Ricercatore> autori = new ArrayList<Ricercatore>();
	Articolo (String titolo, Ricercatore ricercatore, Rivista r) {
		this.titolo = titolo; this.autori.add(ricercatore); this.r = r;}
    Articolo (String titolo, Ricercatore[] ricercatori, Rivista r) {
    	this.titolo = titolo; this.autori = Arrays.asList(ricercatori); this.r = r;
    }
	Articolo (String titolo, Ricercatore ricercatore, Rivista r, int n) {
		this.titolo = titolo; this.autori.add(ricercatore); this.r = r; this.n = n;
	}
    public Rivista getRivista(){return r;}
    public String getTitolo(){return titolo;}
    
    public Collection<Ricercatore> elencoAutori(){
        return autori;}
    
    public void cita(Articolo citato) {citato.n++;}

    public int numCitazioni(){return n;}
	public int compareTo(Articolo a) {
		if (this.n == a.n) return 0;
		else if (this.n < a.n) return 1; else return -1;
	}
 }
