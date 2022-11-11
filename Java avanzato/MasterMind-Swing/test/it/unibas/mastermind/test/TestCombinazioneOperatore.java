package it.unibas.mastermind.test;

import it.unibas.mastermind.modello.Combinazione;
import it.unibas.mastermind.modello.OperatoreCombinazione;
import it.unibas.mastermind.modello.Risposta;
import org.junit.Assert;
import org.junit.Test;

//Se si utilizzano altre versioni bisogna estendere TestCase
public class TestCombinazioneOperatore {
    
    private OperatoreCombinazione operatore = new OperatoreCombinazione();
    
    @Test
    public void testContaOccorrenze() {
        Combinazione combinazione = new Combinazione(1, 2, 3, 4);
        //Quando è sbarrata la classe è deprecata e ci dice che non dovremmo utilizzare
        Assert.assertEquals(1, operatore.ContaOccorrenze(1, combinazione));
        Assert.assertEquals(1, operatore.ContaOccorrenze(2, combinazione));
        Assert.assertEquals(1, operatore.ContaOccorrenze(3, combinazione));
        Assert.assertEquals(1, operatore.ContaOccorrenze(4, combinazione));
        Assert.assertEquals(0, operatore.ContaOccorrenze(5, combinazione));
        Assert.assertEquals(0, operatore.ContaOccorrenze(6, combinazione));
    }
    
    @Test
    public void testGenerazioneCombinazione() {
        for(int i = 0; i < 100; i++) {
            Combinazione combinazioneCasuale = operatore.generaCombinazione();
            Assert.assertTrue(operatore.verificaCorrettezzaDiCombinazione(combinazioneCasuale));
        }
    }
    
    @Test
    public void testCombinazioneCorretta() {
        Assert.assertTrue(operatore.verificaCorrettezzaDiCombinazione(new Combinazione(1, 2, 3, 4)));
        Assert.assertTrue(operatore.verificaCorrettezzaDiCombinazione(new Combinazione(4, 3, 2, 1)));
        Assert.assertTrue(operatore.verificaCorrettezzaDiCombinazione(new Combinazione(1, 3, 2, 4)));
        Assert.assertTrue(operatore.verificaCorrettezzaDiCombinazione(new Combinazione(4, 2, 3, 1)));
        Assert.assertTrue(operatore.verificaCorrettezzaDiCombinazione(new Combinazione(1, 2, 5, 6)));    
    }
    
    @Test
    public void testCombinazioneScorretta() {
        Assert.assertFalse(operatore.verificaCorrettezzaDiCombinazione(new Combinazione(1, 1, 3, 4)));
        Assert.assertFalse(operatore.verificaCorrettezzaDiCombinazione(new Combinazione(4, 3, 2, 4))); 
        try {
            Combinazione combinazione = new Combinazione(1, 2, 5, 7);
            Assert.fail();
        } catch (IllegalArgumentException exception) {     
        }
        try {
            Combinazione combinazione = new Combinazione(0, 1, 2, 3);
            Assert.fail();
        } catch (IllegalArgumentException e) {
        }
    }
    
    @Test
    public void testTentativoUno() {
        Combinazione combinazioneNascosta = new Combinazione(1, 2, 3, 4);
        Combinazione combinazioneTentativo = new Combinazione(5, 6, 1, 2);
        Risposta risposta = operatore.valutaTentativo(combinazioneNascosta, combinazioneTentativo);
        Assert.assertEquals("Fallita la verifica dei pallini neri: ", 0, risposta.getPalliniNeri());
        Assert.assertEquals("Fallita la verifica dei pallini bianchi: ", 2, risposta.getPalliniBianchi());
    }
   
    @Test
    public void testTentativoDue() {
        Combinazione combinazioneNascosta = new Combinazione(2, 4, 6, 1);
        Combinazione combinazioneTentativo = new Combinazione(1, 6, 2, 4);
        Risposta risposta = operatore.valutaTentativo(combinazioneNascosta, combinazioneTentativo);
        Assert.assertEquals("Fallita la verifica dei pallini neri: ", 0, risposta.getPalliniNeri());
        Assert.assertEquals("Fallita la verifica dei pallini bianchi: ", 4, risposta.getPalliniBianchi());
    }
    
    @Test
    public void testTentativoTre() {
        Combinazione combinazioneNascosta = new Combinazione(2, 4, 6, 1);
        Combinazione combinazioneTentativo = new Combinazione(2, 1, 6, 4);
        Risposta risposta = operatore.valutaTentativo(combinazioneNascosta, combinazioneTentativo);
        Assert.assertEquals("Fallita la verifica dei pallini neri: ", 2, risposta.getPalliniNeri());
        Assert.assertEquals("Fallita la verifica dei pallini bianchi: ", 2, risposta.getPalliniBianchi());
    }
    
    @Test
    public void testTentativoQuattro() {
        Combinazione combinazioneNascosta = new Combinazione(6, 2, 5, 1);
        Combinazione combinazioneTentativo = new Combinazione(2, 3, 4, 1);
        Risposta risposta = operatore.valutaTentativo(combinazioneNascosta, combinazioneTentativo);
        Assert.assertEquals("Fallita la verifica dei pallini neri: ", 1, risposta.getPalliniNeri());
        Assert.assertEquals("Fallita la verifica dei pallini bianchi: ", 1, risposta.getPalliniBianchi());
    }
    
    @Test
    public void testTentativoCinque() {
        Combinazione combinazioneNascosta = new Combinazione(1, 2, 3, 4);
        Combinazione combinazioneTentativo = new Combinazione(1, 2, 3, 4);
        Risposta risposta = operatore.valutaTentativo(combinazioneNascosta, combinazioneTentativo);
        Assert.assertEquals("Fallita la verifica dei pallini neri: ", 4, risposta.getPalliniNeri());
        Assert.assertEquals("Fallita la verifica dei pallini bianchi: ", 0, risposta.getPalliniBianchi());
    }
}
