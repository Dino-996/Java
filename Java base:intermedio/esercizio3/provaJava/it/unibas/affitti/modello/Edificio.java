package it.unibas.affitti.modello;

public class Edificio {

	public final static String QUALITA_SUFFICIENTE = "Sufficiente";
	public final static String QUALITA_BUONO = "Buono";
	public final static String QUALITA_OTTIMO = "Ottimo";

	private String indirizzo;
	private int annoCostruzione;
	private String qualitàZonaUrbana;
	
	public Edificio(String indirizzo, int annoCostruzione, String qualitàZonaUrbana) {
		this.indirizzo = indirizzo;
		this.annoCostruzione = annoCostruzione;
		this.qualitàZonaUrbana = qualitàZonaUrbana;
	}

	public String getIndirizzo() {
		return this.indirizzo;
	}

	public int getData() {
		return this.annoCostruzione;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Indirizzo: ").append(this.indirizzo).append("\n");
		sb.append("Anno costruzione: ").append(this.annoCostruzione).append("\n");
		sb.append("Qualità zona urbana: ").append(this.qualitàZonaUrbana).append("\n");
		return sb.toString().trim();
	}
}