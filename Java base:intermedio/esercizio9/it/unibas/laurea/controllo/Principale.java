package it.unibas.laurea.controllo;
import it.unibas.laurea.modello.*;
import it.unibas.utilita.*;

public class Principale {

	public static void main(String[] args) {
		Principale principale = new Principale();
		principale.esegui();
	}

	private void esegui() {
		PianoStudi pianoStudi = new PianoStudi();
		//pianoStudi = caricaMock();
		while(true) {
			int scelta = schermoMenu();
			if (scelta == 0) {
				break;
			}
			if (scelta == 1) {
				pianoStudi = schermoNuovoPianoStudi();
			}
			if (scelta == 2) {
				schermoNuovoInsegnamento(pianoStudi);
			}
			if (scelta == 3) {
				schermoModificaInsegnamento(pianoStudi);
			}
			if (scelta == 4) {
				schermoStampaPiano(pianoStudi);
			}
		}
	}

	private int schermoMenu() {
		System.out.println("\n");
		System.out.println("--------------------------");
		System.out.println("    PIANO STUDI LAUREA    ");
		System.out.println("--------------------------");
		System.out.println(" 1. Nuovo piano studi     ");
		System.out.println(" 2. Nuovo insegnamento    ");
		System.out.println(" 3. Modifica insegnamento ");
		System.out.println(" 4. Stampa piano studio   ");
		System.out.println("--------------------------");
		System.out.println(" 0. Esci                  ");
		System.out.println("--------------------------");
		System.out.println("\n");
		int scelta = leggiInteroLimitato(0, 4, "Scelta--> ");
		return scelta;
	}

	private void schermoStampaPiano(PianoStudi pianoStudi) { 
		if (pianoStudi.nonContieneInsegnamenti()) {
			System.out.println("ERRORE: Nessun insegnamento presente");
		} else {
			System.out.println(pianoStudi);
		}
	}

	private void schermoModificaInsegnamento(PianoStudi pianoStudi) {
		String nome = leggiStringaNonVuota("Nome insegnamento: ");
		Insegnamento insegnamento = pianoStudi.cercaPerNome(nome);
		if (insegnamento == null) {
			System.out.println("ERRORE: Insegnamento non presente");
			return;
		}
		System.out.println("--- DATI INSEGNAMENTO SELEZIONATO ---\n\n" + insegnamento + "\n");
		System.out.println("--- MODIFICA INSEGNAMENTO ---\n");
		int anno = leggiInteroLimitato(1900, 2021, "Anno: ");
		insegnamento.setAnno(anno);
		int crediti = leggiInteroLimitato(0, 15, "Crediti: ");
		insegnamento.setCrediti(crediti);
		System.out.println("*** Insegnamento modificato correttamente ***");
	}

	private void schermoNuovoInsegnamento(PianoStudi pianoStudi) {
		if (pianoStudi == null) {
			System.out.println("ERRORE: Nessun piano studi presente");
			return;
		}
		String nome = leggiStringaNonVuota("Nome insegnamento: ");
		if (pianoStudi.cercaPerNome(nome) != null) {
			System.out.println("ERRORE: Nome inserito già presente");
			return;
		}
		int anno = leggiInteroLimitato(1900, 2021, "Anno: ");
		int crediti = leggiInteroLimitato(0, 15, "Crediti: ");
		Insegnamento insegnamento = new Insegnamento(nome, anno, crediti);
		pianoStudi.addInsegnamento(insegnamento);
		System.out.println("*** Insegnamento aggiunto correttamente ***\n");
		System.out.println("--- DATI INSEGNAMENTO AGGIUNTO ---\n" + insegnamento);
	}

	private PianoStudi schermoNuovoPianoStudi() {
		PianoStudi pianoStudi = new PianoStudi();
		System.out.println("*** Piano studi settato correttamente ***");
		return pianoStudi;
	}

	private int leggiInteroLimitato(int min, int max, String stampa) {
		System.out.print(stampa);
		int valore = Console.leggiIntero();
		while(valore < min || valore > max) {
			System.out.println("ERRORE: Immetti un numero compreso tra " + min + " e " + max);
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

	private PianoStudi caricaMock() {
		PianoStudi pianoStudi = new PianoStudi();

		Insegnamento insegnamento1 = new Insegnamento("Programmazione Procedurale", 2021, 15);
		Insegnamento insegnamento2 = new Insegnamento("Architettura dei calcolatori elettronici", 2021, 6);
		Insegnamento insegnamento3 = new Insegnamento("Analisi 1", 2021, 6);
		Insegnamento insegnamento4 = new Insegnamento("Analisi 2", 2021, 6);
		Insegnamento insegnamento5 = new Insegnamento("Inglese", 2021, 3);
		Insegnamento insegnamento6 = new Insegnamento("Geometria", 2021, 6);
		Insegnamento insegnamento7 = new Insegnamento("Fisica 1", 2021, 5);
		Insegnamento insegnamento8 = new Insegnamento("Fisica 2", 2021, 5);

		pianoStudi.addInsegnamento(insegnamento1);
		pianoStudi.addInsegnamento(insegnamento2);
		pianoStudi.addInsegnamento(insegnamento3);
		pianoStudi.addInsegnamento(insegnamento4);
		pianoStudi.addInsegnamento(insegnamento5);
		pianoStudi.addInsegnamento(insegnamento6);
		pianoStudi.addInsegnamento(insegnamento7);
		pianoStudi.addInsegnamento(insegnamento8);

		return pianoStudi;
	}
}