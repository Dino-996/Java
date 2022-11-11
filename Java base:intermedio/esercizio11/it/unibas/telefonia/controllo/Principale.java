package it.unibas.telefonia.controllo;
import it.unibas.telefonia.modello.*;
import it.unibas.utilita.*;

public class Principale {
	
	public static void main(String[] args) {
		Principale principale = new Principale();
		principale.esegui();
	}

	private void esegui() {
		Operatore operatore = new Operatore();
		operatore = caricaMock();
		while(true) {
			int scelta = schermoMenu();
			if (scelta == 0) {
				break;
			}
			if (scelta == 1) {
				schermoAggiungiSim(operatore);
			}
			if (scelta == 2) {
				schermoAggiungiTelefonata(operatore);
			}
			if (scelta == 3) {
				schermoCalcolaConversazioniTotali(operatore);
			}
		}
	}

	private int schermoMenu() {
		System.out.println("\n");
		System.out.println("-------------------------------------------");
		System.out.println("             GESTORE TELEFONIA             ");
		System.out.println("-------------------------------------------");
		System.out.println(" 1. Aggiungi Sim                           ");
		System.out.println(" 2. Aggiungi dati telefonata               ");
		System.out.println(" 3. Calcola minuti totali per conversazione");
		System.out.println("-------------------------------------------");
		System.out.println(" 0. Esci                                   ");
		System.out.println("-------------------------------------------");
		System.out.println("\n");
		int scelta = leggiInteroLimitato(0, 3, "Scelta--> ");
		return scelta;
	}

	private void schermoCalcolaConversazioniTotali(Operatore operatore) {
		String numero = leggiStringaNonVuota("Numero di telefono: ");
		Sim sim = operatore.cercaNumero(numero);
		if(sim == null) {
			System.out.println("Numero non presente.");
		} else {
			System.out.println("Minuti totali di conversazione: " + "\n" + sim.getMinutiTotali() + "\n" + operatore.calcolaMinuti(numero));
		}
	}

	private void schermoAggiungiTelefonata(Operatore operatore) {
		String numero = leggiStringaNonVuota("Numero di telefono: ");
		Sim sim = operatore.cercaNumero(numero);
		if(sim == null) {
			System.out.println("ERRORE: Numero non presente");
			return;
		}
		String numeroTel = leggiStringaNonVuota("Numero chiamata: ");
		int durata = leggiInteroLimitato(1, 500000, "Durata chiamata(In secondi): ");
		Telefonata telefonata = new Telefonata(numeroTel, durata);
		sim.addTelefonata(telefonata);
		System.out.println("*** Telefonata aggiunta correttamente ***");
	}

	private void schermoAggiungiSim(Operatore operatore) {
		String numero = leggiStringaNonVuota("Numero di telefono: ");
		while(operatore.cercaNumero(numero) != null) {
			System.out.println("Numero già presente. Immettere un nuovo numero");
			numero = leggiStringaNonVuota("Numero di telefono: ");
		}
		double credito = leggiDoublePositivo("Credito residuo: ");
		int chiamate = leggiInteroLimitato(0, 1000, "Chiamate effettuate: ");
		Sim sim = new Sim(numero, credito, chiamate);
		operatore.addSim(sim);
		System.out.println("*** Sim aggiunta correttamente ***");
	}

	private double leggiDoublePositivo(String stampa) {
		System.out.print(stampa);
		double valore = Console.leggiDouble();
		while(valore < 0) {
			System.out.println("ERRORE: Impossibile inserire un valore negativo");
			System.out.print(stampa);
			valore = Console.leggiDouble();
		}
		return valore;
	}

	private int leggiInteroLimitato(int min, int max, String scelta) {
		System.out.print(scelta);
		int valore = Console.leggiIntero();
		while(valore < min || valore > max) {
			System.out.println("ERRORE: Inserire un numero compreso tra " + min + " e " + max);
			System.out.print(scelta);
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

	private Operatore caricaMock() {
		Operatore operatore = new Operatore();

		Sim sim1 = new Sim("329/0312256", 20.30, 8);
		Sim sim2 = new Sim("380/7654384", 1.50, 2);

		Telefonata telefonata1 = new Telefonata("380/4568549", 385);
		Telefonata telefonata2 = new Telefonata("329/0312263", 200);
		Telefonata telefonata3 = new Telefonata("348/9482160", 120);
		Telefonata telefonata4 = new Telefonata("320/5153421", 80);
		Telefonata telefonata5 = new Telefonata("408/2021456", 60);

		sim1.addTelefonata(telefonata1);
		sim1.addTelefonata(telefonata2);
		sim1.addTelefonata(telefonata3);
		sim2.addTelefonata(telefonata4);
		sim2.addTelefonata(telefonata5);

		operatore.addSim(sim1);
		operatore.addSim(sim2);

		return operatore;
	}
	
}