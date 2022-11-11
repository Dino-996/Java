package it.unibas.banca.modello;

import java.util.Calendar;

public class Movimento {

    private Calendar dataOra;
    private double importo;
    private String tipologia;

    public Movimento(Calendar dataOra, double importo, String tipologia) {
        this.dataOra = dataOra;
        this.importo = importo;
        this.tipologia = tipologia;
    }

    public Calendar getDataOra() {
        return dataOra;
    }

    public double getImporto() {
        return importo;
    }

    public String getTipologia() {
        return tipologia;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Movimento{");
        sb.append("dataOra=").append(dataOra);
        sb.append(", importo=").append(importo);
        sb.append(", tipologia=").append(tipologia);
        sb.append('}');
        return sb.toString();
    } 
}
