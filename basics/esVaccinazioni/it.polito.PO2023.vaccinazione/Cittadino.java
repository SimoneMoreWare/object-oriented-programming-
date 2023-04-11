package it.polito.PO2023.vaccinazione;

public class Cittadino {
		private String nome;
		private String CF;
		private String cognome;
		private String indirizzo;
		private String telefono;
		
		private CentroVaccinale centroAssociato=null; //associazione tra cittazione e centro di vaccinazione
		//associazione tradotta tramite riferimenti
		
		//costruttore;
		public Cittadino(String CF,String nome,String congome,String indirizzo,String telefono) {
			this.CF = CF;
			this.nome=nome;
			this.cognome=cognome;
			this.indirizzo=indirizzo;
			this.telefono=telefono;
		}
		
		public boolean isAssegnato() {
			return centroAssociato!=null;
		}
		
		public String getIndirizzo() {
			return indirizzo;
		}
		
		public void assegna(CentroVaccinale piuVicino) {
			centroAssociato = piuVicino;
		}
		
		public String getCf() {
			return CF;
		}
		
		public String getNomeCentro() {
				if(centroAssociato!=null) {
					return centroAssociato.getNome();
				}else{
					return "Cittadino non trovato";
				}
		}
		
}
