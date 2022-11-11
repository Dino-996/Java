package segmenti.test;

import junit.framework.*;
import segmenti.Segmento;
import segmenti.Punto;

public class TestSegmento extends TestCase {
    
    private Segmento segmento;
    
    public void setUp() {
        segmento = new Segmento();
    }
    
    public void testGetLunghezza1() {
        costruisciSegmento(1, 2, 4, 6);
        Assert.assertEquals(segmento.getLunghezza(), 5.0);
    }
    
    public void testGetLunghezza2() {
        costruisciSegmento(-1, 2, 1, -2);
        Assert.assertEquals(segmento.getLunghezza(), Math.sqrt(4 + 16));
    }
    
    public void testGetLunghezza3() {
        costruisciSegmento(-2, -2, -2, -2);
        Assert.assertEquals(segmento.getLunghezza(), 0.0);
    }
    
    private void costruisciSegmento(double x1, double y1, double x2, double y2) {
        Punto p1 = new Punto();
        p1.setAscissa(x1);
        p1.setOrdinata(y1);
        Punto p2 = new Punto();
        p2.setAscissa(x2);
        p2.setOrdinata(y2);
        segmento.setPrimoVertice(p1);
        segmento.setSecondoVertice(p2);
    }
      
}
