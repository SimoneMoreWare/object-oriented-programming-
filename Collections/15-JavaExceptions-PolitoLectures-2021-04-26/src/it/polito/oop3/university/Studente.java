package it.polito.oop3.university;

public class Studente extends Politomember {
	private String residenza;
	
	public Studente(String m, String n, String c, String r) {
		super(m, n, c);
		// TODO Auto-generated constructor stub
		this.residenza=r;
	}

	public String getResidenza() {
		return residenza;
	}

	public void setResidenza(String residenza) {
		this.residenza = residenza;
	}
	
	

}
