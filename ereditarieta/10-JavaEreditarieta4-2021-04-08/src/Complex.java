
public interface Complex {
	public double real();
	public double im();
	public double mod();
	public double arg();
	
	public default boolean isReal() {
		 if (im() == 0) {
			 return true;
		 } else {
			 return false;
		 }
	}
	
	//factory method
	static Complex fromRect(double re, double im) {
			return new ComplexRect(re,im);
	}
	
	//factory method
	static Complex fromPolar(double mod, double arg) {
			return new ComplexPolar(mod,arg);
	}
}
