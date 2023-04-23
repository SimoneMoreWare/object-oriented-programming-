package inheritance.interfaces.patterrns;

import java.util.Arrays;
@SuppressWarnings("rawtypes")

public class CommonBehavior {

	static
	public class Student 
	implements Comparable {
		int id;
		@Override
		public int compareTo(Object o){
			Student other = (Student)o;
			return this.id - other.id;
		}
		Student(int id){ this.id=id; }
		public String toString() { return "Student (" + id + ")"; }
	}

	static Student s(int i) { return new Student(i); }  
	
	public static void main(String[] args) {
		
		Student[] students = {s(7),s(2),s(6),s(1),s(8),s(5)};
		
		System.out.println("Before: " + Arrays.toString(students));

		Arrays.sort(students);
		
		System.out.println("After : " + Arrays.toString(students));
		
		// See also Pattern Strategy (w/Comparator)
		
		Arrays.sort(students,(a,b)->{ // explicit strategy
			return ((Student)a).id - ((Student)b).id;
		});
		Arrays.sort(students,(a,b)->{
			return ((Student)b).id - ((Student)a).id;
		});
		System.out.println("After : " + Arrays.toString(students));


	}
}
