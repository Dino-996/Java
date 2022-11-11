package it.unibas.affitti.modello;

import java.util.*;

public class Societa {

	private List<Edificio> listaEdifici = new ArrayList<Edificio>();

	public void addEdificio(Edificio edificio) {
		this.listaEdifici.add(edificio);
	}

	private boolean contieneEdifici() {
		return !listaEdifici.isEmpty();
	}

	public Edificio leggiIndirizzo(String indirizzo) {
		for (Edificio edificio : listaEdifici) {
			if (edificio.getIndirizzo().equalsIgnoreCase(indirizzo)) {
				return edificio;
			}
		}
		return null;
	}

	public Edificio cercaCorrispondenza(int data, String indirizzo) {
		List<Edificio> listaConFiltro = cercaPerData(data);
		if (listaConFiltro == null) {
			return null;
		}
		Edificio corrispondenza = null;
		for (Edificio edificio : listaConFiltro) {
			if (corrispondenza == null) {
				corrispondenza = edificio;
				continue;
			}
			if (edificio.getIndirizzo().equalsIgnoreCase(indirizzo) == corrispondenza.getIndirizzo().equalsIgnoreCase(indirizzo)) {
				corrispondenza = edificio;
			}
		}
		return corrispondenza;
	}

	public List<Edificio> cercaPerData(int data) {
		List<Edificio> listaConFiltro = new ArrayList<Edificio>();
		for (Edificio edificio : listaEdifici) {
			if (edificio.getData() >= data) {
				listaConFiltro.add(edificio);
			}
		}
		return listaConFiltro;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("-----------------------\n");
		sb.append("     LISTA EDIFICI     \n");
		sb.append("-----------------------\n");
		if (contieneEdifici()) {
			for (Edificio edificio : listaEdifici) {
				sb.append(edificio).append("\n");
				sb.append("-----------------------\n");
			}
		}
		return sb.toString().trim();
	}
}