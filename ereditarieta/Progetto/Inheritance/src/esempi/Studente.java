package esempi;

public class Studente extends Object {

	private String matricola;
	private String nome;
	private String cognome;
	
	public Studente(String m, String n, String c){
		this.matricola = m;
		this.cognome = c;
		this.nome = n;
	}
	
	public final static int STRING = 1;
	public final static int HTML = 2;

	public String toString(){ // OVERRIDE 
		return matricola + " " + cognome + " " + nome;
	}
	
//	public String toString(int tipo){ // OVERLOAD 
//		if( tipo == STRING)
//			return matricola + " " + cognome + " " + nome;
//		if( tipo == HTML)
//			return "<b>" + matricola + "</b> " + cognome + " " + nome;
//		return null;
//	}
	
//	public boolean equals(Studente altro){ // OVERLOAD
	public boolean equals(Object o){ // OVERRIDE
		//return this == o;
	Studente altro = (Studente)o;
		
		
		return this.matricola.equals(altro.matricola)
					&& this.cognome.equals(altro.cognome)
					&& this.nome.equals(altro.nome);
	}
	
}
