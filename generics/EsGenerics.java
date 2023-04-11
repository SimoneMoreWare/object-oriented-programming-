package generics;

public class EsGenerics {
	
	static class Coppia {
		Object primo;
		Object secondo;
		Coppia(Object a, Object b){
			if( ! a.getClass().equals(b.getClass()) ) {
				System.out.println("Errore!!!");
				
			}
			primo=a; secondo = b;
		}
		boolean uguali() {
			return primo.equals(secondo);
		}
		Object getPrimo() {
			return primo;
		}
		void setPrimo(Object p) {
			primo = p;
		}
	}
	
	static class CoppiaStringhe extends Coppia {
		CoppiaStringhe(String s1, String s2){
			super(s1,s2);
		}
		@Override
		String getPrimo() {
			return (String)primo;
		}
		
		void setPrimo(String s) {  // overload
			super.setPrimo(s);
		}
	}
	
	public static class Paio<T> {
		T primo;
		T secondo;
		Paio(T a, T b){
			primo=a; secondo=b;
			
			// primo = new T();  // non posso perchè non so cosa è T
		}
		boolean uguali() {
			return primo.equals(secondo);
		}
		T getPrimo() {
			return primo;
		}
		
	}

	public static void main(String[] args) {

		Coppia c = new Coppia(Integer.valueOf(1),"secondo");
		
		CoppiaStringhe cs = new CoppiaStringhe("primo","secondo");
		
		cs.setPrimo(Integer.valueOf(1));
		
		Paio<String> p = new Paio<>("primo","secondo");
		
//		Paio<String> p1 = new Paio<String>(Integer.valueOf(1),"secondo");
		
		Paio<Integer> p2 = new Paio<Integer>(Integer.valueOf(1),Integer.valueOf(2));

		String s = p.getPrimo();
		// s.setPrimo(Integer.valueOf(1));
		
		Integer i = (Integer)c.getPrimo();
		String s2 = (String)c.getPrimo();  
	}

}
