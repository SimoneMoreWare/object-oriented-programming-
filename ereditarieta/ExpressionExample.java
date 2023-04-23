package inheritance;

public class ExpressionExample {

	public static void main(String[] args) {
		
		Expression e = new Operation('*', 
										new Value(6),
										new Operation('+',
												new Value(4),
												new Value(3)));
		
		System.out.println( e.formula() + " = " + e.eval());
		
	}
}
