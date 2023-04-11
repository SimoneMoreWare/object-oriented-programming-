package it.polito.PO2023.vaccinazione;

public class CentroVaccinale {

	private String nome;
	private String indirizzo;
	
	private Cittadino[] cittadiniAssociati=null; //inizialmente non associato ad alcun centro (null)
	
	public CentroVaccinale(String nome, String indirizzo) {
		this.nome=nome;
		this.indirizzo=indirizzo;
	}
	
	public String getIndirizzo() {
		return indirizzo;  
	}

	public String getNome() {
		return nome;
	}

}
