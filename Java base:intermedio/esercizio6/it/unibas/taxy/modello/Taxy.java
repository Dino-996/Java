package it.unibas.taxy.modello;

public class Taxy {

	private String numero;
	private int cilindrata;
	private int chilometraggio;

	public Taxy(String numero, int cilindrata, int chilometraggio) {
		this.numero = numero;
		this.cilindrata = cilindrata;
		this.chilometraggio = chilometraggio;
	}

	public int getChilometraggio() {
		return this.chilometraggio;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Numero di serie: ").append(this.numero).append("\n");
		sb.append("Cilindrata: ").append(this.cilindrata).append("\n");
		sb.append("Chilometraggio ").append(this.chilometraggio).append("Km").append("\n");
		return sb.toString().trim();
	}
}