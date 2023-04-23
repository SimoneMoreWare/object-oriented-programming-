package inheritance;

public class VarArg {
	static void plst(String pre, Object...args){
		System.out.print(pre + " ");
		for(Object o : args){
			if(o!=args[0]) System.out.print(", ");
			System.out.print(o);
		}
		System.out.println();
	}


	public static void main(String[] args) {
		plst("List:", "A", 'b', 123, "hi!");
	}

}
