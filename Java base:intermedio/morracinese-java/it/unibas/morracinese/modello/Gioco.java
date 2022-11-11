package it.unibas.morracinese.modello;

import it.unibas.morracinese.Costanti;

public class Gioco {

    private int partiteVinteDalComputer;
    private int partiteVinteDalGiocatore;
    private String nomeGiocatore;

    public String getNomeGiocatore() {
        return this.nomeGiocatore;
    }

    public void setNomeGiocatore(String nomeGiocatore) {
        this.nomeGiocatore = nomeGiocatore;
    }

    public int getPartiteVinteDalComputer() {
        return this.partiteVinteDalComputer;
    }

    public int getPartiteVinteDalGiocatore() {
        return this.partiteVinteDalGiocatore;
    }

    public void gestisciPartita(Partita partita) {
        if (partita.getStato() == Costanti.PARTITAVINTADALCOMPUTER) {
            this.partiteVinteDalComputer++;
        } else if (partita.getStato() == Costanti.PARTITAVINTADALGIOCATORE) {
            this.partiteVinteDalGiocatore++;
        }
    }
}
