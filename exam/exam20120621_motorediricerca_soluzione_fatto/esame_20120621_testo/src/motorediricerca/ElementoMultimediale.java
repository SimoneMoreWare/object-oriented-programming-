package motorediricerca;

public class ElementoMultimediale implements Comparable<ElementoMultimediale>{
	String nome;
	float dimensione;
	
	public ElementoMultimediale(String nome, float dimensione){
		this.nome= nome;
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
	public int compareTo(ElementoMultimediale altro) {
		float res = altro.dimensione-this.dimensione;
		if (res>0)
			return -1;
		if (res<0)
			return 1;
		
		return this.getNome().compareTo(altro.getNome());
	}	
}
