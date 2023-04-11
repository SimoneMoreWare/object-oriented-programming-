package inheritance.observer;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestOsservatori {

	@Test
	public void testFormula() {
		
		Valore v1 = new Valore(10.0);
		Valore v2 = new Valore(32.0);
		
		Formula f = new Formula('+',v1,v2);
		
		assertEquals(10.0, v1.getValore(), 0.001);
		assertEquals(32.0, v2.getValore(), 0.001);
		assertEquals(42.0, f.getValore(), 0.001);
		
		v1.setValore(100.0);
		assertEquals(132.0, f.getValore(), 0.001);
		
	}

	
	@Test
	public void testDoppiaFormula() {
		
		Valore v1 = new Valore(10.0);
		Valore v2 = new Valore(32.0);
		Valore v3 = new Valore(-60.0);
		
		Formula f = new Formula('+',v1,v2);
		Formula f2 = new Formula('+',v1,v3);
		
		assertEquals(10.0, v1.getValore(), 0.001);
		assertEquals(32.0, v2.getValore(), 0.001);
		assertEquals(42.0, f.getValore(), 0.001);
		assertEquals(-50.0, f2.getValore(), 0.001);
		
		v1.setValore(100.0);
		assertEquals(132.0, f.getValore(), 0.001);
		assertEquals(40.0, f2.getValore(), 0.001);
		
	}

}
