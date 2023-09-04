package Aerei;

public class Aereo {
	String codice;
	int passeggeri;

	public Aereo(String c, int p) {
		codice = c;
		passeggeri = p;
	}
	public String getCode(){
		return codice;
	}
	public int getPasseggeri(){
		return passeggeri;
	}
}
