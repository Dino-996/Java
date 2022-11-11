package it.unibas.calendario.modello;

public class Appello {
	
	private String nomeInsegnamento;
	private String data;
	private int oraInizio;
	private int oraFine;
	private int numero;

	public Appello(String nomeInsegnamento, String data, int oraInizio, int oraFine, int numero) {
		this.nomeInsegnamento = nomeInsegnamento;
		this.data = data;
		this.oraInizio = oraInizio;
		this.oraFine = oraFine;
		this.numero = numero;
	}

	public String getData() {
		return this.data;
	}

	public int getNumero() {
		return this.numero;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nome insegnamento: ").append(this.nomeInsegnamento).append("\n");
		sb.append("Data: ").append(this.data).append("\n");
		sb.append("Ora inizio: ").append(this.oraInizio).append("\n");
		sb.append("Ora fine: ").append(this.oraFine).append("\n");
		sb.append("Numero prenotati: ").append(this.numero).append("\n");
		return sb.toString().trim();
	}
}