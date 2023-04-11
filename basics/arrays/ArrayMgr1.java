package arrays;
public class ArrayMgr1 {
	static int lp(int[] v1, int[] v2) throws Exception {
		if (v1.length != v2.length) throw new Exception ("invalid data");
		int r = 0;
		for (int i = 0; i < v1.length; i++) {
			r += v1[i] * v2[i];
		}
		return r;
	}

	public static void main(String[] args) {
		int[] v1 = {1,3};
		int[] v2 = {1,3,4};
		try {
			System.out.println(lp(v1,v1));
			System.out.println(lp(v1,v2));
		}
		catch (Exception e) {
			System.out.println("exception: " + e.getMessage());
		}
}
}
