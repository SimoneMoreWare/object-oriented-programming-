import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Lesson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Student s1 = new Student("Ram",10);
		Student s2 = new Student("Shyam",22);
		Student s3 = new Student("Mohan",19);
		Student s4 = new Student("Mahesh",20);
		Student s5 = new Student("Krishna",21);
		
		List<Student> list = Arrays.asList(s1, s2, s3, s4, s5);
		
		
		int longestname = list.stream().
		map(Student::getName).
		map(String::length).
		//filter (p -> p>50).
		//reduce(0,Math::max);
		parallel()
		.reduce (0, (a,b) -> {
			if (a>b) {
				return a;
			} else {
				return b;
			}
		});
		System.out.println("La lunghezza massima del nome  è "+longestname);
	
		//Calcoliamo il minimo numero di uno stream di
		//Interi
		
		int m = IntStream
				.iterate(0, p -> p+1)
				.limit(20)
				.reduce(Integer.MAX_VALUE, Math::min);
		System.out.println("Min: "+ m);
	
		//Calcoliamo il minimo numero pari di uno stream
		//di inter
		
		m = IntStream
			.iterate(0, p -> p+1)
			.limit(20)
			.reduce(Integer.MAX_VALUE, (a,b) -> {
				if (b % 2 == 0) {
					//Pari confronto b con min precedente
					return (Math.min(a, b));
				} else {
					//Dispari ritorno min precedente
					return a;
				}
				
			});
		System.out.println("Min pari: "+m);
		
		//Collezionato le lunghezze dei nomi
		//in una lista
		List<Integer> n = list.stream()
		.map(Student::getName).
		map(String::length).
		collect(LinkedList::new, //supplier
				List::add, //accumulator
				List::addAll //combiner
				);
		
		n.stream().forEach(System.out::println);
		
		//Calcolare la lunghezza media dei nomi
		//usando un collector
		System.out.println ("Avg name:"+list.stream()
		.map(Student::getName).
		collect(Collectors.averagingInt(String::length)));
		
		double m1 = list.stream().
				map(Student::getName).
				map(String::length).
				collect(Collectors.averagingInt(x -> x));
		System.out.println ("Avg names: " + m1);
		
		Collector<String,AverageAcc,Double> avgCollector = 
		Collector.of(
				AverageAcc::new,   //supplier 
				AverageAcc::addName,   //accumulator
				AverageAcc::merge,   //combiner
				AverageAcc::average);  //finisher
		
		Double m2 = list.stream().
		map(Student::getName).
		collect(avgCollector);
		System.out.println ("Avg names: " + m2);
		
		AddToList<String> c = new AddToList<String>();
		
		List<String> ls = list.stream().
		map(Student::getName).
		collect(c);
		
		ls.stream().forEach(System.out::println);
		
	}

}
