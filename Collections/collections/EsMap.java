package collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class EsMap {

	public static void main(String[] args) {
		
		Map<String,String> vocabolario ;
		
		//vocabolario = new HashMap<>();
		vocabolario = new TreeMap<>();
		
		vocabolario.put( "mela", "frutto con buccia molto diffuso..");
		vocabolario.put( "abaco", "strumento meccanico per il calcolo");
		vocabolario.put( "zuzzurellone", "persona alquanto strana");
		vocabolario.put( "poli", "abbreviazione per Politecnico di Torino (gli altri non li consideriamo...)");

		for( String parola : vocabolario.keySet()) {
			String definizione = vocabolario.get(parola);
			System.out.println(parola + ": " + definizione);
		}
		
		for( String s : vocabolario.values()) {
			System.out.println(s);
		}

		String parola = "apple";
		
		String def = vocabolario.get(parola); // -- > null
		if(def!=null) {
			System.out.println(def);
		}
		
		if( vocabolario.containsKey(parola) ) {
			def = vocabolario.get(parola); 
		}else {
			def = "<parola assente>";
		}
		System.out.println(def);
		
		def = vocabolario.getOrDefault(parola, "<parola assente>");
		System.out.println(def);
		
		Map<String, List<String>> diz = new TreeMap<>();
		
		// vocabolario.put( "mela", "frutto con buccia molto diffuso..");
		parola = "mela";
		String definizione = "frutto con buccia molto diffuso..";
		diz.compute(parola, (k,v) -> {
			if(v==null) {
				List<String> l = new ArrayList<>();
				l.add(definizione);
				return l;
			}else {
				v.add(definizione);
				return v;
			}
		});
		// OPPURE
		nuovaDefinizione(diz,"mela","frutto con buccia molto diffuso..");
		
		List<String> definizioni = diz.computeIfAbsent(parola, nuovaDef -> {
			List<String> d = new ArrayList<>();
			d.add(nuovaDef);
			return d;
		});

		for(String p : vocabolario.keySet()) {
			String defin = vocabolario.get(p);
			diz.computeIfAbsent(p,s-> new ArrayList<>()).add(defin);
		}
		
		System.out.println(diz);
	}
	
	static void nuovaDefinizione(Map<String, List<String>> diz,
							     final String parola, 
							     final String definizione) {
		diz.compute(parola, (k,v) -> {
			if(v==null) {
				List<String> l = new ArrayList<>();
				l.add(definizione);
				return l;
			}else {
				v.add(definizione);
				return v;
			}
		});
	}
	

}
