package streams;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import java.util.stream.Collector.Characteristics;

import data.Lyrics;

public class CustomCollector {
	
	static class AddToList<T> implements Collector<T,List<T>,List<T>>{
		public Supplier<List<T>> supplier(){
				return ArrayList<T>::new; }
		public BiConsumer<List<T>,T> accumulator(){
			return List<T>::add; }
		public BinaryOperator<List<T>> combiner() {
		   return (a,b)->{a.addAll(b); return a;}; }
		public Function<List<T>,List<T>> finisher()   
		  { return Function.identity();  }
		@Override
		public Set<Characteristics> characteristics() {
			return new HashSet<>();
		}
		}

	
	static class Average implements Collector<Integer,Average.Acc,Integer>{
		static class Acc {int sum; int n; }
		@Override
		public Supplier<Acc> supplier(){ return Acc::new; }
		@Override
		public BiConsumer<Acc,Integer> accumulator(){
			 return (a,i) -> { a.sum+=i; a.n++; }; }
		@Override
		public BinaryOperator<Acc> combiner() {
		   return (a,b)->{a.sum+=b.sum; a.n+=b.n; return a;}; }
		@Override
		public Function<Acc,Integer> finisher()   
		  { return a -> a.sum/a.n;  }
		@Override
		public Set<Characteristics> characteristics() {
			return new HashSet<>();
		}
	}

	public static void main(String[] args) {
		List<String> words=
		Arrays.stream(Lyrics.ALL_ALONG_THE_WATCHTOWER.split("[ .,\"\n]+"))
		.collect(new AddToList<String>())
		;
		System.out.println(words);

		Collector<String, List<String>, List<String>> ctl = 
				Collector.of(ArrayList::new, 
						     List::add, 
						     (a,b)->{a.addAll(b);return a;});

		ctl = 
				Collector.of(ArrayList::new, 
						     List::add, 
						     mergeInFirst(List::addAll));


		words=
		Arrays.stream(Lyrics.ALL_ALONG_THE_WATCHTOWER.split("[ .,\"\n]+"))
		.collect(ctl)
		;
		System.out.println(words);


		words= Stream.of(Lyrics.ALL_ALONG_THE_WATCHTOWER.split("[ .,\"\n]+"))
		.collect(LinkedList::new,
				 List::add,
				 List::addAll)
		;
		System.out.println(words);

	
		String listOfWords = 
		Stream.of(Lyrics.ALL_ALONG_THE_WATCHTOWER.split("[ .,\"\n]+"))
				.map(String::toLowerCase)
				.distinct()
				.sorted(Comparator.comparing(String::length).reversed())
				.collect(Collector.of(
						ArrayList::new,
						List::add,
				 		(a,b) -> { a.addAll(b); return a; },
						List::toString));
		System.out.println(listOfWords);
		
		int res = 
		IntStream.range(1, 20).collect(
				() -> new int[1],
				(a,i) -> a[0]+=i,
				(a1,a2) -> a1[0]+=a2[0]
				)[0];
		System.out.println(res);

		class Counter { int n; }
		res = 
		IntStream.range(1, 20).collect(
				Counter::new,
				(a,i) -> a.n+=i,
				(a1,a2) -> a1.n+=a2.n
				).n;
		System.out.println(res);

		
		class Acc { 
			int sum;
			int count;
			void add(int i) {sum+=i;count++;}
			int mean() { return sum/count; }
			void combine(Acc o) { sum+=o.sum; count+=o.count; }
		};
		
		res = 
		IntStream.range(1, 20).collect(
				Acc::new,
				Acc::add,
				Acc::combine
				).mean();
		System.out.println(res);

		res = 
		IntStream.range(1, 20).mapToObj(Integer::new).collect(new Average());
		System.out.println(res);

		res = 
		IntStream.range(1, 20).mapToObj(Integer::new).
			collect(Collector.of( ()->new int[2], 
								  (a,i)->{ a[0]+=i; a[1]++; }, 
								  (a1,a2)-> {a1[0]+=a2[0]; a1[1]+=a1[1]; return a1;},
								  a -> a[0]/a[1])) ;
		System.out.println(res);

		System.out.println(
		IntStream.range(1, 20).mapToObj(Integer::new).
		collect(LinkedList::new, 
			    List::add, 
				List::addAll) 
		);

	}
	
	static <T> BinaryOperator<T> mergeInFirst(BiConsumer<T,T> consumer){
		return (a,b) -> { consumer.accept(a, b); return a; };
	}

}
