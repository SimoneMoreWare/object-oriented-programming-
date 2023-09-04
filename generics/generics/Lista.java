package generics;

import java.util.function.Consumer;

public class Lista<E> {
	
	 class Elemento {  // (static) nested class
		E valore;
		Elemento prossimo;
		Elemento(E v, Elemento p){
			valore = v;
			prossimo = p;
		}
		Elemento(E v){
			valore = v;
			prossimo = testa;  // possibile perchè classe Interna (Inner)
		}
	}
	
	protected Elemento testa = null;
	
	public void aggiungi(E v) {
		Elemento nuovo = new Elemento(v,testa);
		testa = nuovo;
	}
	
	public void stampa() {
		Elemento current = testa;
		while( current != null ) {
			System.out.println(current.valore);
			current = current.prossimo;
		}
	}
	
	public Iteratore iteratore() {
		return new Iteratore();
	}
	
	class  Iteratore { // inner class
		Elemento corrente;
		
		Iteratore(){
			corrente = null;
		}
		/**
		 * Restituisce il valore dell'elemento corrente della lista
		 * @return
		 */
		public E getValore() {
			return corrente.valore;
		}
		
		/**
		 * Fa avanzare l'iteratore sul prossimo elemento
		 */
		public void prossimo() {
			corrente = corrente==null?testa:corrente.prossimo;
		}
		
		/**
		 * Verifica se è possibile avanzare
		 * @return
		 */
		public boolean hasNext() {
			return (corrente==null&&testa!=null)||corrente.prossimo != null;
		}
	}

	public boolean vuota() {
		return testa==null;
	}

	public void forEach(Consumer<E> consumer) {
		Elemento current = testa;
		while( current != null ) {
			consumer.accept(current.valore);
			current = current.prossimo;
		}

	}
}
