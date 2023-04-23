package inheritance.iexpr;

public class Value implements Expression {

	private double value;
	
	public Value(double value) {
		this.value = value;
	}
	
	@Override
	public double eval() {
		return value;
	}

	@Override
	public String formula() {
		return String.valueOf(value);
	}

}
