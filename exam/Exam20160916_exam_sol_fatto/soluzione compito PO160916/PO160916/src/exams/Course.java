package exams;
import java.util.*;

public class Course {

	private String name; String getName() {return name;}
	
	Course (String name) {this.name = name;}
	
	private int failingGrades;
	int getFailingGrades() {return failingGrades;}
	void incrFailingGrades() {failingGrades++;}
	
	private Map<String, Grade> grades = new HashMap<>();
	void addGrade(String studentId, Grade grade) {
		grades.put(studentId, grade);
		//studentsWhoTookTheExam.remove(studentId);
	}	
	List<Grade> getGrades() {return new ArrayList<>(grades.values());}	
	Grade getGrade(String studentId) {return grades.get(studentId);}
	
	private SortedSet<String> studentsWhoTookTheExam = new TreeSet<>();
	boolean addStudentToExam (String studentId) {
		return studentsWhoTookTheExam.add(studentId);}
	boolean checkStudentForExam (String studentId) {
		return studentsWhoTookTheExam.contains(studentId);}
	
	List<String> getStudentsWhoTookTheExam() {
		return new ArrayList<>(studentsWhoTookTheExam);
	}
	
	private boolean isOpenSession = false;
	boolean isOpenSession() {return isOpenSession;}
	void openSession() {
		isOpenSession = true;
	}
	boolean closeSession() { //checks that all the students have received a grade
		if (!grades.keySet().containsAll(studentsWhoTookTheExam)) return false;
		studentsWhoTookTheExam.clear(); // clears the list
		isOpenSession = false;
		return true;
	}


}
