package generics;

@SuppressWarnings("unused")
public class PairExample {

	public static void main(String[] args) {
		Pair<String> sp = new Pair<>("One","Two");
		Pair<Integer> ip = new Pair<>(1,2);
		//Pair<String> mixp = new Pair<String>(1, "Two"); // Cannot infer type arguments for Pair<>

		String a = sp.second();
		int b = ip.first();
		// String bs = ip.second();  // type mismatch: cannot convert from Integer to String
	
	}

}
