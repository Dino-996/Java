package it.unibas.censimento.modello;

public class Persona {

	public static final String OCCUPAZIONE_DISOCCUPATO = "Disoccupato";
	public static final String OCCUPAZIONE_INOCCUPATO = "Inoccupato";
	public static final String OCCUPAZIONE_OCCUPATO = "Occupato";

	private int eta;
	private String titoloStudio;
	private String occupazione;

	public Persona(int eta, String titoloStudio, String occupazione) {
		this.eta = eta;
		this.titoloStudio = titoloStudio;
		this.occupazione = occupazione;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Eta: ").append(this.eta).append("\n");
		sb.append("Titolo di studio: ").append(this.titoloStudio).append("\n");
		sb.append("Occupazione :").append(this.occupazione).append("\n");
		return sb.toString().trim();
	}
}