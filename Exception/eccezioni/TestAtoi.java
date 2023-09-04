package eccezioni;

import static org.junit.Assert.*;

import org.junit.Test;

import eccezioni.Parse.ConversionException;

public class TestAtoi {

	@Test
	public void test() throws ConversionException {  // verifico il caso nominale (senza eccezioni)
		String s = "123";
		
		int i = Parse.atoi(s);
		
		assertEquals(123, i);
	}

	
	@Test(expected=eccezioni.Parse.ConversionException.class)
	public void testEccezione() throws ConversionException  {  // verifico il caso CON  eccezione
		String s = "!23";
		
		int i = Parse.atoi(s);
	}
	// OPPURE
	
	@Test
	public void testEccezioneAssert()  {  // verifico il caso CON  eccezione
		String s = "!23";
		
		assertThrows("Mi aspettavo un'eccezzione per un numero non valido",
					 eccezioni.Parse.ConversionException.class, 
					 () -> Parse.atoi(s) );
	}

}
