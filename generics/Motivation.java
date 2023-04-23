package generics;

@SuppressWarnings("unused")
public class Motivation {
	static class Pair {
		Object a, b;
		public Pair(Object a, Object b ) 
		{	this.a=a; this.b=b; }
		Object first(){ return a; }
		Object second(){ return b; }
	}

	public static void main(String[] args) {
		Pair sp = new Pair("One", "Two");
		Pair ip = new Pair(1,2);

		String a = (String) sp.second();
		int i = (Integer) ip.first();

		String b;
		try {
			b = (String) ip.second();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Object o = ip.second();
		if(o instanceof String){
			b = (String) ip.second();
		}else { 
			System.err.println("Error: it is not a String!");
		}

		
		Pair mixpair = new Pair(1,"Two");
		Pair pairmix = new Pair("One",2);

		o = mixpair.second();
		if(o instanceof Integer){
			i = (Integer)o;
		}else { 
			System.err.println("Error: it is not an Integer!");
		}

	}

}
