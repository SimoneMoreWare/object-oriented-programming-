package eccezioni;

public class Parse {

	public static void main(String[] args) {
		
		String s = "123";
		
		int i = Integer.parseInt(s);

		System.out.println(i*2);
		
		String[] numeri = {"3", "4", "10", ""};
		
		int somma = 0;
		for(String n : numeri) {
			try {
				somma += Integer.parseInt(n);
			}catch(NumberFormatException nfe) {
				System.out.println("VAlore errato: '" + n + "'");
			}
		}
		System.out.println(somma);
	}
	
	static class ConversionException extends Exception{}
	
	static public int atoi(String n) throws ConversionException {
		try {
			return Integer.parseInt(n);
		}catch(NumberFormatException e) {
			throw new ConversionException();
		}
	}

}
