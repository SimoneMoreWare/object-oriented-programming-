package generics;

import java.util.Arrays;
import java.util.Comparator;

import static java.util.Arrays.sort ;
import java.util.Random;
import java.util.function.Consumer;

import static java.util.Comparator.*;

public class SortingComparatorsThen {
	
	static class Student implements Comparable<Student> {
		int id;
		String first;
		String last;
		@Override
		public int compareTo(Student other) {
			return this.id - other.id;
		}
		public int getId() { return id; }
		public Student(int id, String first, String last) { 
			this.id=id; this.first=first; this.last=last;
		}
		public String getFirst() {
			return first;
		}
		public String getLast() {
			return last;
		}
	}
	
	final static int N = 1000000;
	public static void main(String[] args) throws InterruptedException {
		Student[] students = new Student[N];
		Student[] studentsw = new Student[N];
		Random rng = new Random(1971);
		Arrays.setAll(students, j -> 
			new Student(rng.nextInt(10000),rName(rng),rName(rng)));

		elapsed("Warm Up",students,studentsw,sv->
		Arrays.sort(sv,
				(a,b)-> {
					int l = a.last.compareTo(b.last);
					if(l!=0) return l;
					return a.first.compareTo(b.first);
				}));
		elapsed("Attribute access",students,studentsw,sv->
		Arrays.sort(sv,
				(a,b)-> {
					int l = a.last.compareTo(b.last);
					if(l!=0) return l;
					return a.first.compareTo(b.first);
				}));
	
		
		elapsed("Getter",students,studentsw,sv->
		Arrays.<Student>sort(sv, 
				(a,b)-> {
					int l = a.getLast().compareTo(b.getLast());
					if(l!=0) return l;
					return a.getFirst().compareTo(b.getFirst());
				}));

		Comparator<Student> lc =  (a,b) -> a.getLast().compareTo(b.getLast());
		Comparator<Student> fc =  (a,b) -> a.getFirst().compareTo(b.getFirst());
		elapsed("Getter+thenComparing",students,studentsw,sv->
		Arrays.<Student>sort(sv, lc.thenComparing(fc) ));
		
		
		elapsed("Comparing+thenComparing",students,studentsw,sv->
		sort(sv, 
			     comparing(Student::getLast).
			     thenComparing(Student::getFirst)));		
	}
	
	final static String letters="abcdefghijklmnopqrstuvxyz";
	static String rName(Random rng) {
		int l = rng.nextInt(10)+4;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<l; ++i) {
			char ch = letters.charAt(rng.nextInt(letters.length()));
			if(i==0) ch=Character.toUpperCase(ch);
			sb.append(ch);
		}
		return sb.toString();
	}

	final static long R=3;
	private static long elapsed(String name,Student[] students, Student[] studentsw, Consumer<Student[]> task) throws InterruptedException {
		long sum=0;
		System.gc();
		long mem0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		for(int i=0; i<R; ++i) {
			Arrays.setAll(studentsw, j -> students[j]);
			long t0 = System.currentTimeMillis();
			task.accept(studentsw);
			long elapsed = System.currentTimeMillis() - t0;	
			long mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
			long memDelta = mem1-mem0;
			System.out.printf("%25s : %12d : %8d\n",name,elapsed,memDelta);
			sum+=elapsed;
		}
		return sum/R;
	}
}
