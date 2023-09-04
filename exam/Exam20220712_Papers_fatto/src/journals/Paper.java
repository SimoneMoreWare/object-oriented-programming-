package journals;

import java.util.LinkedList;
import java.util.List;

public class Paper {
	
	private Journal journal;
	private String title;
	private List<Author> authors = new LinkedList<>();
	
	public Paper(Journal journal, String title) {
		super();
		this.journal = journal;
		this.title = title;
	}
	
	public Journal getJournal() {
		return journal;
	}
	public void setJournal(Journal journal) {
		this.journal = journal;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	public void newAuthor(Author author) {
		authors.add(author);
	}

}
