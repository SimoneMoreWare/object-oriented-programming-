package generics;

public class Persona implements Comparable<Persona> {
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
	public int compareTo(Persona altra) {
		
		return this.cognome.compareTo(altra.cognome);
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}
}
