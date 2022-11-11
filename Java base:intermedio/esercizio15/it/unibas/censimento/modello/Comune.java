package it.unibas.censimento.modello;

import java.util.*;

public class Comune {
	private List<Censimento> listaCensimento = new ArrayList<Censimento>();

	public void addCensimento(Censimento censimento) {
		this.listaCensimento.add(censimento);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("----------------------\n");
		sb.append("      CENSIMENTO      \n");
		sb.append("----------------------\n");
		for (Censimento censimento : listaCensimento) {
			sb.append(censimento).append("\n");
			sb.append("----------------------\n");	
		}
		return sb.toString().trim();
	}
}