package it.unibas.affitti.modello;
import java.util.ArrayList;
import java.util.List;

public class Societa { 

	private List<Edificio> listaEdifici = new ArrayList<Edificio>();

	public void addEdificio(Edificio edificio) {
		this.listaEdifici.add(edificio);
	}

	private boolean contieneEdificio() {
		return !this.listaEdifici.isEmpty();
	}

	public Edificio leggiIndirizzo(String indirizzo) {
		for (Edificio edificio : listaEdifici) {
			if (edificio.getIndirizzo().equalsIgnoreCase(indirizzo)) {
				return edificio;
			}
		}
		return null;
	}

	public Edificio cercaPerMq(int annoCostruzione) {
		List<Edificio> cercaPerAnno = listaFiltrata(annoCostruzione);
		if (cercaPerAnno.isEmpty()) {
			return null;
		}
		Edificio annoMax = null;
		for (Edificio edificio : cercaPerAnno) {
			if (annoMax == null) {
				annoMax = edificio;
				continue;
			}
			if (edificio.getMetriQuadri() > annoMax.getMetriQuadri()) {
				annoMax = edificio;	
			}
		}
		return annoMax;
	}

	public List<Appartamento> trovaAppartamenti(int prezzoMax) {
		List<Appartamento> affittiPrezzoMax = new ArrayList<Appartamento>();
		for (Edificio edificio : listaEdifici) {
			affittiPrezzoMax.addAll(edificio.getAppartamentiPrezzoMax(prezzoMax));
		}
		return affittiPrezzoMax;
	}

	private List<Edificio> listaFiltrata(int annoCostruzione) {
		List<Edificio> cercaPerAnno = new ArrayList<Edificio>();
		for (Edificio edificio : listaEdifici) {
			if (edificio.getAnno() >= annoCostruzione) {
				cercaPerAnno.add(edificio);
			}
		}
		return cercaPerAnno;
	}

	public static int calcolaPrezzoMedio(List<Appartamento> intermedio) {
		if (intermedio == null || intermedio.isEmpty()) {
			return 0;
		}
		int somma = 0;
		for (Appartamento appartamento : intermedio) {
			somma += appartamento.getAffittoMensile();
		}
		return somma / intermedio.size();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("---------------------\n");
		sb.append("|   LISTA EDIFICI   |\n");
		sb.append("---------------------\n");
		if (contieneEdificio()) {
			for (Edificio edificio: listaEdifici) {
				sb.append(edificio).append("\n");
				sb.append("---------------------\n");
			}
		}
		return sb.toString().trim();
	}
}