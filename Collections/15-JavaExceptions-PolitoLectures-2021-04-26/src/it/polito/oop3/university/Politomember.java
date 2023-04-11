package it.polito.oop3.university;

public class Politomember {
	protected String matr;
	protected String nome;
	protected String cognome;
	
	public Politomember (String m, String n, String c) {
		matr = m;
		nome = n;
		cognome = c;
	}

	public String getMatr() {
		return matr;
	}

	public void setMatr(String matr) {
		this.matr = matr;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	@Override
	public boolean equals(Object o) {
		Politomember p = (Politomember) o;
		return this.matr.equals(p.getMatr());
	}
	
}
