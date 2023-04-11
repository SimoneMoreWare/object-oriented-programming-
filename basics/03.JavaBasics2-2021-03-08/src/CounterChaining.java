
public class CounterChaining {
	private int value;
	
	public CounterChaining(int value) {
		this.value = value;
	}
	
	public CounterChaining reset() {
		value=0;
		return this;
	}
	
	public CounterChaining increment() {
		value++;
		return this;
	}
	
	public CounterChaining print() {
		System.out.println("Il valore del counter chained è "+value);
		return this;
	}

}
