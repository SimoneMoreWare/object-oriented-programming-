package class_object;

/**
 * contiene solo valori interi positivi
 * 
 * @author mtk
 *
 */
public class Intero {
	private int valore;  // = 0 (fatto da 'new' )
	
	public Intero(){} // fornito dal compilatore SE non ci sono altri costruttori
	
	public Intero(int valore){  // niente tipo di ritorno!!!!!!
		this.valore = valore;
	}
	
	public void stampa() { // c'è un parametro extra che si chiama 'Intero this'
  //void stampa(Intero this) {
		System.out.println(this.valore);
	}

	public void stampa(int valore) {
		System.out.println(this.valore + " - " + valore);
	}
	
	void setValore(int newValore) {
		if(newValore<0) {
			System.out.println("Che cavolo stai facendo??!?");
		}else {
			valore = newValore;
		}
	}
	
}
