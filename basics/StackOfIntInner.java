package base;

public class StackOfIntInner {
	private class Element {
		int value;
		Element next;

		Element(int value) {
			this.value = value;
			this.next = head;
			head = this;
		}
		int pop() {
			head = next;
			return value;
		}
	}

	private Element head;

	public void push(int v) {
		new Element(v);
	}

	public int pop() {
		return head.pop();
	}
	
	//----------
	// Example
	
	public static void main(String[] args) {
		StackOfIntInner stack = new StackOfIntInner();
		
		stack.push(1);
		stack.push(2);
		stack.push(4);
		
		System.out.println(stack.pop());
	}
}
