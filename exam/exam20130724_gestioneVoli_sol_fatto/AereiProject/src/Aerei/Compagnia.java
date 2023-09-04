package Aerei;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Compagnia {
	String nome;
	AeroportiMondo am;
	Map<String,Aereo> aerei;
	Map<String,Volo> voli;

	public Compagnia(String n, AeroportiMondo amondo) {
		nome = n;
		am = amondo;
		aerei = new TreeMap<String,Aereo>();
		voli = new TreeMap<String,Volo>();
	}
	public String getNome(){
		return nome;
	}
	public List<String> getAerei(){
	    List<String> res = new LinkedList<String>(aerei.keySet());
	    Collections.sort(res);
		return res;
	}
	public List<Volo> getVoli(){
		return new LinkedList<Volo>(voli.values());
	}
	public void addAereo(String cod, int pass) throws InvalidCode {
		if(aerei.containsKey(cod))
			throw new InvalidCode();
		Aereo vett = new Aereo(cod, pass);
		aerei.put(cod, vett);
	}
	public void addVolo(String cod, String aer, String part, String arr, String giorno) throws InvalidCode {
		if(voli.containsKey(cod))
			throw new InvalidCode();
		Aereo vet = aerei.get(aer);
		Aeroporto from = am.getAeroporto(part);
		Aeroporto to = am.getAeroporto(arr);
		Volo vo = new Volo(this, cod, vet, from, to, giorno);
		voli.put(cod, vo);
		from.addPartenza(vo);
		to.addArrivo(vo);
	}
	public void cancelVolo(String cod) throws InvalidCode {
		Volo vo = voli.get(cod);
		if(vo == null)
			throw new InvalidCode();
		Aeroporto from = vo.getPartenza();
		Aeroporto to = vo.getArrivo();
		voli.remove(cod);
		from.cancelPartenza(vo);
		to.cancelArrivo(vo);
	}
	public boolean prenota(int num, String cod) throws InvalidCode {
		Volo vo = voli.get(cod);
		if(vo == null)
			throw new InvalidCode();
		return vo.prenota(num);
	}
	public int postiLiberi(String cod) throws InvalidCode {
		Volo vo = voli.get(cod);
		if(vo == null)
			throw new InvalidCode();
		return vo.getPostiLib();
	}
	public void partitoVolo(String cod, int ritardo) throws InvalidCode {
		Volo vo = voli.get(cod);
		if(vo == null)
			throw new InvalidCode();
		vo.setRitPart(ritardo);
	}	
	public void arrivatoVolo(String cod, int ritardo) throws InvalidCode {
		Volo vo = voli.get(cod);
		if(vo == null)
			throw new InvalidCode();
		vo.setRitArr(ritardo);
	}		
	public List<String> ritardiPartenza() {
		ArrayList<String> rit = new ArrayList<String>();
		for(String c : voli.keySet()){
			if(voli.get(c).getRitPart()>15)
				rit.add(c);
		}
		return rit;
	}	
	public List<String> ritardiArrivo() {
		ArrayList<String> rit = new ArrayList<String>();
		for(String c : voli.keySet()){
			if(voli.get(c).getRitArr()>15)
				rit.add(c);
		}
		return rit;
	}	
	public List<String> voliCritici() {
		ArrayList<String> critici = new ArrayList<String>();
		for(String c : voli.keySet()){
			Volo v = voli.get(c);
			if(v.ritPart>=0 && (float)v.getPostiLib()/v.getPostiDisp()>0.3)
				critici.add(c);
		}
		return critici;
	}
}
