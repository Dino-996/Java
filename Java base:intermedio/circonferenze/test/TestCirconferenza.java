package circonferenze.test;

import junit.framework.*;
import circonferenzea.Circonferenza;

public class TestCirconferenza extends TestCase {

    private Circonferenza circonferenza1;
    private Circonferenza circonferenza2;
    private Circonferenza circonferenzaNulla;
    
    public void setUp() {
        circonferenza1 = new Circonferenza(1.5, 2, 1.7);
        circonferenza2 = new Circonferenza(2, 0, 5);
        circonferenzaNulla = new Circonferenza(0, 0, 0);
    }

    public void testGetLunghezzaCirconferenza1() {
        Assert.assertEquals(circonferenza1.getLunghezzaCirconferenza(), 10.676);
    }

    public void testGetLunghezzaCirconferenzaNulla() {
        Assert.assertEquals(circonferenzaNulla.getLunghezzaCirconferenza(), 0.0);
    }

    public void testGetSuperficieCerchio1() {
        Assert.assertEquals(circonferenza1.getSuperficieCerchio(), 9.0746);
    }

    public void testGetSuperficieCerchioNullo() {
        Assert.assertEquals(circonferenzaNulla.getSuperficieCerchio(), 0.0);
    }

    public void testPosizioneMassimaCirconferenza1() {
        Circonferenza[] collezione = {circonferenza1, circonferenza2, circonferenzaNulla};
        Assert.assertEquals(Circonferenza.posizioneMassimaCirconferenza(collezione), 1);
    }

    public void testPosizioneMassimaCirconferenza2() {
        Circonferenza[] collezione = {circonferenza1};
        Assert.assertEquals(Circonferenza.posizioneMassimaCirconferenza(collezione), 0);
    }

    public void testPosizioneMassimaCirconferenza3() {
        try {
            Circonferenza.posizioneMassimaCirconferenza(null);
            Assert.fail();
        } catch (Exception e) {}
    }

}