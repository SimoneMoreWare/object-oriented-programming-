package it.polito.test;
import java.util.List;
import java.util.SortedMap;

import junit.framework.TestCase;
//import java.util.*;
import proposals.*;

public class TestReq5 extends TestCase {
	ProposalHandling ph = new ProposalHandling();
	protected void setUp() throws Exception {
		super.setUp();
		try{	
			ph.addUsers("john","bob","ted","lucy");
			ph.addOperator("op1","london","paris","prague");
			ph.addOperator("op2","london","paris");
			ph.addOperator("op3","london","paris","lisbon");
			ph.addOperator("op5","london","paris","prague","lisbon");
			
			Proposal p1 = ph.newProposal("p1", "london");
			p1.setOperators("op1", "op3");
			p1.addQuote("op1", 600);
			p1.addQuote("op3", 500);
			
			Proposal p3 = ph.newProposal("p3", "lisbon");
			p3.setOperators("op5","op3"); 
			p3.addQuote("op5", 1000);
			p3.addQuote("op3", 900);
			p3.setUsers("john","bob","lucy");
			p3.makeChoice("bob", "op3");
			p3.makeChoice("john", "op5");
			
			Proposal p2 = ph.newProposal("p2", "paris");
			p2.setOperators("op5","op2","op3"); 
			p2.setUsers("john","bob","ted","lucy");
			p2.addQuote("op5", 1000);
			p2.addQuote("op3", 1200);
			p2.addQuote("op2", 1300);
			p2.makeChoice("bob", "op3");
			p2.makeChoice("john", "op5");
			p2.makeChoice("lucy", "op2");
		}catch(Exception e){
			fail("no exception must be thrown");
		}
	}
	
	
	public void testTotalAmountOfQuotesPerDestination() {
			SortedMap<String, Integer> quotesPerDest = ph.totalAmountOfQuotesPerDestination();
			System.out.println(quotesPerDest);
			String s = "{lisbon=1900, london=1100, paris=3500}";
			assertTrue(quotesPerDest != null && quotesPerDest.toString().equals(s));
	}

	public void testOperatorsPerNumberOfQuotes() {
			SortedMap<Integer, List<String>> oprPerNQuotes = ph.operatorsPerNumberOfQuotes();
			//System.out.println("oprPerNQuotes " + oprPerNQuotes);  
			String s = "{3=[op3], 2=[op5], 1=[op1, op2]}";
			assertTrue(oprPerNQuotes != null && oprPerNQuotes.toString().equals(s));
	}
	
	public void testNumberOfUsersPerDestination() {
			SortedMap<String, Long> nUsersPerDest = ph.numberOfUsersPerDestination();
			System.out.println("nUsersPerDest " + nUsersPerDest); 
			String s = "{lisbon=3, paris=4}";
			assertTrue(nUsersPerDest != null && nUsersPerDest.toString().equals(s));
	}
	
	public void testProposalsPerNumberOfQuotes() {
			SortedMap<Integer, List<String>> proPerNQuotes = ph.proposalsPerNumberOfQuotes();
			//System.out.println(proPerNQuotes); 
			String s = "{3=[p2], 2=[p1, p3]}";
			assertTrue(proPerNQuotes != null && proPerNQuotes.toString().equals(s));
	}
}