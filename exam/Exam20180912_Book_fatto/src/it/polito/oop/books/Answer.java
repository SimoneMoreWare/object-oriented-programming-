package it.polito.oop.books;

public class Answer {
	
	private String answer;
	private boolean correct;
	
	public Answer(String answer, boolean correct) {
		super();
		this.answer = answer;
		this.correct = correct;
	}
	
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public boolean isCorrect() {
		return correct;
	}
	public void setCorrect(boolean correct) {
		this.correct = correct;
	}
	

}
