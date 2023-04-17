package university;
import java.util.logging.Logger;

/**
 * This class represents a university education system.
 * 
 * It manages students and courses.
 *
 */
public class University {
	
	private String name;
	private String first;
	private String last;
	
	private static final int MAX_STUDENTS = 100;
	private static final int START_ID_STUDENT = 10000;
	private int next_id_student = START_ID_STUDENT;
	private Student[] students = new Student[MAX_STUDENTS];	
	
	private static final int MAX_COURSES = 50;
	private static final int START_ID_COURSE = 10;
	private int next_id_course = START_ID_COURSE;
	private Course[] courses = new Course[MAX_COURSES];

// R1
	/**
	 * Constructor
	 * @param name name of the university
	 */
	public University(String name){
		// Example of logging
		// logger.info("Creating extended university object");
		//TODO: to be implemented
		this.name = name;
	}
	
	/**
	 * Getter for the name of the university
	 * 
	 * @return name of university
	 */
	public String getName(){
		//TODO: to be implemented
		return name;
	}
	
	/**
	 * Defines the rector for the university
	 * 
	 * @param first first name of the rector
	 * @param last	last name of the rector
	 */
	public void setRector(String first, String last){
		//TODO: to be implemented
		this.first = first;
		this.last = last;
	}
	
	/**
	 * Retrieves the rector of the university
	 * 
	 * @return name of the rector
	 */
	public String getRector(){
		//TODO: to be implemented
		return first + " "  + last;
	}
	
// R2
	/**
	 * Enrol a student in the university
	 * 
	 * @param first first name of the student
	 * @param last last name of the student
	 * 
	 * @return unique ID of the newly enrolled student
	 */
	public int enroll(String first, String last){
		//TODO: to be implemented
		students[next_id_student-START_ID_STUDENT] = new Student(first,last,next_id_student);
		logger.info("New student enrolled: "+next_id_student+", "+first+" "+last);
		return next_id_student++;
	}
	
	/**
	 * Retrieves the information for a given student
	 * 
	 * @param id the ID of the student
	 * 
	 * @return information about the student
	 */
	public String student(int id){
		//TODO: to be implemented
		return students[id-START_ID_STUDENT].printStudent();
	}
	
// R3
	/**
	 * Activates a new course with the given teacher
	 * 
	 * @param title title of the course
	 * @param teacher name of the teacher
	 * 
	 * @return the unique code assigned to the course
	 */
	public int activate(String title, String teacher){
		//TODO: to be implemented
		courses[next_id_course - START_ID_COURSE] = new Course(title,teacher,next_id_course);
		logger.info("New course activated: "+next_id_course+", "+title + " " + teacher);
		return next_id_course++;
	}
	
	/**
	 * Retrieve the information for a given course.
	 * 
	 * The course information is formatted as a string containing 
	 * code, title, and teacher separated by commas, 
	 * e.g., {@code "10,Object Oriented Programming,James Gosling"}.
	 * 
	 * @param code unique code of the course
	 * 
	 * @return information about the course
	 */
	public String course(int code){
		//TODO: to be implemented
		return courses[code - START_ID_COURSE].printCourse();
	}
	
// R4
	/**
	 * Register a student to attend a course
	 * @param studentID id of the student
	 * @param courseCode id of the course
	 */
	public void register(int studentID, int courseCode){
		//TODO: to be implemented
		students[studentID - START_ID_STUDENT].addCourseForStudent(courses[courseCode - START_ID_COURSE]);
		courses[courseCode - START_ID_COURSE].addStudentInCourse(students[studentID - START_ID_STUDENT]);
		logger.info("Student "+studentID+ " signed up for course "+courseCode);
	}
	
	/**
	 * Retrieve a list of attendees
	 * 
	 * @param courseCode unique id of the course
	 * @return list of attendees separated by "\n"
	 */
	public String listAttendees(int courseCode){
		//TODO: to be implemented
		return courses[courseCode - START_ID_COURSE].printListAttendees();
	}

	/**
	 * Retrieves the study plan for a student.
	 * 
	 * The study plan is reported as a string having
	 * one course per line (i.e. separated by '\n').
	 * The courses are formatted as describe in method {@link #course}
	 * 
	 * @param studentID id of the student
	 * 
	 * @return the list of courses the student is registered for
	 */
	public String studyPlan(int studentID){
		//TODO: to be implemented
		return students[studentID - START_ID_STUDENT].printStudyPlan();
	}

// R5
	/**
	 * records the grade (integer 0-30) for an exam can 
	 * 
	 * @param studentId the ID of the student
	 * @param courseID	course code 
	 * @param grade		grade ( 0-30)
	 */
	public void exam(int studentId, int courseID, int grade) {
;		students[studentId - START_ID_STUDENT].addExam(students[studentId - START_ID_STUDENT], courses[courseID - START_ID_COURSE], grade);
		courses[courseID - START_ID_COURSE].addExam(students[studentId - START_ID_STUDENT], courses[courseID - START_ID_COURSE], grade);
		logger.info("Student "+studentId+" took an exam in course "+courseID+" with grade "+grade);
	}

	/**
	 * Computes the average grade for a student and formats it as a string
	 * using the following format 
	 * 
	 * {@code "Student STUDENT_ID : AVG_GRADE"}. 
	 * 
	 * If the student has no exam recorded the method
	 * returns {@code "Student STUDENT_ID hasn't taken any exams"}.
	 * 
	 * @param studentId the ID of the student
	 * @return the average grade formatted as a string.
	 */
	public String studentAvg(int studentId) {
		return students[studentId - START_ID_STUDENT].getAvg();
	}
	
	/**
	 * Computes the average grades of all students that took the exam for a given course.
	 * 
	 * The format is the following: 
	 * {@code "The average for the course COURSE_TITLE is: COURSE_AVG"}.
	 * 
	 * If no student took the exam for that course it returns {@code "No student has taken the exam in COURSE_TITLE"}.
	 * 
	 * @param courseId	course code 
	 * @return the course average formatted as a string
	 */
	public String courseAvg(int courseId) {
		return courses[courseId - START_ID_COURSE].getAvg();
	}
	

// R6
	/**
	 * Retrieve information for the best students to award a price.
	 * 
	 * The students' score is evaluated as the average grade of the exams they've taken. 
	 * To take into account the number of exams taken and not only the grades, 
	 * a special bonus is assigned on top of the average grade: 
	 * the number of taken exams divided by the number of courses the student is enrolled to, multiplied by 10.
	 * The bonus is added to the exam average to compute the student score.
	 * 
	 * The method returns a string with the information about the three students with the highest score. 
	 * The students appear one per row (rows are terminated by a new-line character {@code '\n'}) 
	 * and each one of them is formatted as: {@code "STUDENT_FIRSTNAME STUDENT_LASTNAME : SCORE"}.
	 * 
	 * @return info on the best three students.
	 */
	public String topThreeStudents() {
		float max1=(float) 0.0;
		float max2=(float) 0.0;
		float max3=(float) 0.0;
		int r1=-1,r2=-1,r3=-1;
		String res="";
		for(int i=0;i<(next_id_student-START_ID_STUDENT);i++) {
			if(students[i].getScore()>max1) {
				max3=max2;
				r3=r2;
				max2=max1;
				r2=r1;
				max1=students[i].getScore();
				r1=i;
			}else if(students[i].getScore()>max2) {
				max3 = max2;
		        r3 = r2;
		        max2 = students[i].getScore();
		        r2 = i;
			}else if (students[i].getScore() > max3) {
		        max3 = students[i].getScore();
		        r3 = i;
		    }
		}
		if(r1!=-1) res = res + students[r1].printScore();
		if(r2!=-1) res = res+ students[r2].printScore();
		if(r3!=-1) res = res + students[r3].printScore(); 
		return res;

	}

// R7
    /**
     * This field points to the logger for the class that can be used
     * throughout the methods to log the activities.
     */
    private final static Logger logger = Logger.getLogger("University");

}
