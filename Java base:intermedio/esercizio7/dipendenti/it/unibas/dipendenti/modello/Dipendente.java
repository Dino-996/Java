package it.unibas.dipendenti.modello;

public class Dipendente {
	private String nome;
	private int stipendio;

	public Dipendente(String nome, int stipendio) {
		this.nome = nome;
		this.stipendio = stipendio;
	}

	public int getStipendio() {
		return this.stipendio;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nome: ").append(this.nome).append("\n");
		sb.append("Stripendio: ").append(this.stipendio).append("€").append("\n");
		return sb.toString().trim();
	}
}