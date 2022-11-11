package it.unibas.concorsi.modello;

import java.util.Calendar;

public class Domanda {

    private String codiceFiscale;
    private String sesso;
    private Calendar dataDomanda;

    public Domanda(String codiceFiscale, String sesso, Calendar dataDomanda) {
        this.codiceFiscale = codiceFiscale;
        this.sesso = sesso;
        this.dataDomanda = dataDomanda;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public String getSesso() {
        return sesso;
    }

    public void setSesso(String sesso) {
        this.sesso = sesso;
    }

    public Calendar getDataDomanda() {
        return dataDomanda;
    }

    public void setDataDomanda(Calendar dataDomanda) {
        this.dataDomanda = dataDomanda;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Domanda{");
        sb.append("codiceFiscale=").append(codiceFiscale);
        sb.append(", sesso=").append(sesso);
        sb.append(", dataDomanda=").append(dataDomanda);
        sb.append('}');
        return sb.toString();
    }
}
