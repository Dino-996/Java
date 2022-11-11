package it.unibas.calendario.controllo;
import it.unibas.calendario.modello.*;
import it.unibas.utilita.*;
import java.util.*;

public class Principale {

	public static void main(String[] args) {
		Principale principale = new Principale();
		principale.esegui();
	}

	private void esegui() {
		Universita universita = new Universita();
		universita = caricaMock();
		System.out.println(universita);
		while(true) {
			int scelta = schermoMenu();
			if (scelta == 0) {
				break;
			}
			if (scelta == 1) {
				schermoAggiungiAula(universita);
			}
			if (scelta == 2) {
				schermoAggiungiEsame(universita);
			}
			if (scelta == 3) {
				schermoCalcolaNumeroPrenotati(universita);
			}
		}
	}

	private int schermoMenu() {
		System.out.println("\n");
		System.out.println("----------------------------");
		System.out.println("       CALENDARIO ESAMI     ");
		System.out.println("----------------------------");
		System.out.println(" 1. Aggiungi aula           ");
		System.out.println(" 2. Aggiungi esame          ");
		System.out.println(" 3. Calcola numero prenotati");
		System.out.println("----------------------------");
		System.out.println(" 0. Esci                    ");
		System.out.println("----------------------------");
		System.out.println("\n");
		int scelta = leggiInteroLimitato(0, 3, "Scelta--> ");
		return scelta;
	}

	private void schermoCalcolaNumeroPrenotati(Universita universita) {
		String data = leggiSringaNonVuota("Data: ");
		List<Aula> dataEsame = universita.aggiungiPerData(data);
		if (dataEsame == null) {
			System.out.println("ERRORE: Nessun prenotato presente");
		} else {
			int numeroDiPrenotati = calcolaPrenotati(data, dataEsame);
			System.out.println("Il numero di prenotati in data: " + data + " e " + numeroPrenotati);
		}

	}

	private int calcolaPrenotati(String data, List<Esami> intermedio) {
		int somma = 0;
		for (Esami esami : intermedio) {
			if (esami.getData().equalsIgnoreCase(data)) {
				somma += esami.getNumeroPrenotati();
			}
		}
		return somma;
	}

	private void schermoAggiungiEsame(Universita universita) {
		String nomeAula = leggiSringaNonVuota("Nome aula: ");
		Aula aula = universita.cercaPerNome(nomeAula);
		if(aula == null) {
			System.out.println("ERRORE: Aula inesistente");
			return;
		}
		String nomeEsame = leggiSringaNonVuota("Nome esame: ");
		String data = leggiSringaNonVuota("Data: ");
		int oraInizio = leggiInteroLimitato(0, 24, "Ora inizio: ");
		int oraFine = leggiInteroLimitato(0, 24, "Ora fine: ");
		int numeroPrenotati = leggiInteroLimitato(0, 80, "Numero prenotati: ");
		Esami esame = new Esami(nomeEsame, data, oraInizio, oraFine, numeroPrenotati);
		aula.addEsame(esame);
		System.out.println("*** Esame aggiunto correttamente ***");
	}

	private void schermoAggiungiAula(Universita universita) {
		String nomeAula = leggiSringaNonVuota("Nome aula: ");
		while(universita.cercaPerNome(nomeAula) != null) {
			System.out.println("ERRORE: Aula già esistente, riprova");
			nomeAula = leggiSringaNonVuota("Nome aula: ");
		}
		int capienza = leggiInteroLimitato(20, 80, "Capienza: ");
		Aula aula = new Aula(nomeAula, capienza);
		universita.addAula(aula);
		System.out.println("*** Aula aggiunta correttamente ***");
	}

	private String leggiSringaNonVuota(String stampa) {
		System.out.print(stampa);
		String valore = Console.leggiStringa();
		while(valore.isEmpty()) {
			System.out.println("ERRORE: Impossibile lasciare la stringa vuota");
			System.out.print(stampa);
			valore = Console.leggiStringa();
		}
		return valore;
 	}

	private int leggiInteroLimitato(int min, int max, String stampa) {
		System.out.print(stampa);
		int valore = Console.leggiIntero();
		while(valore < min || valore > max) {
			System.out.println("ERRORE: Inserire un numero compreso tra " + min + " e " + max);
			System.out.print(stampa);
			valore = Console.leggiIntero();
		}
		return valore;
	}

	private Universita caricaMock() {
		Universita universita = new Universita();

		Aula aula1 = new Aula("Aula 1", 80);

		Esami esame1 = new Esami("Programmazione Procedurale", "14/07/2020", 15, 18, 73);

		aula1.addEsame(esame1);
		universita.addAula(aula1);

		return universita;
	}
}