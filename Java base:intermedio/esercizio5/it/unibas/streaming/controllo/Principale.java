package it.unibas.streaming.controllo;
import it.unibas.streaming.modello.*;
import it.unibas.utilita.*;

public class Principale {
	
	public static void main(String[] args) {
		Principale principale = new Principale();
		principale.esegui();
	}

	private void esegui() {
		Streaming streaming = new Streaming();
		streaming = caricaMock();
		while(true) {
			int scelta = schermoMenu();
			if (scelta == 0) {
				break;
			}
			if (scelta == 1) {
				schermoAggiungiContenuto(streaming);
			}
			if (scelta == 2) {
				schermoAggiungiCommento(streaming);
			}
			if (scelta == 3) {
				schermoLeggiContenuto(streaming);
			}
			if (scelta == 4) {
				schermoCercaMigliorContenuto(streaming);
			}
			if (scelta == 5) {
				schermoCercaContenutoCriticato(streaming);
			}
		}
	}

	public void schermoCercaContenutoCriticato(Streaming streaming) {
		String tipologia = leggiTipologia("Tipologia: ");
		Contenuto peggiore = streaming.cercaPeggiore(tipologia);
		if (peggiore == null) {
			System.out.println("Nessun contenuto trovato per questa tipologia");
			return;
		} else {
			System.out.println("Contenuto criticato trovato: \n\n" + peggiore);
		}
	}

	public void schermoCercaMigliorContenuto(Streaming streaming) {
		String tipologia = leggiTipologia("Tipologia: ");
		Contenuto mediaVotoAlta = streaming.cercaMigliore(tipologia);
		if (mediaVotoAlta != null) {
			System.out.println("Nessun contenuto trovato per questa tipologia");
			return;
		} else {
			System.out.println("Miglior contenuto trovato: \n\n" + mediaVotoAlta);
		}
	}

	public void schermoLeggiContenuto(Streaming streaming) {
		String titolo = leggiStringaNonVuota("Titolo: ");
		Contenuto contiene = streaming.cercaTitolo(titolo);
		if (contiene == null) {
			System.out.println("Nessun contenuto trovato per questo titolo");
		} else {
			System.out.println("Contenuto trovato: \n\n" + contiene);
		}
	}

	public void schermoAggiungiCommento(Streaming streaming) {
		String titolo = leggiStringaNonVuota("Titolo: ");
		Contenuto contiene = streaming.cercaTitolo(titolo);
		if (contiene == null) {
			System.out.println("ERRORE: Contenuto inesistente");
			return;
		}
		String username = leggiStringaNonVuota("Username: ");
		int voto = leggiInteroLimitato(1, 5, "Voto: ");
		String contenuto = leggiStringaNonVuota("Commento: ");
		Commento commento = new Commento(username, voto, contenuto);
		contiene.addCommento(commento);
		System.out.println("*** Commento aggiunto correttamente ***");
	}

	public void schermoAggiungiContenuto(Streaming streaming) {
		String titolo = leggiStringaNonVuota("Titolo: ");
		while(streaming.cercaTitolo(titolo) != null) {
			System.out.println("ERRORE: Contenuto esistente. Immettere un nuovo contenuto..");
			titolo = leggiStringaNonVuota("Titolo: ");
		}
		String regista = leggiStringaNonVuota("Regista: ");
		int annoDiProduzione = leggiInteroLimitato(1900, 2021, "Anno produzione: ");
		String tipologia = leggiTipologia("Tipologia: ");
		Contenuto contenuto = new Contenuto(titolo, regista, annoDiProduzione, tipologia);
		streaming.addContenuto(contenuto);
		System.out.println("*** Contenuto aggiunto correttamente ***");
	}

	public int schermoMenu() {
		System.out.println("\n");
		System.out.println("-----------------------------");
		System.out.println("    CONTENUTI MULTIMEDIALI   ");
		System.out.println("-----------------------------");
		System.out.println(" 1. Aggiungi contenuto       ");
		System.out.println(" 2. Aggiungi commento        ");
		System.out.println(" 3. Stampa contenuto         ");
		System.out.println(" 4. Cerca contenuto migliore ");
		System.out.println(" 5. Cerca contenuto criticato");
		System.out.println("-----------------------------");
		System.out.println(" 0. Esci                     ");
		System.out.println("-----------------------------");
		System.out.println("\n");
		int scelta = leggiInteroLimitato(0, 6, "Scelta--> ");
		return scelta;
	}

	public String leggiStringaNonVuota(String stampa) {
		System.out.print(stampa);
		String valore = Console.leggiStringa();
		while(valore.isEmpty()) {
			System.out.println("ERRORE: Impossibile lasciare il campo vuoto");
			System.out.print(stampa);
			valore = Console.leggiStringa();
		}
		return valore;
	}

	public int leggiInteroLimitato(int min, int max, String stampa) {
		System.out.print(stampa);
		int valore = Console.leggiIntero();
		while(valore < min || valore > max) {
			System.out.println("ERRORE: Inserire un numero compreso tra " + min + " e " + max);
			System.out.print(stampa);
			valore = Console.leggiIntero();
		}
		return valore;
	}

	public String leggiTipologia(String stampa) {
		System.out.print(stampa);
		int valore = leggiInteroLimitato(1, 3, "\n1.Film\n2.SerieTV\n3.Documentario\nScelta--> ");
		if (valore == 1) {
			return Contenuto.TIPOLOGIA_FILM;
		}
		if (valore == 2) {
			return Contenuto.TIPOLOGIA_SERIE_TV;
		}
		return Contenuto.TIPOLOGIA_DOCUMENTARIO;
	}

	private Streaming caricaMock() {
		Streaming streaming = new Streaming();

		Contenuto contenuto1 = new Contenuto("La Teoria del Tutto", "James Burns", 1995, Contenuto.TIPOLOGIA_FILM);
		Commento commento1 = new Commento("Bob05", 5 ,"Bellissimo film");

		contenuto1.addCommento(commento1);
		streaming.addContenuto(contenuto1);

		return streaming;
	}
}