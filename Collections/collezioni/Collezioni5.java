package collezioni;
import java.util.*;
public class Collezioni5 {
	public static void main(String[] args) {
		PointComparator1 pc = new PointComparator1();
		Set<Point> pts = new TreeSet<Point>(pc);
		pts.add(new Point(10,20)); pts.add(new Point(10,20));
		System.out.println(pts);
		ArrayList<Point> l1 = new ArrayList<Point>(pts);
		l1.add(1, new Point(15,25));
		System.out.println(l1);
		Collections.sort(l1, pc);
		System.out.println(l1);
	}

}
