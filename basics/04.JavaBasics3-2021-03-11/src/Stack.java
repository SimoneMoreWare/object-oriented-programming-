
public class Stack {
	
	public static class Element {
		private int value;
		private Element next;
		
		public Element (int v) {
			value = v;
		}
		public int getValue() {
			return value;
		}
		
		public void setNext(Element e) {
			next = e;
		}
	}
	
	private Element top;
	
	public void push (int v) {
		Element n = new Element(v);
		n.setNext(top);
		top = n;
	}
	
	public int pop() {
		Element n = top;
		top = top.next;
		return n.getValue();
	}
}
