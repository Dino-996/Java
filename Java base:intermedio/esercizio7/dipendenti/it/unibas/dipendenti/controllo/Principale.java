package it.unibas.dipendenti.controllo;
import it.unibas.dipendenti.modello.*;
import it.unibas.utilita.*;
import java.util.*;

public class Principale {
	public static void main(String[] args) {
		Principale principale = new Principale();
		principale.esegui();
	}

	private void esegui() {
		Azienda azienda = new Azienda();
		azienda = null;
		while(true) {
			int scelta = schermoMenu();
			if (scelta == 0) {
				break;
			}
			if (scelta == 1) {
				azienda = schermoAggiungiAzienda();
			}
			if (scelta == 2) {
				schermoAggiungiDipendenti(azienda);

			}
			if (scelta == 3) {
				schermoStampaDipendenti(azienda);
				
			}
			if (scelta == 4) {
				schermoCalcolaStipendioMedio(azienda);
			}
			if (scelta == 5) {
				schermoVerificaStipendioDipendenti(azienda);
			}
		}
	}

	private int schermoMenu() {
		System.out.println("\n");
		System.out.println("----------------------------");
		System.out.println("     GESTORE DIPENDENTI     ");
		System.out.println("----------------------------");
		System.out.println(" 1. Aggiungi azienda        ");
		System.out.println(" 2. Aggiungi dipendente     ");
		System.out.println(" 3. Stampa dipendenti       ");
		System.out.println(" 4. Calcola stipendio medio ");
		System.out.println(" 5. Verifica stipendio      ");
		System.out.println("----------------------------");
		System.out.println(" 0. Esci                    ");
		System.out.println("----------------------------");
		System.out.println("\n");
		int scelta = leggiInteroLimitato(0, 5, "Scelta--> ");
		return scelta;
	}

	private void schermoVerificaStipendioDipendenti(Azienda azienda) {
		if (azienda == null) {
			System.out.println("ERRORE: Nessun dipendente presente");
			return;
		}
		Dipendente cercaStipendio = azienda.verificaStipendio();
		if (cercaStipendio == null) {
			System.out.println("Non tutti i dipendenti hanno uno stipendio superiore a 2000€");
		} else {
			System.out.println("Tutti i dipendenti hanno uno stipendio superiore a 2000€");
		}
	}

	private void schermoCalcolaStipendioMedio(Azienda azienda) {
		if (azienda == null) {
			System.out.println("ERRORE: Nessun dipendente presente");
			return;
		}
		int stipendio = leggiInteroLimitato(1000, 3000, "Stipendio: ");
			Dipendente cercaStipendio = azienda.verificaStipendioMedio(stipendio);
			System.out.println("Stipendio medio dipendenti: " + azienda.getStipendioMedio());
			if (cercaStipendio == null) {
				System.out.println("Lo stipendio medio dei dipendenti non è superiore a quello inserito.");
			} else {
				System.out.println("Lo stipendio medio dei dipendenti è superiore a quello inserito.");
			}
	}

	private void schermoStampaDipendenti(Azienda azienda) {
		if (azienda == null) {
			System.out.println("ERRORE: Nessun dipendente presente");
		} else {
			System.out.println(azienda);
		}
	}

	private void schermoAggiungiDipendenti(Azienda azienda) {
		if (azienda == null) {
			System.out.println("ERRORE: Nessun azienda presente");
			return;
		}
		String nome = leggiStringaNonVuota("Nome: ");
		int stipendio = leggiInteroLimitato(1000, 3000, "Stipendio: ");
		Dipendente dipendente = new Dipendente(nome, stipendio);
		azienda.addDipendente(dipendente);
		System.out.println("*** Dipendente aggiunto correttamente ***");
	}

	private Azienda schermoAggiungiAzienda() {
		int scelta = leggiInteroLimitato(1, 2, "Aggiungere una nuova azienda?\n1. Si\n2. No\nScelta--> ");
		if (scelta == 2) {
			System.out.println("AVVISO: Azienda non aggiunta");
			return null;
		}
		Azienda azienda = new Azienda();
		System.out.println("*** Azienda aggiunta correttamente ***");
		return azienda;
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
}