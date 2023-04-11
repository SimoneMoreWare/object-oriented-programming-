package nested;

import static org.junit.Assert.*;

import org.junit.Test;

import nested.Lista.Iteratore;

public class TestList {

	@Test
	public void testEmpty() {
		// una lista non appena creata è vuota
		Lista l = new Lista();
		
		boolean vuota = l.vuota();
		
		
		assertTrue( vuota );
	}

	@Test
	public void testNotEmpty() {
		// una lista con un element non è vuota
		Lista l = new Lista();
		l.aggiungi(1);
		
		assertFalse( l.vuota() );
		
	}

	@Test
	public void testIteratore() {
		// una lista con un element non è vuota
		Lista l = new Lista();
		l.aggiungi(1);
		
		Iteratore it = l.iteratore();
		
		assertNotNull(it);
		assertTrue(it.hasNext());
		
		it.prossimo();
		
		int elemento = it.getValore();
					// 1; messaggio da stampare per fallimento     atteso  effettivo
		assertEquals("Il valore restituito dall'iteratore è errato", 1, elemento);
		
		assertFalse(it.hasNext());
	}

}
