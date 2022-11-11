package it.unibas.censimento.modello;

import java.util.*;

public class Censimento {
	private String comune;
	private String slogan;
	private List<Persona> listaPersone = new ArrayList<Persona>();

	public Censimento(String comune, String slogan) {
		this.comune = comune;
		this.slogan = slogan;
	}

	public void addPersona(Persona persona) {
		this.listaPersone.add(persona);
	}

	public boolean contienePersone() {
		return !this.listaPersone.isEmpty();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (contienePersone()) {
		sb.append("--------------------\n");
		sb.append("Persone intervistate\n");
			for (Persona persona : listaPersone) {
				sb.append(persona).append("\n");
				sb.append("--------------------\n");
			}
		}
		return sb.toString().trim();
	}
}