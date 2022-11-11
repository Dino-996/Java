package it.unibas.supermercato.modello;

import java.text.DateFormat;
import java.util.Calendar;

public class Prodotto {

    private final int idProdotto; //Identificativo univoco prodotto
    private final String nome;
    private final String descrizione;
    private final double prezzo;
    private final Calendar dataInserimentoProdotto;

    public Prodotto(int idProdotto, String nome, String descrizione, double prezzo, Calendar dataInserimentoProdotto) {
        this.idProdotto = idProdotto;
        this.nome = nome;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.dataInserimentoProdotto = dataInserimentoProdotto;
    }

    public int getIdProdotto() {
        return idProdotto;
    }

    public String getNome() {
        return nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public Calendar getDataInserimentoProdotto() {
        return dataInserimentoProdotto;
    }

    private String formattaData() {
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
        String dataFormattata = df.format(dataInserimentoProdotto);
        return dataFormattata;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome prodotto: ").append(this.nome).append("\n");
        sb.append("Descrizione: ").append(this.descrizione).append("\n");;
        sb.append("Prezzo: ").append(this.prezzo).append("\n");
        sb.append("Data inserimento: ").append(formattaData()).append("\n");
        return sb.toString().trim();
    }
    
    //Posso ordinare per prodotto piu costoso e meno costoso
}
