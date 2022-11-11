package it.unibas.banca.persistenza;

import it.unibas.banca.modello.Archivio;
import it.unibas.banca.modello.Conto;
import it.unibas.banca.modello.Costanti;
import it.unibas.banca.modello.Movimento;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DAOArchivio implements IDAOArchivio {

    @Override
    public Archivio carica(String file) throws DAOException {
        Archivio archivio = new Archivio();

        Conto conto1 = new Conto("ITABC12", "Mario Draghi", new GregorianCalendar(2022, Calendar.AUGUST, 11));
        Conto conto2 = new Conto("ITHBN22", "Piero Mannini", new GregorianCalendar(2022, Calendar.JUNE, 10));
        Conto conto3 = new Conto("ITXBI77", "Mario Draghi", new GregorianCalendar(2022, Calendar.AUGUST, 11));
        //Questo conto non dovrebbe apparire perche dopo la data odierna(data di oggi: 15/08/2022)
        Conto conto4 = new Conto("ITRFB12", "Mimmo onofrio", new GregorianCalendar(2022, Calendar.SEPTEMBER, 10));

        conto1.addMovimento(new Movimento(new GregorianCalendar(2022, Calendar.MAY, 18, 10, 30), 100.0, Costanti.BANCOMAT));
        conto1.addMovimento(new Movimento(new GregorianCalendar(2020, Calendar.MAY, 20, 18, 12, 00), 50.0, Costanti.POS));
        conto2.addMovimento(new Movimento(new GregorianCalendar(2022, Calendar.AUGUST, 14, 15, 45), 32.28, Costanti.BONIFICO));

        archivio.addConto(conto1);
        archivio.addConto(conto2);
        //archivio.addConto(conto3);
        archivio.addConto(conto4);
        return archivio;
    }
}
