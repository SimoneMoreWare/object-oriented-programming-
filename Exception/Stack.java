package exceptions;

import java.util.Arrays;

public class Stack{
	int[] theStack = new int[10];
	int size=0;

	public int pop() throws EmptyStack { 
		if(size == 0) {
			EmptyStack e = new EmptyStack();
			throw e;
		}
		return theStack[--size];
	}

	public void push(int value) {
		if(size==theStack.length) {
			theStack = Arrays.copyOf(theStack, size*2);
		}
		theStack[size++] = value;
	}
}
