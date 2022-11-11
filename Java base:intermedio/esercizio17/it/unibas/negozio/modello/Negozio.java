package it.unibas.negozio.modello;
import java.util.*;

public class Negozio {
	private List<Ricambio> listaRicambi = new ArrayList<Ricambio>();

	public void addRicambio(Ricambio ricambio) {
		this.listaRicambi.add(ricambio);
	}

	public boolean contieneRicambi() {
		return !this.listaRicambi.isEmpty();
	}

	public Ricambio cercaCodice(String codice) {
		for (Ricambio ricambio : listaRicambi) {
			if (ricambio.getCodice().equalsIgnoreCase(codice)) {
				return ricambio;
			}
		}
		return null;
	}

	public List<Ricambio> listaFiltrataTipologia(String tipologia) {
		List<Ricambio> listaFiltrata = new ArrayList<Ricambio>();
		for (Ricambio ricambio : listaRicambi) {
			if (ricambio.getTipologia().equals(tipologia)) {
				listaFiltrata.add(ricambio);
			}
		}
		return listaFiltrata;
	}
		

	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (contieneRicambi()) {
			sb.append("--------------------------\n");
			sb.append("          RICAMBI         \n");
			sb.append("--------------------------\n");
			for (Ricambio ricambio : listaRicambi) {
				sb.append(ricambio).append("\n");
				sb.append("--------------------------\n");
			}
		}
		return sb.toString().trim();
	}
}