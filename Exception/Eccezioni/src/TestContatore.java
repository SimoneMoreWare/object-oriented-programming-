import junit.framework.TestCase;


public class TestContatore extends TestCase {

	
	public void testCondizioneNominale() throws LimiteInferioreRaggiuntoException {
		
		Contatore c = new Contatore();
		
		c.incrementa();
		
		c.decrementa();
//		try{
//			c.decrementa();
//			
//			// se passo di qui va tutto bene!
//		}catch(LimiteInferioreRaggiuntoException e){
//			fail("E' stata generate un'eccezione non attesa");
//			// se passo di qui NON va bene!
//		}
		
	}


	public void testCondizioneAnomala(){
		
		Contatore c = new Contatore();
				
		try{
			c.decrementa();

			fail("NON e' stata generata un'eccezione attesa");
			// se passo di qui NON va bene!
		
		}catch(LimiteInferioreRaggiuntoException e){
			// se passo di qui va tutto bene!
		}
		
	}
}
