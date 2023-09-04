package timesheet;

public class Worker {

	private String name;
	private String surname;
	private Profile profile;
	private String id;

	public Worker(String name, String surname, Profile profile, String id) {
		super();
		this.name = name;
		this.surname = surname;
		this.profile = profile;
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Profile getProfile() {
		return profile;
	}
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return name +" "+ surname + " ("+profile.toString()+")";
	}
	
	public boolean isCompatibleEntry(int weekDay, int workedHours) {
		return profile.isCompatibleEntry(weekDay, workedHours);
	}
	
}
