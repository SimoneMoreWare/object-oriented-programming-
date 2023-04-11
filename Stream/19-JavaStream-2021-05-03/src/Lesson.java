import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Lesson {
	
	public static void main(String[] args) {
	/*	
		//Creazione di uno stream a partire da un vettore
		//String[] s = {"Primo", "Secondo", "Terzo", "Quarto"};
		//Arrays.stream(s).forEach(System.out::println);
	
		//Creazione di uno stream a partire da un'enumerazione
		//di elementi
		
		//Stream.of("Biacno","Rosso", "Grigio","Verde")
		//.forEach(System.out::println);
		
		String[] parole = Lyrics.WISH_YOU_WERE_HERE.split("[ ',.\n]+");
		List<String> words = Arrays.asList(parole);
		
		words.stream()						//Sorgente: genero lo stream
		.filter(p -> p.length()>2) 			//Operazione intermedia
		//.sorted()							//Op. in. ordino se comparable
		//.sorted((x,y) -> -x.compareTo(y))	//Ordinamento inverso						//Op. in. ordino se comparable
		.sorted((x,y) -> x.length()-y.length())
		.limit(10)							//Limita il numero di element
		.skip(2)
		.distinct()
		//.map(p -> p.toUpperCase())
		.map(String::toUpperCase)
		//.map(String::length)
		.map(p -> p.length())
		.forEach(System.out::println);		//Operazione finale
	*/
		//Generare i primi 10 nueri della sequenza di Fibonacci
	/*	Stream.generate(fibonacci()).
		limit (10)
		.forEach(System.out::println);		//Operazione finale
	*/
		//Generare un sequenza di numeri 10 casuali maggiori o uguali 
		//a 10 e <=100
		
	/*	Stream.generate(() -> (int) (Math.random() * 100)   )
		.filter(p -> p>=10 && p<=100)
		.limit(10)
		.forEach(System.out::println);*/
		
		//Stream.iterate(0, p -> p+2).limit(10).forEach(System.out::println);
		
		Stream.iterate(new long[] {1,1}, p -> new long[] {p[1],p[0]+p[1]})
		.limit(10).forEach(p->System.out.println(p[0]));
		
	}
	
	private static Supplier<Integer> fibonacci() {
		return new Supplier<Integer>() {
			int precedente=1;
			int ultimo =0;
			public Integer get() {
				int n = precedente + ultimo;
				precedente = ultimo;
				ultimo = n;
				return n;
			}
		};
	}

}
