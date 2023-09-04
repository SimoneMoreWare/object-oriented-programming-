package Aerei;

public class Volo implements Comparable<Volo>{
	String codice;
	Compagnia comp;
	Aereo vettore;
	Aeroporto from, to;
	String giorno;
	int postiLiberi;
	int ritPart = -1;
	int ritArr = -1;

	public Volo(Compagnia cmp, String cod, Aereo v, Aeroporto f, Aeroporto t, String g) {
		comp = cmp;
		codice = cod;
		vettore = v;
		from = f;
		to = t;
		giorno = g;
		postiLiberi = v.getPasseggeri();
	}
	public Aeroporto getPartenza(){
		return from;
	}
	public Aeroporto getArrivo(){
		return to;
	}
	public boolean prenota(int n){
		if(n <= postiLiberi){
			postiLiberi -= n;
			return true;
		}
		else return false;
	}
	public int getPostiLib(){
		return postiLiberi;
	}
	public int getPostiDisp(){
		return vettore.getPasseggeri();
	}
	public String toString(){
		return comp.getNome()+";"+codice+";"+vettore.getCode()+";"+from.getCode()+";"+to.getCode()+";"+giorno+";"+postiLiberi; 
	}
	public void setRitPart(int rit){
		ritPart = rit;
	}
	public void setRitArr(int rit){
		ritArr = rit;
	}
	public int getRitPart(){
		return ritPart;
	}
	public int getRitArr(){
		return ritArr;
	}
	
	public int compareTo(Volo o) {
		return this.codice.compareTo(o.codice);
	}
}
