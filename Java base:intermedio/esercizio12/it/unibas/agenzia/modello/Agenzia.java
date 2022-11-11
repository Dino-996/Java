package it.unibas.agenzia.modello;

import java.util.*;

public class Agenzia {
	private List<Contribuente> listaContribuenti = new ArrayList<Contribuente>();

	public void addContribuente(Contribuente contribuente) {
		this.listaContribuenti.add(contribuente);
	}

	public boolean nonContieneContribuenti() {
		return this.listaContribuenti.isEmpty();
	}

	private boolean contieneContribuenti() {
		return !this.listaContribuenti.isEmpty();
	}

	public List<Contribuente> cercaReddito(int redditoAnnuoLordo) {
		List<Contribuente> listaRedditoContribuenti = new ArrayList<Contribuente>();
		for (Contribuente contribuente : listaContribuenti) {
			if (contribuente.getRedditoAnnuoLordo() < redditoAnnuoLordo) {
				listaRedditoContribuenti.add(contribuente);
			}
		}
		return listaRedditoContribuenti;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (contieneContribuenti()) {
			sb.append("------------------\n");
			sb.append("  Contribuente/i  \n");
			sb.append("------------------\n");
			for (Contribuente contribuente : listaContribuenti) {
				sb.append(contribuente).append("\n");
				sb.append("------------------\n");
			}
		}
		return sb.toString().trim();
	}
}