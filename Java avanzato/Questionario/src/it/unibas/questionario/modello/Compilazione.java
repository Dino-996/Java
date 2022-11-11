package it.unibas.questionario.modello;

public class Compilazione {

    private int codiceNumerico;
    private boolean esito;
    private int tempoCompilazione;

    public Compilazione(int codiceNumerico, boolean esito, int tempoCompilazione) {
        this.codiceNumerico = codiceNumerico;
        this.esito = esito;
        this.tempoCompilazione = tempoCompilazione;
    }

    public int getCodiceNumerico() {
        return codiceNumerico;
    }

    public void setCodiceNumerico(int codiceNumerico) {
        this.codiceNumerico = codiceNumerico;
    }

    public boolean isEsito() {
        return esito;
    }

    public void setEsito(boolean esito) {
        this.esito = esito;
    }

    public int getTempoCompilazione() {
        return tempoCompilazione;
    }

    public void setTempoCompilazione(int tempoCompilazione) {
        this.tempoCompilazione = tempoCompilazione;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Codice numerico: ").append(this.codiceNumerico).append("\n");
        sb.append("Esito: ").append(this.esito).append("\n");
        sb.append("Tempo compilazione: ").append(tempoCompilazione).append("\n");
        return sb.toString().trim();
    }
}
