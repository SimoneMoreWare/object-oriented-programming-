import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeSet;

public class Lesson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Dichiara un variabile in cui posso memorizzare una 
		//referenza a una qualsiasi classe che implementa collection
		//o un'interfaccia derivata e poi crea una linked list
		
		Collection<Person> persons = new LinkedList<Person> ();
		System.out.println ("Dimensione: " + persons.size());
		persons.add(new Person("Bob"));
		System.out.println ("Dimensione: " + persons.size());
		Person a = new Person ("Alice");
		persons.add(a);
		//Visto che tutte le collection sono iterabili posso accedere
		//agli elementi in ordine usando il for
		
		System.out.println("Linked list");
		System.out.println ("Dimensione: " + persons.size());
		for (Person p: persons) {
			System.out.println(p);
		}
		
		//Esempio di construttore con un'altra lista
		Collection<Person> persons1 = new LinkedList<Person> (persons);
		System.out.println("Copia Linked list in un'altra ll");
		for (Person p: persons1) {
			System.out.println(p);
		}
		
		System.out.println("Trasformazione ll in array");
		Person[] arrayp = persons.toArray(new Person[persons.size()]);
		for (Person p: arrayp) {
			System.out.println(p);
		}
		
		System.out.println("Copia Linked list in un'altra ts");
		Collection<Person> persons2 = new TreeSet<Person>();
		persons2.addAll(persons1);
		for (Person p: persons2) {
			System.out.println(p);
		}
		
		LinkedList<Person> ll = (LinkedList<Person>) persons;
		Person p1 = ll.get(1);
		System.out.println(p1);
		
		if (persons.contains(new Person("Alice"))) {
			System.out.println("Alice esiste");
		}

		persons.forEach( p -> {System.out.println(p);});
		persons.forEach(System.out::println);
		
		int count = 0;
		for (Iterator<?> itr = persons.iterator(); itr.hasNext(); ) {
			itr.next();
			if (count ==1) {
				System.out.println("Entrato");
				itr.remove();
			}
			count++;
		}
		persons.forEach( p -> {System.out.println(p);});

		Map<String,Person> people = new HashMap<>();
		people.put("p1",new Person("Alice"));
		people.put("p2", new Person ("Bob"));
		
		if ( !people.containsKey("p1")) {
			System.out.println("Chiave p1 non presente");
		} else {
			System.out.println (people.get("p1").getName());
		}
		
		
		
	}
	
	
	

}
