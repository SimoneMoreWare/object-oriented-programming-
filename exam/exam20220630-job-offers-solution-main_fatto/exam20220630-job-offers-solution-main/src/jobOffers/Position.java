package jobOffers;
import java.util.*;

class Position {
	String position;
	TreeMap<String, Integer> skillLevelMap = null;
	Position (String position, TreeMap<String, Integer> skillLevelMap) {
		this.position = position; this.skillLevelMap = skillLevelMap;
	}
	
	int getAverageLevel () {
		return skillLevelMap.values().stream()
				.mapToInt(v -> v).sum() / skillLevelMap.size();
	}
	Integer getLevel (String skill) {
		return skillLevelMap.get(skill);
	}
}
