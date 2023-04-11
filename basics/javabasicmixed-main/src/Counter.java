
public class Counter {
	
	private int value;
	
	public Counter (int value) {
		this.value = value;
	}
	
	public Counter reset() {
		value=0;
		return this;
	}
	
	public Counter increment() {
		value = value+1;
		return this;
	}
	
	public Counter print() {
		System.out.println("The value of counter is "+value);
		return this;
	}
}
