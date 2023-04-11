package collezioni;
import java.util.*;
public class Collezioni3 {
	public static void main(String[] args) {
		List<String> l1 = new ArrayList<String>(); 	
		Collections.addAll(l1, "beta", "alfa", "delta");
		System.out.println(l1);
		System.out.println(Collections.binarySearch(l1, "beta")); // 1

		List<Object> l1a = new ArrayList<Object>();
		l1a.add("alfa"); l1a.add(10);
		l1.removeAll(l1a);
		System.out.println(l1);
		
		Collections.sort(l1);
		System.out.println(l1); // [alfa, beta, delta]
		
		
		//descending order
		Comparator<String> comp = new Comparator<String>() {
			public int compare(String s1, String s2) {
				return s2.compareTo(s1);
			}
		};
		Collections.sort(l1,comp);
		System.out.println(l1); // [delta, beta, alfa]
		System.out.println(Collections.binarySearch(l1, "beta")); // 1
		System.out.println(Collections.binarySearch(l1, "gamma")); // -4
		System.out.println(Collections.max(l1)); // delta
		System.out.println(Collections.frequency(l1, "alfa")); // 1
		Collections.shuffle(l1, new Random());
		List<Point> l2 = new ArrayList<Point>();
		l2.add(new Point(10,20)); l2.add(new Point(15,25));
		l2.add(new Point(5,25));  l2.add(new Point(15,30));
		Collections.sort(l2);
		System.out.println(l2); 
		// [x = 5 y = 25, x = 10 y = 20, x = 15 y = 25, x = 15 y = 30]
		System.out.println(Collections.binarySearch(l2, new Point(10,20))); // 1
		PointComparator comp1 = new PointComparator();
		Collections.sort(l2, comp1);
		System.out.println(l2); 
		// [x = 15 y = 30, x = 15 y = 25, x = 10 y = 20, x = 5 y = 25]
		System.out.println(Collections.binarySearch(l2, new Point(10,20), comp1)); // 2
	}
}
