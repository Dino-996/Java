package it.unibas.morracinese.modello;

import it.unibas.morracinese.Costanti;
import java.util.Random;

public class Mano {

    private static final Random GENERATORE = new Random();

    private int giocataGiocatore;
    private int giocataComputer;

    public void gioca(int giocataGiocatore) {
        setGiocataGiocatore(giocataGiocatore);
        generaGiocataComputer();
    }

    public boolean isValida(int giocata) {
        return (giocata >= Costanti.CARTA && giocata <= Costanti.SASSO);
    }

    public int getGiocataGiocatore() {
        return this.giocataGiocatore;
    }

    public int getGiocataComputer() {
        return this.giocataComputer;
    }

    private void setGiocataGiocatore(int giocataGiocatore) {
        this.giocataGiocatore = giocataGiocatore;
    }

    private void generaGiocataComputer() {
        this.giocataComputer = GENERATORE.nextInt(3) + 1;
    }

    public int getEsito() {
        int esito = Costanti.MANOVINTADALCOMPUTER;
        if (this.giocataGiocatore == this.giocataComputer) {
            esito = Costanti.MANOINPAREGGIO;
        } else if ((this.giocataGiocatore == Costanti.CARTA) && (this.giocataComputer == Costanti.SASSO)) {
            esito = Costanti.MANOVINTADALGIOCATORE;
        } else if ((this.giocataGiocatore == Costanti.FORBICI) && (this.giocataComputer == Costanti.CARTA)) {
            esito = Costanti.MANOVINTADALGIOCATORE;
        } else if ((this.giocataGiocatore == Costanti.SASSO) && (this.giocataComputer == Costanti.FORBICI)) {
            esito = Costanti.MANOVINTADALGIOCATORE;
        }
        return esito;
    }
}

