package collezioni;
import java.util.*;
public class Collezioni {

public static int r(int k) {return (int) Math.round(Math.random() * k);}
	public static void main(String[] args) {
		int n = 5;
		//set di stringhe
		System.out.println("set di stringhe");
		Set<String> hs; hs = new HashSet<String>(); 	
		Set<String> ripetuti = new HashSet<String>(); 
		Set<String> hs1; hs1 = new TreeSet<String>();   
		List<String> l = new ArrayList<String>();
		for (int i = 0; i < n; i++) {
			String s = "s" + r(3);
			l.add(s);
			boolean b = hs.add(s); hs1.add(s);
			if (!b) ripetuti.add(s);
		}
		System.out.println(l);  		// es. [s2, s1, s3, s2, s1]
		System.out.println(hs); 		// es. [s2, s1, s3]
		System.out.println(hs1);		// es. [s1, s2, s3]
		System.out.println(ripetuti);	// es. [s2, s1]
		// iterazioni
		// iterazioni su set
		for (String s: hs) System.out.println(s);
		for (Iterator<String> it = hs.iterator(); it.hasNext();) 
			System.out.println(it.next());
			
		//set di Integer
		System.out.println("set di Integer");
		Set<Integer> hi = new HashSet<Integer>();
		for (int i = 0; i < n; i++) hi.add(r(3));
		System.out.println(hi); // es. [2, 1, 3]
		
		// set di Punti
		System.out.println("set di Punti");
		Set<Point> phs = new HashSet<Point>();
		Set<Point> pts = new TreeSet<Point>();
		List<Point> pl = new ArrayList<Point>();
		
		for (int i = 0; i < n; i++) {
			Point p = new Point(r(1), r(1));
			pl.add(p); phs.add(p); pts.add(p);
		}
		System.out.println(pl);  // es. [x = 1 y = 1, x = 1 y = 0, x = 1 y = 0, x = 1 y = 1, x = 1 y = 1]
		System.out.println(phs); // es. [x = 1 y = 1, x = 1 y = 0]
		System.out.println(pts);
			// es. [x = 0 y = 1, x = 0 y = 0, x = 0 y = 0, x = 0 y = 0, x = 0 y = 1]
		 	//     [x = 0 y = 1, x = 0 y = 0]
		  	//     [x = 0 y = 0, x = 0 y = 1]
		
		// iterazioni
		for (Point p: phs) System.out.println(p);
		for (Iterator<Point> it = phs.iterator(); it.hasNext();) 
			System.out.println(it.next());
		
		//liste
		System.out.println("liste");
		List<String> al;
		al = new ArrayList<String>();
		for (int i = 0; i < n; i++) al.add("s" + r(5));
		System.out.println(al); // es. [s4, s1, s4, s3, s1]
		Collections.sort(al); System.out.println(al); // es. [s1, s1, s3, s4, s4]
		for (ListIterator<String> it = al.listIterator(); it.hasNext();) 
			System.out.println(it.next());
		
		for (String s: al) System.out.println(s);
		
		// punti
		Set<Point> ps;
		ps = new HashSet<Point>();
		for (int i = 0; i < n; i++) ps.add(new Point(r(1), r(1)));
		System.out.println(ps); // es. [x = 1 y = 1, x = 0 y = 1, x = 1 y = 0]
		
		System.out.println("lista di punti");
		pl = new ArrayList<Point>(); pl.addAll(ps);
		System.out.println(ps); 
		// sorting per x crescenti
		System.out.println("sorting di punti per x, y crescenti");
		Collections.sort(pl); System.out.println(pl); // es. [x = 0 y = 1, x = 1 y = 0, x = 1 y = 1]
		// sorting per x decrescenti
		System.out.println("sorting di punti per x, y decrescenti");
		PointComparator pc = new PointComparator();
		Collections.sort(pl, pc); System.out.println(pl); // [x = 1 y = 1, x = 0 y = 1, x = 1 y = 0]
		// iterazioni su liste
		for (Point p: pl) System.out.println(p);
		for (ListIterator<Point> it = pl.listIterator(); it.hasNext();) 
			System.out.println(it.next());
		
		
		// mappe
		System.out.println("mappe");
		Map<String, Integer> m;
		m = new HashMap<String, Integer>();
		Map<String, Integer> tm = new TreeMap<String, Integer>(); // ordina sulle chiavi
		for (String s:al) {
			Integer c = m.get(s); m.put(s, (c == null ? 1 : c + 1)); 
			tm.put(s, (c == null ? 1 : c + 1)); 
		}
		System.out.println(m); 	// es. {s5=1, s0=2, s4=1, s3=1}
		System.out.println(tm); // es. {s0=2, s3=1, s4=1, s5=1}
		
//		 mappe Point Integer
		System.out.println("mappe Point Integer");
		pl = new ArrayList<Point>();
		for (int i = 0; i < n; i++) pl.add(new Point(r(1), r(1)));
		System.out.println(pl);
		Map<Point, Integer> pm = new TreeMap<Point, Integer>();
		for (Point p:pl) {
			Integer c = pm.get(p); pm.put(p, (c == null ? 1 : c + 1)); 
			pm.put(p, (c == null ? 1 : c + 1)); 
		}
		System.out.println(pm);	
		
		//op. insiemistiche
		System.out.println("op. insiemistiche");
		hs1 = new TreeSet<String>(); hs1.addAll(al);
		System.out.println(hs1); // es. [s1, s3, s4]
		String[] v = {"s9", "s2", "s3"};
		Set<String> hs2 = new TreeSet<String>(); hs2.addAll(Arrays.asList(v));
		System.out.println(hs2);  // es. [s2, s3, s9]
		hs1.addAll(hs2); System.out.println(hs1); // es. [s1, s2, s3, s4, s9]
		hs1.retainAll(hs2); System.out.println(hs1); // es. [s2, s3, s9]
		hs1.removeAll(hs2); System.out.println(hs1); // es. []
	
		//toArray
		System.out.println("toArray");
		Object[] a1 = hs2.toArray();
		for (Object o: a1) System.out.println(o);
		String[] a2 = new String[hs2.size()];
		hs2.toArray(a2);
		for (String s: a2) System.out.println(s);
		
//		 tree set di punti
		System.out.println("tree set di punti");
		Set<Point> pointSet;
		pointSet = new TreeSet<Point>();
		for (int i = 0; i < n; i++) pointSet.add(new Point(r(1), r(1)));
		System.out.println(pointSet); 
		
	}

}
