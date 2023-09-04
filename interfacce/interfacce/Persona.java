package interfacce;

public class Persona implements Comparable {
	private String nome;
	private String cognome;
	
	public Persona(String n, String c) {
		this.nome = n;
		this.cognome = c;
	}
	
	@Override
	public String toString() {
		return cognome + " " + nome;
	}
	
	@Override
	public int compareTo(Object o) {
		
//		if(o instanceof Persona) {
//			Persona altra = (Persona)o;
		if(o instanceof Persona altra) {  // da Java 16 : pattern matching
			return this.cognome.compareTo(altra.cognome);
		}
		
		return 0;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}
}
