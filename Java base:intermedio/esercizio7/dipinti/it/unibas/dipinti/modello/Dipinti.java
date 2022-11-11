package it.unibas.dipinti.modello;

public class Dipinti {

	private String titolo;
	private int anno;

	public Dipinti(String titolo, int anno) {
		this.titolo = titolo;
		this.anno = anno;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Titolo: ").append(this.titolo).append("\n");
		sb.append("Anno di produzione: ").append(this.anno).append("\n");
		return sb.toString().trim();
	}
}