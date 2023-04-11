import java.nio.charset.Charset;

public class Lesson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Metodi con numero variabile di parametri
		 * Tipi enumerativi
		 * Gestione Memoria in Java
		 * Caratteri e Stringhe 
		 * Input da tastiera
		 * 
		 */
		
		
		//METODI CON NUMERO VARIABILE DI PARAMETRI
		Student s1 = new Student (223456, 30);
		Student s2 = new Student (354764, 23);
		Student s3 = new Student (462389, 29);
		
		float avg = StudentStatistics.oopaverage(s1,s2,s3);
		
		System.out.println ("La media dei voti di oop è:"+avg);
		
		Student[] vs = new Student[3];
		vs[0] = s1;
		vs[1] = s2;
		vs[2] = s3;
		
		avg = StudentStatistics.oopaverage(vs);
		
		System.out.println ("La media dei voti di oop è:"+avg);
		
		// TIPI ENUMERATIVI
		s1.computeStatus();
		s1.printStudent();
		
		//USO DEL GC
		s1 = null;
		vs[0] = null; 
		System.gc();
		
		s1 = new Student (55578,30);
		vs[0] = s1;
		
		for (int i = 0; i<100; i++) {
			System.out.println (i + " Aspetto un po' speriamo il gc parta");
		}
	}

}
