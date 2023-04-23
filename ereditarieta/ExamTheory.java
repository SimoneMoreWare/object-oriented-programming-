package inheritance;

public class ExamTheory extends ExamPart {

	private double correctness;

	public ExamTheory(double correctness) {
		super("Theory",0.2);
		this.correctness = correctness;
	}

	@Override
	public double getScore() {
		return correctness;
	}

}
