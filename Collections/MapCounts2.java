package collections;

import static java.lang.System.out;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.function.BiConsumer;

public class MapCounts2 {

	public static void main(String[] args) {
		char[] chars = data.Lyrics.ALL_ALONG_THE_WATCHTOWER.toCharArray();

		SortedMap<Character,Counter> scc = new TreeMap<>();
		for(char ch : chars) {
			if(Character.isAlphabetic(ch))
			scc.computeIfAbsent(Character.toUpperCase(ch), 
								k->new Counter()).i++;
		}
		out.println(scc.toString());

		Map<Character,Counter> cc = new HashMap<>();
		for(char ch : chars) {
			if(Character.isAlphabetic(ch))
			cc.computeIfAbsent(Character.toUpperCase(ch), 
					k->new Counter()).i++;
		}
		out.println(cc.toString());

		
		String[] words = data.Lyrics.ALL_ALONG_THE_WATCHTOWER.split("[ \n\",.]+");

		out.println(Arrays.toString(words));
		
		SortedMap<String,Counter> swc = new TreeMap<>();
		for(String w : words) {
			swc.computeIfAbsent(w,k->new Counter()).i++ ;
		}
		out.println(swc.toString());


		Map<String,Counter> wc = new HashMap<>();
		for(String w : words) {
			wc.computeIfAbsent(w,k->new Counter()).i++ ;
		}
		out.println(wc.toString());

	}
	
	static class Counter {
		int i=0;
		public String toString() { return Integer.toString(i); }
		public int hashCode() {return i;}
		public boolean equals(Object o) { return o instanceof Counter?((Counter)o).i==i:false; }
	}
	
	final static int N = 10000000;
	final static int REPEAT = 5;
	final static String[] words = data.Lyrics.ALL_ALONG_THE_WATCHTOWER.split("[ \n\",.]+");
	static <T> void performanceOf(String label,
								  Map<String,T> m, 
								  BiConsumer<String,Map<String,T>> process) {
		Random rnd = new Random(1971);
		for(int r=0; r<REPEAT; ++r) {
		long t0 = System.currentTimeMillis();
		long m0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		for(int i=0; i<N; ++i) {
			String w = words[rnd.nextInt(words.length)];
			process.accept(w,m);
		}
		long elapsed = System.currentTimeMillis() - t0;
		long used = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory() - m0;
		System.out.println(label+","+elapsed+","+used);
		}
	}

}
