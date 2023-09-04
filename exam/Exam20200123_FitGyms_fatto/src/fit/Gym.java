package fit;

import java.util.LinkedList;
import java.util.List;

public class Gym {
	
	private String name;
	private List<Lesson> lessons = new LinkedList<>();

	public Gym(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void newLesson(Lesson lesson) {
		lessons.add(lesson);
	}

	public List<Lesson> getLessons() {
		return lessons;
	}
	
	public boolean slotIsFree(String startHour, String endHour, int day) {
		
		for(Lesson lesson: lessons) {
			
			if( (lesson.getDay() == day) && (lesson.getStartHour().equals(startHour)) && (lesson.getEndHour().equals(endHour))) return false; 
			
		}
		
		return true;
		
	}
	
	public Lesson getLesson(String startHour, String endHour, int day) {
		
		for(Lesson lesson: lessons) {
			
			if( (lesson.getDay() == day) && (lesson.getStartHour().equals(startHour)) && (lesson.getEndHour().equals(endHour))) return lesson; 
			
		}
		
		return null;
	}
	
	public int getNumLessons() {
		return lessons.size();
	}
	

	
}
