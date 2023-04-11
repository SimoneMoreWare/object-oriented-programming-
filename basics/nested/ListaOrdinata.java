package nested;

public class ListaOrdinata extends Lista {

	@Override
	public void aggiungi(int v) { // Override!!!
		if(testa==null || testa.valore > v) {
			Elemento nuovo = new Elemento(v,testa);
			testa = nuovo;
			return;
		}
		Elemento current = testa;
		while(current!=null) {
			if(current.prossimo == null || current.prossimo.valore > v){
				Elemento nuovo = new Elemento(v,current.prossimo);
				current.prossimo = nuovo;
				break;
			}
			current = current.prossimo;
		}
		
	}
	
	public  void aggiungiMeno(int v) {
		super.aggiungi(-v);
	}

}
