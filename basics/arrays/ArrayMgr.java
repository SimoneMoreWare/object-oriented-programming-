package arrays;
import java.util.*;
public class ArrayMgr {

	int[] genArray(int n) {
		int[]v = new int[n];
		for (int i = 0; i < n; i++) {
			v[i] = (int) Math.round(Math.random() * 10);
		}
		return v;
	}
	int sum(int[] v) {
		int r = 0; for (int i:v) r += i;
		return r;
	}
	int lp(int[] v1, int[] v2) throws Exception {
		if (v1.length != v2.length) throw new Exception ("invalid data");
		int r = 0;
		for (int i = 0; i < v1.length; i++) {
			r += v1[i] * v2[i];
		}
		return r;
	}

	int[][] vp(int[] v1, int[] v2) {
		int[][] m = new int [v1.length][v2.length];
		for (int i = 0; i < v1.length; i++)
			for (int j = 0; j < v2.length; j++) m[i][j] = v1[i] * v2[j];
		return m;
	}
	
	public static void main(String[] args) {
		ArrayMgr a = new ArrayMgr();
		int[] v1 = {2,3};
		int[] v2 = {4,5};
		System.out.println(Arrays.toString(v1)); //[2, 3]
		System.out.println(a.sum(v1)); //5
		try {
			System.out.println(a.lp(v1, v2)); //23
		}
		catch (Exception e) {
			System.out.println("exception: " + e.getMessage());
		}
		int[][] m = a.vp(v1, v2);
		System.out.println(Arrays.deepToString(m)); //[[8, 10], [12, 15]]
		
		v1 = a.genArray(11); // errore se dim. diverse
		v2 = a.genArray(10);
		System.out.println(a.sum(v1));
		System.out.println(a.sum(v2));
		for (int i:v1) System.out.print(i + " "); System.out.println();
		for (int i:v2) System.out.print(i + " "); System.out.println();
		try {
		System.out.println(a.lp(v1, v2));
		}
		catch (Exception e) {
			System.out.println("exception: " + e.getMessage());
		}
		
		m = a.vp(v1, v2);
		//System.out.println(m);
		for (int i:m[0]) System.out.print(i + " "); System.out.println();
	}


	
}
