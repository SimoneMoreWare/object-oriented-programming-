package it.polito.oop.books;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class TheoryChapter {
	
	private String title;
	private int numPages;
	private String text;
	private Set<Topic> topics = new HashSet<>();

    public TheoryChapter(String title, int numPages, String text) {
		super();
		this.title = title;
		this.numPages = numPages;
		this.text = text;
	}

	public String getText() {
		return text;
	}

    public void setText(String newText) {
    	this.text = newText;
    }


	public List<Topic> getTopics() {
        return topics.stream().sorted(Comparator.comparing(Topic::getKeyword)).collect(Collectors.toList());
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
    
    public void addTopic(Topic topic) {
    	
    	topics.add(topic);
    	topic.newTheoryChapter(this);
    	
    	List<Topic> subtopics = topic.getSubTopics();
    	
    	for(Topic subtopic: subtopics) {
    		this.addTopic(subtopic);
    	}
    	
    }
    
    
}
