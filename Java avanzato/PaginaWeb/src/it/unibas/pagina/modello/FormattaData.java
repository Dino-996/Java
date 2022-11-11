package it.unibas.pagina.modello;

import java.text.DateFormat;
import java.util.Date;

public class FormattaData {

    public static String formattaDataOra(Date date) {
        String dataOra;
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.SHORT);
        dataOra = df.format(date);
        return dataOra;
    }
    
    public static String formattaData(Date date) {
        String dataOra;
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        dataOra = df.format(date);
        return dataOra;
    }
}
