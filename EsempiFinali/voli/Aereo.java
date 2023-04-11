package voli;
import java.util.*; 
public class Aereo {
private String codiceAereo; private String descrizione;
private int numeroPosti; 
private TreeSet<Volo> voli = new TreeSet<Volo>();
Aereo(String codiceAereo, String descrizione, int numeroPosti){
	this.codiceAereo = codiceAereo; 
	this.descrizione = descrizione; 
	this.numeroPosti = numeroPosti;}
int getNumeroPosti() { return numeroPosti;}
void addVolo(Volo volo) throws VoliEx{
	if (!voli.add(volo)) throw new 
		VoliEx("sovrapposizione voli:" + volo.getCodiceVolo()); 
	}
public String toString(){
return codiceAereo + " " + descrizione + " " + numeroPosti + " " + voli;}
}
