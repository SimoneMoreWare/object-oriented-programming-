package it.polito.oop.books;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Book {
	
	private HashMap<String,Topic> topics = new HashMap<>();
	private HashMap<String,Question> questions = new HashMap<>();
	private HashMap<String,TheoryChapter> theoryChapters = new HashMap<>();
	private HashMap<String,ExerciseChapter> exerciseChapters = new HashMap<>();
	private HashMap<String,Assignment> assignments = new HashMap<>();

    /**
	 * Creates a new topic, if it does not exist yet, or returns a reference to the
	 * corresponding topic.
	 * 
	 * @param keyword the unique keyword of the topic
	 * @return the {@link Topic} associated to the keyword
	 * @throws BookException
	 */
	public Topic getTopic(String keyword) throws BookException {
		
		if(keyword==null || keyword.isEmpty()) throw new BookException();
		
		if(topics.get(keyword)==null) {
			Topic topic = new Topic(keyword);
			topics.put(keyword, topic);
		}
		
	    return topics.get(keyword);
	}

	public Question createQuestion(String question, Topic mainTopic) {
		Question q = new Question(question,mainTopic);
		questions.put(question, q);
		mainTopic.newQuestion(q);
        return q;
	}

	public TheoryChapter createTheoryChapter(String title, int numPages, String text) {
		
		TheoryChapter theoryChapter = new TheoryChapter(title,numPages,text);
		theoryChapters.put(title, theoryChapter);
		
        return theoryChapter;
	}

	public ExerciseChapter createExerciseChapter(String title, int numPages) {
		ExerciseChapter exerciseChapter = new ExerciseChapter(title, numPages);
		exerciseChapters.put(title, exerciseChapter);
        return exerciseChapter;
	}

	public List<Topic> getAllTopics() {
        
		Set<Topic> res = new HashSet<>();
        
		res = theoryChapters.values().stream().flatMap( tc -> tc.getTopics().stream() ).collect(Collectors.toSet());
		
		res.addAll(exerciseChapters.values().stream().flatMap( ec -> ec.getTopics().stream() ).collect(Collectors.toSet())) ;
        
        return res.stream().sorted(Comparator.comparing(Topic::getKeyword)).collect(Collectors.toList());
        
	}

	public boolean checkTopics() {
		
		Set<Topic> exerciseChaptersTopics = new HashSet<>();
		exerciseChaptersTopics = exerciseChapters.values().stream().flatMap(c -> c.getTopics().stream())
				.collect(Collectors.toSet());
		
		Set<Topic> theoryChaptersTopics = new HashSet<>();
		theoryChaptersTopics = theoryChapters.values().stream().flatMap(c -> c.getTopics().stream())
				.collect(Collectors.toSet());
		return theoryChaptersTopics.containsAll(exerciseChaptersTopics);

	}

	public Assignment newAssignment(String ID, ExerciseChapter chapter) {
		Assignment assignment = new Assignment(ID,chapter);
		assignments.put(ID,assignment);
		chapter.newAssignment(assignment);
        return assignment;
	}
	
    /**
     * builds a map having as key the number of answers and 
     * as values the list of questions having that number of answers.
     * @return
     */
    public Map<Long,List<Question>> questionOptions(){
        return questions.values().stream().
        		collect(Collectors.toMap(q->q,Question::numAnswers)).
        		entrySet().stream().
        		collect(Collectors.groupingBy(
        										Map.Entry::getValue,
        										HashMap::new,
        										Collectors.mapping(Map.Entry::getKey, Collectors.toList())
        										)
        				)
        		;
    }
}
