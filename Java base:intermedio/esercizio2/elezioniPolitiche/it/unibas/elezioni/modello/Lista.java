package it.unibas.elezioni.modello;

import java.util.*;

public class Lista {
	
	private String nomePartito;
	private String slogan;
	private List<Candidato> listaCandidati = new ArrayList<Candidato>();

	public Lista(String nomePartito, String slogan) {
		this.nomePartito = nomePartito;
		this.slogan = slogan;
	}

	public void addCandidato(Candidato candidato) {
		this.listaCandidati.add(candidato);
	}

	public String getNomePartito() {
		return this.nomePartito;
	}

	public Candidato cercaCandidato(String nome) {
		for (Candidato candidato : listaCandidati) {
			if (candidato.getNome().equalsIgnoreCase(nome) && candidato.getSindaco() == Candidato.SINDACO_SI) {
				return candidato;
			}
		}
		return null;
	}

	public int getVotiTotali() {
		int somma = 0;
		for (Candidato candidato : listaCandidati) {
			somma += candidato.getVoti();
		}
		return somma;
	}

	private boolean contieneCandidati() {
		return !listaCandidati.isEmpty();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nome lista: ").append(this.nomePartito).append("\n");
		sb.append("Slogan: ").append(this.slogan).append("\n");
		if (contieneCandidati()) {
			for (Candidato candidato : listaCandidati) {
				sb.append(candidato).append("\n\n");
			}
		}
		return sb.toString().trim();
	}
}