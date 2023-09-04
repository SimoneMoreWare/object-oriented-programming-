package motorediricerca;

public class Video extends ElementoMultimediale{
	int durata;

	public Video(String nome, float dimensione, int durata) {
		super(nome, dimensione);
		this.durata = durata;
	}
	
	public String tipo(){
		return "video";
	}

	public int getDurata() {
		return durata;
	}

	public void setDurata(int durata) {
		this.durata = durata;
	}
	
}
