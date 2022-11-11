package it.unibas.agenzia.controllo;

import it.unibas.agenzia.modello.*;
import it.unibas.utilita.*;
import java.util.*;

public class Principale {
	public static void main(String[] args) {
		Principale principale = new Principale();
		principale.esegui();
	}

	private void esegui() {
		Agenzia agenzia = new Agenzia();
		agenzia = agenziaVuota();
		while(true) {
			int scelta = schermoMenu();
			if (scelta == 0) {
				break;
			}
			if (scelta == 1) {
				schermoAggiungiContribuente(agenzia);
			}
			if (scelta == 2) {
				schermoLeggiContribuente(agenzia);
			}
			if (scelta == 3) {
				schermoCercaContribuenteConRedditoInferiore(agenzia);
			}
			if (scelta == 4) {
				//schermoCercaDestinatario5xMille(agenzia);
			}
		}
	}

	private int schermoMenu() {
		System.out.println("\n");
		System.out.println("----------------------------------------------------------------");
		System.out.println("                      AGENZIA DELLE ENTRATE                     ");
		System.out.println("----------------------------------------------------------------");
		System.out.println(" 1. Aggiungi contribuente                                       ");
		System.out.println(" 2. Visualizza contribuenti                                     ");
		System.out.println(" 3. Cerca contribuente con reddito inferiore ad una certa soglia");
		System.out.println(" 4. Cerca contribuente per destinatario 5xMille                 ");
		System.out.println("----------------------------------------------------------------");
		System.out.println(" 0. Esci                                                        ");
		System.out.println("----------------------------------------------------------------");
		System.out.println("\n");
		int scelta = leggiInteroLimitato(0, 4, "Scelta--> ");
		return scelta;
	}

	private void schermoCercaContribuenteConRedditoInferiore(Agenzia agenzia) {
		int redditoAnnuoLordo = leggiInteroLimitato(10000, 300000, "Reddito annuo lordo: ");
		List<Contribuente> contribuenteAnnuoLordo = agenzia.cercaReddito(redditoAnnuoLordo);
		if (agenzia.nonContieneContribuenti()) {
			System.out.println("ERRORE: Nessun contribuente esistente");
			return;
		}
		for (Contribuente contribuente : contribuenteAnnuoLordo) {
			if (contribuenteAnnuoLordo.isEmpty() || contribuente.getRedditoAnnuoLordo() > redditoAnnuoLordo) {
				System.out.println("ERRORE: Nessun contribuente trovato per il valore inserito");
				return;
			}
			System.out.println("Contribuenti con reddito annuo lordo inferiore a " + redditoAnnuoLordo + "\n-> " + contribuenteAnnuoLordo);
		}
	}

	private void schermoLeggiContribuente(Agenzia agenzia) {
		if (agenzia.nonContieneContribuenti()) {
			System.out.println("ERRORE: Nessun contribuente trovato");
			return;
		}	
		System.out.println(agenzia.toString());
	}

	private void schermoAggiungiContribuente(Agenzia agenzia) {
		String codIdentificativo = leggiStringaNonVuota("Codice identificativo: ");
		String nome = leggiStringaNonVuota("Nome: ");
		String cognome = leggiStringaNonVuota("Cognome: ");
		int redditoAnnuoLordo = leggiInteroLimitato(10000, 300000, "Reddito annuo lordo: ");
		double importoIRPEF = leggiDoublePositivo("Importo IRPEF: ");
		String cinqueXMille = leggiTipologia("Destinatario 5xMille: ");
		Contribuente contribuente = new Contribuente(codIdentificativo, nome, cognome, redditoAnnuoLordo, importoIRPEF, cinqueXMille);
		agenzia.addContribuente(contribuente);
		System.out.println("*** Contribuente aggiunto correttamente ***");
	}

	private int leggiInteroLimitato(int min, int max, String scelta) {
		System.out.print(scelta);
		int valore = Console.leggiIntero();
		while(valore < min || valore > max) {
			System.out.println("ERRORE: Inserisci un valore compreso tra " + min + " e " + max);
			System.out.print(scelta);
			valore = Console.leggiIntero();
		}
		return valore;
	}

	private String leggiStringaNonVuota(String valore) {
		System.out.print(valore);
		String cosa = Console.leggiStringa();
		while(cosa.isEmpty()) {
			System.out.println("Impossbile lasciare il campo vuoto");
			System.out.println(valore);
			cosa = Console.leggiStringa();
		}
		return cosa;
	}

	private double leggiDoublePositivo(String messaggio) {
		System.out.print(messaggio);
		double valore = Console.leggiDouble();
		while(valore < 0) {
			System.out.println("ERRORE: Impossibile inserire valori negativi");
			System.out.print(messaggio);
			valore = Console.leggiDouble();
		}
		return valore;
	}

	private String leggiTipologia(String stampa) {
		System.out.print(stampa);
		int scelta = leggiInteroLimitato(1, 3, "\n1.Onlus\n2.Aim\n3.Airc\nScelta--> ");
		if (scelta == 1) {
			return Contribuente.DESTINATARIO_ONLUS;
		}
		if (scelta == 2) {
			return Contribuente.DESTINATARIO_AIM;
		}
		return Contribuente.DESTINATARIO_AIRC;
	}

	private Agenzia agenziaVuota() {
		Agenzia agenzia = new Agenzia();
		return agenzia;
	}
}