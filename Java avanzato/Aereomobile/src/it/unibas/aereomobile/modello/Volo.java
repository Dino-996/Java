package it.unibas.aereomobile.modello;

import java.util.Calendar;

public class Volo extends FormattaDataAstratta {

    private final Calendar dataOraPartenza;
    private final String aereoportoPartenza;
    private final String aereoportoDestinazione;
    private final int durataVoloMinuti;

    public Volo(Calendar dataOraPartenza, String aereoportoPartenza, String aereoportoDestinazione, int durataVoloMinuti) {
        this.dataOraPartenza = dataOraPartenza;
        this.aereoportoPartenza = aereoportoPartenza;
        this.aereoportoDestinazione = aereoportoDestinazione;
        this.durataVoloMinuti = durataVoloMinuti;
    }

    public Calendar getDataOraPartenza() {
        return dataOraPartenza;
    }

    public String getAereoportoPartenza() {
        return aereoportoPartenza;
    }

    public String getAereoportoDestinazione() {
        return aereoportoDestinazione;
    }

    public int getDurataVoloMinuti() {
        return durataVoloMinuti;
    }

    private String formattaData() {
        return super.dateTimeFormattata(this.dataOraPartenza);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Data e ora partenza: ").append(formattaData()).append("/n");
        sb.append("Aereoporto di partenza: ").append(this.aereoportoPartenza).append("/n");
        sb.append("Aereoporto di destinazione: ").append(this.aereoportoDestinazione).append("/n");
        sb.append("Durata del volo").append(this.durataVoloMinuti).append(" minuti").append("/n");
        return sb.toString().trim();
    }
}
