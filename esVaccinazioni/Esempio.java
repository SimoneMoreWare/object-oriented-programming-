import it.polito.PO2023.vaccinazione.SistemaVaccinale;

public class Esempio {

	public static void main(String[] args) {
		SistemaVaccinale sistema = new SistemaVaccinale();
		
		sistema.registraCittadino("CNDSNP02S05H926V","Simone Pio", "Candido", "Via Calle Del Porto C2", "3515289244");
		sistema.registraCittadino("JBDJABJABSDB2141","Pako Pio", "Candido", "Via Crocchette Del Pollo C2", "352352214");
		sistema.registraCittadino("JFAHIUWHRB2","Mauro", "Vi", "Via Stozitto T3", "364672782");
		sistema.registraCittadino("NFJBJBCE45","Elti", "Salsa", "Via Ciao f4", "3678467462");
		
		System.out.println("Cittadini inseriti: "+sistema.numeroRegistrati());
		
		sistema.inserisciCentro("Centro Vaccinazioni Polito", "Corso Duca 24");
		
		sistema.assegnaCitaddini();
		System.out.println(sistema.centroDelCittadino("CNDSNP02S05H926V"));
	}

}
