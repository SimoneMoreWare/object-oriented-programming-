package it.polito.po.test;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(AllTests.class.getName());
        //$JUnit-BEGIN$
        suite.addTestSuite(TestR1_Products.class);
        suite.addTestSuite(TestR2_Suppliers.class);
        suite.addTestSuite(TestR3_Orders.class);
        suite.addTestSuite(TestR4_Pending.class);
        suite.addTestSuite(TestR5_Stats.class);
        //$JUnit-END$
        return suite;
    }
}