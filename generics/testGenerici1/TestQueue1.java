package testGenerici1;
import generici1.SimpleQueue1;
import java.util.*;
public class TestQueue1 {
	public static double getSum(SimpleQueue1<? extends Number> q) {
		double sum = 0.0; 
		for (Enumeration<? extends Number> e = q.enumerator(); e.hasMoreElements();) { 
			sum += e.nextElement().doubleValue();
		}
		return sum;}
	public static void main(String[] args) {
		SimpleQueue1<Integer> q1 = new SimpleQueue1<Integer>(3);
		q1.put(1); q1.put(2);
		for (Enumeration<Integer> e = q1.enumerator(); e.hasMoreElements();) { 
			System.out.println(e.nextElement());
		}
		System.out.println(getSum(q1));
		SimpleQueue1<String> q2 = new SimpleQueue1<String>(3);
		q2.put("alfa"); q2.put("beta");
		//System.out.println(getSum(q2));
		//errore The method getSum(SimpleQueue1<? extends Number>) in the type TestQueue1 
		//is not applicable for the arguments (SimpleQueue<String>)
	}
}

