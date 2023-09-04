package journals;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

import java.util.*;

public class Journals {

	
	SortedMap<String, Journal> journals = new TreeMap<String, Journal>();
	SortedMap<String, Author> authors = new TreeMap<String, Author>();
	
	//R1 
	/**
	 * inserts a new journal with name and impact factor. 
	 * 
	 * @param name	name of the journal
	 * @param impactFactor relative impact factor
	 * @return  the number of characters of the name
	 * @throws JException if the journal (represented by its name) already exists
	 */
	public int addJournal (String name, double impactFactor) throws JException {
		if(journals.containsKey(name)) {
			throw new JException(" duplicated journal");
		}
		else {
			Journal j = new Journal(name, impactFactor);
			journals.put(name, j);
		}
		return name.length();
	}

	/**
	 * retrieves the impact factor of the journal indicated by the name
	 * 
	 * @param name the journal name
	 * @return the journal IF
	 * @throws JException if the journal does not exist
	 */
	public double getImpactFactor (String name) throws JException {
		Journal j = journals.get(name);
		if(j == null) {
			throw new JException(" journal not exist");
		}
		else {
			return j.impactFactor;
		}
	}

	/**
	 * groups journal names by increasing impact factors. 
	 * Journal names are listed in alphabetical order
	 * 
	 * @return the map of IF to journal
	 */
	public SortedMap<Double, List<String>> groupJournalsByImpactFactor () {
		return journals.values().stream()
		.filter(j -> j.getImpactFactor() > 0)
		.collect(groupingBy(j -> j.getImpactFactor(), TreeMap::new,
				mapping(j->j.name, toList())));
	}

	//R2
	/**
	 * adds authors. 
	 * Duplicated authors are ignored.
	 * 
	 * @param authorNames names of authors to be added
	 * @return the number of authors entered so far
	 */
	public int registerAuthors (String... authorNames) {

		for(int i=0;i<authorNames.length;i++) {
			String currentAuthorName = authorNames[i];
		    if(!authors.containsKey(currentAuthorName)) {
		    	Author a = new Author(currentAuthorName);
		    	authors.put(currentAuthorName, a);
		    }
		}
		
		return authors.size();
	}
	
	/**
	 * adds a paper to a journal. 
	 * The journal is indicated by its name; 
	 * the paper has a title that must be unique in the specified journal,
	 * the paper can have one or more authors.
	 * 
	 * @param journalName
	 * @param paperTitle
	 * @param authorNames
	 * @return the journal name followed by ":" and the paper title.
	 * @throws JException if the journal does not exist or the title is not unique within the journal or not all authors have been registered
	 */
	public String addPaper (String journalName, String paperTitle, String... authorNames) throws JException {
		Journal j = journals.get(journalName);
		if(j == null) {
			throw new JException(" journal not exist");
		}
		if(!authors.keySet().containsAll(List.of(authorNames))) {
			throw new JException(" not registered");
		}
		else {
			SortedMap<String, Author> tempAuthors = new TreeMap<String, Author>();
			for(int i=0;i<authorNames.length;i++) {
				String currentAuthorName = authorNames[i];
			    Author a = authors.get(currentAuthorName);
			    a.addJournal(paperTitle, j);
			    tempAuthors.put(currentAuthorName, a);
			}
			
			Paper p = new Paper(journalName, paperTitle, tempAuthors);
			j.addPaper(p);
			
			for(int i=0;i<authorNames.length;i++) {
				String currentAuthorName = authorNames[i];
			    Author a = authors.get(currentAuthorName);
			    a.addPaper(p);
			}
		}
		return String.format("%s:%s",journalName, paperTitle);
	}
	
	/**
	 * gives the number of papers for each journal. 
	 * Journals are sorted alphabetically. 
	 * Journals without papers are ignored.
	 * 
	 * @return the map journal to count of papers
	 */
	public SortedMap<String, Integer> giveNumberOfPapersByJournal () { //serve toMap
		
		return journals.values().stream()
				.filter(j -> j.getNumberOfPapers() > 0)
				.collect(toMap(j->j.name, j->j.getNumberOfPapers(), (p1, p2) -> p1, TreeMap::new));
	}
	

	//R3
	/**
	 * gives the impact factor for the author indicated.
	 * The impact factor of an author is obtained by adding 
	 * the impact factors of his/her papers. 
	 * The impact factor of a paper is equal to that of the 
	 * journal containing the paper.
	 * If the author has no papers the result is 0.0.
	 *
	 * @param authorName
	 * @return author impact factor
	 * @throws JException if the author has not been registered
	 */
	public double getAuthorImpactFactor (String authorName) throws JException {
		Author a = authors.get(authorName);
		if(a==null) {
			throw new JException(" not registered");
		}
		else {
			return a.getImpactFactor();
		}
	}
	
	/**
	 * groups authors (in alphabetical order) by increasing impact factors.
	 * Authors without papers are ignored.
	 * 
	 * @return the map IF to author list
	 */
	public SortedMap<Double, List<String>> getImpactFactorsByAuthors () {
		return authors.values().stream()
				.filter(a -> a.getImpactFactor() > 0)
				.collect(groupingBy(a -> a.getImpactFactor(), TreeMap::new,
						mapping(j->j.name, toList())));
	}
	
	
	//R4 
	/**
	 * gives the number of papers by author; 
	 * authors are sorted alphabetically. 
	 * Authors without papers are ignored.
	 * 
	 * @return
	 */
	public SortedMap<String, Integer> getNumberOfPapersByAuthor() {
		return authors.values().stream()
				.filter(a -> a.getNumberOfPapers() > 0)
				.collect(toMap(a->a.name, a->a.getNumberOfPapers(), (p1, p2) -> p1, TreeMap::new));
	}
	
	/**
	 * gives the name of the journal having the largest number of papers.
	 * If the largest number of papers is common to two or more journals 
	 * the result is the name of the journal which is the first in 
	 * alphabetical order.
	 * 
	 * @return journal with more papers
	 */
	public String getJournalWithTheLargestNumberOfPapers() {
		Journal journal = journals.values().stream().max((j1,j2) -> Integer.compare(j1.getNumberOfPapers(), j2.getNumberOfPapers())).get();
		return String.format("%s:%d", journal.name, journal.getNumberOfPapers());
	}

}

