import java.util.Arrays;
import java.util.Comparator;

public class Lesson {
	

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Complex c1 = new ComplexRect(4,3);
		System.out.println (c1.real()+ " " + 
		c1.im() + " " + c1.mod() + " " + c1.arg());
		
		Complex c2 = new ComplexPolar(5,0.6435);
		System.out.println (c2.real()+ " " + 
				c2.im() + " " + c2.mod() + " " + c2.arg());
		
		Complex[] cv = {c1 , c2};
		System.out.println(cv[0].im());
		System.out.println(cv[1].im());
		
		
		Complex cc1 = Complex.fromRect(4, 3);
		System.out.println (cc1.real()+ " " + 
				cc1.im() + " " + cc1.mod() + " " + cc1.arg());
		
		Complex cc2 = Complex.fromPolar(5, 0.6435);
		System.out.println (cc2.real()+ " " + 
				cc2.im() + " " + cc2.mod() + " " + cc2.arg());
		
		if (cc1.isReal()) {
			System.out.println("Il numero è reale");
		} else {
			System.out.println("Il numero è complesso");

		}
		
		Student[] as = { new Student(3), new Student(2), new Student(1)};
		
		Arrays.sort(as);
		for (Student s: as) {
			System.out.println(s);
		}
		
		Letters l = new Letters ("Frase di prova");
		for (Object c: l) {
			Character cc = (Character) c;
			System.out.println(cc);
		}
		
		Arrays.sort(as , new StudentComparatorIdCresc() );
		for (Student s: as) {
			System.out.println(s);
		}
		
		Arrays.sort(as , new StudentComparatorIdDesc() );
		for (Student s: as) {
			System.out.println(s);
		}
		
		Student[] as1 = {new Student(1,"Stefano"), 
				new Student(2,"Marco"),
				new Student(3,"Giorgio")};
		
		Arrays.sort(as1, new Comparator() {
			public int compare (Object a, Object b) {
				Student sa = (Student) a;
				Student sb = (Student) b;
				return sa.getName().compareTo(sb.getName());
			}
		});
		for (Student s: as1) {
			System.out.println("Student"+s);
		}
	}
	

	
}
