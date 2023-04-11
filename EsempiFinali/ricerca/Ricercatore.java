package ricerca;
import java.util.*;
public class Ricercatore {
private String codice; private String first; private String last;
	ArrayList<Articolo> articoli = new ArrayList<Articolo>();
	Ricercatore(String codice, String first, String last) {
		this.codice = codice; this.first = first; this.last = last;}
    public String getCodice(){return codice;}
    public String getFirst(){return first;}
    public String getLast(){return last;}
    public int numArticoli() {return articoli.size();}
    void addArticolo(Articolo a) {articoli.add(a);}
    public double sommaIF() {
    	double f = 0;
        for (Articolo a: articoli) f += a.getRivista().getIF();
        return f;}
    public int hIndex() {
    	int i = 1; int val = 0;
    	for (Articolo a: articoli)
    		if (a.numCitazioni() < i) return val; else val = i++;
    	return val;}
    public Collection<Articolo> elencoArticoli(){
        return articoli;}
}
