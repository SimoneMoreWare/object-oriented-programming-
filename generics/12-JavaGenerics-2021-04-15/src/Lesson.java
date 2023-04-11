
public class Lesson {

	static public <T> void printCoppia (GPair<T> a) {
		System.out.println (a.first()+" "+a.second());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Pair sp = new Pair ("One", "Two");
		Pair ip = new Pair (1,2);
		
		Object o1 = sp.first();
		String s1 = (String) sp.first();
		
		//String s2 = (String) ip.first();
		int i = (Integer) ip.second();
		
		Pair mixpair = new Pair (1, "Two");
		Pair pairmix = new Pair ("One", 2);
		
		o1 = mixpair.second();
		Object o2 = mixpair.first();
		if (o1 instanceof Integer && o2 instanceof Integer) {
			System.out.println ("Coppia di stesso tipo");
		} else {
			System.out.println ("Coppia divera");
		}
		
		GPair<String> gps = new GPair<>("One","Two");
		GPair<Integer> gpi = new GPair<>(1,2);
		
		//GPair<String>  mixedgp = new GPair<>("One",2);
  		
		// No downcasting
		String gps1 = gps.first();
		String gps2 = gps.second();
		
		printCoppia(gps);
		
	}

}
