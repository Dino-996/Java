package it.unibas.affitti.controllo;
import it.unibas.affitti.modello.*;
import it.unibas.utilita.*;
import java.util.*;

public class Principale {
	public static void main(String[] args) {
		Principale principale = new Principale();
		principale.esegui();
	}

	private void esegui() {
		Societa societa = new Societa();
		societa = caricaMock();
		//System.out.println(societa);
		while(true) {
			int scelta = schermoMenu();
			if (scelta == 0) {
				break;
			}
			if (scelta == 1) {
				schermoAddEdificio(societa);
			}
			if (scelta == 2) {
				schermoAddAppartamento(societa);
			}
			if (scelta == 3) {
				schermoLeggiEdificioMaxMq(societa);
			}
			if (scelta == 4) {
				schermoAppartamentoEconomico(societa);
			}
		}
	}

	private void schermoAppartamentoEconomico(Societa societa) {
		int prezzoMax = leggiInteroLimitato(0, 750, "Costo di affitto mensile: ");
		List<Appartamento> cercaPrezzoMin = societa.trovaAppartamenti(prezzoMax);
		if (cercaPrezzoMin.isEmpty()) {
			System.out.println("Nessun appartamento trovato per il prezzo inserito: " + prezzoMax);
			return;
		}
		System.out.println("Appartamenti trovati a un prezzo inferiore di " + prezzoMax);
		for (Appartamento appartamento : cercaPrezzoMin) {
			System.out.println(appartamento);
			System.out.println("Costo di affitto mensile: " + appartamento.getAffittoMensile());
			System.out.println("-------------------\n");
		}
		int prezzoMedio = societa.calcolaPrezzoMedio(cercaPrezzoMin);
		System.out.println("Prezzo medio di affitto: " + prezzoMedio);
	}

	private void schermoLeggiEdificioMaxMq(Societa societa) {
		int annoCostruzione = leggiInteroLimitato(1900, 2020, "Anno di costruzione: ");
		Edificio edificio = societa.cercaPerMq(annoCostruzione);
		if (edificio == null) {
			System.out.println("ERRORE: Nessun edificio trovato");
		} else {
			System.out.println("--- EDIFICIO TROVATO ---\n" + edificio.toString());
		}
	}

	private void schermoAddAppartamento(Societa societa) {
		String indirizzo = leggiStringaNonVuota("Indirizzo: ");
		Edificio cercaEdificio = societa.leggiIndirizzo(indirizzo);
		if(cercaEdificio == null) {
			System.out.println("ERRORE: Indirizzo non presente");
			return;
		}
		System.out.println("\n--- EDIFICIO TROVATO ---");
		System.out.println(cercaEdificio + "\n");
		String interno = leggiStringaNonVuota("Interno: ");
		if (cercaEdificio.leggiInterno(interno) != null) {
			System.out.println("ERRORE: Interno già presente");
			return;
		}
		int metriQuadri = leggiInteroLimitato(50, 50000, "Metri quadri: ");
		int numeroStanze = leggiInteroLimitato(2, 20, "Numero stanze: ");
		int numeroBagni = leggiInteroLimitato(1, 5, "Numero bagni: ");
		int costoMetroQuadro = leggiInteroLimitato(10, 100, "Costo per metro quadro: ");
		Appartamento appartamento = new Appartamento(interno, metriQuadri, numeroStanze, numeroBagni, costoMetroQuadro);
		cercaEdificio.addAppartamento(appartamento);
		System.out.println("*** Edificio aggiunto correttamente ***");
	}

	private void schermoAddEdificio(Societa societa) {
		String indirizzo = leggiStringaNonVuota("Indirizzo: ");
		while(societa.leggiIndirizzo(indirizzo) != null) {
			System.out.println("ERRORE: Indirizzo già presente, immetti un nuovo indirizzo");
			indirizzo = leggiStringaNonVuota("Indirizzo: ");
		}
		int annoCostruzione = leggiInteroLimitato(1900, 2020, "Anno di costruzione: ");
		String qualitaZona = leggiTipologia();
		Edificio edificio = new Edificio(indirizzo, annoCostruzione, qualitaZona);
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

	private String leggiTipologia() {
		int valore = leggiInteroLimitato(1, 3, "Qualità zona:\n1. Ottima\n2. Buona\n3. Sufficiente\nScelta--> ");
		if (valore == 1) {
			return Edificio.QUALITA_OTTIMO;
		}
		if (valore == 2) {
			return Edificio.QUALITA_BUONO;
		}
		return Edificio.QUALITA_SUFFICIENTE;
	}

	private int schermoMenu() {
		System.out.println("\n");
		System.out.println("----------------------------------------");
		System.out.println("           GESTORE DI AFFITTI           ");
		System.out.println("----------------------------------------");
		System.out.println(" 1. Aggiungi edificio                   ");
		System.out.println(" 2. Aggiungi appartamento               ");
		System.out.println(" 3. Cerca edificio con più metri quadri ");
		System.out.println(" 4. Cerca appartamento più economico    ");
		System.out.println("----------------------------------------");
		System.out.println(" 0. Esci                                ");
		System.out.println("----------------------------------------");
		System.out.println("\n");
		int scelta = leggiInteroLimitato(0, 4, "Scelta--> ");
		return scelta;
	}

	private Societa caricaMock() {
		Societa societa = new Societa();

		Edificio edificio1 = new Edificio("Via Oscar Romero 6", 2000, Edificio.QUALITA_OTTIMO);
		Edificio edificio2 = new Edificio("Via Napoli 110, Potenza", 1990, Edificio.QUALITA_BUONO);
		Edificio edificio3 = new Edificio("Via Degli Oleandri 31, Potenza", 1960, Edificio.QUALITA_SUFFICIENTE);

		Appartamento appartamento1 = new Appartamento("A14", 60, 2, 3, 10);
		Appartamento appartamento2 = new Appartamento("A15", 180, 3, 2, 15);
		Appartamento appartamento3 = new Appartamento("B10", 30, 5, 2, 7);
		Appartamento appartamento4 = new Appartamento("B21", 80, 4, 1, 9);
		Appartamento appartamento5 = new Appartamento("C1", 140, 3, 2, 11);
		Appartamento appartamento6 = new Appartamento("C2", 220, 6, 3, 20);

		edificio1.addAppartamento(appartamento1);
		edificio1.addAppartamento(appartamento2);
		edificio2.addAppartamento(appartamento3);
		edificio2.addAppartamento(appartamento4);
		edificio3.addAppartamento(appartamento5);
		edificio3.addAppartamento(appartamento6);

		societa.addEdificio(edificio1);
		societa.addEdificio(edificio2);
		societa.addEdificio(edificio3);

		return societa;
	}
}