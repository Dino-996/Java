package it.unibas.aule.persistenza;

import it.unibas.aule.modello.Accesso;
import it.unibas.aule.modello.Archivio;
import it.unibas.aule.modello.Aula;
import it.unibas.aule.modello.Costanti;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DAOArchivio implements IDAOArchivio {

    @Override
    public Archivio carica(String nome) throws DAOException {
        Archivio archivio = new Archivio();
        
        Aula aulaA1 = new Aula("A1", "Aula A1", 0);
        Aula aulaMagna = new Aula("AMD", "Aula Magna DIMIE", 1);
        Aula aulaLeonardo = new Aula("AL", "Aula Leonardo", 2);
        
        aulaA1.addAccesso(new Accesso("61697", "Davide Sabia", 120.0, Costanti.LEZIONE, new GregorianCalendar(2022, Calendar.MAY, 15, 22, 17)));
        aulaA1.addAccesso(new Accesso("90554", "Nicola Miraglio", 90.0, Costanti.RICEVIMENTO, new GregorianCalendar(2022, Calendar.MAY, 24, 20, 17)));
        aulaMagna.addAccesso(new Accesso("61697", "Benedetta Lorusso", 60.0, Costanti.ESAME, new GregorianCalendar(2022, Calendar.MAY, 22, 20, 17)));
        
        archivio.addAula(aulaA1);
        archivio.addAula(aulaMagna);
        archivio.addAula(aulaLeonardo);
        
        return archivio;
    }  
}
