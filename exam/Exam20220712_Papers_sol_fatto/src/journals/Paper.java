package journals;

import java.util.SortedMap;
import java.util.TreeMap;

public class Paper {
	
	String journalName;
	String paperTitle;
	
	SortedMap<String, Author> authors = new TreeMap<String, Author>();
	
	public Paper( String journalName, String paperTitle, SortedMap<String, Author> authors) {
		this.journalName = journalName;
		this.paperTitle = paperTitle;
		this.authors = authors;
	}
}
