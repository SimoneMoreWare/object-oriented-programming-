package gui.traduttore;

import java.util.HashMap;
import java.util.Map;

public class Model {

	private Map<String,String> dizionario = new HashMap<>();
	private String parola;
	private String traduzione;
	
	public Model() {
		dizionario.put("Mela", "Apple");
		dizionario.put("Auto", "Car");
		dizionario.put("Tavolo", "Table");
		dizionario.put("Gatto", "Cat");
	}
	
	public void setParola(String p) {
		parola = p;
		traduzione = dizionario.getOrDefault(p, "<parola non trovata>");
	}
	
	public String getTraduzione() {
		return traduzione;
	}
	
}
