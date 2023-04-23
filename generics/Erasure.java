package generics;

import generics.Wildcards.Student;

public class Erasure {
	static class Student implements Comparable<Student> {
		int id;
		@Override
		public int compareTo(Student other) {
			return this.id - other.id;
		}
	}
	
	// The interface Comparable cannot be implemented more than once with different arguments: 
	// Comparable<Erasure.Student> and Comparable<Erasure.MasterStudent>
//	static public class MasterStudent extends Student 
//			implements Comparable<MasterStudent>{
//		String degree;
//	}


	public static void main(String[] args) {
		Pair<Integer> pi = new Pair<>(1,2);
		Pair<String> ps = new Pair<>("one","two");
		
		boolean is = pi instanceof Pair;
		boolean si = ps instanceof Pair;

		System.out.println(is + ":" + si);
	}

}
