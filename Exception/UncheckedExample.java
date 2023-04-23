package exceptions;

public class UncheckedExample {
	
	final static String[] ROMAN_NUMBERS = {"I","II","III","IV","V","VI","VII","VIII","IX","X"}; 

	public static void main(String[] args) {
		
		String[] strings = {"1","2","III","4","V","6"};
		
		try {
			int sum = 0;
			for(String s : strings) {
				sum += Integer.parseInt(s);
			}
			System.out.println("Sum: " + sum);
		}catch(Exception e){
			e.printStackTrace();
			System.err.println("Error!");
		}

		int sum = 0;
		for(String s : strings) {
			try {
				sum += Integer.parseInt(s);
			}catch(NumberFormatException nfe) {
				System.err.println("Wrong " + s);
			}
		}
		System.out.println("Sum: " + sum);

		sum = 0;
		for(String s : strings) {
			try {
				sum += Integer.parseInt(s);
			}catch(NumberFormatException nfe) {
				int i;
				for(i=0; i<ROMAN_NUMBERS.length; ++i) {
					if(ROMAN_NUMBERS[i].equals(s)) {
						break;
					}
				}
				if(i<ROMAN_NUMBERS.length) {
					System.out.println("Warning: roman " + s);
					sum+=i+1;
				}else {
					System.err.println("Wrong " + s);
				}
			}
		}
		System.out.println("Sum: " + sum);

		sum = 0;
		for(String s : strings) {
			try {
				sum += Integer.parseInt(s);
			}catch(NumberFormatException nfe) {
				try {
					sum += parseRoman(s);
				}catch(NumberFormatException re) {
					System.err.println("Wrong " + s);
				}
			}
		}
		System.out.println("Sum: " + sum);

	}
	
	public static int parseRoman(String s) throws NumberFormatException {
		for(int i=0; i<ROMAN_NUMBERS.length; ++i) {
			if(ROMAN_NUMBERS[i].equals(s)) {
				return i+1;
			}
		}
		throw new NumberFormatException("Not a roman number: \"" + s + "\"");
	}

}
