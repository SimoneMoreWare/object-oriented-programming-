
public class Counter {
	private int value;
	
	public Counter(int value) {
		this.value = value;
	}
	
	public void reset() {
		value=0;
	}
	
	public void increment() {
		value++;
	}
	
	public void print() {
		System.out.println("Il valore del counter è "+value);
	}
	
}
