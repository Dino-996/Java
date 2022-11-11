package calcolatrice.test;

import calcolatrice.Calcolatrice;
import junit.framework.Assert;
import junit.framework.TestCase;

public class TestCalcolatrice extends TestCase {

    private Calcolatrice calcolatrice;

    public void setUp() {
        calcolatrice = new Calcolatrice();
    }

    public void testSomma() {
        calcolatrice.somma(2, 3.4);
        Assert.assertEquals("somma 1", calcolatrice.getRisultatoInMemoria(), 5.4);
        calcolatrice.somma(0, 3.4);
        Assert.assertTrue("somma 2", calcolatrice.getRisultatoInMemoria() == 3.4);
        calcolatrice.somma(2, -1.5);
        Assert.assertTrue("somma 3", calcolatrice.getRisultatoInMemoria() == 0.5);
    }

    public void testSottrai() {
        calcolatrice.sottrai(2, 3.4);
        Assert.assertTrue("sottrai 1", calcolatrice.getRisultatoInMemoria() == -1.4);
        calcolatrice.sottrai(0, 3.4);
        Assert.assertTrue("sottrai 2", calcolatrice.getRisultatoInMemoria() == -3.4);
        calcolatrice.sottrai(2, -1.5);
        Assert.assertTrue("sottrai 3", calcolatrice.getRisultatoInMemoria() == 3.5);
    }

    public void testMoltiplica() {
        calcolatrice.moltiplica(2, 3.4);
        Assert.assertTrue("moltiplica 1", calcolatrice.getRisultatoInMemoria() == 6.8);
        calcolatrice.moltiplica(0, 3.4);
        Assert.assertTrue("moltiplica 2", calcolatrice.getRisultatoInMemoria() == 0);
        calcolatrice.moltiplica(1, -1.5);
        Assert.assertTrue("moltiplica 3", calcolatrice.getRisultatoInMemoria() == -1.5);
    }

    public void testDividi() {
        calcolatrice.dividi(3, 1.5);
        Assert.assertTrue("dividi 1", calcolatrice.getRisultatoInMemoria() == 2);
        calcolatrice.dividi(3, 1);
        Assert.assertTrue("dividi 2", calcolatrice.getRisultatoInMemoria() == 3);
        calcolatrice.dividi(0, 3.4);
        Assert.assertTrue("dividi 3", calcolatrice.getRisultatoInMemoria() == 0);
    }

    public void testSommaAlRisultato() {
        calcolatrice.sommaAlRisultato(10);
        Assert.assertTrue("somma al risultato iniziale", calcolatrice.getRisultatoInMemoria() == 10);
        calcolatrice.somma(2, 3.4);
        Assert.assertTrue("somma iniziale", calcolatrice.getRisultatoInMemoria() == 5.4);
        calcolatrice.sommaAlRisultato(10);
        Assert.assertTrue("somma al risultato 1", calcolatrice.getRisultatoInMemoria() == 15.4);
        calcolatrice.sommaAlRisultato(0);
        Assert.assertTrue("somma al risultato 2", calcolatrice.getRisultatoInMemoria() == 15.4);
        calcolatrice.sommaAlRisultato(-1.5);
        Assert.assertTrue("somma al risultato 3", calcolatrice.getRisultatoInMemoria() == 13.9);
    }

    public void testSottraiDalRisultato() {
        calcolatrice.sottraiDalRisultato(10);
        Assert.assertTrue("sottrai dal risultato iniziale", calcolatrice.getRisultatoInMemoria() == -10);
        calcolatrice.somma(2, 3.4);
        Assert.assertTrue("somma iniziale", calcolatrice.getRisultatoInMemoria() == 5.4);
        calcolatrice.sottraiDalRisultato(10);
        Assert.assertTrue("sottrai dal risultato 1", calcolatrice.getRisultatoInMemoria() == -4.6);
        calcolatrice.sottraiDalRisultato(0);
        Assert.assertTrue("sottrai dal risultato 2", calcolatrice.getRisultatoInMemoria() == -4.6);
        calcolatrice.sottraiDalRisultato(-1.5);
        Assert.assertEquals("sottrai dal risultato 3", calcolatrice.getRisultatoInMemoria(), -3.1, 1E-10);
    }

    public void testMoltiplicaPerIlRisultato() {
        calcolatrice.moltiplicaPerIlRisultato(10);
        Assert.assertTrue("moltiplica per il risultato iniziale", calcolatrice.getRisultatoInMemoria() == 0);
        calcolatrice.somma(2, 3.4);
        Assert.assertTrue("somma iniziale", calcolatrice.getRisultatoInMemoria() == 5.4);
        calcolatrice.moltiplicaPerIlRisultato(10);
        Assert.assertTrue("moltiplica per il risultato 1", calcolatrice.getRisultatoInMemoria() == 54);
        calcolatrice.moltiplicaPerIlRisultato(1);
        Assert.assertTrue("moltiplica per il risultato 2", calcolatrice.getRisultatoInMemoria() == 54);
        calcolatrice.moltiplicaPerIlRisultato(0);
        Assert.assertTrue("moltiplica per il risultato 3", calcolatrice.getRisultatoInMemoria() == 0);
    }

    public void testDividiIlRisultato() {
        calcolatrice.dividiIlRisultato(10);
        Assert.assertTrue("dividi il risultato iniziale", calcolatrice.getRisultatoInMemoria() == 0);
        calcolatrice.somma(2, 3.4);
        Assert.assertTrue("somma iniziale", calcolatrice.getRisultatoInMemoria() == 5.4);
        calcolatrice.dividiIlRisultato(2);
        Assert.assertTrue("dividi il risultato 1", calcolatrice.getRisultatoInMemoria() == 2.7);
    }

    public void testApprossimazione() {
        calcolatrice.somma(2, 3.5);
        calcolatrice.sottraiDalRisultato(0.1);
        calcolatrice.sommaAlRisultato(0.2);
        Assert.assertEquals(calcolatrice.getRisultatoInMemoria(), 5.6, 1E-10);
    }

}
