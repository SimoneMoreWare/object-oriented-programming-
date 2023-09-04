package motorediricerca;

public class ElementoMultimediale implements Comparable<ElementoMultimediale>{
	private String nome;
	private float dimensione;
	
	public ElementoMultimediale(String nome, float dimensione) {
		this.nome = nome;
		this.dimensione = dimensione;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public void setDimensione(float dimensione)
	{
		this.dimensione = dimensione;
	}
	
	public String getNome(){
		return nome;
	}

	public float getDimensione(){
		return dimensione;
	}
	
	public String tipo(){
		return null;
	}

	@Override
	public int compareTo(ElementoMultimediale altro) {
		// dimensione
		float ris = altro.dimensione - this.dimensione;
		if (ris > 0)
			return -1;
		
		if (ris < 0)
			return 1;

		// nome
		return this.getNome().compareTo(altro.getNome());
	}	
}
