package it.unibas.dipendenti.modello;
import java.util.*;

public class Azienda {
	private List<Dipendente> listaDipendenti = new ArrayList<Dipendente>();

	public void addDipendente(Dipendente dipendente) {
		this.listaDipendenti.add(dipendente);
	}

	public boolean contieneDipendenti() {
		return !this.listaDipendenti.isEmpty();
	}

	public float getStipendioMedio() {
		float media = 0;
		for (Dipendente dipendente : listaDipendenti) {
			media = dipendente.getStipendio();
		}
		return media / listaDipendenti.size();
	}

	public Dipendente verificaStipendio() {
		for (Dipendente dipendente : listaDipendenti) {
			if(dipendente.getStipendio() > 2000) {
				return dipendente;
			}
		}
		return null;
	}

	public Dipendente verificaStipendioMedio(int stipendio) {
		for (Dipendente dipendente : listaDipendenti) {
			if(stipendio < getStipendioMedio()) {
				return dipendente;
			}
		}
		return null;
	}

	public List<Dipendente> listaFiltrata(int stipendio) {
		List<Dipendente> listaConfrontaStipendi = new ArrayList<Dipendente>();
		for (Dipendente dipendente : listaDipendenti) {
			if (stipendio < getStipendioMedio()) {
				listaConfrontaStipendi.add(dipendente);
			}
		}
		return listaConfrontaStipendi;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("----------------------\n");
		sb.append("      DIPENDENTI      \n");
		sb.append("----------------------\n");
		if (contieneDipendenti()) {
			for (Dipendente dipendente : listaDipendenti) {
				sb.append(dipendente).append("\n");
				sb.append("----------------------\n");
			}
		}
		return sb.toString().trim();
	}
}