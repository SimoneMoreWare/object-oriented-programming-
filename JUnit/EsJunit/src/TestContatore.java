import junit.framework.TestCase;


public class TestContatore extends TestCase {
	
	public void testInizializzazione(){
		
		Contatore c = new Contatore();
		
		
//		assertEquals( 0, // valore atteso
//					  c.getValore() // valore effettivo
//				);

		assertEquals( "Contatore non inizializzato correttamente", 
					0, // valore atteso
				  c.getValore() // valore effettivo
			);
		
		System.out.println("OK");

	}
	
	public void testIncremento(){
		
		Contatore c = new Contatore();
		
		c.incrementa();
		
		//assertEquals(1,c.getValore());
		assertTrue("Mi aspettavo 1 invece ho ottenuto " + c.getValore(),
				c.getValore() == 1 );
	}

}
