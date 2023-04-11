package generici;
public class TestQueue {
	public static void main(String[] args) {
		SimpleQueue<Integer> q1 = new SimpleQueue<Integer>(3);
		q1.put(1); q1.put(2);
		System.out.println(q1);
		System.out.println(q1.get()); //1
		SimpleQueue<String> q2 = new SimpleQueue<String>(3);
		q2.put("alfa"); q2.put("beta");
		System.out.println(q2.get()); //alfa
		System.out.println(q2.size()); //1
	}
}
