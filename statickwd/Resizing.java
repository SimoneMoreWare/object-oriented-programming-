package statickwd;

import java.util.Arrays;

public class Resizing {
	public final static int TANTE_TANTE_VOLTE = 100000000;

	public static void main(String[] args) {
		int a[];
		
		// resize di mio cugino
		long begin = System.currentTimeMillis();
		a = new int[10];
		int indice=0;
		for(int i=0; i<TANTE_TANTE_VOLTE; ++i) {
			if(indice==a.length) {
				int newA[] = new int[a.length*2];
				for(int j=0; j<a.length; j++) {
					newA[j] = a[j];
				}
				a = newA;
			}
			a[indice++] = i;
		}
		long end = System.currentTimeMillis();
		System.out.println("Elapsed: " + (end-begin));
		

		// Arrays.copyOf
		begin = System.currentTimeMillis();
		a = new int[10];
		indice=0;
		for(int i=0; i<TANTE_TANTE_VOLTE; ++i) {
			if(indice==a.length) {
				a = Arrays.copyOf(a, a.length*2);
			}
			a[indice++] = i;
		}
		end = System.currentTimeMillis();
		System.out.println("Elapsed: " + (end-begin));

	}

}
