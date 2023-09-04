package streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collector.Characteristics;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import static java.util.stream.Collectors.*;

public class AdvancedTerminals {

	public static void main(String[] args) {
		
		String[] parole = data.Lyrics.RADIOACTIVE.split("[ \n.\",]+");

		String reduced = 
		Stream.of(parole).
			reduce("Testo: ",(a,b) -> a + " " + b)
			;
		System.out.println(reduced);
		
		int risultato = IntStream.of(1,2,3,4,5,6).reduce(0, (a,b) -> a+b);
		System.out.println(risultato);
		
		Optional<String> reducedOpt = 
		Stream.of(parole).
		reduce((a,b) -> a + " " + b)
		;
		System.out.println(reducedOpt);
		// equivale a
		
		Optional<String> resOpt = reduce(parole);
		
		System.out.println(resOpt.orElse(""));
		
		// Obiettivo: raccogliere in una lista le parole
		List<String> listaParole = 
		Stream.of(parole).
		collect( // ArrayList::new,  // supplier
				 () -> new ArrayList<String>(),
				 // List::add, // accumulator
				 (l, e) -> l.add(e), // accumulator
				 (a,b) -> {}
				);
		System.out.println(listaParole);
		
		// EQUIVALE A
		listaParole = collect(parole,ArrayList::new,List::add);
		
		// potrei scrivere più semplicemente
		List<String> lp = new ArrayList<>();
		Stream.of(parole).forEach( lp::add );
		
		// meglio, usando i collettori predefiniti nella classe Collectors
		listaParole = Stream.of(parole).
			collect( toList());
		
		// obiettivo avere un elenco delle parole utilizzate (senza duplicati)
		Stream.of(parole).
			distinct().collect(toList()); // dispendioso: set (in distinct) + list
		
		// più efficiente, raccogliere in un set
		Set<String> paroleUniche = 
		Stream.of(parole).collect( toSet() );
		System.out.println(paroleUniche);
		
		// per avere un set ordinato occorre specificar il contenitore
		SortedSet<String> paroleUnicheOrd = 
		Stream.of(parole).collect( toCollection( TreeSet::new ) );
		System.out.println(paroleUnicheOrd);
		
		// e volendo avere un ordinamento custom
		paroleUnicheOrd = 
				Stream.of(parole).
				collect( toCollection( () -> new TreeSet<String>( (a,b) -> a.compareToIgnoreCase(b) ) ) );
				System.out.println(paroleUnicheOrd);
		

		// definizione di un collettore che calcola 
		// lunghezza minima e massima delle parole
		Collector<String,int[],String> collectMinMax = new Collector<>(){
			@Override
			public Supplier<int[]> supplier() { 
				return () -> new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE };
			}
			@Override
			public BiConsumer<int[], String> accumulator() {
				return (valori, s) -> {
					int l = s.length();
					if( l<valori[0] ) valori[0] = l; // min
					if( l>valori[1] ) valori[1] = l; // max
				};
			}
			@Override
			public BinaryOperator<int[]> combiner() {
				return (a,b) -> {
					if(a[0] > b[0]) a[0]=b[0];  // min
					if(a[1] < b[1]) a[1]=b[1];  // max
					return a;
				};
			}
			@Override
			public Function<int[], String> finisher() {
				return valori -> valori[0] + ", " + valori[1];
			}
			@Override
			public Set<Characteristics> characteristics() {
				return Stream.of(Characteristics.CONCURRENT,
								 Characteristics.UNORDERED)
						.collect(toSet());
			}
		};
		
		String minMax = Stream.of(parole).collect(collectMinMax);
		System.out.println(minMax);
				
		// possibilità di utilizzare il factory method 
		// per costruire il collettore
		Stream.of(parole).collect(
				Collector.of(
						() -> new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE }, 
						(valori, s) -> {
							int l = s.length();
							if( l<valori[0] ) valori[0] = l; // min
							if( l>valori[1] ) valori[1] = l; // max
						}, 
						(a,b) -> {
							if(a[0] > b[0]) a[0]=b[0];  // min
							if(a[1] < b[1]) a[1]=b[1];  // max
							return a;
						},
						Characteristics.CONCURRENT,
						Characteristics.UNORDERED
				));
		
		
		Stream<String> words = Stream.of(parole);
		
//		List<String> inizMaiuscola = 
//		words.filter( p -> Character.isUpperCase(p.charAt(0)) )
//		.collect(toList());
//
//		List<String> inizMinuscola = 
//		words.filter( p -> ! Character.isUpperCase(p.charAt(0)) )
//		.collect(toList());  // NON è possibile usare >1 volta uno stream
//		
//		Map<Boolean,List<String>> mm = new HashMap<>();
//		mm.put(true, inizMaiuscola);
//		mm.put(false, inizMinuscola);

		// si utilizza il collettore 'partitioningBy'
		Map<Boolean,List<String>> mm =
		words.collect(partitioningBy( p -> Character.isUpperCase(p.charAt(0)) ));
		System.out.println(mm);

		
		// obiettivo: raggruppare per iniziale
		Map<Character,List<String>> perIniziale = 
		Stream.of(parole)
		.collect( groupingBy( p -> Character.toUpperCase(p.charAt(0)) ) );
		
		System.out.println(perIniziale);
	
		// EQUIVALE A (con downstream esplicito)
		perIniziale = Stream.of(parole)
				.collect( groupingBy( 
						p -> Character.toUpperCase(p.charAt(0)), // classifier
						toList()	// downstream
						) );


		
		
		/// COUNT
		long c1 = Stream.of(parole).count();
		Long c2 = Stream.of(parole).collect(counting());
		///
		
		
		// contare il numero di parole per iniziale
		Map<Character,Long> contaPerIniziale = 
		Stream.of(parole)
		.collect( groupingBy( 
				p -> Character.toUpperCase(p.charAt(0)),
				counting()
				) );
		System.out.println(contaPerIniziale);

		
		// contare il numero di parole per iniziale senza duplicati
		contaPerIniziale = 
		Stream.of(parole)
		.distinct()
		.collect( groupingBy( 
				p -> Character.toUpperCase(p.charAt(0)),
				counting()
				) );
		System.out.println(contaPerIniziale);

		
		// contare il numero di parole per iniziale senza duplicati
		contaPerIniziale = 
		Stream.of(parole)
		.collect( groupingBy( 
				p -> Character.toUpperCase(p.charAt(0)),
				collectingAndThen(
						toSet(),
						s -> (long)s.size()
						)
				) );
		System.out.println(contaPerIniziale);
		
		// classifica delle lettere iniziali più frequenti (dalla più frequente alla meno)
		Map<Long,List<Character>> perFrequenzaIniziale =
		contaPerIniziale.entrySet().stream()
		.collect( groupingBy( e -> e.getValue(), // classifier
				 			  ()-> new TreeMap<>(Comparator.reverseOrder()), // supplier
							  mapping( e->e.getKey(), toList())) // downstream
				);
		
		System.out.println(perFrequenzaIniziale);
		
		// Esercizio:
		// Mostrare le prime cinque posizioni della 
		// classifica delle parole più lunghe
		
	}

	
	// --------
	
	
	private static <E,R> R collect(E[] strings, 
					      Supplier<R> supplier, 
					      BiConsumer<R,E> accumulator){
		
		R container = supplier.get();
		
		for(E element : strings) {
			accumulator.accept(container,element);
		}
		
		return container;
	}
	
	private static Optional<String> reduce(String[] strings) {
		String res = null;
		BinaryOperator<String> reducer = (a,b) -> a + " " + b;
		for(String element : strings) {
			if(res != null) {
				reducer.apply(res, element);
			}else {
				res = element;
			}
		}
		Optional<String> resOpt = Optional.ofNullable(res);
		return resOpt;
	}

}
