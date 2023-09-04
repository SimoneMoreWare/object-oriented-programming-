package timesheet;

public class Activity {

	private Project project;
	private String name;
	private boolean completed;
	
	public Activity(Project project, String name) {
		super();
		this.project = project;
		this.name = name;
		this.completed = false;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	
	
	
}
