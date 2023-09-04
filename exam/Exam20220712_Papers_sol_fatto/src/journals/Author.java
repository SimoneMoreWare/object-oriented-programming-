package journals;

import java.util.SortedMap;
import java.util.TreeMap;

public class Author {
	String name;

	SortedMap<String, Journal> journals = new TreeMap<String, Journal>();
	SortedMap<String, Paper> papers = new TreeMap<String, Paper>();
	
	public Author( String name) {
		this.name = name;
	}
	
	public void addJournal(String paperTitle,Journal journal){
		journals.put(paperTitle, journal);
	}

	public void addPaper(Paper paper){
		if(!papers.containsKey(paper.paperTitle)) {
		    papers.put(paper.paperTitle, paper);
		}
	}
	
	public double getImpactFactor() {
		return journals
				.values()
				.stream()
				.mapToDouble(j-> j.impactFactor).sum();
	}
	
	public int getNumberOfPapers() {
		return papers.size(); 
	}

}
