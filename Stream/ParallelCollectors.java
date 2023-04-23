package streams;

import java.util.stream.Collector;
import java.util.stream.IntStream;

public class ParallelCollectors {

	static class Acc {
		static int combining=0;
		static synchronized int cc() {return ++combining;}
		int sum;
		int count;
		synchronized void add(int i) { sum+=i;count++; }
		int mean() { return sum/count; }
		synchronized Acc combine(Acc o) {
			System.out.println("combining " + cc());
			sum+=o.sum; count+=o.count; return this; }
	};

	public static void main(String[] args) {
		
		System.out.println("Serial");
		IntStream.range(1, 2000).collect(
				Acc::new,
				Acc::add,
				Acc::combine
				).mean();

		Acc.combining=0;
		System.out.println("Parallel int");
		IntStream.range(1, 2000)
		.parallel().collect(
				Acc::new,
				Acc::add,
				Acc::combine
				).mean();
		
		Acc.combining=0;
		System.out.println("Parallel Integer");
		IntStream.range(1, 2000).mapToObj(Integer::new)
		.parallel()
		.collect(
			Collector.of(
				Acc::new,
				Acc::add,
				Acc::combine,
				Acc::mean
				));

		Acc.combining=0;
		System.out.println("Parallel Integer CONCURRENT");
		IntStream.range(1, 2000).mapToObj(Integer::new)
		.parallel()
		.collect(
			Collector.of(
				Acc::new,
				Acc::add,
				Acc::combine,
				Acc::mean,
				Collector.Characteristics.CONCURRENT
				));
		
		Acc.combining=0;
		System.out.println("Parallel Integer CONCURRENT UNORDERED");
		IntStream.range(1, 2000).mapToObj(Integer::new)
		.parallel()
		.collect(
			Collector.of(
				Acc::new,
				Acc::add,
				Acc::combine,
				Acc::mean,
				Collector.Characteristics.CONCURRENT,
				Collector.Characteristics.UNORDERED
				));


		Acc.combining=0;
		System.out.println("Serial Integer CONCURRENT");
		IntStream.range(1, 2000).mapToObj(Integer::new)
		.collect(
			Collector.of(
				Acc::new,
				Acc::add,
				Acc::combine,
				Acc::mean,
				Collector.Characteristics.CONCURRENT
				));

	}

}
