package it.polito.PO2023.vaccinazione;

public class SistemaVaccinale {
	
	private static final int DIMENSIONE_DEFAULT = 100;
	private Cittadino[] cittadiniRegistrati=new Cittadino[DIMENSIONE_DEFAULT];
	private int numCittadini;
	private CentroVaccinale[] centri = new CentroVaccinale[DIMENSIONE_DEFAULT];
	private int numCentri;

	
	public SistemaVaccinale() {
		cittadiniRegistrati = new Cittadino[DIMENSIONE_DEFAULT]; //sarebbe meglio una lista, cosi non devo preoccupare di stimare dimensione;
	}
	
	/*
	 * permette di inserire nel sistema vaccinale 
	 * le informazioni di un nuovo cittadino
	 * CF, nome, cognome, indirizzo, telefono
	 */
	public void registraCittadino(String CF,String nome,String cognome,String indirizzo,String telefono) {
		//crea un oggetto
		Cittadino c = new Cittadino(CF,nome,cognome,indirizzo,telefono);
		cittadiniRegistrati[numCittadini++]=c;
	}
	
	/*
	 * inserisce il numero di cittadini registrati
	 * @return numero cittadini
	 */
	public int numeroRegistrati() {
		return numCittadini;
	}
	
	/*
	 * aggiunge un nuovo centro vaccinale al sistema
	 * @param nome 
	 * @oaram indirizzo
	 */
	public void inserisciCentro(String nome,String indirizzo) {
		CentroVaccinale c = new CentroVaccinale(nome,indirizzo);
		centri[numCentri++]=c;
	}
	
	/*
	 * per ogni cittadino non ancora assegnato
	 * cerca il centro più vicino e assegna il cittadino a quel centro
	 */
	public void assegnaCitaddini() {
		for(Cittadino c: cittadiniRegistrati) {
			if( c!=null && !c.isAssegnato()) {//se il cittadino non è asseganto
				//effettuo ciclo su tutti i centri Vaccinali
				double distanzaMinima = Double.MAX_VALUE;
				CentroVaccinale piuVicino=null;
				for(CentroVaccinale centro:centri) {
					if(centro!=null) {
						double d = calcolaDistanza(c.getIndirizzo(),centro.getIndirizzo());
						if(d<distanzaMinima) {
							distanzaMinima = d;
							piuVicino=centro;
						}
					}
				}
				c.assegna(piuVicino);
			}
		}
	}
	/*
	 * utilizza servizio online di geocolizzazione per calcolare la distanza tra due indirizzi
	 * per il momento usa un numero casuale
	 */
	private double calcolaDistanza(String indirizzo,String indirizzo2) {
		return Math.random()*100;
	}
	
	public String centroDelCittadino(String cf) {
		for(Cittadino c: cittadiniRegistrati) {
			if(c!=null && c.getCf().equals(cf)) {//equals è definito per le stringhe
				return c.getNomeCentro();
			}
		}
		return "Cittadino non trovato";
	}
}
