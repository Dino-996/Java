package it.unibas.fantacalcio.controllo;
import it.unibas.fantacalcio.modello.*;
import it.unibas.utilita.*;
import java.util.*;

public class Principale {
	public static void main(String[] args) {
		Principale principale = new Principale();
		principale.esegui();
	}

	private void esegui() {
		Fantacalcio fantacalcio = new Fantacalcio();
		//fantacalcio = caricaMock();
		//System.out.println(fantacalcio);
		while(true) {
			int scelta = schermoMenu();
			if (scelta == 0) {
				break;
			}
			if (scelta == 1) {
				schermoAggiungiGirone(fantacalcio);
			}
			if (scelta == 2) {
				schermoAggiungiGiocatore(fantacalcio);
			}
			if (scelta == 3) {
				schermoStampaGiocatoreMigliore(fantacalcio);
			}
			if (scelta == 4) {
				schermoStampaMedia(fantacalcio);
			}
		}
	}

	private int schermoMenu() {
		System.out.println("\n");
		System.out.println("----------------------------------");
		System.out.println("            FANTACALCIO           ");
		System.out.println("----------------------------------");
		System.out.println(" 1. Aggiungi girone               ");
		System.out.println(" 2. Aggiungi giocatore            ");
		System.out.println(" 3. Stampa giocatore migliore     ");
		System.out.println(" 4. Stampa media voto giocatori   ");
		System.out.println("----------------------------------");
		System.out.println(" 0. Esci                          ");
		System.out.println("----------------------------------");
		System.out.println("\n");
		int scelta = leggiInteroLimitato(0, 4, "Scelta--> ");
		return scelta;
	}

	private void schermoStampaMedia(Fantacalcio fantacalcio) {
		int numero = leggiInteroLimitato(1, 20, "Girone: ");
		Girone leggiGirone = fantacalcio.leggiNumero(numero);
		if(leggiGirone == null) {
			System.out.println("Girone inesistente");
			return;
		}
		String ruolo = leggiTipologia("Ruolo: ");
		Giocatore calcolaMedia = leggiGirone.mediaVotiGiocatori(ruolo);
		if (calcolaMedia == null) {
			System.out.println("ERRORE: Non esistono giocatori per il ruolo inserito");
		} else {
			System.out.println("Media calcolata per il ruolo di " + ruolo + ": " + leggiGirone.getMedia());
		}
	}

	private void schermoStampaGiocatoreMigliore(Fantacalcio fantacalcio) {
		int numero = leggiInteroLimitato(1, 20, "Girone: ");
		Girone leggiGirone = fantacalcio.leggiNumero(numero);
		if(leggiGirone == null) {
			System.out.println("Girone inesistente");
			return;
		}
		String ruolo = leggiTipologia("Ruolo: ");
		Giocatore cercaMigliore = leggiGirone.leggiGiocatoreMigliore(ruolo);
		if (cercaMigliore == null) {
			System.out.println("ERRORE: Non esistono giocatori per il ruolo inserito");
		} else {
			System.out.println("Giocatore migliore per il ruolo inserito:\n" + cercaMigliore);
		}
	}

	private void schermoAggiungiGiocatore(Fantacalcio fantacalcio) {
		int numero = leggiInteroLimitato(1, 20, "Girone: ");
		Girone leggiGirone = fantacalcio.leggiNumero(numero);
		if(leggiGirone == null) {
			System.out.println("Girone inesistente");
			return;
		}
		String nome = leggiStringaNonVuota("Nome: ");
		String ruolo = leggiTipologia("Tipologia: "); 
		int costo = leggiInteroLimitato(10000, 500000, "Costo: ");
		int voto = leggiInteroLimitato(1, 10, "Voto: ");
		Giocatore giocatore = new Giocatore(nome, ruolo, costo, voto);
		leggiGirone.addGiocatore(giocatore);
		System.out.println("*** Giocatore aggiunto correttamente ***");
	}

	private void schermoAggiungiGirone(Fantacalcio fantacalcio) {
		int numero = leggiInteroLimitato(1, 20, "Girone: ");
		while(fantacalcio.leggiNumero(numero) != null) {
			System.out.println("Errore: Girone già esistente, riprova");
			numero = leggiInteroLimitato(1, 20, "Girone: ");
		}
		String stagione = leggiStringaNonVuota("Stagione: ");
		String data = leggiStringaNonVuota("Data: ");
		Girone girone = new Girone(numero, stagione, data);
		fantacalcio.addGirone(girone);
		System.out.println("*** Girone aggiunto correttamente ***");
	}

	private Fantacalcio caricaMock() {
		Fantacalcio fantacalcio = new Fantacalcio();

		Girone girone1 = new Girone(1, "A", "14/08/2021");
		Giocatore giocatore1 = new Giocatore("Salam Alekum", Giocatore.RUOLO_A, 300000, 10);
		
		girone1.addGiocatore(giocatore1);
		fantacalcio.addGirone(girone1);

		return fantacalcio;
	}

	private String leggiTipologia(String stampa) {
		System.out.println(stampa);
		int valore = leggiInteroLimitato(1, 4, "1. Attaccante\n2. Difensore\n3. Centrocampista \n4. Portiere\nScelta--> ");
		if (valore == 1) {
			return Giocatore.RUOLO_A;
		}
		if (valore == 2) {
			return Giocatore.RUOLO_D;
		}
		if (valore == 3) {
			return Giocatore.RUOLO_C;
		}
		return Giocatore.RUOLO_P;
	}

	private String leggiStringaNonVuota(String messaggio) {
		System.out.print(messaggio);
		String valore = Console.leggiStringa();
		while(valore.isEmpty()) {
			System.out.println("ERRORE: Impossibile lasciare il campo vuoto");
			System.out.print(messaggio);
			valore = Console.leggiStringa();
		}
		return valore;
	}

	private int leggiInteroLimitato(int min, int max, String messaggio) {
		System.out.print(messaggio);
		int valore = Console.leggiIntero();
		while(valore < min || valore > max) {
			System.out.println("ERRORE: Inserisci un numero compreso tra " + min + " e " + max);
			System.out.print(messaggio);
			valore = Console.leggiIntero();
		}
		return valore;
	}
}