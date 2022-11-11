package it.unibas.morracinese.controllo;

import it.unibas.morracinese.Costanti;
import it.unibas.morracinese.modello.Gioco;
import it.unibas.morracinese.modello.Mano;
import it.unibas.morracinese.modello.Partita;
import it.unibas.utilita.Console;

public class Principale {
    
    private final Gioco gioco =  new Gioco();

    public void gioca() {
        String nomeGiocatore = schermoIniziale();
        gioco.setNomeGiocatore(nomeGiocatore);
        boolean continua = true;
        while (continua) {
            int scelta = schermoMenuPrincipale();
            if (scelta == 0) {
                continua = false;
            } else if (scelta == 1) {
                giocaNuovaPartita();
            } else if (scelta == 2) {
                schermoVittorie();
            }
        }
        System.out.println("Arrivederci.");
    }

    private String schermoIniziale(){
        System.out.println();
        System.out.println("Benvenuto nella Morra Cinese");
        System.out.println("--------------------------------------");
        System.out.print("Immetti il tuo nome per iniziare il gioco: ");
        String nomeGiocatore = Console.leggiStringa();
        while (nomeGiocatore.isEmpty()) {
            System.out.println("ERRORE: La stringa non puo' essere vuota. Riprova.");
            System.out.print("---> ");
            nomeGiocatore = Console.leggiStringa();
        }
        System.out.println("+-------------------------------------+");
        System.out.println("   Benvenuto, " + nomeGiocatore);
        System.out.println("+-------------------------------------+");
        return nomeGiocatore;
    }

    private int schermoMenuPrincipale() {
        int scelta;
        System.out.println("+-------------------------------------+");
        System.out.println("|  1. Nuova Partita                   |");
        System.out.println("|  2. Visualizza Vittorie             |");
        System.out.println("|  0. Esci dal Gioco                  |");
        System.out.println("+-------------------------------------+");
        System.out.print("   Scelta --> ");
        scelta = Console.leggiIntero();
        while ((scelta < 0) || (scelta > 2)) {
            System.out.print("*****  Errore: Scelta scorretta. Nuova scelta --> ");
            scelta = Console.leggiIntero();
        }
        return scelta;
    }

    private void schermoVittorie() {
        System.out.println("+-------------------------------------+");
        System.out.println("   " + gioco.getNomeGiocatore() + " hai vinto " + gioco.getPartiteVinteDalGiocatore() + " partite");
        System.out.println("   Il computer ha vinto " + gioco.getPartiteVinteDalComputer() + " partite");
        System.out.println("+-------------------------------------+");
        return;
    }

    public void giocaNuovaPartita() {
        Partita partita = new Partita();
        boolean continua = true;
        while (continua) {
            int scelta = schermoMenuPartita(partita);
            if (scelta == 0) {
                schermoPartitaInterrotta(partita);
                continua = false;
            } else {
                Mano mano = partita.giocaMano(scelta);
                schermoEsitoMano(mano);
                if (partita.getStato() != Costanti.PARTITAINCORSO) {
                    schermoEsitoPartita(partita);
                    continua = false;
                }
            }
        }
    }

    private int schermoMenuPartita(Partita partita) {
        int scelta;
        System.out.println("+-------------------------------------+");
        System.out.println("   " + gioco.getNomeGiocatore() + ": punti " + partita.getManiVinteDalGiocatore());
        System.out.println("   Computer: punti " + partita.getManiVinteDalComputer());
        System.out.println("   Pareggi: " + partita.getPareggi());
        System.out.println("+-------------------------------------+");
        System.out.println("+-------------------------------------+");
        System.out.println("   Inserisci la tua giocata");
        System.out.println("+-------------------------------------+");
        System.out.println("|  1. carta                           |");
        System.out.println("|  2. forbici                         |");
        System.out.println("|  3. sasso                           |");
        System.out.println("|                                     |");
        System.out.println("|  0. Interrompi partita              |");
        System.out.println("+-------------------------------------+");
        System.out.print("   Scelta --> ");
        scelta = Console.leggiIntero();
        while ((scelta < 0) || (scelta > 3)) {
            System.out.println("*****  Errore: Scelta scorretta. Nuova scelta ? ");
            scelta = Console.leggiIntero();
        }
        return scelta;
    }

    private void schermoEsitoMano(Mano mano) {
        System.out.println("+-------------------------------------+");
        System.out.println("  " + gioco.getNomeGiocatore() + ", hai giocato: ");
        System.out.println(getSimbolo(mano.getGiocataGiocatore()));
        System.out.println("   Il computer ha giocato: ");
        System.out.println(getSimbolo(mano.getGiocataComputer()));
        int esito = mano.getEsito();
        if (esito == Costanti.MANOVINTADALCOMPUTER) {
            System.out.println("  Peccato, hai perso la mano");
        } else if (esito == Costanti.MANOVINTADALGIOCATORE) {
            System.out.println("  Bravo, hai vinto la mano");
        } else if (esito == Costanti.MANOINPAREGGIO) {
            System.out.println("  Si e' verificato un pareggio");
        }
        System.out.println("+-------------------------------------+");
    }

    private String getSimbolo(int mossa) {
        StringBuilder simbolo = new StringBuilder();
        if (mossa == Costanti.CARTA) {
            simbolo.append(" _____  \n");
            simbolo.append("| ___ \\ \n");
            simbolo.append("| ___ | \n");
            simbolo.append("| ___ | \n");
            simbolo.append("|_____| \n");
        } else if (mossa == Costanti.FORBICI) {
            simbolo.append(" \\\\    // \n");
            simbolo.append("  \\\\  //  \n");
            simbolo.append("   \\\\//   \n");
            simbolo.append("   //\\\\   \n");
            simbolo.append("  //  \\\\  \n");
            simbolo.append(" ()    ()   \n");
        } else if (mossa == Costanti.SASSO) {
            simbolo.append("  ___   \n");
            simbolo.append(" (   )  \n");
            simbolo.append("( (   ) \n");
            simbolo.append("(____)  \n");
            simbolo.append("\n");
        }
        return simbolo.toString();
    }

    private void schermoEsitoPartita(Partita partita) {
        System.out.println("+-------------------------------------+");
        System.out.println("   " + gioco.getNomeGiocatore() + " hai vinto " + partita.getManiVinteDalGiocatore() + " mani");
        System.out.println("   Il computer ha vinto " + partita.getManiVinteDalComputer() + " mani");
        System.out.println("   Ci sono stati " + partita.getPareggi() + " pareggi");
        System.out.println("+-------------------------------------+");
        if (partita.getStato() == Costanti.PARTITAVINTADALGIOCATORE) {
            System.out.println("  Bravo, " + gioco.getNomeGiocatore() + " hai vinto la partita");
        } else if (partita.getStato() == Costanti.PARTITAVINTADALCOMPUTER){
            System.out.println("  Peccato, " + gioco.getNomeGiocatore() + " hai perso la partita");
        }
        this.gioco.gestisciPartita(partita);
        System.out.println("+-------------------------------------+");
    }

    private void schermoPartitaInterrotta(Partita partita) {
        System.out.println("+-------------------------------------+");
        System.out.println("   Partita interrotta. Fino a questo punto:");
        System.out.println("   " + gioco.getNomeGiocatore() + " avevi vinto " + partita.getManiVinteDalGiocatore() + " mani");
        System.out.println("   Il computer aveva vinto " + partita.getManiVinteDalComputer() + " mani");
        System.out.println("   C'erano stati " + partita.getPareggi() + " pareggi");
        System.out.println("+-------------------------------------+");
    }    
    
    public static void main(String[] args){
        Principale principale = new Principale();
        principale.gioca();
    }

}