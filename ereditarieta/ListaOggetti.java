package ereditarieta;

public class ListaOggetti {
	
	static class Nodo{
		Object valore;
		Nodo prossimo;
		Nodo(Object valore,Nodo prossimo){
			this.valore=valore;
			this.prossimo=prossimo;
		}
	}
	
	Nodo testa;
	int numeroElementi;

	public void aggiungi(Object valore) {
		testa = new Nodo(valore,testa);
		numeroElementi++;
	}
	
	public Object testa() {
		return testa.valore;
	}
	
	public Object estraiTesta() {
		Nodo t = testa;
		testa=t.prossimo;
		numeroElementi--;
		return t.valore;
	}
	
	public int conta() {
		return numeroElementi;
	}
}
