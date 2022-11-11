package it.unibas.elezioni.modello;

public class Candidato {

	public static final String SINDACO_SI = "Si";
	public static final String SINDACO_NO = "No";

	public static final String SESSO_UOMO = "Uomo";
	public static final String SESSO_DONNA = "Donna";

	private String nome;
	private String sindaco;
	private String sesso;
	private int voti;

	public Candidato(String nome, String sindaco, String sesso, int voti) {
		this.nome = nome;
		this.sindaco = sindaco;
		this.sesso = sesso;
		this.voti = voti;
	}

	public int getVoti() {
		return this.voti;
	}

	public String getNome() {
		return this.nome;
	}

	public String getSindaco() {
		return this.sindaco;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nome: ").append(this.nome).append("\n");
		sb.append("Sindaco: ").append(this.sindaco).append("\n");
		sb.append("Sesso: ").append(this.sesso).append("\n");
		sb.append("Voti: ").append(this.voti).append("\n");
		return sb.toString().trim();
	}
}