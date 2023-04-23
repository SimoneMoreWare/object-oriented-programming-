package inheritance;

public class AbstractExamExample {

	public static void main(String[] args) {
		
		ExamPart[] parts=new ExamPart[2];
		
		parts[0] = new ExamProgramming(20, 3);
		parts[1] = new ExamTheory(0.8);

		double grade=0;
		for(ExamPart p : parts) {
			System.out.println(p);
			grade+=p.getPartialGrade();
		}
		System.out.println("Total: " + Math.round(grade) + 
							"/30 (" + String.format("%5.2f",grade) + ")");
	}

}
