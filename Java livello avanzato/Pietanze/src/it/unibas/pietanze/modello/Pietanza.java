package it.unibas.pietanze.modello;

import java.util.ArrayList;
import java.util.List;

public class Pietanza {
    
    private String nome;
    private int costo;
    private String categoria;
    private List<Ingrediente> listaIngredienti = new ArrayList<>();

    public Pietanza(String nome, int costo, String categoria) {
        this.nome = nome;
        this.costo = costo;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome.substring(0, 1).toUpperCase() + nome.substring(1).toLowerCase();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List<Ingrediente> getListaIngredienti() {
        return listaIngredienti;
    }

    public void setListaIngredienti(List<Ingrediente> listaIngredienti) {
        this.listaIngredienti = listaIngredienti;
    }

    public void addIngrediente(Ingrediente ingrediente) {
        this.listaIngredienti.add(ingrediente);
    }

    //PUNTO 1 - MOSTRARE IN TABELLA IL NUMERO DI PIETANZE E SE SONO PRESENTI ALLERGENI O MENO
    public int getNumeroIngredienti() {
        return this.listaIngredienti.size();
    }

    public boolean isContieneAllergene() {
        for (Ingrediente ingrediente : this.listaIngredienti) {
            if (ingrediente.isAllergene()) {
                return true;
            }
        }
        return false;
    }

    //PUNTO 2 - UTENTE CERCA PIETANZA CALORICAMENTE SIMILE
    public double getKcal() {
        double calcolaCalorie = 0.0;
        for (Ingrediente ingrediente : this.listaIngredienti) {
            calcolaCalorie += ingrediente.getKcalCalcola();
        }
        return calcolaCalorie;
    }
}
