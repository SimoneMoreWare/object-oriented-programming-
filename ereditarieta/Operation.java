package inheritance;

public class Operation extends Expression {
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
		return "(" + left.formula() + " " + op + " " + 
					right.formula() + ")";
	}

}
