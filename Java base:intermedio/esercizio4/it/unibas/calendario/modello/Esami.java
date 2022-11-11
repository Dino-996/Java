package it.unibas.calendario.modello;

public class Esami {

	private String nomeEsame;
	private String data;
	private int oraInizio;
	private int oraFine;
	private int numeroPrenotati;

	public Esami(String nomeEsame, String data, int oraInizio, int oraFine, int numeroPrenotati) {
		this.nomeEsame = nomeEsame;
		this.data = data;
		this.oraInizio = oraInizio;
		this.oraFine = oraFine;
		this.numeroPrenotati = numeroPrenotati;
	}

	public int getNumeroPrenotati() {
		return this.numeroPrenotati;
	}

	public String getData() {
		return this.data;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nome aula: ").append(this.nomeEsame).append("\n");
		sb.append("Data: ").append(this.data).append("\n");
		sb.append("Ora inizio: ").append(this.oraInizio).append("\n");
		sb.append("Ora fine: ").append(this.oraFine).append("\n");
		sb.append("Numero prenotati: ").append(this.numeroPrenotati).append("\n");
		return sb.toString().trim();
	}
}