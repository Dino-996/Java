package it.unibas.conto.modello;

public class Utente {
	private String nome;
	private String cognome;
	private int eta;
	private String citta;

	public Utente(String nome, String cognome, int eta, String citta) {
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
		this.citta = citta;
	}

	public int getEta() {
		return this.eta;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nome: ").append(this.nome).append("\n");
		sb.append("Cognome: ").append(this.cognome).append("\n");
		sb.append("Età: ").append(this.eta).append("\n");
		sb.append("Città: ").append(this.citta).append("\n");
		return sb.toString().trim();
	}
}