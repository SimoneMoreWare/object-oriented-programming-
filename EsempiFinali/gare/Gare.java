package gare;
import java.util.*;
public class Gare {
	private Map<String, Atleta> atleti = new TreeMap<String, Atleta>();
	private Map<String, Gara> gare = new HashMap<String, Gara>();
	private Map<String, Squadra> squadre = new HashMap<String, Squadra>();
	public void newAtleta(String nome, String nomeSquadra) throws Exception {
		if (atleti.get(nome)!=null) throw new Exception("atleta! " + nome);
		Squadra squadra = squadre.get(nomeSquadra);
		if (squadra == null) {
			squadra = new Squadra(nomeSquadra); squadre.put(nomeSquadra, squadra);
		}
		atleti.put(nome, new Atleta(nome, squadra));
	}
	public void newGara(String nomeGara) throws Exception {
		if (gare.get(nomeGara)==null) gare.put(nomeGara, new Gara(nomeGara));
		else throw new Exception("gara! " + nomeGara);
	}
	public void newPunteggio(String nomeGara, String nomeAtleta, int punti) throws Exception {
		Gara gara = gare.get(nomeGara); 
		if (gara==null) throw new Exception("gara? " + nomeGara);
		Atleta atleta = atleti.get(nomeAtleta);
		if (atleta==null) throw new Exception("atleta? " + nomeAtleta);
		Punteggio p = new Punteggio(gara, atleta, punti);
		atleta.addPunteggio(p); gara.addPunteggio(p);
	}
	public Collection<? extends ElementoDiClassifica> getClassificaSquadre() {
		ArrayList<Squadra> classifica = new ArrayList<Squadra>(squadre.values());
		Collections.sort(classifica);
		return classifica;
	}
	public Collection<? extends ElementoDiClassifica> getClassificaGenerale() {
		ArrayList<Atleta> classifica = new ArrayList<Atleta>(atleti.values());
		Collections.sort(classifica);
		return classifica;
	}
	public Collection<? extends ElementoDiClassifica> getClassifica(String nomeGara)throws Exception {
		Gara gara = gare.get(nomeGara); 
		if (gara==null) throw new Exception("gara? " + nomeGara);
		return gara.getClassifica();
	}
	public String getPiazzamenti(String nomeAtleta) throws Exception {
		Atleta atleta = atleti.get(nomeAtleta);
		if (atleta==null) throw new Exception("atleta? " + nomeAtleta);
		return atleta.getPiazzamenti();
	}

}
