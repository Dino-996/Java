package it.unibas.tecnichealgoritmiche.modello;

public class Figurina {

    private int numero;
    private String descrizione;
    private double costo;

    public Figurina(int numero, String descrizione, double costo) {
        this.numero = numero;
        this.descrizione = descrizione;
        this.costo = costo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public int getNumero() {
        return numero;
    }

    public double getCosto() {
        return costo;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String toString() {
        return "Figurina n. " + this.numero + " - Descrizione: " + this.descrizione + " - Costo: " + this.costo;
    }
}
