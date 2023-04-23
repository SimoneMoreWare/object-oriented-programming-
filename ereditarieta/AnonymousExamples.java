package inheritance;

public class AnonymousExamples {
	int a;
	static int s;
	
	interface Iface {
		int im();
	}
	
	// member anonymous inner class (initialized on outer object creation)
	Iface maic = new Iface() {
		public int im() { return a; }
	};

	// member anonymous nested class (initialized on class load)
	static Iface manc = new Iface() {
		public int im() { return s; }
	};

	public static void main(String[] args) {
		int l=0;
		
		// anonymous local nested class
		Iface lanc = new Iface() {
			public int im() { return l; }
		};
		
		lanc.im();
				
		System.out.println("LANC: " + lanc.getClass());
		System.out.println("MANC: " + manc.getClass());
		
	}

	public void m(int p) {
		int l=0;
		// anonymous local inner class
		Iface alic = new Iface() {
			public int im() { 
				return l+p;
			}
		};
		
		alic.im();
	}

}
