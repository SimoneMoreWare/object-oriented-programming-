
public class Stack {
	//Vettore in cui salvo i numeri interi contenuti nello stack
	private int[] stack;
	//Indice della prima locazione libera dello stack
	private int next;
	
	public Stack(int size) {
		stack = new int[size];
		next = 0;
	}
	
	public void push (int i) throws FullStack {
		if (next == stack.length) {
			FullStack e = new FullStack();
			throw e;			
		}
		stack[next++]=i;
	}
	
	public int pop() throws EmptyStack{
		if (next == 0) {
			//Se lo stack è vuoto genero la corrispondente eccezione
			//Crea un oggetto associato al tipo di eccezione che si è 
			//verificato
			EmptyStack e = new EmptyStack();
			//scatena l'eccezione
			throw e;
		}
		return stack[--next];
	}
	
	public boolean isEmpty() {
		return next==0;
	}
	
}
