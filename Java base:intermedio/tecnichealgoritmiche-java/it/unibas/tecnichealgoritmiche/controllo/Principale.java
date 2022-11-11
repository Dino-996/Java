package it.unibas.tecnichealgoritmiche.controllo;

import it.unibas.tecnichealgoritmiche.modello.Album;
import it.unibas.tecnichealgoritmiche.modello.Figurina;
import it.unibas.utilita.Console;
import java.util.List;

public class Principale {
    
    public void esegui() {
        Album album = new Album();
        boolean continua = true;
        while (continua) {
            int scelta = this.schermoMenu();
            if (scelta == 0) {
                continua = false;
            } else if (scelta == 1) {
                this.schermoStampaFigurine(album);
            } else if (scelta == 2) {
                Figurina figurina = this.schermoNuovaFigurina();
                album.addFigurina(figurina);
                System.out.println("Figurina inserita");
            } else if (scelta == 3) {
                this.schermoCercaFigurina(album);
            } else if (scelta == 4) {
                Figurina figurina = this.schermoCercaFigurina(album);
                if (figurina != null) {
                    this.schermoAggiornaFigurina(figurina);
                    System.out.println("Figurina aggiornata");
                }
            } else if (scelta == 5) {
                Figurina figurina = this.schermoCercaFigurina(album);
                if (figurina != null) {
                    album.removeFigurina(figurina);
                    System.out.println("Figurina rimossa");
                }
            } else if (scelta == 6) {
                this.schermoCercaFigurine(album);
            } else if (scelta == 7) {
                this.schermoCostoTotaleFigurine(album);
            } else if (scelta == 8) {
                this.schermoFigurineCostose(album);
            } else if (scelta == 9) {
                if (album.getNumeroFigurine() == 0) {
                    System.out.println("Operazione impossibile. Album vuoto");
                } else {
                    this.schermoFigurinaPiuCostosa(album);
                }
            } else if (scelta == 10) {
                this.schermoVerificaFigurineConsecutiveUguali(album);
            } else if (scelta == 11) {
                this.schermoVerificaFigurineDiverse(album);
            }
        }
        System.out.println("\nArrivederci.");
    }
    
    private int schermoMenu() {
        int scelta;
        System.out.println("-------------------------------");
        System.out.println("        Album Figurine         ");
        System.out.println("-------------------------------");
        System.out.println();
        System.out.println("   1. Stampa figurine");
        System.out.println("   2. Inserisci figurina");
        System.out.println("   3. Cerca figurina per numero");
        System.out.println("   4. Aggiorna figurina");
        System.out.println("   5. Rimuovi figurina");
        System.out.println("   6. Cerca figurine per parola chiave");
        System.out.println("   7. Calcola costo totale figurine");
        System.out.println("   8. Conta figurine costose");
        System.out.println("   9. Cerca figurina piu' costosa");
        System.out.println("  10. Verifica esistenza figurine consecutive uguali");
        System.out.println("  11. Verifica doppioni");
        System.out.println();
        System.out.println("   0. Esci");
        System.out.println();
        System.out.print("   Scelta ----> ");
        scelta = Console.leggiIntero();
        while ((scelta < 0) || (scelta > 11)) {
            System.out.print("   Errore. Ripeti ----> ");
            scelta = Console.leggiIntero();
        }
        return scelta;
    }
    
    public static void main(String[] args) {
        Principale principale = new Principale();
        principale.esegui();
    }
    
    private void schermoStampaFigurine(Album album) {
        System.out.println("-----------------------------");
        System.out.println("-    Stampa delle figurine  -");
        System.out.println("-----------------------------");
        if (album.getNumeroFigurine() == 0) {
            System.out.println("Non ci sono figurine nell'album");
        } else {
            for (int i = 0; i < album.getNumeroFigurine(); i++) {
                System.out.println(album.getFigurina(i));
            }
        }
    }
    
    private Figurina schermoNuovaFigurina() {
        System.out.println("-----------------------------");
        System.out.println("-    Inserimento figurina   -");
        System.out.println("-----------------------------");
        System.out.print("Immetti il numero ->       ");
        int numero = Console.leggiIntero();
        while (numero <= 0) {
            System.out.print("ERRORE: Valore scorretto. Ripeti ->");
            numero = Console.leggiIntero();
        }
        System.out.print("Immetti la descrizione ->  ");
        String descrizione = Console.leggiStringa();
        while (descrizione.isEmpty()) {
            System.out.print("ERRORE: Valore scorretto. Ripeti ->");
            descrizione = Console.leggiStringa();
        }
        System.out.print("Immetti il costo ->        ");
        double costo = Console.leggiDouble();
        while (costo <= 0) {
            System.out.print("ERRORE: Valore scorretto. Ripeti ->");
            costo = Console.leggiDouble();
        }
        Figurina figurina = new Figurina(numero, descrizione, costo);
        return figurina;
    }
    
    private Figurina schermoCercaFigurina(Album album) {
        System.out.println("-----------------------------");
        System.out.println("-  Ricerca della figurina   -");
        System.out.println("-----------------------------");
        System.out.print("Immetti il numero ->     ");
        int numero = Console.leggiIntero();
        while (numero <= 0) {
            System.out.print("ERRORE: Valore scorretto. Ripeti ->");
            numero = Console.leggiIntero();
        }
        Figurina figurina = album.cercaFigurinaPerNumero(numero);
        if (figurina != null) {
            System.out.println("Figurina trovata: " + figurina);
        } else {
            System.out.println("Figurina inesistente");
        }
        return figurina;
    }
    
    private void schermoAggiornaFigurina(Figurina figurina) {
        System.out.println("-----------------------------");
        System.out.println("-  Aggiornamento figurina   -");
        System.out.println("-----------------------------");
        System.out.println("Valori attuali:");
        System.out.println(figurina);
        System.out.print("Immetti il nuovo numero ->      ");
        int numero = Console.leggiIntero();
        while (numero <= 0) {
            System.out.print("ERRORE: Valore scorretto. Ripeti ->");
            numero = Console.leggiIntero();
        }
        System.out.print("Immetti la nuova descrizione -> ");
        String descrizione = Console.leggiStringa();
        while (descrizione.isEmpty()) {
            System.out.print("ERRORE: Valore scorretto. Ripeti ->");
            descrizione = Console.leggiStringa();
        }
        System.out.print("Immetti il nuovo costo ->       ");
        double costo = Console.leggiDouble();
        while (costo <= 0) {
            System.out.print("ERRORE: Valore scorretto. Ripeti ->");
            costo = Console.leggiDouble();
        }
        figurina.setNumero(numero);
        figurina.setDescrizione(descrizione);
        figurina.setCosto(costo);
    }
    
    private void schermoCercaFigurine(Album album) {
        System.out.println("-----------------------------");
        System.out.println("-  Ricerca della figurina   -");
        System.out.println("-----------------------------");
        System.out.print("Immetti la parola chiave ->     ");
        String parolaChiave = Console.leggiStringa();
        while (parolaChiave.isEmpty()) {
            System.out.print("ERRORE: Valore scorretto. Ripeti ->");
            parolaChiave = Console.leggiStringa();
        }
        List<Figurina> risultatoRicerca = album.cercaFigurinePerDescrizione(parolaChiave);
        if (risultatoRicerca.isEmpty()) {
            System.out.println("Non ci sono figurine la cui descrizione contiene la parola chiave cercata");
        } else {
            System.out.println("Risultato della ricerca:");
            for (Figurina figurina : risultatoRicerca) {
                System.out.println(figurina);
            }
        }
    }
    
    private void schermoCostoTotaleFigurine(Album album) {
        System.out.println("-----------------------------");
        System.out.println("-  Calcolo costo totale     -");
        System.out.println("-----------------------------");
        System.out.println("Costo totale: " + album.getCostoTotale());
    }
    
    private void schermoFigurineCostose(Album album) {
        System.out.println("-----------------------------");
        System.out.println("- Ricerca figurine costose  -");
        System.out.println("-----------------------------");
        System.out.print("Immetti il costo minimo ->     ");
        double costoMinimo = Console.leggiDouble();
        while (costoMinimo < 0) {
            System.out.print("ERRORE: Valore scorretto. Ripeti ->");
            costoMinimo = Console.leggiDouble();
        }
        System.out.println("Le figurine di costo superiore sono: " + album.getNumeroFigurineCostose(costoMinimo));
    }
    
    private void schermoFigurinaPiuCostosa(Album album) {
        System.out.println("-----------------------------");
        System.out.println("-  Figurina piu' costosa    -");
        System.out.println("-----------------------------");
        System.out.println("La figurina piu' costosa e': " + album.cercaFigurinaMaxCosto());
    }
    
    private void schermoVerificaFigurineConsecutiveUguali(Album album) {
        System.out.println("-----------------------------");
        System.out.println("-  Verifica locale          -");
        System.out.println("-----------------------------");
        if (album.verificaFigurineConsecutiveUguali()) {
            System.out.println("L'album contiene due figurine consecutive con lo stesso numero");
        } else {
            System.out.println("L'album non contiene due figurine consecutive con lo stesso numero");
        }
    }
    
    private void schermoVerificaFigurineDiverse(Album album) {
        System.out.println("-----------------------------");
        System.out.println("-  Verifica globale          -");
        System.out.println("-----------------------------");
        if (album.verificaFigurineDiverse()){
            System.out.println("L'album non contiene doppioni");
        } else {
            System.out.println("L'album contiene doppioni");
        }
    }
    
    
}
