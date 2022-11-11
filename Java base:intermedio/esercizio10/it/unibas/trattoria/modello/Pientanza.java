package it.unibas.trattoria.modello;

public class Pientanza {

	private String nome;
	private double prezzo;
	
	public Pientanza(String nome, double prezzo) {
		this.nome = nome;
		this.prezzo = prezzo;
	}

	public double getPrezzo() {
		return this.prezzo;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nome pietanza: ").append(this.nome).append("\n");
		sb.append("Prezzo: ").append(this.prezzo).append("€").append("\n");
		return sb.toString().trim();
	}
}