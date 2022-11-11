package it.unibas.affitti.controllo;

import it.unibas.affitti.modello.*;
import it.unibas.utilita.*;

public class Principale {

	public static void main(String[] args) {
		Principale principale = new Principale();
		principale.esegui();
	}

	private void esegui() {
		Societa societa = new Societa();
		societa = caricaMock();
		while(true) {
			int scelta = schermoMenu();
			if (scelta == 0) {
				break;
			}
			if (scelta == 1) {
				schermoAggiungiEdificio(societa);
			}
			if (scelta == 2) {
				schermoLeggiDataCostruzione(societa);
			}
		}
	}

	private int schermoMenu() {
		System.out.println("\n");
		System.out.println("--------------------------");
		System.out.println("     DATI APPARTAMENTI    ");
		System.out.println("--------------------------");
		System.out.println(" 1. Aggiungi edificio     ");
		System.out.println(" 2. Leggi data costruzione");
		System.out.println("--------------------------");
		System.out.println(" 0.Esci                   ");
		System.out.println("--------------------------");
		System.out.println("\n");
		int scelta = leggiInteroLimitato(0, 2, "Scelta--> ");
		return scelta;
	}

	private void schermoLeggiDataCostruzione(Societa societa) {
		int data = leggiInteroLimitato(1900, 2021, "Anno costruzione: ");
		String indirizzo = leggiStringaNonVuota("Indirizzo: ");
		Edificio edificio = societa.cercaCorrispondenza(data, indirizzo);
		if (edificio == null) {
			System.out.println("Nessun edificio trovato per i parametri inseriti");
		} else {
			System.out.println("Edificio trovato: \n" + edificio);
		}
	}

	private void schermoAggiungiEdificio(Societa societa) {
		String indirizzo = leggiStringaNonVuota("Indirizzo: ");
		while(societa.leggiIndirizzo(indirizzo) != null) {
			System.out.println("ERRORE: Indirizzo esistente. Fornire un indirizzo diverso.");
			indirizzo = leggiStringaNonVuota("Indirizzo: ");
		}
		int annoCostruzione = leggiInteroLimitato(1900, 2021, "Anno costruzione: ");
		String qualitàUrbana = leggiTipologia("Qualità zona urbana: ");
		Edificio edificio = new Edificio(indirizzo, annoCostruzione, qualitàUrbana);
		societa.addEdificio(edificio);
		System.out.println("*** Edificio aggiunto correttamente ***");
	}

	private int leggiInteroLimitato(int min, int max, String stampa) {
		System.out.print(stampa);
		int valore = Console.leggiIntero();
		while(valore < min || valore > max) {
			System.out.println("ERRORE: Inserire un valore compreso tra " + min + " e " + max);
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

	private String leggiTipologia(String stampa) {
		System.out.println(stampa);
		int scelta = leggiInteroLimitato(1, 3, "1. Sufficiente\n2. Buono\n3. Ottimo\nScelta--> ");
		if (scelta == 1) {
			return Edificio.QUALITA_SUFFICIENTE;
		}
		if (scelta == 2) {
			return Edificio.QUALITA_BUONO;
		}
		return Edificio.QUALITA_OTTIMO;
	}

	private Societa caricaMock() {
		Societa societa = new Societa();

		Edificio edificio1 = new Edificio("Via Oscar Romero", 1990, Edificio.QUALITA_SUFFICIENTE);
		Edificio edificio2 = new Edificio("Via Oscar Romero", 2000, Edificio.QUALITA_SUFFICIENTE);
		Edificio edificio3 = new Edificio("Via Oscar Romero", 2021, Edificio.QUALITA_SUFFICIENTE);
		Edificio edificio4 = new Edificio("Via del popolo 31", 2002, Edificio.QUALITA_BUONO);
		Edificio edificio5 = new Edificio("Via Nazario Sauro 23", 2013, Edificio.QUALITA_OTTIMO);

		societa.addEdificio(edificio1);
		societa.addEdificio(edificio2);
		societa.addEdificio(edificio3);
		societa.addEdificio(edificio4);
		societa.addEdificio(edificio5);


		return societa;
	}
}