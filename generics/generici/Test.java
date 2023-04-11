package generici;
import java.util.*;
public class Test {
public static String getStackInfo(SimpleStack<?> s) {
	return s.getName() + " " +s.getContents();}
public static double getSum(SimpleStack<? extends Number> s) {
	double sum = 0.0; 
	for (int i = 0; i < s.size(); i++) sum += s.get(i).doubleValue();
	return sum;}
public static void main(String[] args) {
SimpleStack<Integer> stack1 = new SimpleStack<Integer>("stack1");
stack1.push(1); stack1.push(2);
System.out.println(stack1.getContents());//[1, 2]
SimpleStack<String> stack2 = new SimpleStack<String>("stack2");
stack2.push("alfa"); stack2.push("beta");
System.out.println(getStackInfo(stack1)); //stack1 [1, 2]
System.out.println(getStackInfo(stack2));//stack2 [alfa, beta]
System.out.println(getSum(stack1)); //3.0
// System.out.println(getSum(stack2)); // produce l'errore di compilazione seguente
// The method getSum(SimpleStack<? extends Number>) in the type Test is not applicable for the arguments (SimpleStack<String>)
System.out.println(stack2.getMax()); // beta
System.out.println(stack1.getClass() == stack2.getClass()); // true Il codice di SimpleStack è uno solo
// Il codice di SimpleStack è uno solo; da un punto di vista impl. stack1 e stack2 appartengono alla stessa classe
// E non può apparire in dichiarazioni statiche
String[] a1 = new String[3];
System.out.println(Arrays.toString(stack2.toArray(a1))); // [alfa, beta, null]
Object[] a2 = new Object[1];
System.out.println(Arrays.toString(stack2.toArray(a2))); // [alfa]
}
}
