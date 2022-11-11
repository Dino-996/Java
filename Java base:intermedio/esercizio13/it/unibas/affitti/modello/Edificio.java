package it.unibas.affitti.modello;
import java.util.*;


public class Edificio {

	public static final String QUALITA_OTTIMO = "Ottima";
	public static final String QUALITA_BUONO = "Buona";
	public static final String QUALITA_SUFFICIENTE = "Sufficiente";	

	private String indirizzo;
	private int annoCostruzione;
	private String qualitaZona;
	private List<Appartamento> listaAppartamenti = new ArrayList<Appartamento>();

	public void addAppartamento(Appartamento appartamento) {
		this.listaAppartamenti.add(appartamento);
	}

	public Edificio(String indirizzo, int annoCostruzione, String qualitaZona){
		this.indirizzo = indirizzo;
		this.annoCostruzione = annoCostruzione;
		this.qualitaZona = qualitaZona;
	}

	private boolean contieneAppartamento() {
		return !this.listaAppartamenti.isEmpty();
	}

	public String getIndirizzo() {
		return this.indirizzo;
	}

	public int getAnno() {
		return this.annoCostruzione;
	}

	public Appartamento leggiInterno(String interno) {
		for (Appartamento appartamento : listaAppartamenti) {
			if (appartamento.getInterno().equalsIgnoreCase(interno)) {
				return appartamento;
			}
		}
		return null;
	}

	public int getMetriQuadri() {
		int somma = 0;
		for (Appartamento appartamento : listaAppartamenti) {
			somma = somma + appartamento.getMetriMQ();
		}
		return somma;
	}

	public List<Appartamento> getAppartamentiPrezzoMax(int prezzoMax) {
		List<Appartamento> appartamentiPrezzoMax = new ArrayList<Appartamento>();
		for (Appartamento appartamento : listaAppartamenti) {
			if (appartamento.getCostoMetroQuadro() < prezzoMax) {
				appartamentiPrezzoMax.add(appartamento);
			}
		}
		return appartamentiPrezzoMax;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Indirizzo: ").append(this.indirizzo).append("\n");
		sb.append("Anno costruzione: ").append(this.annoCostruzione).append("\n");
		sb.append("Qualita zona: ").append(this.qualitaZona).append("\n");
		if (contieneAppartamento()) {
			for (Appartamento appartamento : listaAppartamenti) {
				sb.append(appartamento).append("\n");
				sb.append("---------------------\n");
			}
		}
		return sb.toString().trim();
	}
}