package it.polito.oop3.university;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class Corso {
	private String codice;
	public String getCodice() {
		return codice;
	}

	private String nome;
	private float norep;
	private float nored;
	private Map<Docente,Float> docenti;
	private List<Studente> studenti;
	private List<Lezione> lezioni;
	
	
	public Corso (String c, String n, float op, float od) {
		codice = c;
		nome = n;
		norep = op;
		nored = od;
		docenti = new HashMap<>();
		studenti = new ArrayList<>();
		lezioni = new ArrayList<>();
	}
	
	public Corso (String c) {
		codice = c;
	}
	
	public void addDocente (Docente d, float n) {
		docenti.put(d, n);
	}
	
	public void addStudente (Studente s) {
		studenti.add(s);
	}
	
	public void addStudenteToLezione (Studente s, String data) throws ExceptionLessonNotFound {
		
		int il = lezioni.indexOf(new Lezione(data));
		if (il == -1 ) {
			//System.out.println ("Lezione non trovata");
			ExceptionLessonNotFound e = new ExceptionLessonNotFound();
			throw e;
		} else {
			Lezione l = lezioni.get(il);
			l.addStudente(s);
		}
	}

	
	public void addLezione (String data, Docente d, float ore, char t) {
		lezioni.add(new Lezione (data,d,ore,t));
	}

	public void printLezioni() {
		Collections.sort(lezioni, (a,b) -> {
			Lezione l1 = (Lezione) a;
			Lezione l2 = (Lezione) b;
			return -1*l1.getData().compareTo(l2.getData());
		});
		lezioni.forEach(System.out::println);
	}
	
	public float getOre(char tipo) {
		float ore=0;
		
		for (Lezione l: lezioni) {
			if (l.getTipo() == tipo) {
				ore+=l.getOre();
			}
		}
		return ore;
	}
}
