
public class Lesson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Vettori
		
		Person[] p = {new Person("Stefano"), new Person("Marco")};
		
		int[] a = {2,5,6,7,8};
		
		//System.exit(0);
		
		for (int i=0; i< a.length; i++) {
			System.out.println(a[i]);
		}
		
		String[] s = {new String("es1"), "es2", "es3"};
		
		for (Person p1: p) {
			p1.printname();
			//System.out.println(p1);
		}
		
		for (int n: a) {
			System.out.println(n);
		}
		
		
		
		//Attributi Statici
		//Tenere traccia del numero di oggetti 
		//di tipo car che creo
		
		//C-Style
		int countCars =0;
		
		System.out.println("Ho "+Car.countCars+" macchine");		

		
		Car c = new Car("Fiat 500");
		System.out.println("Ho "+Car.countCars+" macchine");		
		countCars++;
		
		Car c1 = new Car("Alfa Mito");
		System.out.println("Ho "+Car.countCars+" macchine");

		countCars++;
		
		System.out.println("Il numero di macchine è "+countCars);

		System.out.println(c1.countCars);
		
		System.out.println("Il numero 10 ha "+Integer.bitCount(10)+ " bit a 1");
		
		Stack st = new Stack();
		st.push(10);
		System.out.println (st.pop());
		
		
	
	}

}
