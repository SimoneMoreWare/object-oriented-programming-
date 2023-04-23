package junit;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestStackJU5 {

	 @Test
	 public void testStack() throws StackException{
		Stack aStack = new Stack();
		
		assertTrue(aStack.isEmpty(),
						"Stack should be empty");
		
		aStack.push(10);
		assertFalse(aStack.isEmpty(),
						"Stack should not be empty!");
		
		aStack.push(-4);
		assertEquals(-4, aStack.pop());
		assertEquals(10, aStack.pop());
	 }

}
