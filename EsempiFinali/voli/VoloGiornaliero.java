package voli;
import java.util.*;
public class VoloGiornaliero {
private TreeSet<String> prenotazioni; 
private Volo volo; 
private int giorno;
VoloGiornaliero(Volo volo, int giorno){
	this.volo = volo; this.giorno = giorno; 
	prenotazioni = new TreeSet<String>();}
public String toString(){
	return giorno + " " + volo.toString() +	" " + prenotazioni;}
void addPrenotazione(String passeggero) throws VoliEx{
	if (prenotazioni.size() == volo.getAereo().getNumeroPosti()) 
		throw new VoliEx("volo completo:" + volo.getCodiceVolo() 
			+ ":" + giorno);
	if (!prenotazioni.add(passeggero)) 
		throw new VoliEx("prenotazione duplicata:" + 
		volo.getCodiceVolo() + ":" + giorno + " " + passeggero);
	}}
