package base;

public class NestedExamples {
	int attribute;
	
	static class Nested { 
		void m() { /* attribute++; // not allowed */ }
	}
	
    class Inner {
		void m() { attribute++; /* OK */  }
    }
	
	public static void main(String[] args) {
		
		new Nested();

//		new Inner(); // ERROR: no enclosing object
		
		NestedExamples object = new NestedExamples();
		
		object.new Inner(); // OK: new is qualified with object
		
		class NestedLocal { /* implicitly static since declared in static method */
			void m() { /* attribute++; // not allowed */ }
		}
		
		NestedLocal nl = new NestedLocal();
		
		Cloneable anonymousLocalNested =  new Cloneable() { /* implicitly static since declared in static method */
			void m() { /* attribute++; // not allowed: static nested class */ }
		};

	}
	
	public void method() {
		
		new Nested();

		new Inner(); // OK: within enclosing object
		// EQUIVALENT TO
		this.new Inner();
		
		class InnerLocal {
			void m() { attribute++; }
		}
		
		InnerLocal il = new InnerLocal();
	
// 		nl = this.new InnerLocal(); // not allowed: this class has method scope only
		
		Cloneable anonymousInner =  new Cloneable() {
			void m() { attribute++; }
		};
	}

}
