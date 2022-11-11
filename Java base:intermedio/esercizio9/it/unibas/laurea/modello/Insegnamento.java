package it.unibas.laurea.modello;

public class Insegnamento {

	private String nome;
	private int anno;
	private int crediti;

	public Insegnamento(String nome, int anno, int crediti) {
		this.nome = nome;
		this.anno = anno;
		this.crediti = crediti;
	}

	public String getNome() {
		return this.nome;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public void setCrediti(int crediti) {
		this.crediti = crediti;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nome: ").append(this.nome).append("\n");
		sb.append("Anno: ").append(this.anno).append("\n");
		sb.append("Crediti: ").append(this.crediti).append("\n");
		return sb.toString().trim();
	}
}