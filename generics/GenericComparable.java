package generics;

import java.util.Iterator;

public class GenericComparable {
	static
	public class Student 
	implements Comparable<Student> {
		int id;
		@Override
		public int compareTo(Student other){
			return this.id - other.id;
		}
		Student(int id){ this.id=id; }
		@Override
		public String toString() { return "Student (" + id + ")"; }
	}


	static 
	class Letters implements Iterable<Character> {
		private char[] chars;
		public Letters(String s){
			chars = s.toCharArray(); }
		public Iterator<Character> iterator() {
			return new Iterator<Character>(){
				private int i=0;
				public boolean hasNext(){
					return i < chars.length;
				}
				public Character next() {
					return chars[i++];
				}
			};
		}
	}

	public static void main(String[] args) {
		
		// Without generics
		inheritance.interfaces.patterrns.Common_BehaviorIter.
		Letters lo = new inheritance.interfaces.patterrns.Common_BehaviorIter.Letters("Sequence");
		for(Object e : lo){
		  char v = ((Character)e);
		  System.out.println(v);
		}
		
		// With generics		
		Letters l = new Letters("Sequence");
		for(char ch : l){
		    System.out.println(ch);
		}


	}

}
