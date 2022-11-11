package it.unibas.supermercato.modello;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Supermercato {

    private final String nome;
    private final String citta;
    private final String via;
    private final int civico;
    private final Calendar dataAggiornamentoProdotti;
    private final List<Prodotto> listaProdotti = new ArrayList<>();

    public Supermercato(String nome, String citta, String via, int civico, Calendar dataAggiornamentoProdotti) {
        this.nome = nome;
        this.citta = citta;
        this.via = via;
        this.civico = civico;
        this.dataAggiornamentoProdotti = dataAggiornamentoProdotti;
    }

    public String getNome() {
        return nome;
    }

    public String getCitta() {
        return citta;
    }

    public String getVia() {
        return via;
    }

    public int getCivico() {
        return civico;
    }

    public Calendar getDataAggiornamentoProdotti() {
        return dataAggiornamentoProdotti;
    }

    public List<Prodotto> getListaProdotti() {
        return listaProdotti;
    }

    public void addProdotto(Prodotto prodotto) {
        this.listaProdotti.add(prodotto);
    }

    private String formattaData() {
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
        String dataFormattata = df.format(dataAggiornamentoProdotti);
        return dataFormattata;
    }

    private boolean isDuplicati(int id) {
        boolean verifica = false;
        for (Prodotto prodotto : this.listaProdotti) {
            if (prodotto.getIdProdotto() == id) {
                verifica = true;
            }
        }
        return verifica;
    }
    
    public int contaDuplicati() {
        int conta = 0;
        for (Prodotto prodotto : this.listaProdotti) {
            if (isDuplicati(prodotto.getIdProdotto())) {
                conta++;
            }
        }
        return conta;
    }
    
    public double getMediaPrezzi() {
        double somma = 0;
        for (Prodotto prodotto : this.listaProdotti) {
            somma += prodotto.getPrezzo();
        }
        double media = somma / this.listaProdotti.size();
        return media;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome:").append(this.nome).append("\n");
        sb.append("Citta:").append(this.citta).append("\n");
        sb.append("Via: ").append(this.via).append("\n");
        sb.append("Data aggiornamento prodotti: ").append(formattaData()).append("\n");
        return sb.toString().trim();
    }
}
