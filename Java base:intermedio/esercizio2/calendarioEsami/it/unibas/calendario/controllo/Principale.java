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
		System.out.print(universita);
		while(true) {
			int scelta = schermoMenu();
			if (scelta == 0) {
				break;
			}
			if (scelta == 1) {
				schermoAggiungiAula(universita);
			}
			if (scelta == 2) {
				schermoAggiungiAppello(universita);
			}
			if (scelta == 3) {
				schermoLeggiNumeroPrenotati(universita);
			}
		}
	}

	private int schermoMenu() {
		System.out.println("\n");
		System.out.println("---------------------");
		System.out.println("  CALENDARIO ESAMI   ");
		System.out.println("---------------------");
		System.out.println(" 1. Aggiungi Aula    ");
		System.out.println(" 2. Aggiungi Appello ");
		System.out.println(" 3. Numero prenotati ");
		System.out.println("---------------------");
		System.out.println(" 0. Esci             ");
		System.out.println("---------------------");
		System.out.println("\n");
		int scelta = leggiInteroLimitato(0, 3, "Scelta--> ");
		return scelta;
	}

	private void schermoLeggiNumeroPrenotati(Universita universita) {
		String data = leggiStringaNonVuota("Data: ");
		List<Appello> esamiPerData = universita.cercaPerData(data);
		if (esamiPerData.isEmpty()) {
			System.out.println("Nessun prenotato per la data inserita");
		} else {
			int numeroPrenotati = calcolaPrenotati(data, esamiPerData);
			System.out.println("Il numero di prenotati in data " + data + " è: " + numeroPrenotati);
		}
	}

	private int calcolaPrenotati(String data, List<Appello> listaIntermedia) {
		int somma = 0;
		for (Appello appello : listaIntermedia) {
			if (appello.getData().equalsIgnoreCase(data)) {
				somma += appello.getNumero();
			}
		}
		return somma;
	}

	private void schermoAggiungiAppello(Universita universita) {
		String nome = leggiStringaNonVuota("Nome aula: ");
		Aula aula = universita.cercaPerNome(nome);
		if (aula == null) {
			System.out.println("ERRORE: L'aula inserita non esiste");
			return;
		}
		System.out.println("----------------");
		System.out.println("      AULA      ");
		System.out.println("----------------");
		System.out.println(aula);
		String nomeInsegnamento = leggiStringaNonVuota("Nome insegnamento: ");
		String data = leggiStringaNonVuota("Data: ");
		int oraInizio = leggiInteroLimitato(8, 24, "Ora inizio: ");
		int oraFine = leggiInteroLimitato(8, 24, "Ora fine: ");
		int numero = leggiInteroLimitato(0, 120, "Numero prenotati: ");
		Appello appello = new Appello(nomeInsegnamento, data, oraInizio, oraFine, numero);
		aula.addAppello(appello);
		System.out.println("*** Appello aggiunto correttamente ***");
	}

	private void schermoAggiungiAula(Universita universita) {
		String nome = leggiStringaNonVuota("Nome aula: ");
		while(universita.cercaPerNome(nome) != null) {
			System.out.println("ERRORE: Aula già presente. Inserire un nome diverso.");
			nome = leggiStringaNonVuota("Nome aula: ");
		}
		int capienza = leggiInteroLimitato(50, 120, "Capienza: ");
		Aula aula = new Aula(nome, capienza);
		universita.addAula(aula);
		System.out.println("*** Aula aggiunta correttamente ***");
	}

	private int leggiInteroLimitato(int min, int max, String stampa) {
		System.out.print(stampa);
		int valore = Console.leggiIntero();
		while(valore < min || valore > max) {
			System.out.println("ERRORE: Inserire un numero compreso tra: " + min + " e " + max);
			System.out.print(stampa);
			valore = Console.leggiIntero();
		}
		return valore;
	}

	private String leggiStringaNonVuota(String stampa) {
		System.out.print(stampa);
		String valore = Console.leggiStringa();
		while(valore.isEmpty()) {
			System.out.println("ERRORE: Impossibile lasciare il campo vuoto");
			System.out.print(stampa);
			valore = Console.leggiStringa();
		}
		return valore;
	}

	private Universita caricaMock() {
		Universita universita = new Universita();

		Aula aula1 = new Aula("Aula 1", 80);
		Aula aula2 = new Aula("Aula Magna", 60);
		Aula aula3 = new Aula("Aula DIMIE", 120);

		Appello appello1 = new Appello("Programmazione Procedurale", "14/09/2021", 13, 15, 31);
		Appello appello2 = new Appello("Architettura dei calcolatori","14/09/2021", 15, 17, 40);
		Appello appello3 = new Appello("Analisi1","16/02/2022", 10, 12, 60);
		Appello appello4 = new Appello("Analisi2","21/04/2022", 12, 14, 32);
		Appello appello5 = new Appello("Geometria", "17/05/2021", 11, 14, 46);
		Appello appello6 = new Appello("Fisica1", "13/09/2021", 14, 16, 30);
		Appello appello7 = new Appello("Fisica2", "03/12/2021", 16, 18, 24);
		Appello appello8 = new Appello("Inglese", "17/07/2021", 11, 12, 50);

		aula1.addAppello(appello1);
		aula1.addAppello(appello2);
		aula1.addAppello(appello8);
		aula2.addAppello(appello3);
		aula2.addAppello(appello4);
		aula2.addAppello(appello5);
		aula3.addAppello(appello6);
		aula3.addAppello(appello7);

		universita.addAula(aula1);
		universita.addAula(aula2);
		universita.addAula(aula3);

		return universita;
	}
}































