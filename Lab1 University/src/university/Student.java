package university;

public class Student {
	
	private String first;
	private String last;
	private int id;
	
	private static final int MAX_COURSE_FOR_STUDENT = 25;
	private Course[] studyPlan = new Course[MAX_COURSE_FOR_STUDENT];
	private int indexCourseForStudent = 0;
	
	private static final int MAX_EXAM = 25;
	private Exam[] exams = new Exam[MAX_EXAM];
	private int index_exam=0;
	
	public Student(String first,String last,int id) {
		this.first = first;
		this.last = last;
		this.id = id;
	}

	public String printStudent() {
		// TODO Auto-generated method stub
		return id + " " + first + " " + last;
	}
	
	public void addCourseForStudent(Course course) {
		studyPlan[indexCourseForStudent++] = course;
	}

	public String printStudyPlan() {
		// TODO Auto-generated method stub
		StringBuffer res = new StringBuffer();
		for(int i=0;i<indexCourseForStudent;i++) {
			res.append(studyPlan[i].printCourse()).append('\n');
		}
		return res.toString().trim();
	}
	
	public void addExam(Student student,Course course,int grade) {
		exams[index_exam++] = new Exam(student,course,grade);
	}

	public String getAvg() {
		// TODO Auto-generated method stub
		if(index_exam==0) return "Student " + id + " hasn't taken any exams";
		float sum = (float) 0.0;
		for(int i=0;i<index_exam;i++) {
			sum = sum + exams[i].getGrade();
		}
		float avg = (float) sum/index_exam;
		return "Student " + id +" : " + avg;
	}
	
	public float getScore() {
		if(index_exam==0) return -1;
		float sum = (float) 0.0;
		for(int i=0;i<index_exam;i++) {
			sum = sum + exams[i].getGrade();
		}
		float avg = (float) sum/index_exam;
		return avg + (float) 10*(index_exam/indexCourseForStudent);
	}
	
	public String printScore() {
		return first + " " + last + " : " + this.getScore() + "\n";
	}


}
