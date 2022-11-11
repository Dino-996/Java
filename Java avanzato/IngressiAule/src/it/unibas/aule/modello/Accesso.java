package it.unibas.aule.modello;

import java.text.DateFormat;
import java.util.Calendar;

public class Accesso {

    private String matricola;
    private String nome;
    private double tempoPermanenza;
    private String motivazione;
    private Calendar dataOra;

    public Accesso(String matricola, String nome, double tempoPermanenza, String motivazione, Calendar dataOra) {
        this.matricola = matricola;
        this.nome = nome;
        this.tempoPermanenza = tempoPermanenza;
        this.motivazione = motivazione;
        this.dataOra = dataOra;
    }

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getTempoPermanenza() {
        return tempoPermanenza;
    }

    public void setTempoPermanenza(double tempoPermanenza) {
        this.tempoPermanenza = tempoPermanenza;
    }

    public String getMotivazione() {
        return motivazione;
    }

    public void setMotivazione(String motivazione) {
        this.motivazione = motivazione;
    }

    public Calendar getDataOra() {
        return dataOra;
    }

    public void setDataOra(Calendar dataOra) {
        this.dataOra = dataOra;
    }
    
    public String dataFormattata() {
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
        return df.format(this.dataOra.getTime());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Accesso{");
        sb.append("matricola=").append(matricola);
        sb.append(", nome=").append(nome);
        sb.append(", tempoPermanenza=").append(tempoPermanenza);
        sb.append(", motivazione=").append(motivazione);
        sb.append(", dataOra=").append(dataFormattata());
        sb.append('}');
        return sb.toString();
    }
}
