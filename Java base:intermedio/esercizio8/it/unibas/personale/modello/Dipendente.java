package it.unibas.personale.modello;

public class Dipendente {

	public static final String UFFICIO_PERSONALE = "Personale";
	public static final String UFFICIO_VENDITE = "Vendite";
	public static final String UFFICIO_SEGRETERIA = "Segreteria";
	public static final String UFFICIO_RECLAMI = "Reclami";
	public static final String UFFICIO_PRODUZIONE = "Produzione";

	private String nome;
	private String codiceFiscale;
	private String ufficio;

	public Dipendente(String nome, String codiceFiscale, String ufficio) {
		this.nome = nome;
		this.codiceFiscale = codiceFiscale;
		this.ufficio = ufficio;
	}

	public String getNome() {
		return this.nome;
	}

	public String getUfficio() {
		return this.ufficio;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nome dipendente: ").append(this.nome).append("\n");
		sb.append("Codice fiscale: ").append(this.codiceFiscale).append("\n");
		sb.append("Ufficio di appartenenza: ").append(this.ufficio).append("\n");
		return sb.toString().trim();
	}
}