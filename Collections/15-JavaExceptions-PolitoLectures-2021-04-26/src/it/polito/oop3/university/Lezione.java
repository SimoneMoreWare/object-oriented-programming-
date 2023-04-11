package it.polito.oop3.university;

import java.util.LinkedList;
import java.util.List;

public class Lezione {
	/* Ho utilizzato una stringa per memorizzare la data nel formato YYYY-MM-AA.
	 * Non è la soluzione migliore. Java ha delle classi per memorizzare date e orari
	 * ma le studieremo più avanti nel corso.
	 */
	private String data;
	private Docente docente;
	private float nore;
	private char tipo;
	private List<Studente> studenti;

	public Lezione(String data, Docente docente, float nore, char tipo) {
		this.data = data;
		this.docente = docente;
		this.nore = nore;
		this.tipo = tipo;
		this.studenti = new LinkedList<>();
	}
	
	
	public Lezione(String data) {
		this.data = data;
	}

	public String getData() {
		return data;
	}
	
	public char getTipo() {
		return tipo;
	}
	
	public float getOre() {
		return nore;
	}
	
	public void addStudente(Studente s) {
		if (this.tipo == 'D' || (this.tipo == 'P' && s.getResidenza().equals("Torino"))) {
			studenti.add(s);
		} else {
			System.out.println ("Impossibile aggiungere studente a lezione");
		}
	}

	@Override
	public String toString() {
		return data + "\t" + 
				docente.getCognome()+" "+docente.nome+"\t"+
				nore+"\t"+
				tipo;
	}

	@Override
	public boolean equals(Object o) {
		Lezione l = (Lezione) o;
		return data.equals(l.getData());
	}

	
}
