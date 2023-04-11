import java.util.Arrays;

public class Lesson {

	
	public static void main(String[] args) {
/*
		//Oggetto che si vuole osservare che deriva dalla classe
		//Observable
		News observedNews = new News();
		
		//Due oggetti che sono in grado di osservare 
		//Implementano observer
		FirstNewsReader reader1 = new FirstNewsReader();
		SecondNewsReader reader2 = new SecondNewsReader();
		
		//Meccanismo che collega gli osservatori con l'oggetto osservato
		observedNews.addObserver(reader1);
		observedNews.addObserver(reader2);
		
		observedNews.GenerateNews();
*/
		
		Student[] s = new Student[4];
		s[0] = new Student (0,"Stefano", "Di Carlo");
		s[1] = new Student (1, "Marco" , "Torchiano");
		s[2] = new Student (2, "Giorgio", "Bruno");
		s[3] = new Student (3, "Giovanni", "Squillero");
		
		//Implementazione con una classe esplicita
		System.out.println ("Implementazione con classe esplicita");
		ArrayProcessor.process(s, new StudentProcessor());
		
		//Implementazione con una classe unnamed annidata
		System.out.println ("Implementazione con classe anonima annidata");
		ArrayProcessor.process (s, new Processor() {
			@Override
			public void handle(Object o) {
				Student s = (Student) o;
				System.out.println(s);
			}
		});
		
		//Implementazione con lambda function
		System.out.println("Implementazione con lambda function");
		ArrayProcessor.process(s, x -> {
			Student ss = (Student) x;
			System.out.println (ss);
		}); 
		
		//Implementazione usando il method references
		System.out.println("Implementazione con method reference");
		Processor p = System.out::println;
		ArrayProcessor.process(s, p);
		
		ArrayProcessor.process(s, System.out::println);
		
		
		System.out.println("Ordinamento vettore con lambda function");

		Arrays.sort (s, (s1,s2) -> {
			return ((Student) s1).getLastName().compareTo(((Student) s2).getLastName()); 
		}     );
		
		
		for (Student ps: s) {
			System.out.println (ps);
		}
		
		Arrays.sort (s, 
				(s1,s2) ->  ((Student) s1).getLastName().compareTo(((Student) s2).getLastName()) 
				);
		for (Student ps: s) {
			System.out.println (ps);
		}
		
		Arrays.sort (s, (s1,s2) -> ((Student) s2).getId() - ((Student) s1).getId());
		for (Student ps: s) {
			System.out.println (ps);
		}
	}
	
	
}
