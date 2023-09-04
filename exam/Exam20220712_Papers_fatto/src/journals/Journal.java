package journals;

import java.util.LinkedList;
import java.util.List;

public class Journal {
	
	private String name;
	private double impactFactor;
	private List<Paper> papers = new LinkedList<>();
	
	public Journal(String name, double impactFactor) {
		super();
		this.name = name;
		this.impactFactor = impactFactor;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getImpactFactor() {
		return impactFactor;
	}
	public void setImpactFactor(double impactFactor) {
		this.impactFactor = impactFactor;
	}
	
	public boolean isAvaible(String paperTitle) {
		
		for(Paper paper: papers) {
			if(paper.getTitle().equals(paperTitle)) return false;
		}
		
		return true;
		
	}
	
	public void newPaper(Paper paper) {
		papers.add(paper);
	}
	
	public int getNumPapers() {
		return papers.size();
	}
}
