import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

public class Lesson {
	
	public static void main(String[] args) {
		/*Student[] students = new Student[4];
		students[0] = new Student ("Stefano", "Di Carlo",1);
		students[1] = new Student ("Marco", "Torchiano",2);
		students[2] = new Student ("Giorgio", "Bruno",3);
		students[3] = new Student ("Giovanni", "Squillero",4);
		students[0].enroll("Analisi 1");
		students[0].enroll("Analisi 2");
		students[0].enroll("Fisica 1");
		students[1].enroll("Informatica");
		students[1].enroll("Analisi 2");
		students[1].enroll("OOP");
		students[2].enroll("Informatica");
		students[2].enroll("Fisica 1");
		students[3].enroll("Informatica");
		students[3].enroll("Fisica 1");
		students[3].enroll("OOP");
		
		//Stampare la lista univoca dei corsi a cui sono
		//Iscritti gli studenti. La lista deve essere
		//Ordinata in ordine alfabertico.
		
		Arrays.stream(students)    //Esce uno stream di studenti
		 //.map(p -> p.enrolledIn())
		.map(Student::enrolledIn) //Produco uno stream di arraylist di stringhe
		.flatMap(Collection::stream) //Produco uno stream di stringhe
		.distinct()
		.sorted()
		.forEach(System.out::println);
		
		//OPERAZIONI TERMINALI
		*/
		//Creo un vettore di parole a partire da un testo
		String[] parole = Lyrics
					.WISH_YOU_WERE_HERE.split("[ ,'.\n]+");
		
		//Esistono nel testo della canzone delle parole che
		//iniziano con la lettera z?
		/*
		boolean r = Arrays.stream(parole)
				.anyMatch(p -> p.startsWith("z"));
		if (r == true) {
			System.out.println ("Lo stream contiene almeno un parola che inizia con z");
		} else {
			System.out.println ("Lo stream non contiene parole che iniziano con la z");
		}
		
		//Stampare tutte le parole che iniziano con z
		Arrays.stream(parole)
		.filter(p -> p.startsWith("z"))
		.forEach(System.out::println);
		
		//Mi chiedo se tutte le parole della canzone 
		//sono lunghe almeno tre caratteri?
		r = Arrays.stream(parole)
		.allMatch(p -> p.length() >=3);
		if (r == true) {
			System.out.println ("Tutte le parole sono lunghe almeno tre caratteri");
		} else {
			System.out.println ("Ci sono parole più corte di tre caratteri");
		}
		
		//Mi chiedo se non ci sono parole della canzone 
		//che terminano con la i
		
		r = Arrays.stream(parole)
				.noneMatch(p -> p.endsWith("i"));
		if (r == true) {
			System.out.println("Nessuna parola termina con la i");
		} else {
			System.out.println ("Almeno una parola termina con la i");
		}
		
		//OPTIONAL
		
		//Controllare se lo stream contiene almeno una
		//Parola
		
		Optional<String> s = Arrays.
						stream(parole).findFirst();
		if (s.isPresent() == true) {
			System.out.println("Il testo contiene almeno una parola e la prima parola è"+s.get());
		}

		s = Arrays.
				stream(parole).findAny();
		if (s.isPresent() == true) {
			System.out.println("Il testo contiene almeno una parola e la prima parola è"+s.get());
		}
		
		//Cercare, se esiste, una parola lunga più 
		//di 50 caratteri
		
		s = Arrays.stream(parole)
			.filter(p -> p.length() > 50)
			.findFirst();
		if (s.isEmpty() == true) {
			System.out.println ("Non esistono parole più lunghe di 50 car.");	
		} else {
			System.out.println ("Esiste almeno una parola più lunga di 50 caratteri" + s.get());
		}
		*/
		//Cercare la prima parola più lunga di tre
		//caratteri e stampare i primi tre caratteri
	
		Arrays.stream(parole)   	//Genero lo stream
		.filter(p -> p.length()>3)  //Filtro
		.findFirst()				//Ottengo l'elemento
		.ifPresent(p -> {			//Da questo punto in poi lavoro su un optional
			System.out.println (p.substring(0,3));
		});
		
		//Questo genera eccezione se l'elemento non esiste
		System.out.println (Arrays.stream(parole)
				.filter(p->p.equals("think"))
				.findFirst()
				.get());
		
		//risolvo il problema dell'eccezione
		System.out.println (Arrays.stream(parole)
				.filter(p->p.equals("xxx"))
				.findFirst()
				.orElse("Vuoto"));
	
		//orElse con supplier
		System.out.println (Arrays.stream(parole)
				.filter(p->p.equals("xxx"))
				.findFirst()
				.orElseGet(() ->
				{
					String ss = "La parola non esiste";
					return ss;
				}));
		
		//Trovare la lunghezza della parola più corta della canzone
		
		System.out.println(Arrays.stream(parole).
		map(p -> p.length()).min((n1,n2) -> n1 - n2)
		.get());
		
		//Trovare la parola più lunga
		
		System.out.println(
		Arrays.stream(parole).
		max((n1,n2) -> n1.length()-n2.length()).get()
		);
		
		//Trovare la lunghezza media delle parole della
		//canzone
		
		System.out.println(
				Arrays.stream(parole).
				mapToInt(p -> p.length())
				.average().getAsDouble());

		
	}
	


}
