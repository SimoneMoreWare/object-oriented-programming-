package journals;

import java.util.LinkedList;
import java.util.List;

public class Author {
	
	private String name;
	private List<Paper> papers = new LinkedList<>();
	
	public Author(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void newPaper(Paper paper) {
		papers.add(paper);
	}

	public double getImpactFactor() {
		
		double res = 0.0;
		
		for(Paper paper: papers) {
			res = res + paper.getJournal().getImpactFactor();
		}
		
		return res;
		
	}
	
	public int getNumPapers() {
		return papers.size();
	}
	


}
