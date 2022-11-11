package calcolatricestatica;

public class PrincipaleStatica {
    
    public static void eseguiOperazioni() {
        boolean continua = true;
        while (continua) {
            double a = 0, b = 0, risultato = 0;
            int scelta = PrincipaleStatica.schermoMenu();
            if (scelta == 0) {
                continua = false;
            } else {
                if (scelta <= 4) { // operazioni senza memoria: due operandi
                    System.out.print("   Inserisci il primo argomento:   --> ");
                    a = it.unibas.utilita.Console.leggiDouble();
                    System.out.print("   Inserisci il secondo argomento: --> ");
                    b = it.unibas.utilita.Console.leggiDouble();
                } else if (scelta >= 5 && scelta <=8 ) { //operazioni con memoria: un operando
                    System.out.print("   Inserisci l'argomento:   --> ");
                    b = it.unibas.utilita.Console.leggiDouble();
                }
                if (scelta == 1) {
                    risultato = CalcolatriceStatica.somma(a, b);
                }
                if (scelta == 2) {
                    risultato = CalcolatriceStatica.sottrai(a, b);
                }
                if (scelta == 3) {
                    risultato = CalcolatriceStatica.moltiplica(a, b);
                }
                if (scelta == 4) {
                    while (b == 0) {
                        System.out.println("   Errore. Dividendo nullo.");
                        System.out.print("   Inserisci il secondo argomento: --> ");
                        b = it.unibas.utilita.Console.leggiDouble();
                    }
                    risultato = CalcolatriceStatica.dividi(a, b);
                }
                if (scelta == 5) {
                    risultato = CalcolatriceStatica.sommaAlRisultato(b);
                }
                if (scelta == 6) {
                    risultato = CalcolatriceStatica.sottraiDalRisultato(b);
                }
                if (scelta == 7) {
                    risultato = CalcolatriceStatica.moltiplicaPerIlRisultato(b);
                }
                if (scelta == 8) {
                    while (b == 0) {
                        System.out.println("   Errore. Dividendo nullo.");
                        System.out.print("   Inserisci l'argomento: --> ");
                        b = it.unibas.utilita.Console.leggiDouble();
                    }
                    risultato = CalcolatriceStatica.dividiIlRisultato(b);
                }
                if (scelta == 9) {
                    risultato = CalcolatriceStatica.getRisultatoInMemoria();
                }
                System.out.println("\n   Risultato: " + risultato + "\n");
            }
        }
        System.out.println("\nArrivederci.");
    }
    
    private static int schermoMenu() {
        int scelta;
        System.out.println("-------------------------------");
        System.out.println("        Calcolatrice           ");
        System.out.println("-------------------------------");
        System.out.println();
        System.out.println("   1. Esegui somma");
        System.out.println("   2. Esegui differenza");
        System.out.println("   3. Esegui moltiplicazione");
        System.out.println("   4. Esegui divisione");
        System.out.println("   5. Esegui somma con il risultato precedente");
        System.out.println("   6. Esegui differenza dal risultato precedente");
        System.out.println("   7. Esegui moltiplicazione per il risultato precedente");
        System.out.println("   8. Esegui divisione del risultato precedente");
        System.out.println("   9. Visualizza contenuto memoria");
        System.out.println();
        System.out.println("   0. Esci");
        System.out.println();
        System.out.print("   Scelta ----> ");
        scelta = it.unibas.utilita.Console.leggiIntero();
        while ((scelta < 0) || (scelta > 9)) {
            System.out.print("   Errore. Ripeti ----> ");
            scelta = it.unibas.utilita.Console.leggiIntero();
        }
        return scelta;
    }
    
    public static void main(String args[]) {
        PrincipaleStatica.eseguiOperazioni();
    }
}
