package voli;
import java.util.*;
public class Voli {
private Map<String, Aereo> aerei = new HashMap<String, Aereo>(); 
private Map<String, Volo> voli = new HashMap<String, Volo>();
public Aereo addAereo(String codiceAereo, String descrizione, int numeroPosti) throws VoliEx{
	if (codiceAereo == null || numeroPosti <= 0	
	|| aerei.containsKey(codiceAereo)) 
		throw new VoliEx("dati errati in addAereo: " + codiceAereo);
	Aereo a1 = new Aereo(codiceAereo, descrizione, numeroPosti);
	aerei.put(codiceAereo, a1); return a1;}
public void addVolo(String codiceVolo, String codiceAereo, 
		String luogoPartenza, int oraPartenza, 
		String luogoArrivo, int oraArrivo) throws VoliEx {
	if (codiceVolo == null || voli.containsKey(codiceVolo)
	|| luogoPartenza == null || luogoArrivo == null 
	|| oraPartenza < 1 || oraPartenza > 24 || oraArrivo < 1 
	|| oraArrivo > 24 || oraPartenza >= oraArrivo 
	|| !aerei.containsKey(codiceAereo)) 
		throw new VoliEx("dati errati in addVolo: " + codiceVolo);
	Aereo a = aerei.get(codiceAereo);
	Volo v1 = new Volo(codiceVolo, a, luogoPartenza, oraPartenza,
 		luogoArrivo, oraArrivo);
	a.addVolo(v1);	//verifica sovrapposizione voli su aereo
	voli.put(codiceVolo, v1); 
}

public void addPrenotazione(String codiceVolo, String passeggero, int giorno) throws VoliEx {
	getVoloGiornaliero(codiceVolo, giorno).addPrenotazione(passeggero);
}

public VoloGiornaliero getVoloGiornaliero(String codiceVolo, int giorno) throws VoliEx {
	if (codiceVolo == null || giorno < 1 || giorno > 7 
	|| !voli.containsKey(codiceVolo)) throw new 
		VoliEx("dati errati in getVoloGiornaliero: " + codiceVolo);
	Volo v1 = voli.get(codiceVolo);
	return v1.getVoloGiornaliero(giorno);	
}}

