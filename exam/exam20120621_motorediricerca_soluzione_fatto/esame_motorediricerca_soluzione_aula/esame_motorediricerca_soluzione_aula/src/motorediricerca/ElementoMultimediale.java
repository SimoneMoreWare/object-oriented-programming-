package motorediricerca;

public class ElementoMultimediale implements Comparable<ElementoMultimediale>{
	private String nome;
	private float dimensione;
	
	public ElementoMultimediale(String nome, float dimensione) {
		this.nome = nome;
		this.dimensione = dimensione;
	}

	public void setNome(String nome){
		this.nome = nome;
	}

	public void setDimensione(float dimensione){
		this.dimensione = dimensione;
	}
	
	public String getNome(){
		return nome;
	}

	public float getDimensione(){
		return dimensione;
	}
	
	public String tipo(){
		return "";
	}

	@Override
	public int compareTo(ElementoMultimediale o) {
		float dimensione = o.getDimensione()-this.dimensione;
		if (dimensione>0)
			return -1;
		if (dimensione<0)
			return 1;
		
		return this.getNome().compareTo(o.getNome());
	}	
}
