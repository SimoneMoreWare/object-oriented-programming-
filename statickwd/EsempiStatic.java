package statickwd;

import java.util.Arrays;

//import java.lang.*;

public class EsempiStatic {
	
	static int max(int a, int b) {
		return a>b?a:b;
	}

	int maxi(int a, int b) {
		return a>b?a:b;
	}

	public static void main(String[] args) {
		
		int maggiore = EsempiStatic.max(3,4);
		
		
		EsempiStatic oggetto = new EsempiStatic();
		maggiore = oggetto.maxi(3,4);
		
		int i = Integer.parseInt("42");
		
		//Intero j = new Intero(i);
		Intero j = Intero.valoreIntero(i);
		
		Intero k = Intero.valoreIntero(i);
		
		int[] a = new int[10];
		
		int[] newA = new int[2*a.length];
		for(int l=0; l<a.length; ++l) {
			newA[l] = a[l];
		}
		a = newA;
		// OVVERO:
		a = Arrays.copyOf(a, 2*a.length);
		
		a = new int[]{1,3,99,42,33,5,15,7};
		
		System.out.println(Arrays.toString(a));
		
		Arrays.sort(a);
		
		System.out.println(Arrays.toString(a));
		
		
		
		
	}

}
