package base;

public class ExNoGetSet {
	public static class Student {
		public String first;
		public String last;
		public int id;
		public Student(String first, String last, int id){
			this.first=first; this.last=last; this.id=id;
		} 
	}

	public static class Exam {
		public int grade;
		public Student student;
		public Exam(int grade){this.grade=grade;}
	}


	public static void main(String[] args) {
	    // defines a student and her exams
	    // lists all student’s exams
	    Student s=new Student("Alice","Green",1234);
	    Exam e = new Exam(30);
	    e.student = s; 
	    // print vote
	    System.out.println(e.grade);
	    // print student
	    System.out.println(e.student.last); 

	}
}