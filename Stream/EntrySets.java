package streams;

import java.util.stream.Stream;
import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;
import java.util.Comparator;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class EntrySets {

	public static void main(String[] args) {
		List<String> classifica = 
		Stream.of(data.Lyrics.WISH_YOU_WERE_HERE.split("[ \n\t,.!]+"))
		.collect(groupingBy( w -> Character.toUpperCase(w.charAt(0)),
							 TreeMap::new,
							 counting()))
		.entrySet().stream()
//		.sorted(comparing(Map.Entry::getValue).reversed())
		.sorted(comparing(Map.Entry<Character,Long>::getValue).reversed())
		.sorted(comparing(Map.Entry::getValue,reverseOrder()))
		.map( e -> e.getKey() + " : " + e.getValue())
		.collect(toList())
		;
		System.out.println(classifica);
	}

}
