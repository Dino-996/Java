package it.unibas.streaming.modello;

import java.util.*;

public class Archivio {

List<Contenuto> listaContenuti = new ArrayList<Contenuto>();

	public void addContenuto(Contenuto contenuto) {
		this.listaContenuti.add(contenuto);
	}

	public Contenuto leggiTitolo(String titolo) {
		for (Contenuto contenuto : listaContenuti) {
			if(contenuto.getTitolo().equalsIgnoreCase(titolo)) {
				return contenuto;
			}
		}
		return null;
	}

	public Contenuto peggiorContenuto(String tipologia) {
		List<Contenuto> contenutoPerTipologia = filtraPerTipologia(tipologia);
		if (contenutoPerTipologia.isEmpty()) {
			return null;
		}
		Contenuto peggiore = null;
		for (Contenuto contenuto : contenutoPerTipologia) {
			if (peggiore == null && contenuto.contaNegativi() > 0) {
				peggiore = contenuto;
				continue;
			}
			if (peggiore != null && (peggiore.contaNegativi() < contenuto.contaNegativi())){
				peggiore = contenuto;
			}
		}
		return peggiore;
	}

	public Contenuto migliorContenuto(String tipologia) {
		List<Contenuto> contenutoPerTipologia = filtraPerTipologia(tipologia);
		if (contenutoPerTipologia.isEmpty()) {
			return null;
		}
		Contenuto migliore = null;
		for (Contenuto contenuto : contenutoPerTipologia) {
			if (contenuto.contieneCommenti() && migliore == null) {
				migliore = contenuto;
				continue;
			}
			if (contenuto.contieneCommenti() && migliore.getMedia() < contenuto.getMedia()) {
				migliore = contenuto;
			}
		}
		return migliore;
	}

	private List<Contenuto> filtraPerTipologia (String tipologia) {
		List<Contenuto> listaFiltrata = new ArrayList<Contenuto>();
		for (Contenuto contenuto : listaFiltrata) {
		 	if(contenuto.getTipologia().equals(tipologia)) {
		 		listaFiltrata.add(contenuto);
		 	}
		 } 
		 return listaFiltrata;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("----------------------").append("\n");
		sb.append("| ARCHIVIO CONTENUTI |").append("\n");
		sb.append("----------------------").append("\n");
		for (Contenuto contenuto : listaContenuti) {
		sb.append(contenuto).append("\n");
		sb.append("----------------------").append("\n");
		}
		return sb.toString().trim();
	}

}