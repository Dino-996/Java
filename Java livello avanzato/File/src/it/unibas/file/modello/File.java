package it.unibas.file.modello;

import java.util.Calendar;

public class File {

    private final String nome;
    private final int dimensione;
    private final Calendar dataCreazione;

    public File(String nome, int dimensione, Calendar dataCreazione) {
        this.nome = nome;
        this.dimensione = dimensione;
        this.dataCreazione = dataCreazione;
    }

    public String getNome() {
        return nome;
    }

    public int getDimensione() {
        return dimensione;
    }

    public Calendar getDataCreazione() {
        return dataCreazione;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("File{");
        sb.append("nome=").append(nome);
        sb.append(", dimensione=").append(dimensione);
        sb.append(", dataCreazione=").append(dataCreazione);
        sb.append('}');
        return sb.toString();
    }

}
