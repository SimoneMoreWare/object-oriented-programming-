package gui.traduttore;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestTraduttore {
	ViewCtrl view;

	@Before
	public void setUp() {
		Model m = new Model();
		view = new ViewCtrl(m);
	}
	
	@After
	public void tearDown() {
		view.setVisible(false);
		view.dispose();
	}
	
	@Test
	public void test() throws InterruptedException {
		
		view.parola.setText("Gatto");
		view.pulsante.doClick();
		
		Thread.sleep(100);  // evita test FLAKY
		
		String traduzione = view.traduzione.getText();
		
		assertEquals("Cat",traduzione);
	}

}
