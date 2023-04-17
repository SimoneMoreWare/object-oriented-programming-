package university;

public class Exam {
	private Student student;
	private Course course;
	private int grade;
	
	public Exam(Student student,Course course,int grade) {
		this.student = student;
		this.course = course;
		this.grade = grade;
	}

	public float getGrade() {
		// TODO Auto-generated method stub
		return grade;
	}
}
