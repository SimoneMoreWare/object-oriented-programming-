package competenze1;
import java.util.*;
public class Competenza implements Comparable<Competenza>{
	private String nome; 
	private TreeSet<Attivit�> attivit� = new TreeSet<Attivit�>();
	private TreeSet<Utente> utenti = new TreeSet<Utente>();
	Competenza(String nome) {this.nome = nome;} 
	public String toString(){return nome + ":" + " nA=" + attivit�.size() 
		+ " nU=" + utenti.size();}
	String getNome() {return nome;}
	public int compareTo(Competenza c) {return nome.compareTo(c.nome);}
	void addAttivit�(Attivit� a){attivit�.add(a);}
	void addUtente(Utente u){utenti.add(u);}
	public int getNA(){return attivit�.size();}
	public int getNU(){return utenti.size();}
	public String getAttivit�(){return "attivit� che richiedono " + nome + " " + attivit�.toString();}
	public String getUtenti(){return "utenti che possiedono " + nome + " " + utenti.toString();}
}