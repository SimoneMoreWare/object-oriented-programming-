package generics;

public class TypeInference {

	public static void main(String[] args) {
		//Pair<String> ps = new Pair<>(new Integer(1),new Integer(2));
		//Pair<String> ps2 = new Pair<>(1,2);
	}
	
	public static <T,U extends T> void method(T a, U b){
		T x = b;
	}
}
