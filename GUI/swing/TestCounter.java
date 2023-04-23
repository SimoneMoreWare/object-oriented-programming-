package swing;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCounter {

	@Test
	public void test() {
		Counter model = new Counter();
		Controller ctrl = new Controller(model);
		View view = new View(model,ctrl);
		
		assertEquals("Initially should be 0",
					 "0", view.value.getText());
		
		view.plus.doClick();
		view.plus.doClick();
		view.plus.doClick();
		assertEquals("Wrong value",
				 	"3", view.value.getText());
		
		view.minus.doClick();
		assertEquals("Wrong value",
			 	"2", view.value.getText());
	}

}
