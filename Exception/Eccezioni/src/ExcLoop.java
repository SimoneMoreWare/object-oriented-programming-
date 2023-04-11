
public class ExcLoop {

	public static void main(String[] args) {
		
		String[] s = {"123","456", "X", "789"};
		
		int somma = somma(s);
		
		System.out.println("Somma: " + somma);

		System.out.println("Somma2: " + somma2(s));

	}

	private static int somma(String[] s) {
		int somma=0;
		for(String e : s){
			try{
				int i = Integer.parseInt(e);
				somma += i;
			}catch(NumberFormatException nfe){
				System.err.println("Formato errato: " + nfe);
			}
		}
		return somma;
	}

	private static int somma2(String[] s) {
		int somma=0;
		try{
			for(String e : s){
				int i = Integer.parseInt(e);
				somma += i;
			}
		}catch(NumberFormatException nfe){
			System.err.println("Formato errato: " + nfe);
		}
		return somma;
	}

}
