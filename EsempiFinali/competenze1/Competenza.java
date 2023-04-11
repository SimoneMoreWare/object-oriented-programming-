package competenze1;
import java.util.*;
public class Competenza implements Comparable<Competenza>{
	private String nome; 
	private TreeSet<Attività> attività = new TreeSet<Attività>();
	private TreeSet<Utente> utenti = new TreeSet<Utente>();
	Competenza(String nome) {this.nome = nome;} 
	public String toString(){return nome + ":" + " nA=" + attività.size() 
		+ " nU=" + utenti.size();}
	String getNome() {return nome;}
	public int compareTo(Competenza c) {return nome.compareTo(c.nome);}
	void addAttività(Attività a){attività.add(a);}
	void addUtente(Utente u){utenti.add(u);}
	public int getNA(){return attività.size();}
	public int getNU(){return utenti.size();}
	public String getAttività(){return "attività che richiedono " + nome + " " + attività.toString();}
	public String getUtenti(){return "utenti che possiedono " + nome + " " + utenti.toString();}
}