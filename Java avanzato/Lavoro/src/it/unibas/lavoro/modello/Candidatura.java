package it.unibas.lavoro.modello;

public class Candidatura {
    private String codiceNumerico;
    private String codiceFiscale;
    private int eta;

    public Candidatura(String codiceNumerico, String codiceFiscale, int eta) {
        this.codiceNumerico = codiceNumerico;
        this.codiceFiscale = codiceFiscale;
        this.eta = eta;
    }

    public String getCodiceNumerico() {
        return codiceNumerico;
    }

    public void setCodiceNumerico(String codiceNumerico) {
        this.codiceNumerico = codiceNumerico;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Candidatura{");
        sb.append("codiceNumerico=").append(codiceNumerico);
        sb.append(", codiceFiscale=").append(codiceFiscale);
        sb.append(", eta=").append(eta);
        sb.append('}');
        return sb.toString();
    }
}
