package exams;

import java.util.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

public class ExamHandling {

	private Map<String,Plan> plans=new HashMap<>();
	private Map<String,Course> courses=new HashMap<>();
	private Map<String,Student> students=new HashMap<>();
	private Map<String,ExamSession> sessions=new HashMap<>();
	private Map<String,ArrayList<String>> exams =new HashMap<>();
	
	public void addStudyPlan(String name, String... courses) throws ExamException {
		if(plans.containsKey(name)) throw new ExamException("");
		Plan p=new Plan(name);
		plans.put(name,p);
		List<String> mylist=new ArrayList<>();
		for(String c:courses){
			if(!this.courses.containsKey(c)){
			Course course=new Course(c);
			this.courses.put(c, course);
			}
			mylist.add(c);
		   	
		}
		p.addCourses(mylist);
	}

	public void enrollStudent(String studentId, String studentName, String studyPlan) throws ExamException {
		if(!plans.containsKey(studyPlan)) throw new ExamException("");

		if(students.containsKey(studentId)) throw new ExamException("");
		Student s=new Student(studentId,studentName,studyPlan);
		s.addCourses(plans.get(studyPlan).getCourses());
		students.put(studentId,s);
		plans.get(studyPlan).addStudents(studentId);
		
	    
	}

	public SortedMap<String, Long> numberOfStudentsForStudyPlan() {
		return
students.values().stream().collect(Collectors.groupingBy(Student::getStudyPlan,TreeMap::new,
		Collectors.counting()))	;	

	}

	public SortedMap<String, List<String>> studentsForStudyPlan() {
return
			 students.values().stream().
			 collect(Collectors.groupingBy(Student::getStudyPlan, TreeMap::new ,
			 Collectors.mapping(Student::getStudentId, toList()) ))	;
	
				
	}
/*
 * The method openExam(String courseName) opens an exam session for the given course. It
 *  throws an exception if the course is undefined or if there is already and open
 *   session for the course. 
A student sustaining an exam is recorded through method 
takeExam(String studentId, String course). 
 The method throws an exception if the course is undefined, 
 is not in the study plan of the student, there is no exam session open, 
 the student already sustained the exam in the current session, or the student 
 already holds a pass grade (i.e. >= 18) for the course. 
	
 */
	
	
//mapping(SPlan::getStudents, Collectors.mapping(Student::getStudentName),Collectors.toList())
	// R2

	public void openExam(String courseName) throws ExamException {
	if(sessions.containsKey(courseName))throw new ExamException("");
		ExamSession s=new ExamSession(courseName);
     sessions.put(courseName, s);
		// Exam ex=exams.get(courseName);

		
	}

	public int numberOfOpenExamSessions() {
		int l=(int) sessions.values().stream().count();
		return l;
	}
/*The method studentsWhoTookTheExam(String courseName) returns the
 *  sorted list of the ids of the students that sustained the exam in
 *   the current session, i.e. for whom a takeExam() was called. It throws an 
 *   exception if the course is undefined. 
 */

/*	The method throws an exception if the course is undefined, is not in the study plan of the student, 
	there is no exam session open, the student already sustained the exam in the current session, or the student already
	holds a pass grade (i.e. >= 18) for the course. */
	
	public void takeExam(String studentId, String courseName) throws ExamException {
		if(!students.containsKey(studentId)) throw new ExamException("");
		if(!courses.containsKey(courseName)) throw new ExamException("");
		if(!plans.get((students.get(studentId).getStudyPlan())).getCourses().contains(courseName))  throw new ExamException("");
		if(!sessions.containsKey(courseName)) throw new ExamException("");
	    students.get(studentId).addTakencourses(courseName);
	  
	}

	
	public List<String> studentsWhoTookTheExam(String courseName) throws ExamException {
		if(!courses.containsKey(courseName)) throw new ExamException("");
		
		return students.values().stream().filter(s->s.getTakencourses().contains(courseName)).map(s->s.getStudentId()).
				collect(Collectors.toList());
		}


	// R3

	public void giveGrade(String courseName, String studentId, int grade) throws ExamException {
    students.get(studentId).gradedCourses(courseName,grade);
    if(grade>=18)
    courses.get(courseName).passStudent(studentId,grade);
    else
    	courses.get(courseName).failStudent(studentId,grade);
	}

	public void closeExam(String courseName) throws ExamException {
		sessions.get(courseName).close();

	}

	// R4
	public SortedMap<Integer, List<String>> gradesOfStudent(String studentId) throws ExamException {
		return  students.get(studentId).getGradedcourses().entrySet().stream().
				collect(Collectors.groupingBy(Map.Entry::getValue,TreeMap::new,
						
						mapping(Map.Entry::getKey,toList())));

	}

	public SortedMap<Integer, List<String>> gradesOfCourse(String courseName) throws ExamException {
		return   courses.get(courseName).getPass().entrySet().stream().collect(Collectors.
				groupingBy(Map.Entry::getValue,TreeMap::new,mapping(Map.Entry::getKey,toList())))
				
				;
	}

	public int failingGradesOfStudent(String studentId) throws ExamException {
		return 
				(int) students.get(studentId).getGradedcourses().entrySet().stream().
		filter(c->c.getValue()<18).count();
	}

	public int failingGradesOfCourse(String courseName) throws ExamException {
		return courses.get(courseName).getFail().size();
	}

}
