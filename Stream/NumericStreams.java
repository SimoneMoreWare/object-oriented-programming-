package streams;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumericStreams {

	public final static int N = 100_000_000;
	public static void main(String[] args) {
		
		for(int i=1; i<5; ++i) {
			long t0=System.currentTimeMillis();
			IntStream seqp = IntStream.generate( 
					()-> (int)(Math.random()*100));
			int maxp = seqp.limit(N).max().getAsInt();
			long elapsed=System.currentTimeMillis()-t0;
			System.out.println("primitive,"+elapsed);
	
			t0=System.currentTimeMillis();
			Stream<Integer> seqw = Stream.generate(
					()-> (int)(Math.random()*100));
			int maxw = seqw.limit(N)
				.max(java.util.Comparator.naturalOrder()).get();
			elapsed=System.currentTimeMillis()-t0;
			System.out.println("wrapper,"+elapsed);
		}
	}

}
