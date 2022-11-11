package it.unibas.affitti.modello;

import java.util.*;

public class Societa {

	private List<Edificio> listaEdifici = new ArrayList<Edificio>();

	public void addEdificio(Edificio edificio) {
		this.listaEdifici.add(edificio);
	}

	public Edificio cercaPerIndirizzo(String indirizzo) {
		for (Edificio edificio : listaEdifici) {
			if (edificio.getIndirizzo().equalsIgnoreCase(indirizzo)) {
				return edificio;
			}
		}
		return null;
	}

	public Edificio cercaEdificioMax(int annoCostruzione) {
		List<Edificio> cercaAnno = cercaPerAnno(annoCostruzione);
		if (cercaAnno.isEmpty()) {
			return null;
		}
		Edificio annoMax = null;
		for (Edificio edificio : cercaAnno) {
			if (annoMax == null) {
				annoMax = edificio;
				continue;
			}
			if (annoMax.getMQTotali() < edificio.getMQTotali()) {
				annoMax = edificio;
			}
		}
		return annoMax;
	}

	public List<Edificio> cercaPerAnno(int annoCostruzione) {
		List<Edificio> listaFiltrata = new ArrayList<Edificio>();
		for (Edificio edificio : listaEdifici) {
			if (edificio.getAnnoCostruzione() >= annoCostruzione) {
				listaFiltrata.add(edificio);
			}
		}
		return listaFiltrata;
	}

	public List<Appartamento> costoAffittoMax(double costoPerMQ) {
		List<Affitti> affittiPrezzoMax = new ArrayList<>();
		for (Edificio edificio : listaEdifici) {
			affittiPrezzoMax.addAll(edificio.getAppartamentiPrezzoMax(costoPerMQ));
		}
		return affittiPrezzoMax;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("-------------\n");
		sb.append("LISTA EDIFICI\n");
		sb.append("-------------\n");
		for (Edificio edificio : listaEdifici) {
			sb.append(edificio).append("\n");
			sb.append("-------------\n");
		}
		return sb.toString().trim();
	}

}