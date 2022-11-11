package it.unibas.calendario.modello;

import java.util.*;

public class Universita {
	
	private List<Aula> listaAule = new ArrayList<Aula>();

	public void addAula(Aula aula) {
		this.listaAule.add(aula);
	}

	public Aula cercaPerNome(String nome) {
		for (Aula aula : listaAule) {
			if (aula.getNome().equalsIgnoreCase(nome)) {
				return aula;
			}
		}
		return null;
	}

	public List<Appello> cercaPerData(String data) {
    	List<Appello> cercaData = new ArrayList<Appello>();
    	for (Aula aula : listaAule) {
    		cercaData.addAll(aula.filtraDate(data));
    	}
    	return cercaData;
    }

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("--------------------\n");
		sb.append("APPELLI UNIVERSITARI\n");
		sb.append("--------------------\n");
		for (Aula aula : listaAule) {
			sb.append(aula).append("\n");
			sb.append("********************\n");
		}
		return sb.toString().trim();
	}
}