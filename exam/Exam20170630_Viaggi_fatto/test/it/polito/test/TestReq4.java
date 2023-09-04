package it.polito.test;
import junit.framework.TestCase;
//import java.util.*;
import proposals.*;

public class TestReq4 extends TestCase {
	ProposalHandling ph = new ProposalHandling();
	Proposal p3 = null;
	protected void setUp() throws Exception {
		super.setUp();
		try{	
			ph.addUsers("john","bob","ted","lucy", "mary");
			ph.addOperator("opr1","london","rome", "lisbon");
			ph.addOperator("opr5","berlin","rome","madrid", "lisbon");
			ph.addOperator("opr4","paris","london");
			ph.addOperator("opr2","paris","rome");
			ph.addOperator("opr6","lisbon","rome");
			p3 = ph.newProposal("p3", "lisbon");
			p3.setUsers("john","mary","bob");
			p3.setOperators("opr1", "opr5", "opr6");
			p3.addQuote("opr1", 800);
			p3.addQuote("opr6", 700);
			p3.addQuote("opr5", 1000);
		}catch(Exception e){
			fail("no exception must be thrown");
		}
	}
	
	public static void printQuote(Quote q) {
		System.out.println(String.format("winning quote: proposal %s, operator %s, amount %d, n. of choices %d",	
			q.getProposalName(), q.getOperatorName(), q.getAmount(), q.getNChoices()));
	}
	
	public void testMakeChoice() throws ProposalException {
	    try{
			p3.makeChoice("ted", "opr1");
	        fail("user is not associated with the proposal");
	    }catch(ProposalException e){
	        // OK
	    }
	}

	public void testMakeChoice1() throws ProposalException {
        try{
			p3.makeChoice("john", "opr4");
			fail("operator is not associated with the proposal");
        }catch(ProposalException e){
            // OK
        }
	}
	
	public void testGetWinningQuote() {
		try{
			p3.makeChoice("bob", "opr6");
			p3.makeChoice("john", "opr1");
			p3.makeChoice("mary", "opr5");
		}catch(Exception e){
			e.printStackTrace();
			fail("no exception must be thrown");
		}
			Quote q = p3.getWinningQuote(); //opr6, 700
			printQuote(q);
			assertTrue(q != null && q.getOperatorName().equals("opr6"));
			assertTrue(q.getAmount() == 700 && q.getNChoices() == 1);
	}
	
}