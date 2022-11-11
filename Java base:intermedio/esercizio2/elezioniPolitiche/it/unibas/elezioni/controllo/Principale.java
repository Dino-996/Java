package it.unibas.elezioni.controllo;

import it.unibas.elezioni.modello.*;
import it.unibas.utilita.*;

public class Principale {

	public static void main(String[] args) {
		Principale principale = new Principale();
		principale.esegui();
	}

	private void esegui() {
		Elezioni elezioni = new Elezioni();
		//elezioni = caricaMock();
		while(true) {
		int scelta = schermoMenu();
			if (scelta == 0) {
				break;
			}
			if (scelta == 1) {
				schermoAggiungiLista(elezioni);
				System.out.print(elezioni);
			}
			if (scelta == 2) {
				schermoAggiungiCandidato(elezioni);
			}
			if (scelta == 3) {
				schermoStampaListaVincente(elezioni);
			}
		}
	}

	private int schermoMenu() {
		System.out.println("\n");
		System.out.println("--------------------------");
		System.out.println(" ELEZIONI POLITICHE       ");
		System.out.println("--------------------------");
		System.out.println(" 1. Aggiungi lista        ");
		System.out.println(" 2. Aggiungi candidato    ");
		System.out.println(" 3. Stampa lista vincente ");
		System.out.println("--------------------------");
		System.out.println(" 0. Esci                  ");
		System.out.println("--------------------------");
		System.out.println("\n");
		int scelta = leggiInteroLimitato(0, 3, "Scelta--> ");
		System.out.println("\n");
		return scelta;
	}

	private void schermoStampaListaVincente(Elezioni elezioni) {
		Lista listaVincente = elezioni.cercaListaVincente();
		if (listaVincente == null) {
			System.out.println("ERRORE: Non è presente nessuna lista vincente");
		} else {
			System.out.println("Lista vincente: \n" + listaVincente + "\nVoti totali: " + listaVincente.getVotiTotali());
		}
	}

	private void schermoAggiungiCandidato(Elezioni elezioni) {
		String nomePartito = leggiStringaNonVuota("Nome partito: ");
		Lista partito = elezioni.cercaPartito(nomePartito);
		if (partito == null) {
			System.out.println("ERRORE: Lista insesistente.");
			return;
		}
		System.out.println(partito);
		String pierino = leggiStringaNonVuota("Nome candidato: ");
		String sindaco = leggiSindaco("Candidato sindaco: ");
		while (partito.cercaCandidato(pierino) != null) {
			System.out.println("ERRORE: Candidato sindaco già presente. Immetti un nuovo candidato");
			pierino = leggiStringaNonVuota("Nome candidato: ");
			sindaco = leggiSindaco("Candidato sindaco: ");
		}
		String sesso = leggiSesso("Sesso: ");
		int voti = leggiInteroLimitato(1, 500, "Voti: ");
		Candidato candidato = new Candidato(pierino, sindaco, sesso, voti);
		partito.addCandidato(candidato);
		System.out.println("*** Candidato aggiunto correttamente ***");
	}

	private void schermoAggiungiLista(Elezioni elezioni) {
		String nomePartito = leggiStringaNonVuota("Nome Lista: ");
		while (elezioni.cercaPartito(nomePartito) != null) {
			System.out.println("ERRORE: Lista già esistente, immetti un nuovo nome.");
			nomePartito = leggiStringaNonVuota("Nome partito: ");
		}
		String slogan = leggiStringaNonVuota("Slogan: ");
		Lista lista = new Lista(nomePartito, slogan);
		elezioni.addLista(lista);
		System.out.println("*** Lista aggiunta correttamente ***");
	}

	private String leggiSesso(String stampa) {
		System.out.println(stampa);
		int scelta = leggiInteroLimitato(1, 2, "1.Uomo\n2.Donna\nScelta--> ");
		if (scelta == 1) {
			return Candidato.SESSO_UOMO;
		}
		return Candidato.SESSO_DONNA;
	}

	private String leggiSindaco(String stampa) {
		System.out.println(stampa);
		int scelta = leggiInteroLimitato(1, 2, "1.Si\n2.No\nScelta--> ");
		if (scelta == 1) {
			return Candidato.SINDACO_SI;
		}
		return Candidato.SINDACO_NO;
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
			System.out.println("ERRORE: Immetti un valore compreso tra " + min + " e " + max);
			System.out.print(stampa);
			valore = Console.leggiIntero();
		}
		return valore;
	}

	private Elezioni caricaMock() {
		Elezioni elezioni = new Elezioni();

		Lista lista1 = new Lista("Uniti per il comune", "Vivere bene e vivere meglio");
		Lista lista2 = new Lista("Il partito della libertà", "Diritti prima dei doveri");

		Candidato candidato1 = new Candidato("Mario Draghi", Candidato.SINDACO_SI, Candidato.SESSO_UOMO, 300);
		Candidato candidato2 = new Candidato("Romea Giuli", Candidato.SINDACO_NO, Candidato.SESSO_DONNA, 120);
		Candidato candidato3 = new Candidato("Domenica Amendola", Candidato.SINDACO_SI, Candidato.SESSO_DONNA, 450);
		Candidato candidato4 = new Candidato("Massimo Meridio", Candidato.SINDACO_NO, Candidato.SESSO_UOMO, 200);

		lista1.addCandidato(candidato1);
		lista1.addCandidato(candidato2);
		lista2.addCandidato(candidato3);
		lista2.addCandidato(candidato4);

		elezioni.addLista(lista1);
		elezioni.addLista(lista2);

		return elezioni;
	}
}