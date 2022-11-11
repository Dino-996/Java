package it.unibas.personale.controllo;
import it.unibas.personale.modello.*;
import it.unibas.utilita.*;
import java.util.*;

public class Principale {
	public static void main(String[] args) {
		Principale principale = new Principale();
		principale.esegui();
	}

	private void esegui() {
		Azienda azienda = null;
		//azienda = caricaMock();
		//System.out.println(azienda);
		while(true) {
			int scelta = schermoMenu();
			if (scelta == 0) {
				break;
			}
			if (scelta == 1) {
				azienda = schermoAddAzienda();
			}
			if (scelta == 2) {
				schermoAddDipendente(azienda);
			}
			if (scelta == 3) {
				schermoStampaAzienda(azienda);
			}
			if (scelta == 4) {
				schermoCercaDipendentePerUfficio(azienda);
			}
		}
	}

	private int schermoMenu() {
		System.out.println("\n");
		System.out.println("********************************");
		System.out.println("       GESTORE AZIENDALE        ");
		System.out.println("********************************");
		System.out.println(" 1. Inserisci nuova azienda     ");
		System.out.println(" 2. Inserisci dipendente        ");
		System.out.println(" 3. Stampa nome azienda         ");
		System.out.println(" 4. Cerca dipendente per ufficio");
		System.out.println("********************************");
		System.out.println(" 0. Esci                        ");
		System.out.println("********************************");
		System.out.println("\n");
		int scelta = leggiInteroLimitato(0, 4, "Scelta--> ");
		return scelta;
	}

	private void schermoCercaDipendentePerUfficio(Azienda azienda) {
		if (azienda == null) {
			System.out.println("AVVISO: Nessun azienda presente");
			return;
		}
		String ufficio = leggiTipologia("Ufficio di appartenenza");
		List<Dipendente> listaDipendente = azienda.cercaPerTipologia(ufficio);
		for (Dipendente dipendente : listaDipendente) {
			if (!azienda.contieneDipendenti()) {
			System.out.println("ERRORE: Nessun dipendente presente nell'ufficio selezionato");
		} else {
			System.out.println(dipendente);
		}
	}
}

	private void schermoStampaAzienda(Azienda azienda) {
		if (azienda == null) {
			System.out.println("AVVISO: Nessun azienda presente");
			return;
		}
		System.out.println("********************************");
		System.out.println(azienda);
	}

	private void schermoAddDipendente(Azienda azienda) {
		if (azienda == null) {
			System.out.println("AVVISO: Nessun azienda presente");
			return;
		}
		String nome = leggiStringaNonVuota("Nome dipendente: ");
		while(azienda.cercaPerNome(nome) != null) {
			System.out.println("AVVISO: Il nome inserito è già presente.\nInserire un nome diverso");
			nome = leggiStringaNonVuota("Nome dipendente: ");
		}
		String codiceFiscale = leggiStringaNonVuota("Codice fiscale: ");
		String ufficio = leggiTipologia("Ufficio di appartenenza: ");
		Dipendente dipendente = new Dipendente(nome, codiceFiscale, ufficio);
		azienda.addDipendente(dipendente);
		System.out.println("*** DIPENDENTE AGGIUNTO CORRETTAMENTE ***");
	}

	private Azienda schermoAddAzienda() {
		String nome = leggiStringaNonVuota("Nome azienda: ");
		Azienda azienda = new Azienda(nome);
		System.out.println("*** AZIENDA AGGIUNTA CORRETTAMENTE ***");
		return azienda;
	}

	private String leggiTipologia(String messaggio) {
		System.out.println(messaggio);
		int valore = leggiInteroLimitato(1, 5, "1.Personale\n2.Vendite\n3.Segreteria\n4.Reclami\n5.Produzione\nScelta--> ");
		if (valore == 1) {
			return Dipendente.UFFICIO_PERSONALE;
		}
		if (valore == 2) {
			return Dipendente.UFFICIO_VENDITE;
		}
		if (valore == 3) {
			return Dipendente.UFFICIO_SEGRETERIA;
		}
		if (valore == 4) {
			return Dipendente.UFFICIO_RECLAMI;
		}
		return Dipendente.UFFICIO_PRODUZIONE;
	}

	private String leggiStringaNonVuota(String messaggio) {
		System.out.print(messaggio);
		String valore = Console.leggiStringa();
		while(valore.isEmpty()) {
			System.out.println("ERRORE: Impossibile lasciare la stringa vuota");
			System.out.print(messaggio);
			valore = Console.leggiStringa();
		}
		return valore;
	}

	private int leggiInteroLimitato(int min, int max, String messaggio) {
		System.out.print(messaggio);
		int valore = Console.leggiIntero();
		while(valore < min || valore > max) {
			System.out.println("ERRORE: Inserisci un valore compreso tra " + min + " e " + max);
			System.out.print(messaggio);
			valore = Console.leggiIntero();
		}
		return valore;
	}

	private Azienda caricaMock() {
		Azienda azienda = new Azienda("DaviTech S.P.A");

		Dipendente dipendente1 = new Dipendente("Luca Giorgio", "GIL975", Dipendente.UFFICIO_PRODUZIONE);
		Dipendente dipendente2 = new Dipendente("Alberto Santarsiero", "ALS563", Dipendente.UFFICIO_RECLAMI);
		Dipendente dipendente3 = new Dipendente("Maria Menichini", "MRM571", Dipendente.UFFICIO_SEGRETERIA);
		Dipendente dipendente4 = new Dipendente("Annarita Natillo", "NTA664", Dipendente.UFFICIO_VENDITE);
		Dipendente dipendente5 = new Dipendente("Celeste Genovese", "CLS290", Dipendente.UFFICIO_PERSONALE);

		azienda.addDipendente(dipendente1);
		azienda.addDipendente(dipendente2);
		azienda.addDipendente(dipendente3);
		azienda.addDipendente(dipendente4);
		azienda.addDipendente(dipendente5);

		return azienda;
	}
}