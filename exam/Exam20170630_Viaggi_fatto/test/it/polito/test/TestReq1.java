package it.polito.test;
import junit.framework.TestCase;
import java.util.*;
import proposals.*;

public class TestReq1 extends TestCase {
	ProposalHandling ph = new ProposalHandling();

	public void testAddUsers() throws Exception {
		try{	
			int n = ph.addUsers("john","mary","ann","bob","ted","lucy");
			assertEquals(6,n);
		}catch(Exception e){
			fail("no exception must be thrown");
		}
	}
	
	public void testOprDuplicated() {
		try {
			ph.addOperator("opr1","london","rome");
			ph.addOperator("opr5","berlin","rome","madrid");
			ph.addOperator("opr1","paris","lisbon");
			fail("operator duplicated");
		} catch (ProposalException e) {}
	}
	
	public void testGetDestOperators() {
		try {
			ph.addOperator("opr1","london","rome", "lisbon");
			ph.addOperator("opr5","berlin","rome","madrid", "lisbon");
			ph.addOperator("opr2","paris","lisbon");
		} catch (ProposalException e) {
			fail("no exception must be thrown");
			return;
		}
		List<String> list = ph.getDestOperators("lisbon"); 
		String s = "[opr1, opr2, opr5]";
		assertNotNull(list);
		assertTrue(list.toString().equals(s));
	}
		
}
