package it.unibas.cesti.modello;

import java.text.DateFormat;
import java.util.Calendar;

public class Prodotto {
    private String nome;
    private String tipologia;
    private int peso;
    private Calendar dataScadenza;

    public Prodotto(String nome, String tipologia, int peso, Calendar dataScadenza) {
        this.nome = nome;
        this.tipologia = tipologia;
        this.peso = peso;
        this.dataScadenza = dataScadenza;
    }

    public String getNome() {
        return nome;
    }

    public String getTipologia() {
        return tipologia;
    }

    public int getPeso() {
        return peso;
    }

    public Calendar getDataScadenza() {
        return dataScadenza;
    }
    
    public String formattaData() {
        String dataFormattata;
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
        dataFormattata = df.format(this.dataScadenza.getTime());
        return dataFormattata;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Prodotto{");
        sb.append("nome=").append(nome);
        sb.append(", tipologia=").append(tipologia);
        sb.append(", peso=").append(peso);
        sb.append(", dataScadenza=").append(this.formattaData());
        sb.append('}');
        return sb.toString();
    }
}
