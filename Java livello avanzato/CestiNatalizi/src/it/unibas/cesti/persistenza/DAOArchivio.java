package it.unibas.cesti.persistenza;

import it.unibas.cesti.modello.Archivio;
import it.unibas.cesti.modello.Cesto;
import it.unibas.cesti.modello.Costanti;
import it.unibas.cesti.modello.Prodotto;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DAOArchivio implements IDAOArchivio {

    @Override
    public Archivio carica(String file) throws DAOException {
        Archivio archivio = new Archivio();

        Cesto cestoPiccolo = new Cesto("Cesto natalizio", 8, Costanti.CESTO_PICCOLO);
        Cesto cestoMedio = new Cesto("Cesto delle sorprese", 10, Costanti.CESTO_MEDIO);
        Cesto cestoGrande = new Cesto("Cesto grande sorpresa", 15, Costanti.CESTO_GRANDE);

        cestoPiccolo.addProdotto(new Prodotto("Salsiccia", Costanti.SALUMI, 350, new GregorianCalendar(2022, Calendar.AUGUST, 29)));
        cestoPiccolo.addProdotto(new Prodotto("Bresaola", Costanti.SALUMI, 350, new GregorianCalendar(2022, Calendar.AUGUST, 29)));
        cestoPiccolo.addProdotto(new Prodotto("Bresaola", Costanti.SALUMI, 180, new GregorianCalendar(2022, Calendar.AUGUST, 28)));
        cestoPiccolo.addProdotto(new Prodotto("Capocollo", Costanti.SALUMI, 270, new GregorianCalendar(2022, Calendar.AUGUST, 29)));
        cestoPiccolo.addProdotto(new Prodotto("Bresaola", Costanti.SALUMI, 180, new GregorianCalendar(2022, Calendar.AUGUST, 28)));
        cestoPiccolo.addProdotto(new Prodotto("Capocollo", Costanti.SALUMI, 350, new GregorianCalendar(2022, Calendar.AUGUST, 29)));

        cestoMedio.addProdotto(new Prodotto("Salame napoli", Costanti.SALUMI, 100, new GregorianCalendar(2022, Calendar.AUGUST, 29)));
        cestoMedio.addProdotto(new Prodotto("Vino", Costanti.BEVANDA, 1000, new GregorianCalendar(2022, Calendar.AUGUST, 27)));
        cestoMedio.addProdotto(new Prodotto("Vino", Costanti.BEVANDA, 1000, new GregorianCalendar(2022, Calendar.AUGUST, 27)));
        cestoMedio.addProdotto(new Prodotto("Salame napoli", Costanti.SALUMI, 100, new GregorianCalendar(2022, Calendar.AUGUST, 29)));

        archivio.addCesto(cestoPiccolo);
        archivio.addCesto(cestoMedio);
        archivio.addCesto(cestoGrande);

        return archivio;
    }

}
