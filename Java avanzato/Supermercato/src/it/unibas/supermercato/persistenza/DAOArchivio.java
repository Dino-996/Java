package it.unibas.supermercato.persistenza;

import it.unibas.supermercato.modello.Archivio;
import it.unibas.supermercato.modello.Costanti;
import it.unibas.supermercato.modello.Prodotto;
import it.unibas.supermercato.modello.Supermercato;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DAOArchivio implements IDAOArchivio {

    @Override
    public Archivio carica(String file) throws DAOException {
        Archivio archivio = new Archivio();
        
        Supermercato Potenza1 = new Supermercato(Costanti.SUPERMERCATO_CONAD, Costanti.CITTA_POTENZA, "Pietro Paoli", 2, new GregorianCalendar(2022, Calendar.JULY, 23));
        Supermercato Potenza2 = new Supermercato(Costanti.SUPERMERCATO_CONAD, Costanti.CITTA_POTENZA, "Oscar Romero", 2, new GregorianCalendar(2022, Calendar.JULY, 25));
        Supermercato Potenza3 = new Supermercato(Costanti.SUPERMERCATO_QUI_DISCOUNT, Costanti.CITTA_POTENZA, "Oscar Romero", 2, new GregorianCalendar(2022, Calendar.JULY, 12));
        Supermercato Potenza4 = new Supermercato(Costanti.SUPERMERCATO_MD, Costanti.CITTA_POTENZA, "Oscar Romero", 2, new GregorianCalendar(2022, Calendar.JULY, 15));
        
        Potenza1.addProdotto(new Prodotto(92, "Spaghetti", "Spaghetti di grano duro", 2.50, new GregorianCalendar(2022, Calendar.AUGUST, 23)));
        Potenza1.addProdotto(new Prodotto(86, "Tonno", "Tonno all'olio di oliva", 5.70, new GregorianCalendar(2022, Calendar.AUGUST, 14)));
        Potenza1.addProdotto(new Prodotto(59, "Proteine del latte", "Proteine del latte al gusto cacao", 35.90, new GregorianCalendar(2022, Calendar.AUGUST, 12)));
        Potenza1.addProdotto(new Prodotto(12, "Latte intero biologico", "Latte biologico", 3.7, new GregorianCalendar(2022, Calendar.AUGUST, 1)));
        
        archivio.addSupermercato(Potenza1);
        archivio.addSupermercato(Potenza2);
        archivio.addSupermercato(Potenza3);
        archivio.addSupermercato(Potenza4);
        return archivio;
    }   
}
