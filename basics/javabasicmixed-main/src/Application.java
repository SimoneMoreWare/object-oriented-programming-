
public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		//WRAPPER CLASSES
		
		// FLOW N. 1
				// 1. PRIMITIVE DATA TYPE DECLARATIOM
		int i = 500;
		// 2. Converting primitive dt into String
		String s = String.valueOf(i);
		System.out.println(s);
		
		// 3.1 Converting string into wrapper class
		
		Integer i1 = Integer.valueOf(s);
		// 3.2 Converting string into wrapper class
		
		Integer i2 = new Integer(s);
		
		// 4. Convert a wrapper class into primitive type
		
		int i3  = i1.intValue() ;
		
		
		
		// FLOW 2
		
		int a = 500;
		
		// 1. convert primitive data type into wc
		
		Integer b1 = new Integer (a);
		
		Integer b2= Integer.valueOf(a);
		
		// 2. convert a wrapper class to string
		
		String s2 = b1.toString();
		
		// 3. Convert string to primitive method
		
		int b3 = Integer.parseInt(s2);
		
		
		
		Counter c = new Counter(5);
		/*c.increment();
		c.print();
		c.reset();
		c.print();*/
		
		c.increment().print().reset().print();
		
		Stack st = new Stack();
		
		st.push(5);
		st.push(4);
		st.push(3);
		
		System.out.println (st.pop());
		System.out.println (st.pop());
		System.out.println (st.pop());
		
		
		
	}

}
