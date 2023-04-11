package esempi;

public class Persona implements Comparable<Persona>{

	private String cf;
	private String nome;
	private String cognome;
	
	public Persona(String cf, String n, String c){
		this.cf = cf;
		this.nome = n;
		this.cognome = c;
	}
	
	public String toString(){
		return "(" + cf + ")" + cognome + ", " + nome;
	}

	/**
	 * restituisce == 0 se this == altro
	 * 				> 0 se this > altro
	 * 				< 0 se this < altro
	 */
	public int compareTo(Persona altro) {
		return this.cf.compareTo(altro.cf);
	}

	public String getCognome() {
		return cognome;
	}

	public String getNome() {
		return nome;
	}
	
	public String getCf() {
		return cf;
	}

}
