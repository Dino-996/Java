package it.unibas.calendario.modello;
import java.util.*;

public class Aula {

	private String nomeAula;
	private int capienza;
	private List<Esami> listaEsami = new ArrayList<Esami>();

	public Aula(String nomeAula, int capienza) {
		this.nomeAula = nomeAula;
		this.capienza = capienza;
	}

	public void addEsame(Esami esami) {
		this.listaEsami.add(esami);
	}

	private boolean contieneEsami() {
		return !listaEsami.isEmpty();
	}

	public String getNomeAula() {
		return this.nomeAula;
	}

	public List<Esami> listaFiltrata(String data) {
		List<Esami> leggiLaData = new ArrayList<Esami>();
		for (Esami esami : listaEsami) {
			if (esami.getData().equalsIgnoreCase(data)) {
				leggiLaData.add(esami);
			}
		}
		return leggiLaData;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nome aula: ").append(this.nomeAula).append("\n");
		sb.append("Capienza: ").append(this.capienza).append("\n");
		if (contieneEsami()) {
			sb.append("----------------------------\n");
			sb.append("           ESAMI            \n");
			sb.append("----------------------------\n");
			for (Esami esami : listaEsami) {
				sb.append(esami).append("\n");
			}
		}
		return sb.toString().trim();
	}
}