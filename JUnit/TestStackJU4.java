package junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestStackJU4 {

	@Test
	public void testStack() throws StackException {
		Stack aStack = new Stack();
		
		assertTrue("Stack should be empty",
						aStack.isEmpty());
		
		aStack.push(10);
		
		assertFalse("Stack should not be empty!",
						aStack.isEmpty());
		
		aStack.push(-4);
		
		assertEquals(-4, aStack.pop());
		assertEquals(10, aStack.pop());
	}
	
	@Test
	public void testEmptyErrorAssert() {
		Stack aStack = new Stack();
		
		assertThrows("Expected exception when popping and empty stack",
					 StackException.class,
					 ()-> aStack.pop());
	}


	@Test(expected=StackException.class)
	public void testEmptyErrorExpected() throws StackException {
		Stack aStack = new Stack();
		
		aStack.pop();
	}
}
