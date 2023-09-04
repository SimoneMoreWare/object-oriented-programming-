package it.polito.test;
import junit.framework.TestCase;

import java.util.*;

import proposals.*;

public class TestReq2 extends TestCase {
	ProposalHandling ph = new ProposalHandling();
	protected void setUp() throws Exception {
		super.setUp();
		try{	
			ph.addUsers("john","bob","ted","lucy");
			ph.addOperator("op1","london","rome", "lisbon");
			ph.addOperator("opr5","berlin","rome","madrid", "lisbon");
			ph.addOperator("opr2","paris","lisbon");
			ph.newProposal("p1", "london");
		}catch(Exception e){
			fail("no exception must be thrown");
		}
	}
	
	public void testNewProposal() {
		try {
			ph.newProposal("p2", "prague");
			fail("destination undefined");
		} catch (Exception e) {
		    //OK
		}
	}
	public void testNewProposal1() {
		try {
			ph.newProposal("p1", "berlin");
			fail("proposal name duplicated");
		} catch (Exception e) {
		    // OK
		}
	}
	
	public void testSetUsers() throws ProposalException {
			Proposal p3 = ph.newProposal("p3", "rome");
			assertNotNull(p3);
			List<String> list = p3.setUsers("john","mary","ann","bob");
			System.out.println(list); //[ann, mary]
			String s = "[ann, mary]";
			assertTrue(list.toString().equals(s));
	}
	
	public void testSetUsers1() throws ProposalException {
			Proposal p4 = ph.newProposal("p4", "madrid");
			assertNotNull(p4);
			List<String> list = p4.setUsers("john","bob");
			System.out.println(list); //[]
			String s = "[]";
			assertTrue(list.toString().equals(s));
	}
}
