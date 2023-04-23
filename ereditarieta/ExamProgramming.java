package inheritance;

public class ExamProgramming extends ExamPart {
	private int passed;
	private int failed;

	public ExamProgramming(int passed, int failed) {
		super("Practice",0.8);
		this.passed=passed;
		this.failed=failed;
	}

	@Override
	public double getScore() {
		return passed / (double)(passed+failed);
	}

}
