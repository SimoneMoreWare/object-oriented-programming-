package generici;
public class TestBox {
	public static void main(String[] args) {
	Box<Integer> b1 = new Box<Integer>();
	Box<String> b2 = new Box<String>();
	System.out.println(b1.toString()); //generici.Box@19821f senza toString
	System.out.println(b1.put(10)); //true
	System.out.println(b1.toString());
	//System.out.println(b1.get()); //10
	//Integer i1 = b1.get();
	System.out.println(b2.put("alfa")); //true
	System.out.println(b2.put("beta")); //false
	System.out.println(b2.get()); //alfa
	}
}
