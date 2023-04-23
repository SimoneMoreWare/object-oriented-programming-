package inheritance;

public abstract class  ExamPart {
	
	/** name of the exam part e.g. oral, practice, theory, etc. */
	private String name;
	private double weight;
	
	public ExamPart(String name, double weight) {
		this.name=name;
		this.weight=weight;
	}
	
	public abstract double getScore();
	
	public double getPartialGrade() {
		return 30*weight*getScore();
	}

	public String getName() {
		return name;
	}
	
	public String toString() {
		return name + " : "+ String.format("%5.2f", getPartialGrade());
	}
}
