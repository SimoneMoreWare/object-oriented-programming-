package it.polito.oop.books;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Question {
	
	private String question;
	private Topic topic;
	private List<Answer> answers = new LinkedList<>();
	private List<ExerciseChapter> exerciseChapters = new LinkedList<>();
	
	public Question(String question, Topic topic) {
		this.question = question;
		this.topic = topic;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public Topic getMainTopic() {
		return topic;
	}

	public void addAnswer(String answer, boolean correct) {
		Answer a = new Answer(answer, correct);
		answers.add(a);
	}
	
    @Override
    public String toString() {
        return question + " (" + topic.getKeyword() + ")";
    }

	public long numAnswers() {
	    return answers.size();
	}

	public Set<String> getCorrectAnswers() {
		return answers.stream().filter(a->a.isCorrect()).map(Answer::getAnswer).collect(Collectors.toSet());
	}

	public Set<String> getIncorrectAnswers() {
		return answers.stream().filter(a->!a.isCorrect()).map(Answer::getAnswer).collect(Collectors.toSet());
	}
	
	public void newExerciseChapter(ExerciseChapter exerciseChapter) {
		exerciseChapters.add(exerciseChapter);
	}
	
	public String getKeywordTopic() {
		return this.topic.getKeyword();
	}
	
}
