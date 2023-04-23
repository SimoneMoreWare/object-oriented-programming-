package streams;

import java.util.function.Function;
import java.util.stream.Stream;
import static java.util.stream.Collectors.*;

public class MapFlatMap {

	public static void main(String[] args) {
		
		Stream.of(data.Lyrics.ALL_ALONG_THE_WATCHTOWER.split("[ ,\n.]+"))
		.map(String::toUpperCase)
		.distinct()
		.sorted()
		.forEach(System.out::println);

		Stream.of(data.Lyrics.ALL_ALONG_THE_WATCHTOWER.split("[ ,\n.]+"))
		.map(String::toUpperCase)
		.flatMap( w -> w.chars().mapToObj( c -> (char)c) )
		.distinct()
		.sorted()
		.forEach(System.out::println);
		;

		
//		System.out.println(
//		Stream.of(data.Lyrics.ALL_ALONG_THE_WATCHTOWER.split("[ ,\n.]+"))
//		.map(String::toUpperCase)
//		.collect(groupingBy(Function.identity(),counting()))
//		);
//
//		System.out.println(
//		Stream.of(data.Lyrics.ALL_ALONG_THE_WATCHTOWER.split("[ ,\n.]+"))
//		.flatMap( w -> w.chars().mapToObj( c -> (char)c) )
//		.collect(groupingBy(Function.identity(),counting()))
//		);
}

}
