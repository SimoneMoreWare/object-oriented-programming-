package collections;

import java.util.HashMap;
import java.util.Map;

import java.util.Random;
import java.util.TreeMap;
import java.util.function.Consumer;


public class Maps2 {

	final static int N = 1000000;
	public static void main(String[] args) throws InterruptedException {
		HashMap<String,Integer> hm = new HashMap<>();
		TreeMap<String,Integer> tm = new TreeMap<>();
		
		Random rng = new Random(1971);
		String[] keys= new String[N];
		
		for(int i=0; i<N; ++i) {
			String k = rName(rng);
			hm.put(k, i);
			tm.put(k, i);
			keys[i]=k;
		}

//		elapsed("Warm up...",hm, m -> {
//			  for(String k:keys) m.get(k);
//			});

//		elapsed("HashMap 1M",hm, m -> {
//		  for(String k:keys) m.get(k);
//		});
//
//		elapsed("TreeMap 1M",tm, m -> {
//			for(String k:keys)  m.get(k);
//		});
//
		int[] n = {0};
		for(int k=100000; k<=1000000; k+=100000) {
			n[0] = k;
			elapsed("HashMap "+n[0],hm, m -> {
			  for(int i=0; i<n[0];++i) m.get(keys[i]);
			});

			elapsed("TreeMap "+n[0],tm, m -> {
				  for(int i=0; i<n[0];++i) m.get(keys[i]);
			});
		}
	
	
	}

	final static long R=3;
	private static long elapsed(String name,Map<String, Integer> map, Consumer<Map<String, Integer>> task) throws InterruptedException {
		long sum=0;
		System.gc();
		for(int i=0; i<R; ++i) {
			long t0 = System.currentTimeMillis();	
			task.accept(map);
			long elapsed = System.currentTimeMillis() - t0;	
			System.out.printf("%25s : %12d\n",name,elapsed);
			sum+=elapsed;
		}
		return sum/R;
	}
	
	final static String letters="abcdefghijklmnopqrstuvxyz";
	static String rName(Random rng) {
		int l = rng.nextInt(10)+4;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<l; ++i) {
			char ch = letters.charAt(rng.nextInt(letters.length()));
			if(i==0) ch=Character.toUpperCase(ch);
			sb.append(ch);
		}
		return sb.toString();
	}

}
