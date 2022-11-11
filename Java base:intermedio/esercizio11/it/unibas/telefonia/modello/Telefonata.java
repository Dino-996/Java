package it.unibas.telefonia.modello;

public class Telefonata {

	private String numeroChiamata;
	private int durata;

	public Telefonata(String numeroChiamata, int durata) {
		this.numeroChiamata = numeroChiamata;
		this.durata = durata;
	}

	public int getDurata() {
		return this.durata;
	}

	public int convertiInMinuti() {
		return getDurata() / 60;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Numero chiamata: ").append(this.numeroChiamata).append("\n");
		sb.append("Durata: ").append(this.durata).append(" secondi").append("\n");
		return sb.toString().trim();
	}
}