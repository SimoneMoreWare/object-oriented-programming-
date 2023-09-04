package it.polito.oop.books;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


public class ExerciseChapter {
	
	private String title;
	private int numPages;
	private List<Topic> topics = new LinkedList<>();
	private List<Question> questions = new LinkedList<>();
	private List<Assignment> assignments = new LinkedList<>();
	 

    public ExerciseChapter(String title, int numPages) {
		super();
		this.title = title;
		this.numPages = numPages;
	}


	public List<Topic> getTopics() {
        return topics.stream().collect(Collectors.toSet()).stream().sorted(Comparator.comparing(Topic::getKeyword)).collect(Collectors.toList());
    }
	
	

    public String getTitle() {
        return title;
    }

    public void setTitle(String newTitle) {
    	this.title = newTitle;
    }

    public int getNumPages() {
        return numPages;
    }
    
    public void setNumPages(int newPages) {
    	this.numPages = newPages;
    }
    

	public void addQuestion(Question question) {
		questions.add(question);
		this.topics.add(question.getMainTopic());
		question.getMainTopic().newExerciseChapter(this);
		question.newExerciseChapter(this);
	}	
	
	public void newAssignment(Assignment assignment) {
		assignments.add(assignment);
	}
}
