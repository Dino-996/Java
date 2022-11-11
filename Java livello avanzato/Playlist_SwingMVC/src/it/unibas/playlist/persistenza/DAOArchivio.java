package it.unibas.playlist.persistenza;

import it.unibas.playlist.modello.Archivio;
import it.unibas.playlist.modello.Brano;
import it.unibas.playlist.modello.Costanti;
import it.unibas.playlist.modello.Playlist;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DAOArchivio implements IDAOArchivio {

    @Override
    public Archivio carica(String nomeFile) throws DAOException {
        Archivio archivio = new Archivio();
        
        Playlist playlist1 = new Playlist("Nuova playlist", "Mario Rossi", new GregorianCalendar(18, Calendar.MAY, 2022, 18, 30));
        
        Brano brano1 = new Brano("I figli del sole", "Gianni Bianchi", Costanti.CATEGORIA_CLASSICA, 120);
        Brano brano2 = new Brano("Maledetta luna", "Francesco Maggio", Costanti.CATEGORIA_ROCK, 90);
        Brano brano3 = new Brano("I don't live", "Mila Mala", Costanti.CATEGORIA_POP, 100);
        
        playlist1.addBrano(brano1);
        playlist1.addBrano(brano2);
        playlist1.addBrano(brano3);
        
        archivio.addPlaylist(playlist1);
        
        return archivio;
    }
    
}
