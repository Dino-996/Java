package segmenti.test;

import junit.framework.*;

public class TestTutto extends TestCase {
	
    public static TestSuite suite() {
        TestSuite suite = new TestSuite();
        suite.addTestSuite(TestPunto.class);
        suite.addTestSuite(TestSegmento.class);
        return suite;
    }	
	
}
