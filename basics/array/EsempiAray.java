package array;

public class EsempiAray {
	
	static class ArrayDiInt {
		final int length=4;
		
		int e0;
		int e1;
		int e2;
		int e3;
		//...
	}

	static class ArrayDiString {
		final int length=4;
		
		String e0;
		String e1;
		String e2;
		String e3;
		//...
	}

	public static void main(String[] args) {
		
		int[] a;  // rifetimento ad oggetto di tipo array-di-int
		
		a = new int[10];
		ArrayDiInt adi = new ArrayDiInt();
		
		System.out.println(a[0]);
		System.out.println(adi.e0);
		
		//a = new int[100];
		a = raddoppialo(a);
		
		
		//int v[10];
		
		String[] parole = new String[10];
		System.out.println(parole[0]);
		
		parole[0] = "Tanto";
		parole[1] = "va";
		parole[2] = "la";
		parole[3] = "gatta";
		parole[4] = "al";

		System.out.println(parole[0]);
		
		String s1 = null;
		String s2 = "null";
		System.out.println(s1);
		System.out.println(s2);
		
		// For each String p in parole...
		for(String p : parole) {  // for-each
			if( p == null ) break;
			System.out.println(p);
		}
		
		
	}
	
	static int[] raddoppialo(int[] a) {
		int[] doppio = new int[a.length * 2];
		for(int i=0; i<a.length; ++i) {
			doppio[i] = a[i];
		}
		return doppio;
	}

}
