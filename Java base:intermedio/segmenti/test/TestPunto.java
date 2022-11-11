package segmenti.test;

import junit.framework.*;
import segmenti.Punto;

public class TestPunto extends TestCase {
    
    private Punto punto;
    
    public void setUp() {
        punto = new Punto();
    }
    
    public void testGetQuadrante1() {
        punto.setAscissa(1.5);
        punto.setOrdinata(3);
        Assert.assertTrue("quadrante 1.1", punto.getQuadrante() == 1);
        punto.setAscissa(1.5);
        punto.setOrdinata(0);
        Assert.assertTrue("quadrante 1.2", punto.getQuadrante() == 1);
        punto.setAscissa(0);
        punto.setOrdinata(2);
        Assert.assertTrue("quadrante 1.3", punto.getQuadrante() == 1);
    }
    
    public void testGetQuadrante2() {
        punto.setAscissa(-1.5);
        punto.setOrdinata(2);
        Assert.assertTrue("quadrante 2.1", punto.getQuadrante() == 2);
        punto.setAscissa(-1.5);
        punto.setOrdinata(0);
        Assert.assertTrue("quadrante 2.2", punto.getQuadrante() == 2);
    }
    
    public void testGetQuadrante3() {
        punto.setAscissa(-1.5);
        punto.setOrdinata(-2);
        Assert.assertTrue("quadrante 1.1", punto.getQuadrante() == 3);
    }
    
    public void testGetQuadrante4() {
        punto.setAscissa(1.5);
        punto.setOrdinata(-2);
        Assert.assertTrue("quadrante 4.1", punto.getQuadrante() == 4);
        punto.setAscissa(0);
        punto.setOrdinata(-2);
        Assert.assertTrue("quadrante 4.2", punto.getQuadrante() == 4);
    }
    
}