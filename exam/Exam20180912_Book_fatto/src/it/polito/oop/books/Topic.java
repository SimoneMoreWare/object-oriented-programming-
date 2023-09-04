package it.polito.oop.books;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Topic {
	
	private String keyword;
	private List<Topic> subtopics = new LinkedList<>();
	private List<Question> questions = new LinkedList<>();
	private List<TheoryChapter> theoryChapters = new LinkedList<>();
	private List<ExerciseChapter> execiseChapters = new LinkedList<>();
	
	public Topic(String keyword) {
		this.keyword = keyword;
	}

	public String getKeyword() {
        return keyword;
	}
	
	@Override
	public String toString() {
	    return keyword;
	}

	public boolean addSubTopic(Topic topic) {
		
		if(subtopics.contains(topic)==false) {
			subtopics.add(topic);
			return true;
		}
		
        return false;
	}

	/*
	 * Returns a sorted list of subtopics. Topics in the list *MAY* be modified without
	 * affecting any of the Book topic.
	 */
	public List<Topic> getSubTopics() {    
		return subtopics.stream().sorted(Comparator.comparing(Topic::getKeyword)).collect(Collectors.toList());
	}
	
	public void newQuestion(Question question) {
		questions.add(question);
	}
	
	public void newTheoryChapter(TheoryChapter theoryChapter) {
		theoryChapters.add(theoryChapter);
	}
	
	public void newExerciseChapter(ExerciseChapter exerciseChapter) {
		execiseChapters.add(exerciseChapter);
	}
}
