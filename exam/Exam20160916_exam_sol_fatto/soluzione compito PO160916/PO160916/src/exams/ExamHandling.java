package exams;
import java.util.*;
import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

public class ExamHandling {
	private Map<String, List<String>> studyPlanMap = new TreeMap<>();
	private Set<String> courseSet = new TreeSet<>();
	private Map<String, Student> studentMap = new TreeMap<>();
	private Map<String, Course> courseMap = new TreeMap<>();

	
	//R1
	public void addStudyPlan (String name, String... courses) throws ExamException {
		if (studyPlanMap.containsKey(name)) throw new ExamException("duplicated studyPlan " + name);
		List<String> studyPlanCourses = Arrays.asList(courses);
		studyPlanMap.put(name, studyPlanCourses);
		courseSet.addAll(studyPlanCourses);
		for (String s: studyPlanCourses)
			if (!courseMap.keySet().contains(s)) courseMap.put(s, new Course (s));
	}
	
	public void enrollStudent (String studentId, String studentName, String studyPlan) throws ExamException {
		if (!studyPlanMap.containsKey(studyPlan)) throw new ExamException("undefined studyPlan " + studyPlan);
		if (studentMap.containsKey(studentId)) throw new ExamException("duplicated student " + studentId);
		studentMap.put(studentId, new Student(studentId, studentName, studyPlan));
	}
	
	public SortedMap<String, Long> numberOfStudentsForStudyPlan() {
		return studentMap.values().stream()
		.collect(groupingBy(Student::getStudyPlan, TreeMap::new, counting()));
	}
	public SortedMap<String, List<String>> studentsForStudyPlan() { //dà null inizialmente
		return studentMap.values().stream()
		.sorted(comparing(Student::getId))
		.collect(groupingBy(Student::getStudyPlan, TreeMap::new, mapping(Student::getId, toList())));
	}
	
	//R2
	
	Course checkCourse (String courseName) throws ExamException {
		Course course = courseMap.get(courseName);
		if (course == null) throw new ExamException("undefined course " + courseName);
		return course;
	}
	Student checkStudent (String studentId) throws ExamException {
		Student student = studentMap.get(studentId);
		if (student == null) throw new ExamException("undefined student " + studentId);
		return student;
	}
	
	public void openExam (String courseName) throws ExamException {
		Course course = checkCourse(courseName);
		if (course.isOpenSession()) throw new ExamException("exam session already open for course " + courseName);
		course.openSession();
	}
	public void takeExam (String studentId, String courseName) throws ExamException {
		Course course = checkCourse(courseName);
		Student student = checkStudent(studentId);
		List<String> courses = studyPlanMap.get(student.getStudyPlan());
		if (!courses.contains(courseName))
			throw new ExamException(String.format("course %s not in study plan of %s ", courseName, studentId));
		if (!course.isOpenSession())
			throw new ExamException("no open session for course " + courseName);
		if (course.getGrade(studentId) != null)
			throw new ExamException(String.format("student %s already has a grade for course %s ", studentId, courseName));
		if (!course.addStudentToExam(studentId))
			throw new ExamException(String.format("student %s already took the exam for course %s ", studentId, courseName));
	}
	
	public List<String> studentsWhoTookTheExam (String courseName) throws ExamException {
		Course course = checkCourse(courseName);
		return course.getStudentsWhoTookTheExam();
	}
	
	public int numberOfOpenExamSessions () {
		return (int) courseMap.values().stream()
		.filter(c -> c.isOpenSession())
		.count();
	}
	
	//R3
	
	public void giveGrade (String courseName, String studentId, int grade) throws ExamException {
		Student student = checkStudent(studentId);
		Course course = checkCourse(courseName);
		Grade g = course.getGrade(studentId);
		if (g != null) 
			throw new ExamException(String.format("duplicated grade for student %s in course %s ", studentId, courseName));
		if (!course.checkStudentForExam(studentId))
			throw new ExamException(String.format("student %s didn't take the exam for course %s ", studentId, courseName));
		if (grade < 12 || grade > 30)
			throw new ExamException("wrong grade " + grade);
		if (grade >= 18) {
			g = new Grade (grade, studentId, courseName);
			course.addGrade(studentId, g);
			student.addGrade(courseName, g);
		} else {
			student.incrFailingGrades(); course.incrFailingGrades();
		}
	}
	
	public void closeExam (String courseName) throws ExamException {
		Course course = checkCourse(courseName);
		if (!course.isOpenSession()) 
			throw new ExamException("exam session is not open for course " + courseName);
		if (!course.closeSession())
			throw new ExamException("missing grades in session for course " + courseName);
	}
	
	
	//R4
	public SortedMap<Integer, List<String>> gradesOfStudent(String studentId) throws ExamException {
		Student student = checkStudent(studentId);
		return student.getGrades().stream()
		.sorted(comparing(Grade::getCourseName))
		.collect(groupingBy(Grade::getVal, () -> new TreeMap<>(reverseOrder()), 
				mapping(Grade::getCourseName, toList())));
	}
	
	public SortedMap<Integer, List<String>> gradesOfCourse(String courseName) throws ExamException {
		Course course = checkCourse(courseName);
		return course.getGrades().stream()
		.sorted(comparing(Grade::getStudentId))
		.collect(groupingBy(Grade::getVal, () -> new TreeMap<>(reverseOrder()), 
				mapping(Grade::getStudentId, toList())));
	}
	
	public int failingGradesOfStudent(String studentId) throws ExamException {
		Student student = checkStudent(studentId);
		return student.getFailingGrades();
	}
	
	public int failingGradesOfCourse(String courseName) throws ExamException {
		Course course = checkCourse(courseName);
		return course.getFailingGrades();
	}
	
}
