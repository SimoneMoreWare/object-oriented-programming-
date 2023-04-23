package generics;

public class Wildcards {
	
	static class Student implements Comparable<Student> {
		int id;
		@Override
		public int compareTo(Student other) {
			return this.id - other.id;
		}
	}
	
	static public class MasterStudent extends Student {
		String degree;
	}

	
	static <T extends Comparable<T>>
	void sortPairECT(Pair<T> p) {
			if(p.first().compareTo(p.second()) > 0){
				T tmp = p.first();
				p.set1st(p.second());
				p.set2nd(tmp);
			}
	}

	static <E,T extends Comparable<? super T>>
	void sortPairECUSTa(Pair<T> p) {
			if(p.first().compareTo(p.second()) > 0){
				T tmp = p.first();
				p.set1st(p.second());
				p.set2nd(tmp);
			}
	}
	
	static <T extends Comparable<? super T>>
	void sortPairECUST(Pair<T> p) {
			if(p.first().compareTo(p.second()) > 0){
				T tmp = p.first();
				p.set1st(p.second());
				p.set2nd(tmp);
			}
	}

	public static void main(String[] args) {
		
		Pair<Double> pn = new Pair<>(3.5, 4.3);
		
		sortPairECT(pn);
		
		sortPairECUST(pn);
		
		Pair<MasterStudent> msp = new Pair<>(new MasterStudent(),new MasterStudent());

//		sortPairECT(msp); // The method sortPairECT(Pair<T>) in the type Wildcards is not applicable for the arguments (Pair<Wildcards.MasterStudent>)
		
		sortPairECUST(msp);
		

	}

}
