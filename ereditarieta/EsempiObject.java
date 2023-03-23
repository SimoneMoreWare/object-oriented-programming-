package ereditarieta;
import ereditarieta.ListaOggetti;
public class EsempiObject {
	
	static class Persona{
		 String nome = "Renza mattei";
		 
		 public String toString() {
			 return nome;
		 }
	}
	
	public static void main(String[] args) {
		Object object = "Hello!"; //up-cast
		
		ListaOggetti l = new ListaOggetti();
		
		l.aggiungi("Ciao!");
		
		Object primo = l.testa();
		
		String s = (String) primo; //down cast
		
		System.out.println(s);
		
		l.aggiungi(Integer.valueOf(42));
		l.aggiungi(Double.valueOf(3.14));
		
		l.aggiungi(new Persona());
		
		Object corrente;
		while(l.conta()>0) {
			corrente=l.estraiTesta();
			
			//nella classe object per stampare si  usa metodo tostring
			System.out.println(corrente.toString());
		}
	}
	
}
