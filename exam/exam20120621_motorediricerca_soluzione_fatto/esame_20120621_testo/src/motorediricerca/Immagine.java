package motorediricerca;

public class Immagine extends ElementoMultimediale{

	public Immagine(String nome, float dimensione) {
		super(nome, dimensione);
	}
	
	public String tipo(){
		return "immagine";
	}
}
