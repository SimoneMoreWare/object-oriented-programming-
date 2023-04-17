package university;

public class Course {
	
	private String title;
	private String teacher;
	private int id;
	
	private final static int MAX_STUDENT_FOR_COURSE = 100;
	private Student[] enrolled = new Student[MAX_STUDENT_FOR_COURSE];
	private int indexStudentForCourse = 0;
	
	private final static int MAX_STUDENT_FOR_EXAM = 100;
	private Exam[] exams = new Exam[MAX_STUDENT_FOR_EXAM];
	private int index_exam = 0;
	
	public Course(String title,String teacher,int id) {
		this.title = title;
		this.teacher = teacher;
		this.id = id;
	}

	public String printCourse() {
		// TODO Auto-generated method stub
		return id+","+title+","+teacher;
	}
	
	public void addStudentInCourse(Student student) {
		enrolled[indexStudentForCourse++] = student;
	}

	public String printListAttendees() {
		StringBuffer res = new StringBuffer();
		for(int i=0;i<indexStudentForCourse;i++) {
			res.append(enrolled[i].printStudent()).append('\n');
		}
		return res.toString().trim();
	}
	
	public void addExam(Student student,Course course,int grade) {
		exams[index_exam++] = new Exam(student,course,grade);
	}

	public String getAvg() {
		// TODO Auto-generated method stub
		if(index_exam==0) return "No student has taken the exam in " + title;
		float sum = (float) 0.0;
		for(int i=0;i<index_exam;i++) {
			sum = sum + exams[i].getGrade();
		}
		float avg = (float) sum/index_exam;
		return "The average for the course " + title + " is: "+avg;
	}

}
