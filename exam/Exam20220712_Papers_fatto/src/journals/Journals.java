package journals;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Journals {

	private HashMap<String,Journal> journals = new HashMap<>();
	private HashMap<String,Author> authors = new HashMap<>();
	private HashMap<String,Paper> papers = new HashMap<>();
	
	
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
		
		if(journals.get(name)!=null) throw new JException();
		
		Journal journal = new Journal(name,impactFactor);
		journals.put(name, journal);
		
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
			
		if(journals.get(name)==null) throw new JException();
		
		return journals.get(name).getImpactFactor();
	}

	/**
	 * groups journal names by increasing impact factors. 
	 * Journal names are listed in alphabetical order
	 * 
	 * @return the map of IF to journal
	 */
	public SortedMap<Double, List<String>> groupJournalsByImpactFactor () {
			return journals.values().stream().
					collect(Collectors.groupingBy(Journal::getImpactFactor, TreeMap::new, Collectors.mapping(Journal::getName, Collectors.collectingAndThen(Collectors.toList(), list -> list.stream().sorted().collect(Collectors.toList())))));

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
			
		for(String authorName: authorNames) {
			if(authors.get(authorName)==null) {
				Author author = new Author(authorName);
				authors.put(authorName, author);
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
	public String addPaper(String journalName, String paperTitle, String... authorNames) throws JException {
			
		if(journals.get(journalName)==null) throw new JException();
		if(journals.get(journalName).isAvaible(paperTitle)==false) throw new JException();
		for(String authorName: authorNames)  if(authors.get(authorName)==null) throw new JException();		
		
		Paper paper = new Paper(journals.get(journalName), paperTitle);
		
		for(String authorName: authorNames) {
			paper.newAuthor(authors.get(authorName));
			authors.get(authorName).newPaper(paper);
		}
		
		journals.get(journalName).newPaper(paper);
		papers.put(paperTitle, paper);
		
		return journalName + ":" + paperTitle;
		

	}
	
	/**
	 * gives the number of papers for each journal. 
	 * Journals are sorted alphabetically. 
	 * Journals without papers are ignored.
	 * 
	 * @return the map journal to count of papers
	 */
	public SortedMap<String, Integer> giveNumberOfPapersByJournal () { //serve toMap
		
		return journals.values().stream().
				filter( j -> j.getNumPapers()>0).
				collect(Collectors.toMap(Journal::getName, Journal::getNumPapers, (j1,j2)->j1, TreeMap::new));
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
	
		if(authors.get(authorName)==null) throw new JException();
		
		return authors.get(authorName).getImpactFactor();

	}
	
	/**
	 * groups authors (in alphabetical order) by increasing impact factors.
	 * Authors without papers are ignored.
	 * 
	 * @return the map IF to author list
	 */
	public SortedMap<Double, List<String>> getImpactFactorsByAuthors () {
		
		return authors.values().stream().
				filter(a->a.getNumPapers()>0).
				collect(Collectors.groupingBy(Author::getImpactFactor, TreeMap::new, Collectors.mapping(Author::getName, Collectors.collectingAndThen(Collectors.toList(), list->list.stream().sorted().collect(Collectors.toList())))))
				;

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
		return authors.values().stream().
				filter(a->a.getNumPapers()>0).
				collect(Collectors.toMap(Author::getName, Author::getNumPapers, (a1,a2)->a1, TreeMap::new));
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
		Journal journalWithTheLarhestNumberOfPapers = journals.values().stream().max(Comparator.comparing(Journal::getNumPapers).thenComparing(Comparator.comparing(Journal::getName).reversed())).orElse(null);
		return journalWithTheLarhestNumberOfPapers.getName() + ":" + journalWithTheLarhestNumberOfPapers.getNumPapers();
	}

}

