package journals;

import java.util.SortedMap;
import java.util.TreeMap;

public class Journal {
    String name;
	double impactFactor;
	
	SortedMap<String, Paper> papers = new TreeMap<String, Paper>();
	
	public Journal( String name, double impactFactor) {
		this.name = name;
		this.impactFactor = impactFactor;
	}
	
	public void addPaper(Paper paper) throws JException {
		if(papers.containsKey(paper.paperTitle)) {
			throw new JException("dup paper");
		}
		else {
			papers.put(paper.paperTitle, paper);
		}
	}
	
	public double getImpactFactor() {
		return impactFactor;
	}
	
	public int getNumberOfPapers() {
		return papers.size();
	}

}
