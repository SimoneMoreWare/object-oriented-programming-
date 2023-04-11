package statickwd;

public class Intero {
	public final static int MAX_POOL = 10;
	private final int value;
	
	/**
	 * Costruisce un nuovo oggetto Intero
	 * @param v
	 * @era-deprecated
	 */
	private Intero(int v) {
		this.value = v;
	}
	
	public int intValue() {
		return value;
	}

	/**
	 * Metodo molto intelligente di creazione di un
	 * oggetto intero che usa una serie di oggetti
	 * pre-memorizzati per evitare ....
	 * 
	 * @param v
	 * @return
	 */
	private static Intero[] pool;
	static { // static initialization block
		pool = new Intero[10];
		for(int i=0; i<10; ++i) {
			pool[i] = new Intero(i);
		}
	}
	//private static Intero[] pool = new Intero[10];
	//private static Intero[] pool = {new Intero(0), new Intero(1), new Intero(42),null,null,null,null,null,null,null};
	public static Intero valoreIntero(int v) {
		for(Intero p : pool) {
			if(p==null) break;
			if( p.value == v) {
				System.out.println("Trovato! Era nel pool " + v);
				return p;
			}
		}
		System.out.println("Accidenti mi tocca creare un nuovo Intero con " + v);
		Intero result = new Intero(v);
		for(int i=0; i<pool.length; ++i) {
			if(pool[i]==null) {
				pool[i] = result;
				break;
			}
		}
		return result;
	}
}
