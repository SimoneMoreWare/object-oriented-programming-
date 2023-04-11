package it.polito.OOP.ITA3;

public class Student {
	private String first;
	private String last;
	private int id;
	
	public Student() {
		first = null;
		last = null;
		id = 0; 
	}
	
	public Student(String nome) {
		first = nome;
	}
	
	/*
	 * Non si può fare perchè ho duplicato la signature
	public Student(String cognome) {
		last = cognome; 
	}
	*/
	
	public Student(String nome, String cognome) {
		first = nome;
		last = cognome;
	}
	
	public Student(String nome, String cognome, int id) {
		first = nome;
		last = cognome;
		this.id = id;
	}
	
	/* Questo costruttore ha una signature diversa dal precedente */
	public Student(String nome, int id, String cognome) {
		first = nome;
		last = cognome;
		this.id = id;
	}
	
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	/*
	 * Metodo che viene invocato quando un oggetto
	 * viene distrutto dal garbage collecotr
	 */
	public void finalize() {
		System.out.println("Aiuto mi stanno uccidendo");
	}

}
