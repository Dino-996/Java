package it.unibas.aereomobile.persistenza;

import it.unibas.aereomobile.modello.Aereomobile;
import it.unibas.aereomobile.modello.Archivio;
import it.unibas.aereomobile.modello.Costanti;
import it.unibas.aereomobile.modello.Volo;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DAOArchivio implements IDAOArchivio {

    @Override
    public Archivio carica(String file) throws DAOException {
        Archivio archivio = new Archivio();
        
        Aereomobile boeing = new Aereomobile("B12n", 660, Costanti.TIPOLOGIA_BOEING, new GregorianCalendar(2022, Calendar.JUNE, 18));
        Aereomobile airbus = new Aereomobile("A34u", 840, Costanti.TIPOLOGIA_AIRBUS, new GregorianCalendar(2022, Calendar.JUNE, 28));
        Aereomobile ilyushin = new Aereomobile("I57s", 520, Costanti.TIPOLOGIA_MCDONNELL, new GregorianCalendar(2022, Calendar.JUNE, 30));
        //Voli Boeing media=347.5
        boeing.addVolo(new Volo(new GregorianCalendar(2022, Calendar.JULY, 27, 10, 30), "Fiumicino", "John F. Kennedy International Airport", 540));
        boeing.addVolo(new Volo(new GregorianCalendar(2022, Calendar.JULY, 30, 12, 30), "Fiumicino", "Praga", 320));
        boeing.addVolo(new Volo(new GregorianCalendar(2022, Calendar.AUGUST, 18, 18, 45), "Fiumicino", "Nizza", 280));
        boeing.addVolo(new Volo(new GregorianCalendar(2022, Calendar.AUGUST, 20, 22, 15), "Fiumicino", "Amsterdam", 250));
        //Voli Airbus media=943
        airbus.addVolo(new Volo(new GregorianCalendar(2022, Calendar.JULY, 20, 11, 40), "Malpensa", "Bucarest", 150));
        airbus.addVolo(new Volo(new GregorianCalendar(2022, Calendar.JULY, 26, 11, 40), "Malpensa", "Nizza", 1567));
        airbus.addVolo(new Volo(new GregorianCalendar(2022, Calendar.JULY, 25, 11, 40), "Malpensa", "Praga", 890));
        airbus.addVolo(new Volo(new GregorianCalendar(2022, Calendar.JULY, 24, 11, 40), "Malpensa", "Burundi", 852));
        airbus.addVolo(new Volo(new GregorianCalendar(2022, Calendar.JULY, 23, 11, 40), "Malpensa", "Amsterdam", 1256));
        //Voli Ilyushin 840
        ilyushin.addVolo(new Volo(new GregorianCalendar(2022, Calendar.JULY, 28, 15, 45), "Linate", "San Paolo", 840));

        archivio.addAereomobile(boeing);
        archivio.addAereomobile(airbus);
        archivio.addAereomobile(ilyushin);

        return archivio;
    }
}
