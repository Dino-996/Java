package it.unibas.affitti.modello;

import java.util.*;

public class Appartamento {

	private String interno;
	private double mQ;
	private int numeroBagni;
	private int numeroStanze;
	private double costoPerMQ;

	public Appartamento(String interno, double mQ, int numeroBagni, int numeroStanze, double costoPerMQ) {
		this.interno = interno;
		this.mQ = mQ;
		this.numeroBagni = numeroBagni;
		this.numeroStanze = numeroStanze;
		this.costoPerMQ = costoPerMQ;
	}

	public String getInterno() {
		return this.interno;
	}

	public double getMQ() {
		return this.mQ;
	}
	public double getCostoMetroQuadro() {
		double totale = (this.costoPerMQ * this.mQ) + 10 * this.numeroStanze + (50 *numeroBagni);
		return totale;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Interno: ").append(this.interno).append("\n");
		sb.append("Metri quadri: ").append(this.mQ).append("\n");
		sb.append("Numero bagni: ").append(this.numeroBagni).append("\n");
		sb.append("Numero stanze: ").append(this.numeroStanze).append("\n");
		sb.append("Costo per metro quadro: ").append(this.costoPerMQ).append("\n");
		return sb.toString().trim();
	}
}