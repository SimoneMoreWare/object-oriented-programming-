package inheritance;

public class AnonymousExamplesClone {
	int a;
	static int s;
	
	interface Iface extends Cloneable {
		int im();
		Object clone() throws CloneNotSupportedException;
	}
	
	// member anonymous inner class (initialized on outer object creation)
	Iface maic = new Iface() {
		public int im() { return a; }
		public Object clone() throws CloneNotSupportedException {return super.clone(); }
	};

	// member anonymous nested class (initialized on class load)
	static Iface manc = new Iface() {
		public int im() { return s; }
		public Object clone() throws CloneNotSupportedException {return super.clone(); }
	};

	public static void main(String[] args) throws CloneNotSupportedException {
		int l=0;
		
		// anonymous local nested class
		Iface lanc = new Iface() {
			public int im() { return l; }
			public Object clone() throws CloneNotSupportedException {return super.clone(); }
		};
		
		lanc.im();
				
		
		AnonymousExamplesClone obj = new AnonymousExamplesClone();
		
		System.out.println("MAIC: " + obj.maic.getClass());
		System.out.println("MANC: " + manc.getClass());
		System.out.println("LANC: " + lanc.getClass());
		
		Iface lancClone = (Iface) lanc.clone();
		System.out.println("LANC clone: " + lancClone.getClass());

		obj.m(42);
	}

	public void m(int p) {
		int l=0;
		// anonymous local inner class
		Iface laic = new Iface() {
			public int im() { 
				return l+p;
			}
			public Object clone() throws CloneNotSupportedException {return super.clone(); }
		};
		
		System.out.println("LAIC: " + laic.getClass());

		
		laic.im();
	}

}
