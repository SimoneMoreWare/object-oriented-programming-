package eccezioni;

public class EsEccezioni {

	public static void main(String[] args) throws Checked {
		try {
			try {
				String s = null;
				
				s.charAt(0);
			}catch(NullPointerException npe) {
				System.out.println("C'era un null pointer ma facciamo finta di niente...");
			}
			
			m1();
		}catch(Unchecked u) {
			System.out.println("Eccezione Unchecked rilevata");
			u.printStackTrace();
		}catch(Exception t) {
			System.out.println("Eccezione rilevata");
			t.printStackTrace();
		}
		
		System.out.println("Il programma prosegue tranquillo oltre...");
		// throw new Unchecked();
		//throw new Checked();
	}
	
	static void m1() {
		m2();
	}
	
	static void m2() {
		if(true)
			throw new Unchecked();
		System.out.println("in m2()");
	}
	static class Checked extends Exception {}
	static class Unchecked extends RuntimeException {}
}
