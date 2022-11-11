package it.unibas.anagrafica.persistenza;

import it.unibas.anagrafica.modello.Archivio;
import it.unibas.anagrafica.modello.Azienda;
import it.unibas.anagrafica.modello.Costanti;
import it.unibas.anagrafica.modello.Dipendente;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DAOArchivio implements IDAOArchivio {

    @Override
    public Archivio carica(String file) throws DAOException {
        Archivio archivio = new Archivio();
        
        Azienda azienda = new Azienda("IT7363684ND", "AbbiamoStile SPA", "Torino");
        Azienda azienda1 = new Azienda("IT337383BFFS", "BabboNataleEsiste SRL", "Torino");
        Azienda azienda2 = new Azienda("ITENBEKDKD76", "Colonial SPA", "Milano");
        
        azienda.addDipendente(new Dipendente("AB12ER", "Piero", "Viggiano", new GregorianCalendar(2022, Calendar.APRIL, 10), Costanti.MASCHIO_STRING));
        azienda.addDipendente(new Dipendente("ABCF5T", "Valerio", "Mastro", new GregorianCalendar(2022, Calendar.MAY, 17), Costanti.FEMMINA_STRING));
        azienda.addDipendente(new Dipendente("TR37IX", "Mirco", "Benedetti", new GregorianCalendar(2022, Calendar.MAY, 28), Costanti.MASCHIO_STRING));
        
        azienda1.addDipendente(new Dipendente("AF56UY", "Manila", "Uprio", new GregorianCalendar(2022, Calendar.AUGUST, 3), Costanti.FEMMINA_STRING));
        azienda1.addDipendente(new Dipendente("AB12ER", "Dennis", "Mastrangelo", new GregorianCalendar(2022, Calendar.AUGUST,10), Costanti.MASCHIO_STRING));
        
        azienda2.addDipendente(new Dipendente("AB12ER", "Dante", "Alighieri", new GregorianCalendar(2022, Calendar.SEPTEMBER, 24), Costanti.MASCHIO_STRING));
        
        archivio.addAzienda(azienda);
        archivio.addAzienda(azienda1);
        archivio.addAzienda(azienda2);
        return archivio;
    }
    
}
