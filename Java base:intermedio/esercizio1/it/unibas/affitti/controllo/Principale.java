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
				schermoAggiungiAppartamento(societa);
			}
			if (scelta == 3) {
				schermoPiuMetriQuadri(societa);
			}
			if (scelta == 4) {
				schermoAppartamentoEconomico(societa);
			}
		}
	}

	private int schermoMenu() {
		System.out.println("\n");
		System.out.println("---------------------------------------");
		System.out.println("          REGISTRO APPARTAMENTI        ");
		System.out.println("---------------------------------------");
		System.out.println(" 1. Aggiungi edificio                  ");
		System.out.println(" 2. Aggiungi appartamento              ");
		System.out.println(" 3. Cerca edificio con piu metri quadri");
		System.out.println(" 4. Cerca appartamento economico       ");
		System.out.println("---------------------------------------");
		System.out.println(" 0. Esci                               ");
		System.out.println("---------------------------------------");
		System.out.println("\n");
		int scelta = leggiInteroLimitato(0, 4, "Scelta--> ");
		return scelta;
	}

	private void schermoAppartamentoEconomico(Societa societa) {
		double costoPerMQ = leggiDoublePositivo("Costo di affitto(max €750): ");
		List<Appartamento> appartamento = societa.costoAffittoMax(costoPerMQ);
	}

	private void schermoPiuMetriQuadri(Societa societa) {
		int annoCostruzione = leggiInteroLimitato(1900, 2020, "Anno costruzione: ");
		Edificio edificio = societa.cercaEdificioMax(annoCostruzione);
		if (edificio == null) {
			System.out.println("ERRORE: Nessun edificio trovato per l'anno di costruzione inserito");
		} else {
			System.out.println("Edificio trovato: \n" + edificio);
		}
	}

	private void schermoAggiungiAppartamento(Societa societa) {
		String indirizzo = leggiStringaNonVuota("Indirizzo: ");
		Edificio edificio = societa.cercaPerIndirizzo(indirizzo);
		if (edificio == null) {
			System.out.println("ERRORE: Indirizzo inesistente.");
			return;
		}
		System.out.println("--- EDIFICIO ---");
		System.out.println(edificio + "\n");
		String interno = leggiStringaNonVuota("Interno: ");
		Appartamento cercaInterno = edificio.cercaInterno(interno);
		if(cercaInterno != null) {
			System.out.println("ERRORE: Appartamento già esistente.");
			return;
		}
		double mQ = leggiDoublePositivo("Metri quadri: ");
		int numeroBagni = leggiInteroLimitato(1, 3, "Numero bagni: ");
		int numeroStanze = leggiInteroLimitato(1, 5, "Numero stanze: ");
		double costoPerMQ = leggiDoublePositivo("Costo per metro quadro: ");
		Appartamento appartamento = new Appartamento(interno, mQ, numeroBagni, numeroStanze, costoPerMQ);
		edificio.addAppartamento(appartamento);
		System.out.println("*** Appartamento aggiunto correttamente:\n" + societa);
	}

	private double leggiDoublePositivo(String stampa) {
		System.out.print(stampa);
		double valore = Console.leggiDouble();
		while(valore < 0) {
			System.out.println("ERRORE: Impossibile inserire un numero negativo");
			System.out.print(stampa);
			valore = Console.leggiDouble();
		}
		return valore;
	}

	private void schermoAggiungiEdificio(Societa societa) {
		String indirizzo = leggiStringaNonVuota("Indirizzo: ");
		while(societa.cercaPerIndirizzo(indirizzo) != null) {
			System.out.println("ERRORE: Indirizzo già esistente! Riprova.");
			indirizzo = leggiStringaNonVuota("Indirizzo: ");
		}
		int annoCostruzione = leggiInteroLimitato(1900, 2020, "Anno costruzione: ");
		String livelloQualita = leggiTipologia();
		Edificio edificio = new Edificio(indirizzo, annoCostruzione, livelloQualita);
		societa.addEdificio(edificio);
		System.out.println("*** Edifico aggiunto correttamente:\n" + societa);
	}

	private String leggiTipologia() {
		int scelta = leggiInteroLimitato(1, 3, "Livello qualità:\n1.Ottimo\n2.Buono\n3.Sufficiente\nScelta--> ");
		if (scelta == 1) {
			return Edificio.QUALITA_OTTIMA;
		}
		if (scelta == 2) {
			return Edificio.QUALITA_BUONA;
		}
		return Edificio.QUALITA_SUFFICIENTE;
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

	private String leggiStringaNonVuota(String stampa) {
		System.out.print(stampa);
		String valore = Console.leggiStringa();
		while(valore.isEmpty()) {
			System.out.println("Impossibile lasciare il campo vuoto");
			System.out.print(stampa);
			valore = Console.leggiStringa();
		}
		return valore;
	}

	private Societa caricaMock() {
		Societa societa = new Societa();

		Edificio edificio1 = new Edificio("Via Oscar Romero 6", 2000, Edificio.QUALITA_SUFFICIENTE);
		Edificio edificio2 = new Edificio("Via del popolo 10", 1950, Edificio.QUALITA_BUONA);

		Appartamento appartamento1 = new Appartamento("A13", 70, 2, 5, 12.5);
		Appartamento appartamento2 = new Appartamento("B18", 90, 1, 4, 11.4);
		Appartamento appartamento3 = new Appartamento("A21", 180, 1, 4, 10.2);
		Appartamento appartamento4 = new Appartamento("B5", 130, 2, 5, 15.2);

		edificio1.addAppartamento(appartamento1);
		edificio1.addAppartamento(appartamento2);
		edificio2.addAppartamento(appartamento3);
		edificio2.addAppartamento(appartamento4);

		societa.addEdificio(edificio1);
		societa.addEdificio(edificio2);

		return societa;
	}
}