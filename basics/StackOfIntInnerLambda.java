package base;

public class StackOfIntInnerLambda {
	interface Element {
		int pop();
	}

	private Element head;

	public void push(final int v) {
		final Element prev=head;
		head = () -> {
			head = prev;
			return v;
		};
	}

	public int pop() {
		return head.pop();
	}
	
	//----------
	// Example
	
	public static void main(String[] args) {
		StackOfIntInnerLambda stack = new StackOfIntInnerLambda();
		
		stack.push(1);
		stack.push(2);
		stack.push(4);
		
		System.out.println(stack.pop());
	}
}
