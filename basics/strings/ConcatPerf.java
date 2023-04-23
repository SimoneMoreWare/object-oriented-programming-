package strings;

public class ConcatPerf {
	final static long N = 100_000;
	static long begin, end;
	static long memStart,memFinal;

	static void start() {
		begin = System.nanoTime();
		memStart = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
//		System.out.println(Runtime.getRuntime().freeMemory() + " - " + Runtime.getRuntime().maxMemory()  + " - " + Runtime.getRuntime().totalMemory());
	}

	static void stop() {
		end = System.nanoTime();
		memFinal = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		System.gc();
//		System.out.println(Runtime.getRuntime().freeMemory() + " - " + Runtime.getRuntime().maxMemory()  + " - " + Runtime.getRuntime().totalMemory());
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
		return String.format("%4d:%2d.%3d %3d",m,s,ms,us);
	}
	
	static String used() {
		return String.format("%,d",memFinal-memStart);
	}

	public static void main(String[] args) {

		start();
		plus();
		stop();
		System.out.println("Elapsed " + elapsed());
		System.out.println("Used memory " + used());

		start();
		buffer();
		stop();
		System.out.println("Elapsed " + elapsed());
		System.out.println("Used memory " + used());
		
		start();
		builder();
		stop();
		System.out.println("Elapsed " + elapsed());
		System.out.println("Used memory " + used());

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
