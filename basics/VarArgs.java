package base;

public class VarArgs {

	static int min(int... values) {
		int res = Integer.MAX_VALUE;
		for (int v : values) {
			if (v < res)
				res = v;
		}
		return res;
	}

	public static void main(String[] args) {
		int m = min(9,3,5,7,2,8);
		System.out.println("min=" + m);
	}
}
