package inheritance.interfaces.patterrns;

import static java.lang.Math.*;

/**
 * Context:
 * The same module can be implemented in different ways by distinct classes with varying:
 *   - Storage type or strategy
 *   - Processing
 * 
 * Problem:
 * The classes should be interchangeable
 * 
 * Solution:
 * An interface defines methods with a well-defined semantics and functional specification
 * Distinct classes can implement it
 * 
 */
public class AlternativeImpl {
	
	/**
	 * Complex numbers
	 * 
	 * Can be implemented using, e.g., either cartesian or polar coordinates
	 */
	public interface Complex {
		double real();
		double im();
		double mod();
		double arg();

		/*
		 * Interfaces can become the façade for alternative implementations
		 * If alternatives are known in advance, static methods can serve as factory methods
		 */
		static Complex fromRect(double re, double im){
			return new ComplexRect(re,im);
		}
		static Complex fromPolar(double mod, double arg){
			return new ComplexPolar(mod,arg);
		}

		default boolean isReal(){
			return im()==0;
		}


		public static int precision = 2;
		default String fmt(double x) {
			return String.format("%."+precision+"f", x);
		}	
	}

	/**
	 * Cartesian (a.k.a. rectangular) coordinates
	 *
	 */
	static
	class ComplexRect implements Complex {
		  private double im, re;
		  public ComplexRect(double re, double im) {
		               this.im = im; this.re = re; }
		  @Override public double real() { return re; }
		  @Override public double im() { return im; }
		  @Override public double mod() {
		               return sqrt(re*re+im*im); }
		  @Override public double arg() {
		               return atan2(im, re); }
		  public String toString() {
			  return fmt(re) + "+i" + fmt(im);
		  }
	}
	
	/**
	 * Polar coordinates
	 *
	 */
	static
	class ComplexPolar implements Complex {
		  private double mod, arg;
		  public ComplexPolar(double mod, double arg) {
		               this.mod = mod; this.arg = arg; }
		  @Override public double real() { 
			  			return mod*cos(arg); }
		  @Override public double im() { 
			  			return mod*sin(arg); }
		  @Override public double mod() { return mod; }
		  @Override public double arg() { return arg; }
		  public String toString() {
			  return "|" + fmt(mod) + "|e^i" + fmt(arg);
		  }

		}
	
	public static void main(String[] args) {
		Complex c1 = new ComplexRect(4,3);
		System.out.println(c1 + 
		" -> Module " + c1.mod() + 
		"  argument: " + c1.arg());
		Complex c2 = new ComplexPolar(5,0.6435);
		System.out.println(c2 + 
		" -> Real " + c2.real() + 
		"  Imaginary: " + c2.im());
		
		c1 = Complex.fromRect(4,3);
		System.out.println(c1 + 
						" -> Module " + c1.mod() + 
						"  Argument: " + c1.arg());
		c2 = Complex.fromPolar(5,0.6435);
		System.out.println(c2 + 
						" -> Real " + c2.real() + 
						"  Imaginary: " + c2.im());
	}
	

}
