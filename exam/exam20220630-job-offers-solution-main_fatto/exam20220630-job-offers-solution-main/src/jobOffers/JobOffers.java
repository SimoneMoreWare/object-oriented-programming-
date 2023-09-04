package jobOffers; 
import java.util.*;
import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

public class JobOffers  {

TreeSet<String> skillsColl = new TreeSet<>();
TreeMap<String, Position> positionsColl = new TreeMap<>();
TreeMap<String, Candidate> candidatesColl = new TreeMap<>();
TreeMap<String, Consultant> consultantsColl = new TreeMap<>();
List<Application> applications = new ArrayList<>();
TreeMap<String, Rating> ratingsMap = new TreeMap<>(); //candidate -> rating


//R1
	public int addSkills (String... skills) {
		for (String skill:skills) skillsColl.add(skill);
		return skillsColl.size();
	}
	
	public int addPosition (String position, String... skillLevels) throws JOException {
		if (positionsColl.containsKey(position)) throw new JOException ("duplicated position");
		TreeMap<String, Integer> skillLevelMap = new TreeMap<>();
		for (String skillLevel: skillLevels) {
			String[] elements = skillLevel.split(":");
			String skill = elements[0]; 
			int level = Integer.parseInt(elements[1]);
			if (! skillsColl.contains(skill)) throw new JOException ("skill not found");
			if (level < 4 || level > 8) throw new JOException ("wrong level");
			skillLevelMap.put(skill, level);
		}
		Position p = new Position(position, skillLevelMap);
		positionsColl.put(position, p);
		return p.getAverageLevel();
	}
	
//R2	
	public int addCandidate (String name, String... skills) throws JOException {
		List<String> skillsList = new ArrayList<String> (Arrays.asList(skills));
		if (candidatesColl.containsKey(name)) throw new JOException ("duplicated candidate " + name);
		if (! skillsColl.containsAll(skillsList)) throw new JOException ("unknown skills in addCandidate " + name);
		Candidate c = new Candidate(name, new TreeSet<String> (skillsList));
		candidatesColl.put (name, c);
		return skills.length;
	}
	
	public List<String> addApplications (String candidate, String... positions) throws JOException {
		if (! candidatesColl.containsKey(candidate)) throw new JOException ("unknown candidate " + candidate);
		Candidate c = candidatesColl.get(candidate);
		List<String> positionsList = new ArrayList<String> (Arrays.asList(positions));
		if (! positionsColl.keySet().containsAll(positionsList)) throw new JOException ("unknown positions"); 
		for (String position: positions) {
			if (! c.skills.containsAll(positionsColl.get(position).skillLevelMap.keySet()))
				throw new JOException ("candidate does not have all the required skills " + candidate + " " 
						+ c.skills + " " + positionsColl.get(position).skillLevelMap.keySet());
		}
		for (String position: positions) applications.add (new Application(candidate, position));
		List<String> list = new ArrayList<>();
		for (String position: positions) {
			list.add(candidate + ":" + position);
		}
		Collections.sort(list);
		return list;
	} 
	
	public TreeMap<String, List<String>> getCandidatesForPositions() {
		TreeMap<String, List<String>> map = applications.stream()
		.sorted (comparing(Application::getCandidate))
		.collect(groupingBy (Application::getPosition, TreeMap::new, 
				mapping(Application::getCandidate, toList())));
		//System.out.println(map);
		return map;
	}
	
	
//R3
	public int addConsultant (String name, String... skills) throws JOException {
		List<String> skillsList = new ArrayList<String> (Arrays.asList(skills));
		if (consultantsColl.containsKey(name)) throw new JOException ("duplicated consultant " + name);
		if (! skillsColl.containsAll(skillsList)) throw new JOException ("unknown skills in addConsultant " + name);
		Consultant c = new Consultant(name, new TreeSet<> (skillsList));
		consultantsColl.put (name, c);
		return skills.length;
	}
	
	public Integer addRatings (String consultant, String candidate, String... skillRatings)  throws JOException {
		if (! candidatesColl.containsKey(candidate)) throw new JOException ("unknown candidate " + candidate);
		if (! consultantsColl.containsKey(consultant)) throw new JOException ("unknown consultant " + consultant);
		Candidate candidateObj = candidatesColl.get(candidate);
		Consultant consultantObj = consultantsColl.get(consultant);
		if (! consultantObj.skills.containsAll(candidateObj.skills)) throw new JOException 
			("consultant's skills do not include candidate's skills " + consultant + " " + candidate);
        TreeMap<String, Integer> skillsRatingsMap = new TreeMap<>();
		for (String skillRating: skillRatings) {
			String[] elements = skillRating.split(":");
			String skill = elements[0]; 
			int rating = Integer.parseInt(elements[1]);
			if (rating < 4 || rating > 10) throw new JOException ("wrong rating");
			skillsRatingsMap.put(skill, rating);
		}
		//check whether skills rated are the same as the skills of the candidate
		if (! skillsRatingsMap.keySet().containsAll(candidateObj.skills)) throw new JOException ("some skills not rated");

		candidateObj.skillsRatingsMap = skillsRatingsMap;
		return candidateObj.getAverageRating();
	}
	
//R4
	public List<String> discardApplications() {
		List<String> discardedApps = new ArrayList<>();
		TreeMap<String, Integer> skillsRatingsMap;
		for (Application app: applications) { //candidate position
			//TreeMap<String, Integer> skillLevelMap = positionsColl.get(app.position).skillLevelMap;
			Candidate candidateObj = candidatesColl.get(app.candidate);
			skillsRatingsMap = candidateObj.skillsRatingsMap;
			if (skillsRatingsMap == null) {
				//System.out.println ("no ratings for candidate " + app.candidate);
				discardedApps.add(app.candidate + ":" + app.position);
			}
			else {
				//System.out.println ("ratings for candidate " + app.candidate + " " + skillsRatingsMap);
				Position p = positionsColl.get(app.position);
				for (String skillNeeded: p.skillLevelMap.keySet()) {
					int level = p.skillLevelMap.get(skillNeeded);
					int rate = skillsRatingsMap.get(skillNeeded);
					//System.out.println(app.candidate + " " + skillNeeded + " rating and level " + rate + " " + level);

					if (rate < level) {
						discardedApps.add(app.candidate + ":" + app.position);
					}
				}
			}
		
		}
		
		Collections.sort(discardedApps);
		//
		//System.out.println ("discardedApps " + discardedApps);
		return discardedApps;
	}
	
	 
	public List<String> getEligibleCandidates(String position) {
		List<String> candidateWinners = new ArrayList<>();
		Position p = positionsColl.get(position);
		//TreeMap<String, Integer> levels = p.skillLevelMap;
		for (Application app: applications) {
			if (app.getPosition().equals(position)) {
				String candidate = app.getCandidate();
				Candidate candidateObj = candidatesColl.get(candidate);
				int negative = 0;
				TreeMap<String, Integer> skillsRatingsMap = candidateObj.skillsRatingsMap; 
				if (skillsRatingsMap == null) negative -= 1;
				else {
					for (String skillNeeded: p.skillLevelMap.keySet()) {
						int level = p.skillLevelMap.get(skillNeeded);
						int rate = skillsRatingsMap.get(skillNeeded);
						if (rate < level) negative -= 1;
					}
				}
				if (negative == 0) candidateWinners.add(candidate);
			}
		}
		Collections.sort(candidateWinners);
		return candidateWinners;
	}
	

	
}

		
