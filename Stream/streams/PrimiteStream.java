package streams;

import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.IntStream;

public class PrimiteStream {

	public static void main(String[] args) {
		int[] fibonacci = {1,1};
		IntStream.generate( ()-> {
		  int next = fibonacci[0]+fibonacci[1];
		  int ris = fibonacci[0];
		  fibonacci[0] = fibonacci[1];
		  fibonacci[1] = next;
		  return ris;
		} )
		.limit(10)
		.forEach( i->System.out.println(i));

		IntStream.range(0, 10)
		.map( i->i*i)
		.forEach( i->System.out.println(i));
		
		Random rnd = new Random();
		
		OptionalInt max = 
		IntStream.generate( () -> rnd.nextInt(0, 100))
		.limit(1000)
		.max();
		
		if( max.isPresent() ) {
			int realMax = max.getAsInt();
			System.out.println(realMax);
		}
		// OPPURE
		max.ifPresent( System.out::println );
		
		int anyMax = max.orElse( -1 );
	}

}
