package base;

public class StackOfIntNested {
	private static class Element {
		int value;
		Element next;

		Element(int value, Element next) {
			this.value = value;
			this.next = next;
		}
	}

	private Element head;

	public void push(int v) {
		head = new Element(v, head);
	}

	public int pop() {
		int value = head.value;
		head = head.next;
		return value;
	}
	
	//----------
	// Example
	
	public static void main(String[] args) {
		StackOfIntNested stack = new StackOfIntNested();
		
		stack.push(1);
		stack.push(2);
		stack.push(4);
		
		System.out.println(stack.pop());
	}
}
