package collections;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import java.util.Random;
import java.util.TreeMap;
import java.util.function.Consumer;


import java.util.ArrayList;

public class MapVsList {
	
	static class NameValue {
		String name;
		int value;
		NameValue(String name, int value) {
			this.name = name;
			this.value = value;
		}
	}

	final static int N = 1000000;
	final static int M = 100000;
	public static void main(String[] args) throws InterruptedException {
		Random rng = new Random(1971);
		NameValue[] nvs= new NameValue[N];
		for(int i=0; i<N; ++i) {
			String k = rName(rng);
			nvs[i] = new NameValue(k,i);
		}
		
		
		int[] n = {0};
		for(int k=100000; k<=1000000; k+=100000) {
			n[0] = k;
			HashMap<String,NameValue> hm = new HashMap<>();
			TreeMap<String,NameValue> tm = new TreeMap<>();
			ArrayList<NameValue> al = new ArrayList<>();
			LinkedList<NameValue> ll = new LinkedList<>();
			for(int i=0; i<k; ++i) {
				hm.put(nvs[i].name, nvs[i]);
				tm.put(nvs[i].name, nvs[i]);
				al.add(nvs[i]);
				ll.add(nvs[i]);
			}

			elapsed("HashMap "+n[0],hm, m -> {
			  for(int i=0; i<M;++i) m.get(nvs[N/2-M/2+i].name);
			});

			elapsed("TreeMap "+n[0],tm, m -> {
				  for(int i=0; i<M;++i) m.get(nvs[N/2-M/2+i].name);
			});
			elapsed("List "+n[0],tm, m -> {
				  for(int i=0; i<M;++i) {
					  for(int j=0; j<ll.size(); ++j) {
						  if(ll.get(j).name.equals(nvs[N/2-M/2+i].name)) break;
					  }
				  }
			});

		}
	
	
	}

	final static long R=3;
	private static <K,V> long elapsed(String name,Map<K, V> map, Consumer<Map<K, V>> task) throws InterruptedException {
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
