package exams;
import java.util.*;
class Student {

	private String id; String getId() {return id;}
	private String name; String getName() {return name;}
	private String studyPlan; String getStudyPlan() {return studyPlan;}

		
	Student(String id, String name, String studyPlan) {
		this.id = id; this.name = name; this.studyPlan = studyPlan;
	}

	private int failingGrades;
	int getFailingGrades() {return failingGrades;}
	void incrFailingGrades() {failingGrades++;}
	
	private Map<String, Grade> grades = new HashMap<>();
	boolean addGrade(String courseName, Grade grade) {
		if (grades.containsKey(courseName)) return false;
		grades.put(courseName, grade);return true;
	}	
	List<Grade> getGrades() {return new ArrayList<>(grades.values());}	
	Grade getGrade(String courseName) {return grades.get(courseName);}
	
	
}
