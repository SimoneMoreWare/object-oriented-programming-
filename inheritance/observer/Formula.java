package inheritance.observer;

public class Formula extends Cella {
	
	private Cella[] dipendenze = new Cella[2];
	private char operazione;
	private double valore;
	
	public Formula(char operazione, Cella opnS, Cella opnD) {
		this.operazione = operazione;
		dipendenze[0] = opnS;
		dipendenze[1] = opnD;
		
		ricalcola();
		
		opnS.registraOsservatore( (d,o) -> {
			ricalcola();
		});
		opnD.registraOsservatore( (d,o) -> {
			ricalcola();
		});
	}
	
	private void ricalcola() {
		switch(operazione) {
		case '+': valore = dipendenze[0].getValore() + dipendenze[1].getValore();
				  break;
		// ...
		}
	}
	
	public double getValore() {
		return valore;
	}

//	@Override
//	public void notificaEvento(String descrizione, Object dati) {
//		System.out.println("Ricevo la notifica del cambio di una dipendenza e quindi ricalcolo!");
//		ricalcola();
//	}

}
