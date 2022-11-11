package it.unibas.affitti.modello;

public class Appartamento {

	private String interno;
	private int metriQuadri;
	private int numeroStanze;
	private int numeroBagni;
	private int costoMetroQuadro;

	public Appartamento(String interno, int metriQuadri, int numeroStanze, int numeroBagni, int costoMetroQuadro) {
		this.interno = interno;
		this.metriQuadri = metriQuadri;
		this.numeroStanze = numeroStanze;
		this.numeroBagni = numeroBagni;
		this.costoMetroQuadro = costoMetroQuadro;
	}

	public String getInterno() {
		return this.interno;
	}

	public int getMetriMQ() {
		return this.metriQuadri;
	}

	public int getAffittoMensile() {
		int totale = (this.costoMetroQuadro * this.metriQuadri) + 10 * this.numeroStanze + (50 * this.numeroBagni);
		return totale;
	}

	public int getCostoMetroQuadro() {
		return this.costoMetroQuadro;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Interno: ").append(this.interno).append("\n");
		sb.append("Metri Quadri: ").append(this.metriQuadri).append("\n");
		sb.append("Numero stanze: ").append(this.numeroStanze).append("\n");
		sb.append("Numero bagni: ").append(this.numeroBagni).append("\n");
		sb.append("Costo per metro quadro: ").append(this.costoMetroQuadro).append("\n");
		return sb.toString().trim();
	}
}