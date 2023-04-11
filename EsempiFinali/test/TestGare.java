package test;
import gare.*;
public class TestGare {
	public static void main(String[] args) {
		try{
			Gare gare = new Gare();
			gare.newAtleta("Miguel", "Olmo"); gare.newAtleta("Francesco", "Olmo");
			//inserisce nome e squadra atleta, errore se già inserito
			gare.newAtleta("Eddy", "Bianchi"); 
			gare.newGara("Giro delle Fiandre");
			//inserisce nome gara, errore se già inserita
			gare.newGara("Parigi Roubaix");
			gare.newPunteggio("Giro delle Fiandre", "Miguel", 10); 
			gare.newPunteggio("Giro delle Fiandre", "Francesco", 8);
			//inserisce punteggio atleta in gara, errore se atleta o gara inesistenti
			//oppure se ciclista o tempo già inseriti
			gare.newPunteggio("Giro delle Fiandre", "Eddy", 9);
			gare.newPunteggio("Parigi Roubaix", "Eddy", 10);
			gare.newPunteggio("Parigi Roubaix", "Francesco", 7);
			System.out.println("classifica Giro delle Fiandre");
			for (ElementoDiClassifica e: gare.getClassifica("Giro delle Fiandre")) 
				System.out.println(e.getNome() + " " + e.getValore());
			System.out.println("classifica generale");
			for (ElementoDiClassifica e: gare.getClassificaGenerale()) 
				System.out.println(e.getNome() + " " + e.getValore());	
			System.out.println("classifica a squadre");
			for (ElementoDiClassifica e: gare.getClassificaSquadre())
				System.out.println(e.getNome() + " " + e.getValore());	
			System.out.println(gare.getPiazzamenti("Eddy"));
		} catch(Exception e){System.out.println(e.getMessage());}
	}

/*	
classifica Giro delle Fiandre
Miguel 10
Eddy 9
Francesco 8
classifica generale
Eddy 19
Francesco 15
Miguel 10
classifica per squadre
Olmo 25
Bianchi 19
piazzamenti di Eddy: Parigi Roubaix.10 Giro delle Fiandre.9
*/	
}
