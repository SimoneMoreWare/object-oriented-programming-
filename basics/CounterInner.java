package base;

public class CounterInner {
	private int i;

	public class Incrementer {
		private int step = 1;

		public void doIncrement() {
			i += step;
			CounterInner.this.i++;
		}

		Incrementer(int step) {
			this.step = step;
		}
	}

	public Incrementer buildIncrementer(int step) {
		return new Incrementer(step);
	}

	public int getValue() {
		return i;
	}

	public static void main(String[] args) {
		CounterInner c = new CounterInner();
		Incrementer byOne = c.buildIncrementer(1);
		Incrementer byFour = c.buildIncrementer(4);
		byOne.doIncrement();
		byFour.doIncrement();
		c.getValue();
	}
}
