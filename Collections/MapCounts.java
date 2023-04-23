package collections;

import static java.lang.System.out;

import java.util.Arrays;
import java.util.Map;
import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.function.BiConsumer;

public class MapCounts {

	public static void main(String[] args) {
		String[] words = data.Lyrics.ALL_ALONG_THE_WATCHTOWER.split("[ \n\",.]+");

		out.println(Arrays.toString(words));
		
		SortedMap<String,Integer> wc = new TreeMap<>();
		for(String w : words) {
			int i=1;
			if( wc.containsKey(w) ) {
				i = wc.get(w) + 1;
			}
			wc.put(w, i);
		}
		out.println(wc.toString().replaceAll(",", "\n,"));

		wc = new TreeMap<>();
		for(String w : words) {
			Integer i= wc.get(w);
			wc.put(w, i==null?1:i+1);
		}
		out.println(wc.toString().replaceAll(",", "\n,"));
		
		wc = new TreeMap<>();
		for(String w : words) {
			wc.compute(w, (k,v) -> v==null?1:v+1 );
		}
		out.println(wc.toString().replaceAll(",", "\n,"));

		SortedMap<String,int[]> wca = new TreeMap<>();
		for(String w : words) {
			wca.computeIfAbsent(w,k->new int[1])[0]++;
		}
		out.println(wc.toString().replaceAll(",", "\n,"));

		performanceOf("Integer",
					new TreeMap<String,Integer>(), 
					(w,mc) -> mc.compute(w, (k,v) -> v==null?1:v++ ) );

		performanceOf("int[]",
				new TreeMap<String,int[]>(), 
				(w,mc) -> mc.computeIfAbsent(w,k->new int[1])[0]++ );

		performanceOf("Counter",
				new TreeMap<String,Counter>(), 
				(w,mc) -> mc.computeIfAbsent(w,k->new Counter()).i++ );
	}
	
	static class Counter {
		int i=0;
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
