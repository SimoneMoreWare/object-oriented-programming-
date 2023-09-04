package it.polito.test;
import junit.framework.TestCase;

import java.util.*;

import proposals.*;

public class TestReq3 extends TestCase {
	ProposalHandling ph = new ProposalHandling();
	protected void setUp() throws Exception {
		super.setUp();
		try{	
			ph.addUsers("john","bob","ted","lucy");
			ph.addOperator("opr1","london","rome", "lisbon");
			ph.addOperator("opr5","berlin","rome","madrid", "lisbon");
			ph.addOperator("opr4","paris","london");
			ph.addOperator("opr2","paris","rome");
			ph.addOperator("opr6","lisbon","rome");
			//ph.newProposal("p1", "london");
			//ph.newProposal("p2", "paris");
			//ph.newProposal("p3", "lisbon");
		}catch(Exception e){
			fail("no exception must be thrown");
		}
	}
	
	public void testSetOperators() throws ProposalException {
			Proposal p3 = ph.newProposal("p3", "lisbon");
			assertNotNull(p3);
			List<String> list = p3.setOperators("opr1", "opr4","opr2", "opr5"); 
			System.out.println(list); 
			String s = "[opr2, opr4]";
			assertTrue(list.toString().equals(s));
	}

	public void testSetOperators1() throws ProposalException {
			Proposal p3 = ph.newProposal("p3", "lisbon");
			assertNotNull(p3);
			List<String> list = p3.setOperators("opr1", "opr5"); 
			System.out.println(list); //[]
			String s = "[]";
			assertTrue(list.toString().equals(s));
	}
	
	public void testSetAddQuote() throws ProposalException {
        try{
			Proposal p3 = ph.newProposal("p3", "lisbon");
			assertNotNull(p3);
			p3.setOperators("opr1", "opr5", "opr6", "opr2"); 
			p3.addQuote("opr2", 1000);
			fail("operator does not handle the proposal");
        }catch(ProposalException e){
            // OK
        }
	}
	public void testSetAddQuote1() throws ProposalException {
	    try{
			Proposal p3 = ph.newProposal("p3", "lisbon");
			assertNotNull(p3);
			p3.setOperators("opr1", "opr5", "opr6", "opr7"); 
			p3.addQuote("opr7", 1000);
			fail("undefined operator");
	    }catch(ProposalException e){
	        // OK
	    }
	}
	
	public void testGetQuotes() throws ProposalException {
			Proposal p3 = ph.newProposal("p3", "lisbon");
			assertNotNull(p3);
			p3.setOperators("opr1", "opr5", "opr6", "opr7"); 
			try {
				p3.addQuote("opr1", 500);
				p3.addQuote("opr6", 1000);
				p3.addQuote("opr5", 1000);
			}	catch(Exception e){
				fail("no exception must be thrown");
			}
			List<Quote> list = p3.getQuotes();
			assertTrue(list.size() == 3);
			System.out.println(list.get(0).getOperatorName());
			assertTrue(list.get(0).getOperatorName().equals("opr5"));
	}
	
}