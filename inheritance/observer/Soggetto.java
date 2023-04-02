package inheritance.observer;

import java.util.Arrays;

/**
 * Classe di base per le classi che devono essere osservate
 * 
 * @author mtk
 *
 */
public class Soggetto {
	private Osservatore[] osservatori = new Osservatore[5];
	private int prossimo = 0;
	
	/**
	 * Metodo pensato per essere invocato dagli osservatori
	 * per (auto-)registrarsi
	 * 
	 * @param obs
	 */
	public void registraOsservatore(Osservatore obs) {
		if(prossimo==osservatori.length) {
			osservatori = Arrays.copyOf(osservatori, prossimo);
		}
		osservatori[prossimo++] = obs;
	}
	
	/**
	 * Metodo pensato per le sottoclassi sogetto di osservazione
	 * per inviare a tutti gli osservatori la notifica.
	 * 
	 * @param descrizione
	 */
//	public void avvisaOsservatori(String descrizione) {
//		for(Osservatore o : osservatori) {
//			if(o==null) break;
// 			o.notificaEvento(descrizione);
//		}
//	}
	
	/**
	 * Metodo pensato per le sottoclassi sogetto di osservazione
	 * per inviare a tutti gli osservatori la notifica.
	 * 
	 * @param descrizione
	 */
	public void avvisaOsservatori(String descrizione, Object dati) {
		for(Osservatore o : osservatori) {
			if(o==null) break;
 			o.notificaEvento(descrizione,dati);
		}

	}

}
