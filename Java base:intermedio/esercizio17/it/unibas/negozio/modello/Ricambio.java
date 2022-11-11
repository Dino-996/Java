package it.unibas.negozio.modello;

public class Ricambio {

	public static final String TIPO_SUV = "SUV";
	public static final String TIPO_UTILITARIA = "Utilitaria";
	public static final String TIPO_SPORTIVA = "Sportiva";

	private String codice;
	private String descrizione;
	private double prezzo;
	private String tipologia;

	public Ricambio(String codice, String descrizione, double prezzo, String tipologia) {
		this.codice = codice;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.tipologia = tipologia;
	}

	public String getCodice() {
		return this.codice;
	}

	public String getTipologia() {
		return this.tipologia;
	}

	public double getPrezzo() {
		return this.prezzo;
	}

	public double sommaPrezzo() {
		double somma = 0;
		somma += getPrezzo();
		return somma;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Codice: ").append(this.codice).append("\n");
		sb.append("Descrizione: ").append(this.descrizione).append("\n");
		sb.append("Prezzo: ").append(this.prezzo).append("\n");
		sb.append("Modello auto: ").append(this.tipologia).append("\n");
		return sb.toString().trim();
	}
}