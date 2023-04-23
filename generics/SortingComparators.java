package generics;

import java.util.Arrays;
import static java.util.Arrays.sort ;
import java.util.Random;
import java.util.function.Consumer;

import static java.util.Comparator.*;

public class SortingComparators {
	
	static class Student implements Comparable<Student> {
		int id;
		@Override
		public int compareTo(Student other) {
			return this.id - other.id;
		}
		public int getId() { return id; }
		public Student(int id) { this.id=id; }
	}

	static class MasterStudent extends Student {
		public MasterStudent(int id) { super(id); }
	}

	final static int N = 1000000;
	public static void main(String[] args) throws InterruptedException {
		Student[] students = new Student[N];

		elapsed("Warm up",students,sv->
		Arrays.sort(sv,
				(a,b)-> a.id- b.id));

		elapsed("Attribute access",students,sv->
		Arrays.sort(sv,
				(a,b)-> a.id - b.id));
		
		elapsed("Getter",students,sv->
		Arrays.<Student>sort(sv,
				(a,b)-> a.getId() - b.getId()));

		elapsed("Comparing.reversed",students,sv->
		sort(sv, 
			     comparing(Student::getId)));
		
		elapsed("ComparingInt.reversed",students,sv->
		Arrays.sort(sv, 
			     comparingInt(Student::getId)));


		
	}

	final static long R=3;
	private static long elapsed(String name,Student[] students, Consumer<Student[]> task) throws InterruptedException {
		long sum=0;
		System.gc();
		long mem0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		for(int i=0; i<R; ++i) {
			Random rng = new Random(1971);
			Arrays.setAll(students, j -> new MasterStudent(rng.nextInt(10000)));
			Thread.sleep(500);
			long t0 = System.currentTimeMillis();
			task.accept(students);
			long elapsed = System.currentTimeMillis() - t0;	
			long mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
			long memDelta = mem1-mem0;
			System.out.printf("%25s : %12d : %8d\n",name,elapsed,memDelta);
			sum+=elapsed;
		}
		return sum/R;
	}
}
