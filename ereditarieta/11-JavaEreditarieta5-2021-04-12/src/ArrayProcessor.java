
public class ArrayProcessor {

	public static void process (Object[] v, Processor p) {
		for (Object o: v) {
			p.handle(o);
		}
	}
}
