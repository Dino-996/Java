package it.unibas.streaming.modello;


public class Commento {
	
	private String username;
	private int voto;
	private String contenuto;

	public Commento (String username, int voto, String contenuto) {
		this.username = username;
		this.voto = voto;
		this.contenuto = contenuto;
	}

	public int getVoti() {
		return this.voto;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Username: ").append(this.username).append("\n");
		sb.append("Voto: ").append(this.voto).append("\n");
		sb.append("Contenuto: ").append(this.contenuto).append("\n");
		return sb.toString().trim();
	}
}