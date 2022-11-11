package it.unibas.aereomobile.modello;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class GestoreDate {

    public static String getDataFormattata(Date date) {
        String dataFormattata;
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        dataFormattata = df.format(date);
        return dataFormattata;
    }

    public static String getDataOraFormattata(Date date) {
        String dataOraFormattata;
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.SHORT);
        dataOraFormattata = df.format(date);
        return dataOraFormattata;
    }

    public static String confrontaDate(Date data1, Date data2) {
        int valore = data1.compareTo(data2);
        String data1Formattata = getDataOraFormattata(data1);
        String data2Formattata = getDataOraFormattata(data2);
        String esitoVerifica = "";
        if (valore == 0) {
            esitoVerifica = "Le due date sono uguali";
        } else {
            if (valore > 0) {
                esitoVerifica = data1Formattata + " è avanti nel tempo rispetto a " + data2Formattata;
            }
            if (valore < 0) {
                esitoVerifica = data1Formattata + " è indietro nel tempo rispetto a " + data2Formattata;
            }
        }
        return esitoVerifica;
    }

    public static String verificaDateUguali(Date data1, Date data2) {
        Calendar dataUno = Calendar.getInstance();
        Calendar dataDue = Calendar.getInstance();
        dataUno.setTime(data1);
        dataDue.setTime(data2);
        String data1Formattata = getDataOraFormattata(data1);
        String data2Formattata = getDataOraFormattata(data2);
        boolean esito = dataUno.equals(dataDue);
        String esitoVerifica = data1Formattata + " non è uguale a " + data2Formattata;
        if (esito) {
            esitoVerifica = data1Formattata + " è uguale a " + data2Formattata;
        }
        return esitoVerifica;
    }

    public static String confrontoDateDiretto(Date data1, Date data2) {
        String data1Formattata = getDataOraFormattata(data1);
        String data2Formattata = getDataOraFormattata(data2);
        long dataUno = data1.getTime();
        long dataDue = data2.getTime();
        String esitoVerifica = "";
        if (dataUno == dataDue) {
            esitoVerifica = data1Formattata + " è uguale a " + data2Formattata;
        } else {
            if (dataUno < dataDue) {
                esitoVerifica = data1Formattata + " è indietro nel tempo rispetto a " + data2Formattata;
            }
            if (dataUno > dataDue) {
                esitoVerifica = data1Formattata + " è avanti nel tempo rispetto a " + data2Formattata;
            }
        }
        return esitoVerifica;
    }
}
