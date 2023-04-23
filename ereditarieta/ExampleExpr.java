package inheritance;

public class ExampleExpr {

	public static void main(String[] args) {
		
		Expression s= new Operation('+',
				new Value(3),
				new Value(4));
		
		System.out.println(s + " = " + s.eval());


	}

}
