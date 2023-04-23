package strings;

public class ConcatPerfNano {
	final static long N = 100_000;
	static long begin, end;

	static void start() {
		begin = System.nanoTime();
	}

	static void stop() {
		end = System.nanoTime();
	}

	static String elapsed() {
		long elapsed = end - begin;
		long ns = elapsed % 1000;
		elapsed /= 1000;
		long us = elapsed % 1000;
		elapsed /= 1000;
		long ms = elapsed % 1000;
		elapsed /= 1000;
		long s = elapsed % 60000;
		elapsed /= 60000;
		long m = elapsed % 3600;
		return (m > 0 ? String.format("%3d",m) : "  0") + ":" 
			 + (s > 0 ? String.format("%2d",s) : " 0") + "." 
		     + (ms > 0 ? String.format("%3d",ms) : "  0") + "."
		     + (us > 0 ? String.format("%3d",us) : "  0")
		     ;
	}

	public static void main(String[] args) {

		start();
		plus();
		stop();
		System.out.println("Elapsed " + elapsed());

		start();
		buffer();
		stop();
		System.out.println("Elapsed " + elapsed());

		start();
		builder();
		stop();
		System.out.println("Elapsed " + elapsed());

	}

	static void plus() {
		String s = "";

		for (int i = 0; i < N; ++i) {
			s += i;
		}
	}

	static void buffer() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < N; ++i) {
			sb.append(i);
		}
	}

	static void builder() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; ++i) {
			sb.append(i);
		}
	}
}
