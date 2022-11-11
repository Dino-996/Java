package it.unibas.tecnichealgoritmiche.test.modello;

import it.unibas.tecnichealgoritmiche.modello.Album;
import it.unibas.tecnichealgoritmiche.modello.Figurina;
import junit.framework.TestCase;

public class TestAlbum extends TestCase {

    private Album album;
    private Figurina figurina1;
    private Figurina figurina2;
    private Figurina figurina3;
    private Figurina figurina4;

    protected void setUp() throws Exception {
        album = new Album();
        figurina1 = new Figurina(1, "aaa", 1.0);
        figurina2 = new Figurina(2, "bbb", 2.0);
        figurina3 = new Figurina(3, "ccc - bbb", 3.0);
        figurina4 = new Figurina(3, "ccc - bbb", 3.0);
    }

    public void testCercaFigurina() {
        assertNull(album.cercaFigurinaPerNumero(1));
        album.addFigurina(figurina1);
        assertNotNull(album.cercaFigurinaPerNumero(1));
    }

    public void testCercaMaxCosto() {
        album.addFigurina(figurina1);
        assertEquals(figurina1, album.cercaFigurinaMaxCosto());
        album.addFigurina(figurina3);
        assertEquals(figurina3, album.cercaFigurinaMaxCosto());
        album.addFigurina(figurina2);
        assertEquals(figurina3, album.cercaFigurinaMaxCosto());
    }

    public void testCercaFigurinePerDescrizione() {
        album.addFigurina(figurina1);
        assertEquals(0, album.cercaFigurinePerDescrizione("bbb").size());
        album.addFigurina(figurina3);
        assertEquals(1, album.cercaFigurinePerDescrizione("bbb").size());
        album.addFigurina(figurina2);
        assertEquals(2, album.cercaFigurinePerDescrizione("bbb").size());
    }

    public void testCostoTotale() {
        album.addFigurina(figurina1);
        album.addFigurina(figurina3);
        album.addFigurina(figurina2);
        assertEquals(6.0, album.getCostoTotale());
    }

    public void testGetNumeroFigurineCostose() {
        album.addFigurina(figurina1);
        album.addFigurina(figurina3);
        album.addFigurina(figurina2);
        assertEquals(0, album.getNumeroFigurineCostose(10.0));
        assertEquals(1, album.getNumeroFigurineCostose(2.5));
        assertEquals(2, album.getNumeroFigurineCostose(1.5));
        assertEquals(3, album.getNumeroFigurineCostose(0.5));
    }

    public void testVerificaConsecutiveUguali() {
        album.addFigurina(figurina1);
        album.addFigurina(figurina3);
        album.addFigurina(figurina2);
        assertFalse(album.verificaFigurineConsecutiveUguali());
        album.setFigurina(2, figurina4);
        assertTrue(album.verificaFigurineConsecutiveUguali());
    }
    
    public void testFigurineDiverse() {
        album.addFigurina(figurina1);
        album.addFigurina(figurina3);
        album.addFigurina(figurina2);
        assertTrue(album.verificaFigurineDiverse());
        album.addFigurina(figurina4);
        assertFalse(album.verificaFigurineDiverse());
    }
}