package fit;

import java.util.LinkedList;
import java.util.List;

public class Instructor {
	
	private String name;
	private List<Lesson> lessons = new LinkedList<>();

	public Instructor(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void newLessonGiven(Lesson lesson) {
		lessons.add(lesson);
	}
	
	public int getNumLessonGiven(String gymnname) {
		
		int res = 0;
		
		for(Lesson lesson: lessons) {
			
			if( lesson.getGym().getName().equals(gymnname) ) res ++;
			
		}
		
		return res;
		
	}
	

}
