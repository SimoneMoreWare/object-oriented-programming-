package biblioteca;
public class Libro {
	private String titolo; private int nPrestiti = 0;
	private Volume[] volumi; 
	Libro(String titolo, int n, int nuovoCodice){
		this.titolo = titolo; volumi = new Volume[n];
		for (int i = 0; i < volumi.length; i++) 
			volumi[i] = new Volume(this, nuovoCodice++);
	}
	String getTitolo(){return titolo;}
	int getNPrestiti() {return nPrestiti;}
	Volume getVolume() {
		for (int i = 0; i < volumi.length; i++){
			Volume v = volumi[i];
			if (v.getDisp()) {nPrestiti ++; return v;}
		}
		return null;}
	public String toString(){return titolo + ":" + nPrestiti;}}
