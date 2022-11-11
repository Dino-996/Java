package it.unibas.taxy.controllo;
import it.unibas.taxy.modello.*;
import it.unibas.utilita.*;
import java.util.*;

public class Principale {

	public static void main(String[] args) {
		Principale principale = new Principale();
		principale.esegui();
	}

	private void esegui() {
		//CompagniaTaxy compagniaTaxy = caricaMock();
		CompagniaTaxy compagniaTaxy = null;
		while(true) {
			int scelta = schermoMenu();
			if (scelta == 1) {
				compagniaTaxy = schermoInserisciCompagnia();
			}
			if (scelta == 2) {
				schermoLeggiCompagnia(compagniaTaxy);
			}
			if (scelta == 3) {
				schermoCalcolaChilometraggiomedio(compagniaTaxy);
			}
			if (scelta == 0) {
				break;
			}
		}
	}

	private int schermoMenu() {
		System.out.println("\n");
		System.out.println("--------------------------------");
		System.out.println("         COMPAGNIA TAXY         ");
		System.out.println("--------------------------------");
		System.out.println(" 1. Aggiungi compagnia          ");
		System.out.println(" 2. Aggiungi Taxy               ");
		System.out.println(" 3. Calcola chilometraggio medio");
		System.out.println("--------------------------------");
		System.out.println(" 0. Esci");
		System.out.println("--------------------------------");
		System.out.println("\n");
		int scelta = leggiInteroLimitato(0, 3, "Scelta--> ");
		return scelta;
	}

	private void schermoCalcolaChilometraggiomedio(CompagniaTaxy compagniaTaxy) {
		if (compagniaTaxy == null) {
			System.out.println("Nessuna compagnia taxy presente");
			return;
		}
		System.out.println(compagniaTaxy);
		if (compagniaTaxy.contieneTaxy()) {
			System.out.println("Il chilometraggio medio è: " + compagniaTaxy.getMedia() + "Km");
		} else {
			System.out.println("Non è possibile calcolare il chilometraggio medio");
		}
	}

	private void schermoLeggiCompagnia(CompagniaTaxy compagniaTaxy) {
		if (compagniaTaxy == null) {
			System.out.println("Nessuna compagnia taxy presente");
			return;
		}
		String numero = leggiStringaNonVuota("Numero di serie: ");
		int cilindrata = leggiInteroLimitato(1000, 3000, "Cilindrata: ");
		int chilometraggio = leggiInteroLimitato(0, 350000, "Chilometraggio: ");
		Taxy taxy = new Taxy(numero, cilindrata, chilometraggio);
		compagniaTaxy.addTaxy(taxy);
		System.out.println("*** Taxy aggiunto correttamente ***");
	}

	private CompagniaTaxy schermoInserisciCompagnia() {
		
		String nome = leggiStringaNonVuota("Nome compagnia: ");
		String numero = leggiStringaNonVuota("Numero di telefono: ");
		CompagniaTaxy cercaTaxy = new CompagniaTaxy(nome, numero);
		System.out.println("*** Compagnia aggiunta correttamente ***");
		return cercaTaxy;

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
			System.out.println("ERRORE: Inserire in valore compreso tra " + min + " e " + max);
			System.out.print(stampa);
			valore = Console.leggiIntero();
		}
		return valore;
	}

	private CompagniaTaxy caricaMock() {
		CompagniaTaxy compagniaTaxy = new CompagniaTaxy("Taxisti4Ever", "0971/443228");

		Taxy taxy1 = new Taxy ("1280", 1200, 16000);
		Taxy taxy2 = new Taxy ("1700", 1100, 32000);
		Taxy taxy3 = new Taxy ("9876", 1300, 132000);
		Taxy taxy4 = new Taxy ("3420", 1250, 320000);

		compagniaTaxy.addTaxy(taxy1);
		compagniaTaxy.addTaxy(taxy2);
		compagniaTaxy.addTaxy(taxy3);
		compagniaTaxy.addTaxy(taxy4);

		return compagniaTaxy;
	}
}