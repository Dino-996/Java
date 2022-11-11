package it.unibas.negozio.controllo;
import it.unibas.negozio.modello.*;
import it.unibas.utilita.*;
import java.util.*;


public class Principale {
	public static void main(String[] args) {
		Principale principale = new Principale();
		principale.esegui();
	}

	private void esegui() {
		Negozio negozio = new Negozio();
		negozio = caricaMock();
		//System.out.println(negozio);
		while(true) {
			int scelta = schermoMenu();
			if (scelta == 0) {
				break;
			}
			if (scelta == 1) {
				schermoAggiungiRicambio(negozio);
			}
			if (scelta == 2) {
				schermoCalcolaMediaPerTipologia(negozio);
			}
		}
	}

	private int schermoMenu() {
		System.out.println("\n");
		System.out.println("--------------------------------------");
		System.out.println("      GESTORE PEZZI DI RICAMBIO       ");
		System.out.println("--------------------------------------");
		System.out.println(" 1. Aggiungi pezzo di ricambio        ");
		System.out.println(" 2. Calcola media prezzo per tipologia");
		System.out.println("--------------------------------------");
		System.out.println(" 0. Esci                              ");
		System.out.println("--------------------------------------");
		System.out.println("\n");
		int scelta = leggiInteroLimitato(0, 2, "Scelta--> ");
		return scelta;
	}

	private void schermoCalcolaMediaPerTipologia(Negozio negozio) {
		String tipologia = leggiTipologia("Modello auto: ");
		List<Ricambio> listaRicambi = negozio.listaFiltrataTipologia(tipologia);
		if (listaRicambi.isEmpty()) {
			System.out.println("AVVISO: Impossibile calcolare il prezzo medio. Nessun ricambio trovato.");
			return;
		}
		double somma = 0;
		for (Ricambio ricambio : listaRicambi) {
			somma += ricambio.sommaPrezzo();
		}
		System.out.println("Prezzo medio per i ricambi " + tipologia + " " + somma / listaRicambi.size());
	}

	private void schermoAggiungiRicambio(Negozio negozio) {
		String codice = leggiStringaNonVuota("Codice: ");
		while(negozio.cercaCodice(codice) != null) {
			System.out.println("AVVISO: Codice già presente :(\nRIPROVA!");
			codice = leggiStringaNonVuota("Codice: ");
		}
		String descrizione = leggiStringaNonVuota("Descrizione: ");
		double prezzo = leggiDoublePositivo("Prezzo: ");
		String tipologia = leggiTipologia("Modello auto: ");
		Ricambio ricambio = new Ricambio(codice, descrizione, prezzo, tipologia);
		negozio.addRicambio(ricambio);
		System.out.println("*** RICAMBIO AGGIUNTO CORRETTAMENTE ***");
	}

	private int leggiInteroLimitato(int min, int max, String stampa) {
		System.out.print(stampa);
		int valore = Console.leggiIntero();
		while(valore < min || valore > max) {
			System.out.println("ERRORE: Immettere un valore compreso tra " + min + " e " + max);
			System.out.print(stampa);
			valore = Console.leggiIntero();
		}
		return valore;	
	}

	private double leggiDoublePositivo(String messaggio) {
		System.out.print(messaggio);
		double valore = Console.leggiDouble();
		while(valore < 0) {
			System.out.println("ERRORE: Impossibile inserire un valore negativo");
			System.out.print(messaggio);
			valore = Console.leggiDouble();
		}
		return valore;
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

	private String leggiTipologia(String messaggio) {
		System.out.println(messaggio);
		int scelta = leggiInteroLimitato(1, 3, "1.SUV\n2.Sportiva\n3.Utilitaria\nImmetti un numero: ");
		if (scelta == 1) {
			return Ricambio.TIPO_SUV;
		}
		if (scelta == 2) {
			return Ricambio.TIPO_SPORTIVA;
		}
		return Ricambio.TIPO_UTILITARIA;
	}

	private Negozio caricaMock() {
		Negozio negozio = new Negozio();

		Ricambio ricambio1 = new Ricambio("FR01", "Pastiglie Freni", 76.66, Ricambio.TIPO_SUV);
		Ricambio ricambio2 = new Ricambio("GM01", "Gomme", 210.88, Ricambio.TIPO_SUV);
		Ricambio ricambio3 = new Ricambio("PD01", "Pedaliera", 30.21, Ricambio.TIPO_SPORTIVA);
		Ricambio ricambio4 = new Ricambio("TC01", "Tergi Cristalli", 30.00, Ricambio.TIPO_SPORTIVA);
		Ricambio ricambio5 = new Ricambio("TR01", "Turbina", 12.50, Ricambio.TIPO_UTILITARIA);
		Ricambio ricambio6 = new Ricambio("TP01", "Tappetino", 10.00, Ricambio.TIPO_UTILITARIA);

		negozio.addRicambio(ricambio1);
		negozio.addRicambio(ricambio2);
		negozio.addRicambio(ricambio3);
		negozio.addRicambio(ricambio4);
		negozio.addRicambio(ricambio5);
		negozio.addRicambio(ricambio6);

		return negozio;
	}
}