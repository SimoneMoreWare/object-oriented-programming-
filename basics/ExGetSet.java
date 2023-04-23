package base;

public class ExGetSet {

	public static class Student {

		private String first;
		private String last;
		private int id;
		public Student(String first, String last, int id){
			this.first=first; this.last=last; this.id=id;
		} 

		public String toString() {
			return first + " " + 
	            last  + " " + 
	            id;		
		}
	}
	
	public static class Exam {
	    private int grade;
	    private Student student;

	    public Exam(int grade){this.grade=grade;}
		public void print() {
			 System.out.println("Student " + 
					 student.toString() + " got " + grade);
		}

		public void setStudent(Student s) {
			 this.student =s;	
	    }
	}

	
	public static void main(String[] args) {
	    Student s = new Student("Alice", "Green", 1234);
	    Exam e = new Exam(30);

	    e.setStudent(s);  
		// prints its values and asks students to
		// print their data
		e.print();    
	}

}
