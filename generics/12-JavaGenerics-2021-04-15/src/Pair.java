/*
 * Una classe che implementa una coppia di dati generici dello
 * stesso tipo.
 */
public class Pair {
	private Object a,b;
	
	public Pair (Object a, Object b) {
		this.a = a;
		this.b=b;
	}
	public Object first() {
		return a;
	}
	
	public Object second() {
		return b;
	}
}
