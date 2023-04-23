package collections;

import java.util.Map;
import java.util.TreeMap;

public class MapIdioms {

	public static void main(String[] args) {
		Map<String,String> map = new TreeMap<>();
		
		map.put("dog", "a domesticated carnivorous mammal that typically has a long snout, an acute sense of smell, non-retractable claws, and a barking, howling, or whining voice");
		map.put("cat", "a small domesticated carnivorous mammal with soft fur, a short snout, and retractable claws");
		map.put("pig", "an omnivorous domesticated hoofed mammal with sparse bristly hair and a flat snout for rooting in the soil, kept for its meat");

		String key = "cat";
		{
			String val = map.get(key);
			if( val == null ) {
				// not found
			}
		}
		// OR
		{
			if( ! map.containsKey(key)) {
				// not found
			}
			String val = map.get(key);
			
			System.out.println(val);
		}
		
		
	}

}
