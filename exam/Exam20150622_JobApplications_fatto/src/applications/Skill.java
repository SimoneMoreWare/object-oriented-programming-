package applications;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


public class Skill {

	private String name;
	private List<Position> positions = new LinkedList<>();
	private List<Applicant> applicants = new LinkedList<>();
	
	public Skill(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public List<Position> getPositions() {
		return positions.stream().sorted(Comparator.comparing(Position::getName)).collect(Collectors.toList());
	}

	public void setPositions(List<Position> positions) {
		this.positions = positions;
	}
	public void newPosition(Position position) {
		positions.add(position);
	}

	public List<Applicant> getApplicants() {
		return applicants;
	}

	public void setApplicant(List<Applicant> applicants) {
		this.applicants = applicants;
	}
	public void newApplicant(Applicant applicant) {
		applicants.add(applicant);
	}
}