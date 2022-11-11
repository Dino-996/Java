package it.unibas.pietanze.modello;

public class Ingrediente {

    private String nome;
    private double quantita;
    private boolean allergene;
    private double kcal100gr; //Kcal rispetto a 100gr d'ingrediente

    public Ingrediente(String nome, double quantita, boolean allergene, double kcal100gr) {
        this.nome = nome;
        this.quantita = quantita;
        this.allergene = allergene;
        this.kcal100gr = kcal100gr;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getQuantita() {
        return quantita;
    }

    public void setQuantita(double quantita) {
        this.quantita = quantita;
    }

    public boolean isAllergene() {
        return allergene;
    }

    public void setAllergene(boolean allergene) {
        this.allergene = allergene;
    }

    public double getKcal100gr() {
        return kcal100gr;
    }

    public void setKcal100gr(double kcal100gr) {
        this.kcal100gr = kcal100gr;
    }
    
    public double getKcalCalcola() {
        return this.quantita * this.kcal100gr / 100.0;
    }
}
