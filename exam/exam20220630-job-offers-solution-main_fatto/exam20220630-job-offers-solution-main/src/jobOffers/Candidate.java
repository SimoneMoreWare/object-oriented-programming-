package jobOffers;
import java.util.*;

class Candidate {
	String name;
	Set<String> skills = new TreeSet<> ();
	Candidate (String name, Set<String> skills) {
		this.name = name; this.skills = skills;
	}
	
	TreeMap<String, Integer> skillsRatingsMap;
	
	int getAverageRating () {
		return skillsRatingsMap.values().stream()
				.mapToInt(v -> v).sum() / skillsRatingsMap.size();
	}
	
	TreeMap<String, Integer> getSkillsRatingsMap() {
		return skillsRatingsMap;
	}
	String winnerOf = null;
}