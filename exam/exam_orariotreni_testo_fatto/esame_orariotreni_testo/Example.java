import java.util.List;

import orari.*;


public class Example {

	public static void main(String[] args) throws PercorsoNonValido, StazioneNonValida {
		
		Orari orari = new Orari();
		
		Percorso ic123 = orari.creaPercorso("IC123", "Intercity");

		ic123.aggiungiFermata("Torino Porta Susa", 8, 5);
		ic123.aggiungiFermata("Vercelli", 8, 40);
		ic123.aggiungiFermata("Milano", 9, 35);
		
		List<Fermata> fermate = ic123.getFermate();
		System.out.println("Il percorso " + ic123.getCodice() + " ha " + fermate.size() + " fermate");
		System.out.println("\tda " + fermate.get(0) + " a " + fermate.get(fermate.size()-1));
		
		Treno t = orari.nuovoTreno("IC123", 19, 6, 2009);
		
		Passaggio p = t.registraPassaggio("Torino Porta Susa", 8, 10);
		
		System.out.println("Il ritardo alla stazione " + p.getStazione() + " � di "
							+ p.ritardo() + " minuti");
		
		t.registraPassaggio("Vercelli", 9, 55);
		t.registraPassaggio("Milano", 9, 42);
		
		System.out.println("Ritardo finale " + t.ritardoFinale());
		System.out.println("Ritardo massimo " + t.ritardoMassimo());
	}

}
