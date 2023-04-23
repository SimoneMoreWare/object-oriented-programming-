package inheritance.interfaces.patterrns;

import java.util.Arrays;
import java.util.Iterator;
@SuppressWarnings("rawtypes")

public class Common_BehaviorIter {
	
	static
	public class LettersI implements Iterable {
		class LI implements Iterator {
			private int i=0;
			public boolean hasNext(){
				return i < chars.length;
			}
			public Object next() {
				return Character.valueOf(chars[i++]);
			}
		}
		private char[] chars;
		public LettersI(String s){
			chars = s.toCharArray(); }
		public Iterator iterator() {
			return new LI();
		} 
	}
	
	static
	public class Letters implements Iterable {
		private char[] chars;
		public Letters(String s){
			chars = s.toCharArray(); }
		public Iterator iterator() {
			return new Iterator(){
				private int i=0;
				public boolean hasNext(){
					return i < chars.length;
				}
				public Object next() {
					return Character.valueOf(chars[i++]);
				}
			};
		} 
	}

	static
	class Random implements Iterable {
		private int[] values;
		public Random(int n, int min, int max){
			values=new int[n];
			for(int i=0; i<n; ++i) 
				values[i] = (int)(Math.random()*(max+1));
		}
		class RIterator implements Iterator {
			private int next=0;
			public boolean hasNext() { 
				return next < values.length; }
			public Object next() { 
				return Integer.valueOf(values[next++]);}
		}
		public Iterator iterator() {
			return new RIterator();
		}
	}
	
	static
	class RandomLazy implements Iterable {
		private int n,min,max;
		public RandomLazy(int n, int min, int max){
			this.n=n; this.min=min; this.max=max;
		}
		public Iterator iterator() {
			return new Iterator() {
				private int next=0;
				public boolean hasNext() { return next++ < n; }
				public Object next() { 
					return Integer.valueOf((int)(min+Math.random()*(max-min+1)));}
			};
		}
	}

	public static void main(String[] args) {
		
		Letters l = new Letters("Sequence");
		
		for( Iterator it = l.iterator();
				      it.hasNext();) {
			Object el = it.next();
			System.out.println(el);
		}
		
		
		
		for(Object e : l){         // ---+
		  char c = ((Character)e); // ---+--> could improve by using Generics 
		  System.out.print("[" + c + "]");
		}
		
		
		Iterable seq = new Random(10,5,10);
		for(Object e : seq){
		  int v = ((Integer)e).intValue();
		  System.out.print(v + " ");
		}
		
		// Bonus point: how random is random?
		// compute f
		final int k = 10;
		final int n = 1000000;
		int[] freqs=new int[k];
		seq = new RandomLazy(n,0,k-1);
		for(Object e : seq){
			  int i = ((Integer)e).intValue();
			  freqs[i]++;
		}
		
		System.out.println(Arrays.toString(freqs));
		
		// Use Pearson chi-squared test
		// assuming equal probability means expected number is
		int m = n/k;
		double ss=0.0;
		for(int i=0; i<freqs.length; ++i) {
			ss+=((double)freqs[i])*((double)freqs[i]);
		}
		double chiSq = ss/m - n;
		System.out.println("Chi-squared: " + chiSq);
		System.out.println("50% CI : 5.898826 ; 11.38875");
		System.out.println("95% CI : 2.700389 ; 19.02277");
		System.out.println("99% CI : 1.734933 ; 23.58935");
	}
}
