package inheritance.iexpr;

public class Operation implements Expression, Composed {
	private char op;
	private Expression left;
	private Expression right;

	public Operation(char op, Expression left, Expression right) {
		this.op = op;
		this.left = left;
		this.right = right;
	}

	@Override
	public double eval() {
		switch(op) {
		case '+': return left.eval()+right.eval();
		case '-': return left.eval()-right.eval();
		case '*': return left.eval()*right.eval();
		case '/': return left.eval()/right.eval();
		}
		return -1;
	}

	@Override
	public String formula() {
		String lf = left.formula();
		String rf = right.formula();
		if( left instanceof Composed ) {
			lf = "(" + lf + ")";
		}
		if( right instanceof Composed) {
			rf = "(" + rf + ")";
		}
		return lf +  op + rf;
	}

}
