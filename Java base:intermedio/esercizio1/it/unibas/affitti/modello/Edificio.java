package it.unibas.affitti.modello;

import java.util.*;

public class Edificio {

	public static final String QUALITA_OTTIMA = "Ottimo";
	public static final String QUALITA_BUONA = "Buono";
	public static final String QUALITA_SUFFICIENTE = "Sufficiente";

	private String indirizzo;
	private int annoCostruzione;
	private String livelloQualità;
	private List<Appartamento> listaAppartamenti = new ArrayList<Appartamento>();

	public Edificio(String indirizzo, int annoCostruzione, String livelloQualità) {
		this.indirizzo = indirizzo;
		this.annoCostruzione = annoCostruzione;
		this.livelloQualità = livelloQualità;
	}

	public void addAppartamento(Appartamento appartamento) {
		this.listaAppartamenti.add(appartamento);
	}

	public String getIndirizzo() {
		return this.indirizzo;
	}

	public int getAnnoCostruzione() {
		return this.annoCostruzione;
	}

	public Appartamento cercaInterno(String interno) {
		for (Appartamento appartamento : listaAppartamenti) {
			if (appartamento.getInterno().equalsIgnoreCase(interno)) {
				return appartamento;
			}
		}
		return null;
	}

	public List<Appartamento> getAppartamentiPrezzoMax(double costoPerMQ) {
		List<Appartamento> appartamentiMaxPrezzo = new ArrayList<Appartamento>();
		for (Appartamento appartamento : listaAppartamenti) {
			if (appartamento.getCostoMetroQuadro() < costoPerMQ) {
				appartamentiMaxPrezzo.add(appartamento);
			}
		}
		return appartamentiMaxPrezzo;
	}

	public double getMQTotali() {
		double somma = 0;
		for (Appartamento appartamento : listaAppartamenti) {
			somma += appartamento.getMQ();
		}
		return somma;
	}

	private boolean contieneAppartamento() {
		return !listaAppartamenti.isEmpty();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Indirizzo: ").append(this.indirizzo).append("\n");
		sb.append("Anno costruzione: ").append(this.annoCostruzione).append("\n");
		sb.append("Livello qualita: ").append(this.livelloQualità).append("\n");
		if (contieneAppartamento()) {
			for (Appartamento appartamento : listaAppartamenti) {
				sb.append(appartamento).append("\n");
			}
		}
		return sb.toString().trim();
	}
}