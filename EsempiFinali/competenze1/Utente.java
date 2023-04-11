package competenze1;
import java.util.*;
public class Utente implements Comparable<Utente>{
private String nome;
private TreeSet<Competenza> competenze = new TreeSet<Competenza>();
Utente(String nome) {this.nome = nome;}
void addCompetenza(Competenza c){competenze.add(c);}
public String toString(){return nome;}
public String getInfo(){
	TreeSet<String> s = new TreeSet<String>();
	for (Competenza c: competenze) s.add(c.getNome());
	return nome + s;}		
public int compareTo(Utente u) {return nome.compareTo(u.nome);}
}	

