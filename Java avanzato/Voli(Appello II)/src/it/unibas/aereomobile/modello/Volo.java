package it.unibas.aereomobile.modello;

import java.util.Calendar;

public class Volo {
    private Calendar dataOraPartenza;
    private String aereoportoPartenza;
    private String aereoportoDestinazione;
    private int durataInMinuti;

    public Volo(Calendar dataOraPartenza, String aereoportoPartenza, String aereoportoDestinazione, int durataInMinuti) {
        this.dataOraPartenza = dataOraPartenza;
        this.aereoportoPartenza = aereoportoPartenza;
        this.aereoportoDestinazione = aereoportoDestinazione;
        this.durataInMinuti = durataInMinuti;
    }

    public Calendar getDataOraPartenza() {
        return dataOraPartenza;
    }

    public void setDataOraPartenza(Calendar dataOraPartenza) {
        this.dataOraPartenza = dataOraPartenza;
    }

    public String getAereoportoPartenza() {
        return aereoportoPartenza;
    }

    public void setAereoportoPartenza(String aereoportoPartenza) {
        this.aereoportoPartenza = aereoportoPartenza;
    }

    public String getAereoportoDestinazione() {
        return aereoportoDestinazione;
    }

    public void setAereoportoDestinazione(String aereoportoDestinazione) {
        this.aereoportoDestinazione = aereoportoDestinazione;
    }

    public int getDurataInMinuti() {
        return durataInMinuti;
    }

    public void setDurataInMinuti(int durataInMinuti) {
        this.durataInMinuti = durataInMinuti;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Data e ora di partenza: ").append(dataOraPartenza).append("\n");
        sb.append("Aereoporto di partenza: ").append(aereoportoPartenza).append("\n");
        sb.append("Aereoporto di destinazione: ").append(aereoportoDestinazione).append("\n");
        sb.append("Durata in minuti: ").append(durataInMinuti).append("\n");
        return sb.toString().trim();
    }   
}
