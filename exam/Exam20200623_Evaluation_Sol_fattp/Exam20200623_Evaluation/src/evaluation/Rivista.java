package evaluation;

public class Rivista {
	
	private String name;
	private String discipline;
	private Livello livello;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDiscipline() {
		return discipline;
	}
	public void setDiscipline(String discipline) {
		this.discipline = discipline;
	}
	public Livello getLivello() {
		return livello;
	}
	public void setLivello(Livello livello) {
		this.livello = livello;
	}
	public Rivista(String name, String discipline, Livello livello) {
		super();
		this.name = name;
		this.discipline = discipline;
		this.livello = livello;
	}
	
	
	

}
