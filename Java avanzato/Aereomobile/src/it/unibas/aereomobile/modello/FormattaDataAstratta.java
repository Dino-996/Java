package it.unibas.aereomobile.modello;

import java.text.DateFormat;
import java.util.Calendar;

public abstract class FormattaDataAstratta {

    public String dataFormattata(Calendar dataInserita) {
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
        String dataFormattata = df.format(dataInserita.getTime());
        return dataFormattata;
    }

    public String dateTimeFormattata(Calendar dataTimeInserita) {
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
        return df.format(dataTimeInserita.getTime());
    }
}
