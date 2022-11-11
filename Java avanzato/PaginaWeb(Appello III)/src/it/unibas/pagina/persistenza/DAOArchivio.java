package it.unibas.pagina.persistenza;

import it.unibas.pagina.modello.Annotazione;
import it.unibas.pagina.modello.Archivio;
import it.unibas.pagina.modello.Costanti;
import it.unibas.pagina.modello.PaginaWeb;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DAOArchivio implements IDAOArchivio {

    @Override
    public Archivio carica(String file) throws DAOException {
        Archivio archivio = new Archivio();
        
        PaginaWeb paginaReginaElisabetta = new PaginaWeb("https://it.wikipedia.org/wiki/ReginaElisabetta", "Regina Elisabetta", new GregorianCalendar(2022, Calendar.SEPTEMBER, 16, 12, 00), 450);
        paginaReginaElisabetta.addAnnotazione(new Annotazione(3, 6, Costanti.COLORE_VERDE, new GregorianCalendar(2022, Calendar.SEPTEMBER, 16, 11, 30)));
        paginaReginaElisabetta.addAnnotazione(new Annotazione(10, 26, Costanti.COLORE_ROSSO, new GregorianCalendar(2022, Calendar.SEPTEMBER, 16, 11, 35)));
        paginaReginaElisabetta.addAnnotazione(new Annotazione(94, 110, Costanti.COLORE_ROSSO, new GregorianCalendar(2022, Calendar.SEPTEMBER, 16, 11, 40)));
        
        PaginaWeb paginaCamillaShand = new PaginaWeb("https://it.wikipedia.org/wiki/CamillaShand", "Camilla Shand", new GregorianCalendar(2022, Calendar.SEPTEMBER, 18, 18, 18), 550);
        paginaCamillaShand.addAnnotazione(new Annotazione(8, 16, Costanti.COLORE_ROSSO, new GregorianCalendar(2022, Calendar.SEPTEMBER, 18, 18, 05)));
        paginaCamillaShand.addAnnotazione(new Annotazione(13, 21, Costanti.COLORE_ROSSO, new GregorianCalendar(2022, Calendar.SEPTEMBER, 18, 18, 12)));
        paginaCamillaShand.addAnnotazione(new Annotazione(80, 100, Costanti.COLORE_ROSSO, new GregorianCalendar(2022, Calendar.SEPTEMBER, 18, 18, 13)));
        
        PaginaWeb paginaCarloIII = new PaginaWeb("https://it.wikipedia.org/wiki/CarloIII", "CarloIII", new GregorianCalendar(2022, Calendar.SEPTEMBER, 20, 10, 30), 300);
        paginaCarloIII.addAnnotazione(new Annotazione(13, 62, Costanti.COLORE_ROSSO, new GregorianCalendar(2022, Calendar.SEPTEMBER, 20, 10, 00)));
        
        PaginaWeb paginaProvaData = new PaginaWeb("prova", "ProvaData", new GregorianCalendar(2022, Calendar.SEPTEMBER, 1, 10, 30), 1000);
        paginaProvaData.addAnnotazione(new Annotazione(0, 0, "Prova", new GregorianCalendar(2022, Calendar.OCTOBER, 1, 10, 30)));
        
        archivio.addPaginaWeb(paginaReginaElisabetta);
        archivio.addPaginaWeb(paginaCamillaShand);
        archivio.addPaginaWeb(paginaCarloIII);
        archivio.addPaginaWeb(paginaProvaData);
        
        return archivio;
    } 
}
