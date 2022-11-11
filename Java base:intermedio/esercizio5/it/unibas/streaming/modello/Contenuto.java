package it.unibas.streaming.modello;
import java.util.*;

public class Contenuto {
	
	public static final String TIPOLOGIA_FILM = "Film";
	public static final String TIPOLOGIA_DOCUMENTARIO = "Documentario";
	public static final String TIPOLOGIA_SERIE_TV = "SerieTv";

	private String titolo;
	private String regista;
	private int annoDiProduzione;
	private String tipologia;
	private List<Commento> listaCommenti = new ArrayList<Commento>();

	public Contenuto(String titolo, String regista, int annoDiProduzione, String tipologia) {
		this.titolo = titolo;
		this.regista = regista;
		this.annoDiProduzione = annoDiProduzione;
		this.tipologia = tipologia;
	}

	public void addCommento(Commento commento) {
		this.listaCommenti.add(commento);
	}

	public boolean contieneCommenti() {
		return !this.listaCommenti.isEmpty();
	}

	public String getTitolo() {
		return this.titolo;
	}

	public String getTipologia() {
		return this.tipologia;
	}

	public float getMedia() {
		float media = 0;
		for (Commento commento : listaCommenti) {
			media += commento.getVoti();
		}
		return media / listaCommenti.size();
	}

	public int contaNegativi() {
		int somma = 0;
		for (Commento commento : listaCommenti) {
			if (commento.getVoti() <= 2) {
				somma += commento.getVoti();
			}
		}
		return somma;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Titolo: ").append(this.titolo).append("\n");
		sb.append("Regista: ").append(this.regista).append("\n");
		sb.append("Anno di produzione: ").append(this.annoDiProduzione).append("\n");
		sb.append("Tipologia: ").append(this.tipologia).append("\n");
		if (contieneCommenti()) {
			sb.append("-----------------------\n");
			sb.append("        COMMENTO       \n");
			sb.append("-----------------------\n");
			for (Commento commento : listaCommenti) {
				sb.append(commento).append("\n");
			}
		}
		return sb.toString().trim();
	}
}