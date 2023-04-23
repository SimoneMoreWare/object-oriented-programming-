package junit;

public class Stack {
	private int[] stack; 
	private int next = 0;
	
	public Stack(){ this(10);}
	
	public Stack(int size){ stack = new int[size];}
	
	public boolean isEmpty(){ return next==0; }
	
	public boolean push(int i) {
	  if(next==stack.length) return false;
	  stack[next++] = i;
	  return true;	
	}
	
	public int pop() throws StackException { 
		if(next==0) throw new StackException("Stack empty: cannot pop.");
		return stack[--next];
	}
}
