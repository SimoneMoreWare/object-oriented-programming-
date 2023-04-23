package collections;

import java.util.Arrays;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import static java.util.stream.Collectors.*;

import static java.lang.System.*;

public class MapList {

	public static void main(String[] args) {
		String[] words = data.Lyrics.ALL_ALONG_THE_WATCHTOWER.split("[ \n\",.]+");

		out.println(Arrays.toString(words));
				
		Map<Integer,SortedSet<String>> m = new TreeMap<>();
		for(String w: words) {
			SortedSet<String> ws = m.get(w.length());
			if(ws==null) {
				ws = new TreeSet<>();
				m.put(w.length(), ws);
			}
			ws.add(w);
		}
		System.out.println(m);
		// EQUIVALENT TO
		m = new TreeMap<>();
		for(String w: words) {
			m.computeIfAbsent(w.length(),
							  l -> new TreeSet<>()).add(w);
		}
		System.out.println(m);
		// EQUIVALENT TO
		m = Arrays.stream(words).
			collect(groupingBy(String::length,
							   TreeMap::new,
							   toCollection(TreeSet::new) ) );
		System.out.println(m);	}

}
