package it.unibas.conto.controllo;

import it.unibas.conto.modello.*;
import it.unibas.utilita.*;
import java.util.*;

public class Principale {
	public static void main(String[] args) {
		Principale principale = new Principale();
		principale.esegui();
	}

	private void esegui() {
		Banca banca = new Banca();
		//banca = caricaMock();
		while(true) {
			int scelta = schermoMenu();
			if (scelta == 0) {
				break;
			}
			if (scelta == 1) {
				schermoApriConto(banca);
			}
			if (scelta == 2) {
				schermoEffettuaVersamento(banca);
			}
			if (scelta == 3) {
				schermoEffettuaPrelevamento(banca);
			}
			if (scelta == 4) {
				schermoVerificaSaldo(banca);
			}
			if (scelta == 5) {
				schermoChiudiConto(banca);
			}
		}
	}

	private int schermoMenu() {
		System.out.println("\n");
		System.out.println("--------------------------");
		System.out.println("     UNICREDIT S.P.A      ");
		System.out.println("--------------------------");
		System.out.println(" 1. Apri un conto corrente");
		System.out.println(" 2. Effettua versamento   ");
		System.out.println(" 3. Effettua prelevamento ");
		System.out.println(" 4. Verifica saldo        ");
		System.out.println(" 5. Chiudi conto corrente ");
		System.out.println("--------------------------");
		System.out.println(" 0. Esci                  ");
		System.out.println("--------------------------");
		System.out.println("\n");
		int scelta = leggiInteroLimitato(0, 5, "Scelta--> ");
		return scelta;
	}

	private void schermoChiudiConto(Banca banca) {
		int numConto = leggiInteroLimitato(1, 1000, "Numero conto corrente: ");
		ContoCorrente contoCorrente = banca.cercaPerConto(numConto);
		if (contoCorrente == null) {
			System.out.println("ERRORE: Numero di conto inesistente");
			return;
		}
		System.out.println("----------------------");
		System.out.println("Sicuro di voler chiudere il conto?");
		int sceltaUtente = leggiInteroLimitato(1, 2, "1. Chiudi il conto\n2. Annulla operazione\nScelta--> ");
		System.out.println("----------------------");
		if (sceltaUtente == 1) {
			contoCorrente.setNumConto(numConto);
			System.out.println("AVVISO: Conto corrente eliminato correttamente");
		} else {
			System.out.println("AVVISO: Operazione annullata");
		}
	}

	private void schermoVerificaSaldo(Banca banca) {
		int numConto = leggiInteroLimitato(1, 1000, "Numero conto corrente: ");
		ContoCorrente contoCorrente = banca.cercaPerConto(numConto);
		if (contoCorrente == null) {
			System.out.println("ERRORE: Numero di conto inesistente");
		} else {
			System.out.println("----------------------");
			System.out.println(" SALDO CONTO CORRENTE ");
			System.out.println("----------------------");
			System.out.println(contoCorrente);
		}
	}

	private void schermoEffettuaPrelevamento(Banca banca) {
		int numConto = leggiInteroLimitato(1, 1000, "Numero conto corrente: ");
		ContoCorrente contoCorrente = banca.cercaPerConto(numConto);
		if (contoCorrente == null) {
			System.out.println("ERRORE: Numero di conto inesistente");
			return;
		}
		double importo = leggiDouble("Importo da prelevare: ");
		if (contoCorrente.getSaldo() < importo) {
			System.out.println("ERRORE: Saldo inferiore dell'importo richiesto: " + contoCorrente.getSaldo());
			return;
		}
		contoCorrente.setSaldoPrelevamento(importo);
		System.out.println("--------------------\n");
		System.out.println("Saldo corrente: " + contoCorrente.getSaldo());
		System.out.println("--------------------\n");
		System.out.println("*** Importo prelevato correttamente ***");
	}

	private void schermoEffettuaVersamento(Banca banca) {
		int numConto = leggiInteroLimitato(1, 1000, "Numero conto corrente: ");
		ContoCorrente contoCorrente = banca.cercaPerConto(numConto);
		if (contoCorrente == null) {
			System.out.println("ERRORE: Numero di conto inesistente");
			return;
		}
		double importo = leggiDouble("Importo da versare: ");
		while(importo < 0) {
			System.out.println("ERRORE: Impossibile versare un importo negativo");
			importo = leggiDouble("Importo da versare: ");
		}
		contoCorrente.setSaldoVersamento(importo);
		System.out.println("--------------------");
		System.out.println("Saldo corrente: " + contoCorrente.getSaldo());
		System.out.println("--------------------\n");
		System.out.println("*** Importo versato correttamente ***");
	}

	private void schermoApriConto(Banca banca) {
		String nome = leggiStringaNonVuota("Nome: ");
		String cognome = leggiStringaNonVuota("Cognome: ");
		int eta = leggiInteroLimitato(18, 120, "Eta: ");
		String citta = leggiStringaNonVuota("Comune di resisenza: ");
		Utente utente = new Utente(nome, cognome, eta, citta);
		System.out.println("------------------------------------");
		System.out.println("           CONTO CORRENTE           ");
		System.out.println("------------------------------------");
		int numConto = 0;
		int leggiConto = banca.getNumeroConto(numConto);
		System.out.println("Numero conto corrente: " + leggiConto);
		double saldo = 0.0;
		System.out.println("Saldo: " + saldo);
		ContoCorrente contoCorrente = new ContoCorrente(leggiConto, saldo);
		contoCorrente.addUtente(utente);
		banca.addContoCorrente(contoCorrente);
		System.out.println("*** Conto corrente aperto correttamente ***");
	}

	private double leggiDouble(String stampa) {
		System.out.print(stampa);
		double valore = Console.leggiDouble();
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

	private Banca caricaMock() {
		Banca banca = new Banca();
		
		ContoCorrente contoCorrente1 = new ContoCorrente(1, 0.0);
		Utente utente1 = new Utente("Davide", "Sabia", 18, "Potenza");

		contoCorrente1.addUtente(utente1);
		banca.addContoCorrente(contoCorrente1);

		return banca;
	}
}