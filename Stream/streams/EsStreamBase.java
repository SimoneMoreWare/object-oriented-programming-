package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class EsStreamBase {

	public static void main(String[] args) {
		// Source (1)
		/*Stream<String> stream = */
		//Stream.of("one","two","three").
		int[] fibonacci = {1,1};
//		Stream.generate( ()-> {
//		  int next = fibonacci[0]+fibonacci[1];
//		  String ris = "numero " + fibonacci[0];
//		  fibonacci[0] = fibonacci[1];
//		  fibonacci[1] = next;
//		  return ris;
//		} )
		
		
		//Stream.iterate( "*" , s -> s+"*")
		
//		Stream<String> e = Stream.empty();
//		
//		e
		
		List<String> lista = new ArrayList<>();
		lista.add("One"); lista.add("Two"); lista.add("Three");
		
		lista.stream()
		// Intermediate operations (*)
		.limit(8)
		.map( String::toUpperCase ) // Function<String,String>
		
		// Terminal operation (1)
		.forEach( System.out::println  ); // Consumer<String>
		
		
		// --------------
		
		Stream.of("one","two","three","one","two","three","drink")

		.forEach( System.out::println  ); // Consumer<String>
		// EQUIVALE A
		Arrays.asList("one","two","three","one","two","three","drink")
		.forEach( System.out::println  ); // Consumer<String>

		System.out.println("---");
		Stream.of("one","two","three","one","two","three","drink")
		.filter( s -> s.length()<4 )
		.forEach( System.out::println  ); // Consumer<String>
		
		System.out.println("---");
		Stream.of("one","two","three","one","two","three","drink")
		.sorted()  // Attenzione: unbounded
		.forEach( System.out::println  ); // Consumer<String>

		
		System.out.println("---");
		Stream.of("one","two","three","one","two","three","drink")
		.distinct() // Attenzione: unbounded
		.forEach( System.out::println  ); // Consumer<String>

		System.out.println("---");
		Stream.of("one","two","three","one","two","three","drink")
		.sorted( (a,b) -> a.length()-b.length() )
		   // EQUIVALE A:
		.sorted( Comparator.comparing( String::length ) )
		   // EQUIVALE A:
		.sorted( Comparator.comparingInt( String::length ) )
		.forEach( System.out::println  ); 

	}
}
