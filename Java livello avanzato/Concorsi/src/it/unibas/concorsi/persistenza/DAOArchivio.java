package it.unibas.concorsi.persistenza;

import it.unibas.concorsi.modello.Archivio;
import it.unibas.concorsi.modello.Concorso;
import it.unibas.concorsi.modello.Costanti;
import it.unibas.concorsi.modello.Domanda;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DAOArchivio implements IDAOArchvio{

    @Override
    public Archivio carica(String file) throws DAOException {
        Archivio archivio = new Archivio();
        
        Concorso concorsoUno = new Concorso("BI01", "Concorso pubblico per 150 postini", 150, "Basilicata", new GregorianCalendar(2022, Calendar.AUGUST, 25, 10, 30));
        concorsoUno.addDomanda(new Domanda("DW94IU", Costanti.SESSO_MASCHIO, new GregorianCalendar(2022, Calendar.AUGUST, 10)));
        concorsoUno.addDomanda(new Domanda("DI12NA", Costanti.SESSO_FEMMINA, new GregorianCalendar(2022, Calendar.AUGUST, 21)));
        archivio.addConcorso(concorsoUno);
        
        Concorso concorsoDue = new Concorso("BI02", "Concorso privato per 4 usurai", 4, "Calabria", new GregorianCalendar(2022, Calendar.AUGUST, 25, 13, 30));
        concorsoDue.addDomanda(new Domanda("SD98UT", Costanti.SESSO_MASCHIO, new GregorianCalendar(2022, Calendar.AUGUST, 15)));
        concorsoDue.addDomanda(new Domanda("AB34CD", Costanti.SESSO_FEMMINA, new GregorianCalendar(2022, Calendar.AUGUST, 18)));
        archivio.addConcorso(concorsoDue);
        
        Concorso concorsoTre = new Concorso("BI03", "Concorso pubblico per 8 impiegati", 8, "Lazio", new GregorianCalendar(2022, Calendar.AUGUST, 25, 18, 40));
        concorsoTre.addDomanda(new Domanda("CO55WE", Costanti.SESSO_MASCHIO, new GregorianCalendar(2022, Calendar.AUGUST, 16)));
        concorsoTre.addDomanda(new Domanda("UN13TR", Costanti.SESSO_FEMMINA, new GregorianCalendar(2022, Calendar.AUGUST, 3)));
        archivio.addConcorso(concorsoTre);
        
        Concorso concorsoQuattro = new Concorso("BI04", "Concorso pubblico per 10 spazzini", 10, "Basilicata", new GregorianCalendar(2022, Calendar.AUGUST, 25, 8, 30));
        concorsoQuattro.addDomanda(new Domanda("CU00LO", Costanti.SESSO_MASCHIO, new GregorianCalendar(2022, Calendar.AUGUST, 9)));
        concorsoQuattro.addDomanda(new Domanda("SE87NI", Costanti.SESSO_FEMMINA, new GregorianCalendar(2022, Calendar.AUGUST, 11)));
        archivio.addConcorso(concorsoQuattro);
        
        return archivio;
    }   
}
