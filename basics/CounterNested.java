package base;

public class CounterNested {
	private int i;

	public static class Incrementer {
		private int step = 1;
		private CounterNested counter;
		

		public void doIncrement() {
			counter.i += step;
		}

		Incrementer(CounterNested counter, int step) {
			this.counter= counter;
			this.step = step;
		}
	}

	public Incrementer buildIncrementer(int step) {
		return new Incrementer(this,step);
	}

	public int getValue() {
		return i;
	}

	public static void main(String[] args) {
		CounterNested c = new CounterNested();
		Incrementer byOne = c.buildIncrementer(1);
		Incrementer byFour = c.buildIncrementer(4);
		byOne.doIncrement();
		byFour.doIncrement();
		c.getValue();
	}
}
