package base;

/**
 * Example: operation chaining idiom
 * Slide set: 02-JavaBase
 * Slide numbers: 46
 * @author mtk
 *
 */
public class ExCounterChain {

	public static void main(String[] args) {
		Counter cnt = new Counter();
		cnt.reset().print()
		   .increment(10).print()
		   .decrement(7).print();
	}

}
