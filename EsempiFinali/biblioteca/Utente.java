package biblioteca;
import java.util.*;
public class Utente {
	private String nome; private int maxVolumi; 
	private TreeSet<Volume> volumi = new TreeSet<Volume>();
	
Utente(String nome, int maxVolumi) 
	{this.nome = nome; this.maxVolumi = maxVolumi;}
String getNome(){return nome;}
boolean prestitoAmmissibile () {return volumi.size() < maxVolumi;}
void addVolume(Volume v) {volumi.add(v);}
void removeVolume(Volume v) {volumi.remove(v);}
}