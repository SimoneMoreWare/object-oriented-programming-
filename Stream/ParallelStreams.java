package streams;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ParallelStreams {

	public final static int N = 10_000_000;
	public static void main(String[] args) {
		
		Random rng = new Random(1971);
		int[] numbers = new int[N];
		Arrays.setAll(numbers, i->rng.nextInt() );
		
		for(int i=1; i<5; ++i) {
			long t0=System.currentTimeMillis();
			IntStream seqs = IntStream.of(numbers);
			int maxs = seqs.limit(N).reduce(0,(a,b)->a>b?a:b);
			long elapsed=System.currentTimeMillis()-t0;
			System.out.println("sequential reduce,"+elapsed);
	
			t0=System.currentTimeMillis();
			IntStream seqp = IntStream.of(numbers);
			int maxp = seqp.limit(N).parallel().reduce(0,Math::max);
//			int maxp = seqp.limit(N).parallel().reduce(0,(a,b)->a>b?a:b);
			elapsed=System.currentTimeMillis()-t0;
			System.out.println("parallel reduce,"+elapsed);
			
			t0=System.currentTimeMillis();
			IntStream seqm = IntStream.of(numbers);
			int maxm = seqm.limit(N).max().getAsInt();
			elapsed=System.currentTimeMillis()-t0;
			System.out.println("sequential max,"+elapsed);

			t0=System.currentTimeMillis();
			IntStream seqpm = IntStream.of(numbers);
			int maxpm = seqpm.limit(N).parallel().max().getAsInt();
			elapsed=System.currentTimeMillis()-t0;
			System.out.println("parallel max,"+elapsed);

		}
	}

}
