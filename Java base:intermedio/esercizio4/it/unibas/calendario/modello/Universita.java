package it.unibas.calendario.modello;
import java.util.*;

public class Universita {

	private List<Aula> listaAule = new ArrayList<Aula>();

	public void addAula(Aula aula) {
		this.listaAule.add(aula);
	}

	public Aula cercaPerNome(String nomeAula) {
		for (Aula aula : listaAule) {
			if (aula.getNomeAula().equalsIgnoreCase(nomeAula)) {
				return aula;
			}
		}
		return null;
	}

	public List<Esami> aggiungiPerData(String data) {
		List<Esami> leggiData = new ArrayList<Esami>();
		for (Esami esami : listaEsami) {
			leggiData.addAll(esami.listaFiltrata(data));
		}
		return leggiData;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("----------------------------\n");
		sb.append("            AULA            \n");
		sb.append("----------------------------\n");
		for (Aula aula : listaAule) {
			sb.append(aula).append("\n");
		}
		return sb.toString().trim();
	}
}