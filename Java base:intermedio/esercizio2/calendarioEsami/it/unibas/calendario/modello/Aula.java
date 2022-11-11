package it.unibas.calendario.modello;

import java.util.*;

public class Aula {
	
	private String nome;
	private int capienza;
	private List<Appello> listaAppelli = new ArrayList<Appello>();

	public Aula(String nome, int capienza) {
		this.nome = nome;
		this.capienza = capienza;
	}

	public void addAppello(Appello appello) {
		this.listaAppelli.add(appello);
	}

	public boolean contieneAppelli() {
		return !listaAppelli.isEmpty();
	}

	public String getNome() {
		return this.nome;
	}

	public List<Appello> filtraDate(String data) {
		List<Appello> filtraPerData = new ArrayList<Appello>();
		for (Appello appello : listaAppelli) {
			if (appello.getData().equals(data)) {
				filtraPerData.add(appello);
			}
		}
		return filtraPerData;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nome aula: ").append(this.nome).append("\n");
		sb.append("Capienza: ").append(this.capienza).append("\n");
		if (contieneAppelli()) {
			for (Appello appello : listaAppelli) {
			sb.append(appello).append("\n");
			sb.append("----------------\n");
			}
		}
		return sb.toString().trim();
	}
}