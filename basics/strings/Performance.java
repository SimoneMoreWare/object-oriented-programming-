package strings;

public class Performance {
	final static int N = 100_000;

	public static void main(String[] args) {
		Timer t = new Timer();
		t.start();
		stringConcat();
		t.stop();
		System.out.println("Elapsed: " + t.elapsed());
		System.out.println("Used: " + t.usedMemory());

		t.start();
		stringBufferConcat();
		t.stop();
		System.out.println("Elapsed: " + t.elapsed());
		System.out.println("Used: " + t.usedMemory());

		t.start();
		stringBuilderConcat();
		t.stop();
		System.out.println("Elapsed: " + t.elapsed());
		System.out.println("Used: " + t.usedMemory());
}

	private static void stringConcat() {
		String s = "";
		for(int i=0; i<N; ++i) {
			s+=i;
		}
	}

	private static void stringBuilderConcat() {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; ++i) {
			sb.append(i);
		}
	}

	private static void stringBufferConcat() {
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<N; ++i) {
			sb.append(i);
		}
	}
}
