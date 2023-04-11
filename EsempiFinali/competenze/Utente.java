package competenze;
import java.util.*;
class Utente {
private String nome;
private TreeSet<String> competenze;
Utente(String nome, TreeSet<String> competenze) {
		this.nome = nome; this.competenze = competenze;
}
public String toString(){return nome + competenze;}}	

