package it.unibas.trattoria.controllo;
import it.unibas.trattoria.modello.*;
import it.unibas.utilita.*;


public class Principale {

	public static void main(String[] args) {
		Principale principale = new Principale();
		principale.esegui();
	}

	private void esegui() {
		Menu menu = new Menu();
		menu = caricaMock();
		System.out.println(menu);
		while(true) {
			int scelta = schermoMenu();
			if (scelta == 0) {
				break;
			}
			if (scelta == 1) {
				menu = schermoAggiungiMenu();
			}
			if (scelta == 2) {
				schermoAggiungiPietanza(menu);
			}
			if (scelta == 3) {
				schermoCercaCostosa(menu);
			}
		}
	}

	private int schermoMenu() {
		System.out.println("\n");
		System.out.println("-------------------------------");
		System.out.println("              MENU             ");
		System.out.println("-------------------------------");
		System.out.println(" 1. Aggiungi menù              ");
		System.out.println(" 2. Aggiungi pietanza          ");
		System.out.println(" 3. Cerca pietanza più costosa ");
		System.out.println("-------------------------------");
		System.out.println(" 0.Esci                        ");
		System.out.println("-------------------------------");
		System.out.println("\n");
		int scelta = leggiInteroLimitato(0, 3, "Scelta--> ");
		return scelta;
	}

	private void schermoCercaCostosa(Menu menu) {
		Pientanza pietanza = menu.cercaPiuCostosa();
		if (pietanza == null) {
			System.out.println("Nessuna pietanza presente per il prezzo inserito");
			return;
		}
		System.out.println(pietanza);
	}

	private void schermoAggiungiPietanza(Menu menu) {
		String nome = leggiStringaNonVuota("Nome pietanza: ");
		double prezzo = leggiDoublePositivo("Prezzo: ");
		Pientanza pietanza = new Pientanza(nome, prezzo);
		System.out.println("--- PIETANZE ---");
		System.out.println(pietanza);
		menu.addPietanza(pietanza);
		System.out.println("*** Pietanza aggiunta correttamente ***");
	}

	private Menu schermoAggiungiMenu() {
		Menu menu = new Menu();
		int scelta = leggiInteroLimitato(1, 2, "Scegli tra \n1. Crea Menu\n2. Non creare il menù\nScelta: ");
		if (scelta == 1) {
			System.out.println("*** Menu creato correttamente ***");
			return menu;
		} else {
			System.out.println("*** Menu non creato ***");
			return null;
		}
	}

	private int leggiInteroLimitato(int min, int max, String scelta) {
		System.out.print(scelta);
		int valore = Console.leggiIntero();
		while(valore < min || valore > max) {
			System.out.println("ERRORE: Inserire un valore compreso tra " + min + " e " + max);
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

	private double leggiDoublePositivo(String messaggio) {
		System.out.print(messaggio);
		double valore = Console.leggiDouble();
		while(valore < 0) {
			System.out.print("ERRORE: Inserire un valore positivo");
			System.out.print(messaggio);
			valore = Console.leggiDouble();
		}
		return valore;
	}

	private Menu caricaMock() {
		Menu menu = new Menu();

		Pientanza pietanza1 = new Pientanza("Orecchiette al sugo", 4);
		Pientanza pietanza2 = new Pientanza("Pizza margherita", 4.5);
		Pientanza pietanza3 = new Pientanza("Petto di pollo", 3.5);
		Pientanza pietanza4 = new Pientanza("Piadina", 2);
		Pientanza pietanza6 = new Pientanza("Carnazza", 10);
		Pientanza pietanza5 = new Pientanza("Tagliata", 10);

		menu.addPietanza(pietanza1);
		menu.addPietanza(pietanza2);
		menu.addPietanza(pietanza3);
		menu.addPietanza(pietanza4);
		menu.addPietanza(pietanza5);

		return menu;
	}
}