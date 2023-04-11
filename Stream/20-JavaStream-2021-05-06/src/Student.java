import java.util.ArrayList;

public class Student {
	private String firstName;
	private String lastName;
	private int id;
	private ArrayList<String> courses;
	
	public Student (String firstName, String lastName, int id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		courses = new ArrayList<String>();
	}
	
	public void enroll (String course) {
		courses.add(course);
	}
	
	public ArrayList<String> enrolledIn() {
		return courses;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
