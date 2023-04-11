//Importo una singola classe del package
import it.polito.OOP.ITA3.Student;

//Importo tutte le classi presenti in un package
import it.polito.OOP.ITA3.*;



public class Lesson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println ("Hello World");
		
		Counter c = new Counter(5);
		
		c.print();
		c.increment();
		c.print();
		c.reset();
		c.print();
		
		CounterChaining c1 = new CounterChaining(4);
		
		/*
		 * Quello che avviene con il chaining è equivalente a
		 * salvare il valore di ritorno di ogni metodo in una
		 * variabile temporanea che può memorizzare una referenza
		 * a Counter Chaining
		 * 
		 * tmp1 = c1.print();
		 * tmp2 = tmp1.increment();
		 * tmp3 = tmp2.print();
		 */
		
		CounterChaining tmp;
		
		tmp = c1.print().increment().print().reset().print();
		
		
		Student s1 = new Student("Stefano");
		Student s2 = new Student();
		Student s3 = new Student ("Stefano", "Di Carlo");
		Student s4 = new Student ("Stefano", "Di Carlo", 3272);
		
		System.out.println (s1.getFirst());
		System.out.println (s1.getLast());
		
		int i = 10;
		
		Integer oi = new Integer(i);
		String s = oi.toString();
		System.out.println(s);
		
		int s5 = Integer.parseInt("2356787");
		System.out.println (s5);
		
		
		
		
	}

}
