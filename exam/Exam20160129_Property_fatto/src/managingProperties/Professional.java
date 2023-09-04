package managingProperties;

public class Professional {
	
	private String id;
	private Profession profession;
	
	public Professional(String id, Profession profession) {
		super();
		this.id = id;
		this.profession = profession;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Profession getProfession() {
		return profession;
	}
	public void setProfession(Profession profession) {
		this.profession = profession;
	}
	
	

}
