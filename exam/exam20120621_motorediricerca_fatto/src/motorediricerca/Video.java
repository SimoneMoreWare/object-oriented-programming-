package motorediricerca;

public class Video extends ElementoMultimediale{
	private int secondi;

	public Video(String nome, float dimensione,  String tipo, int secondi) {
		super(nome, dimensione,tipo);
		this.secondi = secondi;
	}

	public int getSecondi() {
		return secondi;
	}

	public void setSecondi(int secondi) {
		this.secondi = secondi;
	}
	
	
}
