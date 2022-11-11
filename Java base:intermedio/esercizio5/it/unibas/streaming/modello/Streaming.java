package it.unibas.streaming.modello;
import java.util.*;

public class Streaming {

	private List<Contenuto> listaContenuti = new ArrayList<Contenuto>();

	public void addContenuto(Contenuto contenuto) {
		this.listaContenuti.add(contenuto);
	}

	public Contenuto cercaMigliore(String tipologia) {
		List<Contenuto> listaContenutiMigliori = listaFiltrata(tipologia);
		if (listaContenuti == null) {
			return null;
		}
		Contenuto votoMax = null;
		for (Contenuto contenuto : listaContenutiMigliori) {
			if (contenuto.contieneCommenti() && (votoMax == null)) {
				votoMax = contenuto;
				continue;
			}
			if (contenuto.contieneCommenti() && (contenuto.getMedia() < votoMax.getMedia())) {
				votoMax = contenuto;
			}
		}
		return votoMax;
	}

	private List<Contenuto> listaFiltrata(String tipologia) {
		List<Contenuto> cercaTipologia = new ArrayList<Contenuto>();
		for (Contenuto contenuto : listaContenuti) {
			if (contenuto.getTipologia().equalsIgnoreCase(tipologia)) {
				cercaTipologia.add(contenuto);
			}
		}
		return cercaTipologia;
	}

	public Contenuto cercaTitolo(String titolo) {
		for (Contenuto contenuto : listaContenuti) {
			if (contenuto.getTitolo().equalsIgnoreCase(titolo)) {
				return contenuto;
			}
		}
		return null;
	}

	public Contenuto cercaPeggiore(String tipologia) {
		List<Contenuto> listaContenutiNegativi = listaFiltrata(tipologia);
		if (listaContenutiNegativi.isEmpty()) {
			return null;
		}
		Contenuto negativiMax = null;
		for (Contenuto contenuto : listaContenutiNegativi) {
			if (negativiMax == null && (contenuto.contaNegativi() > 0)) {
				negativiMax = contenuto;
				continue;
			}
			if (negativiMax != null && (negativiMax.contaNegativi() < contenuto.contaNegativi())) {
				negativiMax = contenuto;
			}
		}
		return negativiMax;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
			sb.append("-----------------------\n");
			sb.append("       CONTENUTO       \n");
			sb.append("-----------------------\n");
		for (Contenuto contenuto : listaContenuti) {
			sb.append(contenuto).append("\n");
			sb.append("-----------------------\n");
		}
		return sb.toString().trim();
	}
}