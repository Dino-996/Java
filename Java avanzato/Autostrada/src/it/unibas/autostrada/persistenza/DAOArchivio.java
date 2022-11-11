package it.unibas.autostrada.persistenza;

import it.unibas.autostrada.modello.Accesso;
import it.unibas.autostrada.modello.Archivio;
import it.unibas.autostrada.modello.Casello;
import it.unibas.autostrada.modello.Costanti;

public class DAOArchivio implements IDAOArchivio {

    @Override
    public Archivio carica(String file) throws DAOException {
        Archivio archivio = new Archivio();
        
        Casello casello1 = new Casello("A037", "A1", 7.7);
        Casello casello2 = new Casello("A129", "A1", 19.8);
        Casello casello3 = new Casello("A872", "A5", 15.3);
        
        casello1.addAccesso(new Accesso("AA12BB", Costanti.MARCA_FIAT, 10.3, Costanti.PAGAMENTO_POS));
        casello1.addAccesso(new Accesso("CC46DD", Costanti.MARCA_AUDI, 15.5, Costanti.PAGAMENTO_PAYPAL));
        casello1.addAccesso(new Accesso("FR74BH", Costanti.MARCA_FORD, 13.2, Costanti.PAGAMENTO_CONTANTI));
        
        casello2.addAccesso(new Accesso("DF89PO", Costanti.MARCA_FIAT, 10.9, Costanti.PAGAMENTO_PAYPAL));
        casello2.addAccesso(new Accesso("LF10TE", Costanti.MARCA_AUDI, 15.1, Costanti.PAGAMENTO_POS));
        casello2.addAccesso(new Accesso("CC46DD", Costanti.MARCA_AUDI, 15.5, Costanti.PAGAMENTO_PAYPAL));  
        
        casello3.addAccesso(new Accesso("FT99LO", Costanti.MARCA_FORD, 11.7, Costanti.PAGAMENTO_CONTANTI));
        
        archivio.addCasello(casello1);
        archivio.addCasello(casello2);
        archivio.addCasello(casello3);
        
        return archivio;
    }
    
}
