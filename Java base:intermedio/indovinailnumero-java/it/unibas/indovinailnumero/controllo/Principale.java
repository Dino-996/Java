package it.unibas.indovinailnumero.controllo;

import it.unibas.indovinailnumero.modello.Partita;
import it.unibas.utilita.Console;

public class Principale {

    public void schermoIniziale() {
        boolean continua = true;
        while (continua) {
            System.out.println("\n-----------------------------------");
            System.out.println(" Benvenuto, il mio nome e' Joshua");
            System.out.println(" Vogliamo fare una partita ?");
            System.out.println("-----------------------------------\n");
            System.out.print("--> Inserisci il tuo nome: ");
            String nome = this.leggiStringaNonVuota();
            Partita partita = new Partita();
            partita.setNome(nome);
            schermoTentativi(partita);
            char risposta = schermoNuovaPartita();
            if (risposta == 'n') {
                continua = false;
            }
        }
        schermoUscita();
    }

    private void schermoTentativi(Partita partita) {
        boolean esci = false;
        while (!partita.getTrovato() && !esci) {
            int tentativo = schermoLeggiTentativo(partita);
            if (tentativo == 0) {
                esci = true;
            } else {
                partita.gestisciTentativo(tentativo);
            }
        }
        if (esci) {
            schermoInterruzione(partita);
        } else {
            schermoFineGioco(partita);
        }
    }

    private int schermoLeggiTentativo(Partita partita) {
        System.out.println("\n--------------------------------");
        System.out.println("\n***** " + partita.getSuggerimento() + " *****");
        System.out.println("\nFinora hai effettuato " + partita.getNumeroDiTentativi() + " tentativi");
        System.out.print("\n--> " + partita.getNome() + ", inserisci il tuo tentativo (0 per smettere): ");
        int tentativo = Console.leggiIntero();
        while ((tentativo < 0) || (tentativo > 100)) {
            System.out.println("    Errore. Il valore deve essere compreso tra 1 e 100");
            tentativo = Console.leggiIntero();
        }
        return tentativo;
    }

    private void schermoFineGioco(Partita partita) {
        int numTentativi = partita.getNumeroDiTentativi();
        System.out.println("\nBRAVO, " + partita.getNome() + "! HAI INDOVINATO!");
        System.out.println("\nHai effettuato in totale " + numTentativi + " tentativi");
    }

    private void schermoInterruzione(Partita partita) {
        System.out.println("\nPartita Interrotta");
        System.out.println("Il numero da indovinare era: " + partita.getNumeroDaIndovinare());
    }

    private char schermoNuovaPartita() {
        System.out.print("\nVuoi fare un'altra partita (s/n) ? ");
        char risposta = Console.leggiCarattere();
        while ((risposta != 's') && (risposta != 'n')) {
            System.out.println("Errore: devi scegliere s/n. Vuoi fare un'altra partita (s/n) ?");
            risposta = Console.leggiCarattere();
        }
        return risposta;
    }

    private void schermoUscita() {
        System.out.println("\nArrivederci");
        System.out.println("E saluti al Prof. Falken\n\n");
    }

    private String leggiStringaNonVuota() {
        String stringa = Console.leggiStringa();
        while (stringa.length() == 0) {
            System.out.println("ERRORE: La stringa non puo' essere nulla. Riprova.");
            System.out.print("---> ");
            stringa = Console.leggiStringa();
        }
        return stringa;
    }

    public static void main(String[] args) {
        Principale principale = new Principale();
        principale.schermoIniziale();
    }

}
