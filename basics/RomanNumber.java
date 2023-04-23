package base;

import java.util.Arrays;

public class RomanNumber extends Number {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private double value;
	
	private static final char[] ciphers = {'I','V','X','L','C','D','M'};
	private static final int[] weight = {1,5,10,50,100,500,1000};
	private static int weight(char cp) {
		for(int i=0; i<ciphers.length; ++i) {
			if(cp==ciphers[i]) return weight[i];
		}
		return -1;
	}
	
	
	public static double parseRoman(String s) {
		if(s.equals("N")) {
			return 0;
		}
		int value=0;
		int chunk = 0;
		int prevWeight = 0;
		for(int pos=0; pos<s.length(); ++pos) {
			int w = weight(s.charAt(pos));
			if(w==-1) {
				throw new NumberFormatException(
						String.format("Invalid char in position %d: '%c'",
								pos,s.charAt(pos)));
			}
			if(pos==0) {
				chunk = w;
			}else {
				if(w == prevWeight) { //cumulating chunk
					chunk+=w;
				}else {				
					if(w > prevWeight) { //subracting
						value-=chunk;
					}
					if(w < prevWeight) { // adding
						value+=chunk;
					}
					chunk=w;
				}
			}
			prevWeight = w;
		}
		value+=chunk;
		return value;
	}
	
	public static RomanNumber valueOf(String s) {
		return new RomanNumber(parseRoman(s));
	}
	
	public RomanNumber(double value) {
		this.value=value;
	}

	@Override
	public int intValue() {
		return (int)value;
	}

	@Override
	public long longValue() {
		return (long)value;
	}

	@Override
	public float floatValue() {
		return (float)value;
	}

	@Override
	public double doubleValue() {
		return value;
	}
	
	public String toString() {
		if(value==0) return "N";
		StringBuilder sb = new StringBuilder();
		double residual=value;
		for( int i=ciphers.length-1; i>=0; i-=2) {
			int n = (int)residual / weight[i];
			if(n>0) {
				if(i<ciphers.length-1 && n>3) {
					switch(n) {
					case 4: sb.append(ciphers[i]).append(ciphers[i+1]);
							break;
					case 5:	sb.append(ciphers[i+1]);
							break;
					case 6: sb.append(ciphers[i+1]).append(ciphers[i]);
							break;
					case 7: sb.append(ciphers[i+1]).append(ciphers[i]).append(ciphers[i]);
							break;
					case 8: sb.append(ciphers[i+1]).append(ciphers[i]).append(ciphers[i]).append(ciphers[i]);
							break;
					case 9: sb.append(ciphers[i]).append(ciphers[i+2]);
							break;
					}
				}else{
					char[] r= new char[n];
					Arrays.fill(r, ciphers[i]);
					sb.append(r);
				}
			}
			residual = residual % weight[i];
		}
		return sb.toString();
	}
	
	public static final void main(String[] args) {
		String[] numbers = {"I","II","III","IV","XIX","LXXV","LXXXIX","IXC","MCMLXXI"};
		for(String n : numbers)
			System.out.println(n + " : " + RomanNumber.parseRoman(n) 
								 + " -> " + RomanNumber.valueOf(n));
		
	}

}
