package it.unibas.agenzia.modello;

public class Contribuente {

	public static final String DESTINATARIO_ONLUS = "Onlus";
	public static final String DESTINATARIO_AIM = "AIM";
	public static final String DESTINATARIO_AIRC = "AIRC";

	public String codIdentificativo;
	private String nome;
	private String cognome;
	private int redditoAnnuoLordo;
	private double importoIRPEF;
	private String cinqueXMille;

	public Contribuente(String codIdentificativo, String nome, String cognome, int redditoAnnuoLordo, double importoIRPEF, String cinqueXMille) {
		this.codIdentificativo = codIdentificativo;
		this.nome = nome;
		this.cognome = cognome;
		this.redditoAnnuoLordo = redditoAnnuoLordo;
		this.importoIRPEF = importoIRPEF;
		this.cinqueXMille = cinqueXMille;
	}

	public int getRedditoAnnuoLordo() {
		return this.redditoAnnuoLordo;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Codice identificativo: ").append(this.codIdentificativo).append("\n");
		sb.append("Nome: ").append(this.nome).append("\n");
		sb.append("Cognome: ").append(this.cognome).append("\n");
		sb.append("Reddito annuo lordo: ").append(this.redditoAnnuoLordo).append("\n");
		sb.append("Importo IRPEF: ").append(this.importoIRPEF).append("\n");
		sb.append("5xMille: ").append(this.cinqueXMille).append("\n");
		return sb.toString().trim();
	}

}