package it.unibas.morracinese.modello;

import it.unibas.morracinese.Costanti;

public class Partita {
    private int maniVinteDalComputer = 0;
    private int maniVinteDalGiocatore = 0;
    private int pareggi = 0;

    public int getManiVinteDalComputer() {
        return this.maniVinteDalComputer;
    }

    public int getManiVinteDalGiocatore() {
        return this.maniVinteDalGiocatore;
    }

    public int getPareggi() {
        return this.pareggi;
    }

    public Mano giocaMano(int giocata) {
        Mano mano = new Mano();
        mano.gioca(giocata);
        int esito = mano.getEsito();
        if (esito == Costanti.MANOVINTADALCOMPUTER) {
            this.maniVinteDalComputer++;
        } else if (esito == Costanti.MANOVINTADALGIOCATORE) {
            this.maniVinteDalGiocatore++;
        } else if (esito == Costanti.MANOINPAREGGIO) {
            this.pareggi++;
        }
        return mano;
    }

    public int getStato(){
        int stato = Costanti.PARTITAINCORSO;
        if (this.maniVinteDalComputer == Costanti.LIMITEMANI) {
            stato = Costanti.PARTITAVINTADALCOMPUTER;
        } else if (this.maniVinteDalGiocatore == Costanti.LIMITEMANI) {
            stato = Costanti.PARTITAVINTADALGIOCATORE;
        }
        return stato;
    }

}
