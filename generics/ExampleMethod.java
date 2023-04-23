package generics;

import java.util.Comparator;

public class ExampleMethod {

	public static <T> 
	  boolean contains(T[] ary, T element){
			 for(T current : ary){
				 if(current.equals(element)) 
					 return true;
			 }
			 return false;
		}

	public static <T,E extends T> 
	  boolean containss(T[] ary, E element){
			 for(T current : ary){
				 if(current.equals(element)) 
					 return true;
			 }
			 return false;
		}

//	public static <T super Integer> // syntax error!
//	  boolean containse(T[] ary, Integer element){
//			 for(T current : ary){
//				 if(current.equals(element)) 
//					 return true;
//			 }
//			 return false;
//		}

//	public static <T> 
//	void sort(T v[]){
//	  for(int i=1; i<v.length; ++i)
//	    for(int j=1; j<v.length; ++j){
//	      if(v[j-1].compareTo(v[j])>0){  // <-- the method compareTo(T) is undefined for the type T
//	        T o=v[j];
//	        v[j]=v[j-1]; 
//	        v[j-1]=o;
//	  } }
//	}

	public static <T extends Comparable> 
	void sort(T v[]){
	  for(int i=1; i<v.length; ++i)
	    for(int j=1; j<v.length; ++j){
	      if(v[j-1].compareTo(v[j])>0){
	        T o=v[j];
	        v[j]=v[j-1]; 
	        v[j-1]=o;
	  } }
	}
	
	public static <T,C extends Comparator<T>> 
	 void sort(T v[], C cmp){
	    for(int i=1; i<v.length; ++i)
	      for(int j=1; j<v.length; ++j){
	        if(cmp.compare(v[j-1],v[j])>0){ 
	          T o=v[j];
	          v[j]=v[j-1]; 
				    v[j-1]=o;
	  } } }

	 public static <T> 
	 void sort2(T v[], Comparator<T> cmp){
	    for(int i=1; i<v.length; ++i)
	      for(int j=1; j<v.length; ++j){
	        if(cmp.compare(v[j-1],v[j])>0){ 
	          T o=v[j];
	          v[j]=v[j-1]; 
				    v[j-1]=o;
	  } } }

	
	public static void main(String[] args) {
		String[] words = { "The", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "dogs" };
		boolean found = contains(words,"fox");
		System.out.println(found);
		
		Number[] numbers= {1, 2, 3.0, 4}; // autoboxing to Integer and Double
		
		contains(numbers,new Integer(4)); // implicit upcast
		containss(numbers,new Integer(4)); // implicit upcast
	}

}
