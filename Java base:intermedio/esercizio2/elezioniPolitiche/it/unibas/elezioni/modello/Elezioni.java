package it.unibas.elezioni.modello;

import java.util.*;

public class Elezioni {

	private List<Lista> listaCandidati = new ArrayList<Lista>();

	public void addLista(Lista lista) {
		this.listaCandidati.add(lista);
	} 

	public Lista cercaPartito(String nomePartito) {
		for (Lista lista : listaCandidati) {
			if (lista.getNomePartito().equalsIgnoreCase(nomePartito)) {
				return lista;
			}
		}
		return null;
	}

	public Lista cercaListaVincente() {
		Lista vincente = null;
		for (Lista lista : listaCandidati) {
			if (vincente == null) {
				vincente = lista;
				continue;
			}
			if (lista.getVotiTotali() > vincente.getVotiTotali()) {
				vincente = lista;
			}
		}
		return vincente;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("---------------\n");
		sb.append("LISTE PARTITI\n");
		sb.append("---------------\n");
		for (Lista lista : listaCandidati) {
			sb.append(lista).append("\n");
			sb.append("***************\n");
		}
		return sb.toString().trim();	
	}	
}