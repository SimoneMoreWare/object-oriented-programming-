package voli;
public class Volo implements Comparable<Volo> {
private String codiceVolo; 
private String luogoPartenza; private String luogoArrivo;
private int oraPartenza;  private int oraArrivo;
private Aereo aereo; 
private VoloGiornaliero[] voliGiornalieri; 
String getCodiceVolo() {return codiceVolo;}
Aereo getAereo() {return aereo;}
Volo(String codiceVolo, Aereo aereo, String luogoPartenza, int oraPartenza, String luogoArrivo, int oraArrivo){
	this.codiceVolo = codiceVolo; 
	this.aereo = aereo; 
	this.luogoPartenza = luogoPartenza; this.oraPartenza = oraPartenza; 
	this.luogoArrivo = luogoArrivo; this.oraArrivo = oraArrivo; 
	voliGiornalieri = new VoloGiornaliero[7];
	for (int g = 0; g < 7; g++) 
		voliGiornalieri[g] = new VoloGiornaliero(this, g);
	}

public int compareTo(Volo v2){
	if (this.oraArrivo < v2.oraPartenza) return -1;
	else if (this.oraPartenza > v2.oraArrivo) return 1;
	else return 0;
}
VoloGiornaliero getVoloGiornaliero(int giorno){
	return voliGiornalieri[giorno];	
}	
public String toString(){return codiceVolo + " da " 
	+ luogoPartenza + ":" + oraPartenza + " a " + luogoArrivo 
	+ ":" + oraArrivo;}}
