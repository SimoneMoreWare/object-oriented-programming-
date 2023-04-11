package inheritance.observer;

public class Valore extends Cella {
	
	private double valore;
	
	public Valore(double v) {
		valore = v;
	}

	public void setValore(double v) {
		if(v!=valore) {
			System.out.println("Cambo il valore da " + valore + " a " + v +
					" e annuncio il cambiamento agli osservatori");
			valore = v;
			avvisaOsservatori("Cambiato valore", Double.valueOf(valore));
		}
	}
	
	public double getValore() {
		return valore;
	}

}
