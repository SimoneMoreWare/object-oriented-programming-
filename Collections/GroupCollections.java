package collections;

import java.util.ArrayList;
import java.util.List;

public class GroupCollections {

	public static void main(String[] args) {
		List<Integer> l = new ArrayList<>();

		l.add(42);    // 42 in position 0
		l.add(0, 13); // 42 moved to position 1
		l.set(0, 20); // 13 replaced by 20
		int a = l.get(1);     // returns 42
		System.out.println(a);
		l.add(9, 30); // NO: out of bounds
		l.add(Integer.valueOf(30));    
	}

}
