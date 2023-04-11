
public class ComplexPolar implements Complex {
	private double mod, arg;
	
	public ComplexPolar (double mod, double arg ) {
		this.mod = mod;
		this.arg = arg;
	}
	@Override
	public double real() {
		return mod*Math.cos(arg);
	}
	
	@Override
	public double im() {
		return mod*Math.sin(arg);
	}
	
	@Override
	public double mod() {
		return mod;
	}
	
	@Override
	public double arg() {
		return arg;
	}
}
