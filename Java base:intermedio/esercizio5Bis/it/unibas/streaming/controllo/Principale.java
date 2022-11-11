package it.unibas.streaming.controllo;

import it.unibas.utilita.*;
import it.unibas.streaming.modello.*;

public class Principale {

	public static void main(String[] args) {
		Principale principale = new Principale();
		principale.esegui();
	}

	private void esegui() {
		Archivio archivio = new Archivio();
		archivio = caricaMock();
		while(true) {
			int scelta = schermoMenu();
			if(scelta == 0) {
				break;
			}
			if(scelta == 1) {
				schermoDatiContenuto(archivio);
			}
			if(scelta == 2) {
				schermoDatiCommento(archivio);
			}
			if(scelta == 3) {
				leggiContenutoMultimediale(archivio);
			}
			if(scelta == 4) {
				schermoMigliorContenuto(archivio);

			}
			if(scelta == 5) {
				schermoContenutoCriticato(archivio);
			}
		}
	}

	private int schermoMenu() {
		System.out.println("\n");
		System.out.println("-------------------------------------------------");
		System.out.println("|       GESTORE DI CONTENUTI MULTIMEDIALI       |");
		System.out.println("-------------------------------------------------");
		System.out.println("| 1. Inserisci contenuto multimediale           |");
		System.out.println("| 2. Inserisci un commento                      |");
		System.out.println("| 3. Stampa contenuto multimediale              |");
		System.out.println("| 4. Cerca miglior contenuto multimediale       |");
		System.out.println("| 5. Cerca contenuto multimediale pir criticato |");
		System.out.println("-------------------------------------------------");
		System.out.println("| 0. Esci                                       |");
		System.out.println("-------------------------------------------------");
		System.out.println("\n");
		int scelta = leggiInteroLimitato(0, 5, "Scelta--> ");
		return scelta;
	}

	private void schermoContenutoCriticato(Archivio archivio) {
		String tipologia = leggiTipologia();
		Contenuto contenuto = archivio.peggiorContenuto(tipologia);
		if (contenuto == null) {
			System.out.println("*** Nessuna valutazione per la tipologia inserita ***");
		} else {
			System.out.println(contenuto);
		}
	}

	private void schermoMigliorContenuto(Archivio archivio) {
		String tipologia = leggiTipologia();
		Contenuto contenuto = archivio.migliorContenuto(tipologia);
		if(contenuto == null) {
			System.out.println("*** Nessuna valutazione per la tipologia inserita ***");
		} else {
			System.out.println(contenuto);
		}
	}

	private Archivio leggiContenutoMultimediale(Archivio archivio) {
		String titolo = leggiStringaNonVuota("Inserisci il titolo: ");
		Contenuto contenuto = archivio.leggiTitolo(titolo);
		if (contenuto == null) {
			System.out.println("*** Contenuto multimediale inesistente ***");
			return null;
		}
		System.out.println(contenuto);
		return archivio;
	}

	private Archivio schermoDatiCommento(Archivio archivio) {
		String titolo = leggiStringaNonVuota("Inserisci il titolo: ");
		Contenuto contenuto = archivio.leggiTitolo(titolo);
		if(contenuto == null) {
			System.out.println("*** Contenuto multimediale inesistente ***");
			return null;
		}
		String username = leggiStringaNonVuota("Inserisci l'username: ");
		int voto = leggiInteroLimitato(1, 5, "Inserisci il voto: ");
		String contenutoStringa = leggiStringaNonVuota("Inserisci il commento: ");
		Commento commento = new Commento(username, voto, contenutoStringa);
		contenuto.addCommento(commento);
		archivio.addContenuto(contenuto);
		System.out.println("*** Commento aggiunto correttamente ***");
		return archivio;
	}

	private Archivio schermoDatiContenuto(Archivio archivio) {
		String titolo = leggiStringaNonVuota("Inserisci il titolo: ");
		while(archivio.leggiTitolo(titolo) != null) {
			System.out.println("Errore. Titolo già presente");
			titolo = leggiStringaNonVuota("Inserisci un nuovo titolo: ");
		}
		String regista = leggiStringaNonVuota("Inserisci il regista: ");
		int annoDiProduzione = leggiInteroLimitato(1800, 2021, "Inserisci l'anno di produzione: ");
		String tipologia = leggiTipologia();
		Contenuto contenuto = new Contenuto(titolo, regista, annoDiProduzione, tipologia);
		archivio.addContenuto(contenuto);
		System.out.println("*** Contenuto aggiunto correttamente ***");
		return archivio;
	}

	private String leggiTipologia() {
		int scelta = leggiInteroLimitato(0, 3, "Scegli tra: \n1.Film\n2.SerieTV\n3.Documentario\nScegli--> ");
		if(scelta == 1) {
			return Contenuto.TIPOLOGIA_FILM;
		}
		if(scelta == 2) {
			return Contenuto.TIPOLOGIA_SERIE_TV;
		}
		return Contenuto.TIPOLOGIA_DOCUMENTARIO;
	}

	private String leggiStringaNonVuota(String messaggio) {
		System.out.print(messaggio);
		String stringaStampare = Console.leggiStringa();
		while(stringaStampare.isEmpty()) {
			System.out.println("*** Errore. Impossibile lasciare il campo vuoto");
			System.out.print(messaggio);
		stringaStampare = Console.leggiStringa();
		}
		return stringaStampare;
	}

	private int leggiInteroLimitato(int min, int max, String messaggio) {
		System.out.print(messaggio);
		int valore = Console.leggiIntero();
		while(valore < min || valore > max) {
			System.out.println("*** Errore. Inserire un numero compreso tra " + min + " e " + max);
			System.out.print(messaggio);
			valore = Console.leggiIntero();
		}
		return valore;
	}

	private Archivio caricaMock() {
		Archivio archivio = new Archivio();

		Contenuto contenuto1 = new Contenuto("La teoria del Tutto", "James Marsh", 2014, Contenuto.TIPOLOGIA_FILM);
		Commento commento2 = new Commento("Sax120", 5, "Film molto bello");
		Commento commento1 = new Commento("Bon05", 5, "Film fantastico, consiglio di vederlo assolutamente");

		contenuto1.addCommento(commento1);
		contenuto1.addCommento(commento2);
		archivio.addContenuto(contenuto1);
		

		return archivio;
	}
}