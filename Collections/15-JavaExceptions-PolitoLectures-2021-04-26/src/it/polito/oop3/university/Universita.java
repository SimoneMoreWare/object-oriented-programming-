package it.polito.oop3.university;

import java.util.Hashtable;
import java.util.Map;

public class Universita {

	private Map<String,Corso> corsi;
	private Map<String,Politomember> politomembers;

	public Universita() {
		corsi = new  Hashtable<>();
		politomembers = new Hashtable<>();
	}
	
	public void addCorso(String c, String n, float op, float od) {
		Corso corso = new Corso(c,n,op,od);
		corsi.put(c,corso);
	}
	
	public void addDocente(String m, String n, String c) {
		Docente d = new Docente(m,n,c);
		politomembers.put(m,d);
	}
	
	public void addStudente(String m, String n, String c, String r) {
		Studente s = new Studente(m,n,c,r);
		politomembers.put(m,s);
	}
	
	
	public void assignCorsotoDocente(String codicec, String mdoc, float n) {
		
		Corso corso = corsi.get(codicec);
		Politomember docente = politomembers.get(mdoc);
		if (corso == null || docente == null || !(docente instanceof Docente)) {
			System.out.println("Impossibile trovare il corso o il docente");
		} else {
			corso.addDocente((Docente) docente, n);
		}
	}
	
	
	public void assignStudentetoCorso (String codicec, String mstud) {
		Corso corso = corsi.get(codicec);
		Politomember studente = politomembers.get(mstud);
		if (corso == null || studente == null || !(studente instanceof Studente)) {
			System.out.println("Impossibile trovare il corso o il docente");
		} else {
			corso.addStudente((Studente) studente);
		}	
	}
	
	public void addLezione (String codicec, String mdoc, String data, float ore, char tipo) {
		Corso corso = corsi.get(codicec);
		Politomember docente = politomembers.get(mdoc);
		if (corso == null || docente == null || !(docente instanceof Docente)) {
			System.out.println("Impossibile trovare il corso o il docente");
		} else {
			corso.addLezione(data, (Docente) docente, ore, tipo);
		}	
		
	}
	
	public void addStudenteToLezione(String codicec, String mstud, String data) throws ExceptionLessonNotFound {
		Corso corso = corsi.get(codicec);
		Politomember studente = politomembers.get(mstud);
		if (corso == null || studente == null || !(studente instanceof Studente)) {
			System.out.println("Impossibile trovare il corso o lo studente");
		} else {
			corso.addStudenteToLezione((Studente) studente,data);
		}	
	}
	
	public void printLezioni (String codcorso) {
		Corso corso = corsi.get(codcorso);
		if (corso == null) {
			System.out.println("Impossibile trovare il corso");
		} else {
			corso.printLezioni();
		}
	}

	
	public float getOre(String codcorso, char tipo) {
		Corso corso = corsi.get(codcorso);
		if (corso == null) {
			System.out.println("Impossibile trovare il corso");
			return 0;
		} else {
			return corso.getOre(tipo);
		}
		
	}
	
}
