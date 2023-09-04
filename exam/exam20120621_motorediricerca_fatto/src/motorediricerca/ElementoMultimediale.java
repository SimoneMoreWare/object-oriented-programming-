package motorediricerca;

public class ElementoMultimediale{
	
	private String nome;
	private float dimensione;
	private String tipo;
	
	
	public ElementoMultimediale(String nome, float dimensione, String tipo) {
		super();
		this.nome = nome;
		this.dimensione = dimensione;
		this.tipo = tipo;
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
		return this.tipo;
	}	
}
