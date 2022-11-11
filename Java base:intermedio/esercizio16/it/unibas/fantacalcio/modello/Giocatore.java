package it.unibas.fantacalcio.modello;

public class Giocatore {

	public static final String RUOLO_A = "Attaccante";
	public static final String RUOLO_C = "Centrocampista";
	public static final String RUOLO_D = "Difensore";
	public static final String RUOLO_P = "Portiere";
	
	private String nome;
	private String ruolo;
	private int costo;
	private int voto;

	public Giocatore(String nome, String ruolo, int costo, int voto) {
		this.nome = nome;
		this.ruolo = ruolo;
		this.costo = costo;
		this.voto = voto;
	}

	public String getRuolo() {
		return this.ruolo;
	}

	public int getVoto() {
		return this.voto;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nome: ").append(this.nome).append("\n");
		sb.append("Ruolo: ").append(this.ruolo).append("\n");
		sb.append("Costo: ").append(this.costo).append("\n");
		sb.append("Voto: ").append(this.voto).append("\n");
		return sb.toString().trim();
	}
}
