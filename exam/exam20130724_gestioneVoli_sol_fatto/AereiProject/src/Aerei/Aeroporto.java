package Aerei;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Aeroporto {
	String codice;
	List<Volo> arrivi, partenze;

	public Aeroporto(String c) {
		codice = c;
		arrivi = new ArrayList<Volo>();
		partenze = new ArrayList<Volo>();
	}
	public String getCode(){
		return codice;
	}
	public void addArrivo(Volo v){
		arrivi.add(v);
	}
	public void cancelArrivo(Volo v){
		arrivi.remove(v);
	}
	public void addPartenza(Volo v){
		partenze.add(v);
	}
	public void cancelPartenza(Volo v){
		partenze.remove(v);
	}
	public List<Volo> getArrivi(){
		Collections.sort( arrivi);
		return arrivi;
	}
	public List<Volo> getPartenze(){
		Collections.sort( partenze);
		return partenze;
	}
}
