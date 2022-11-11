package it.unibas.telefonia.modello;
import java.util.*;

public class Operatore {

	private List<Sim> listaSim = new ArrayList<Sim>();

	public void addSim(Sim sim) {
		this.listaSim.add(sim);
	}

	public Sim cercaNumero(String numero) {
		for (Sim sim : listaSim) {
			if (sim.getNumero().equalsIgnoreCase(numero)) {
				return sim;
			}
		}
		return null;
	}

	public Sim calcolaMinuti(String numero) {
		List<Sim> listaMax = listaFiltrata(numero);
		if (listaMax == null) {
			return null;
		}
		Sim sommaMax = null;
		for (Sim sim : listaMax) {
			if (sommaMax == null) {
				sommaMax = sim;
				continue;
			}
			if (sommaMax.getMinutiTotali() == sim.getMinutiTotali()) {
				sommaMax = sim;
			}
		}
		return sommaMax;
	}

	public List<Sim> listaFiltrata(String numero) {
		List<Sim> listaDelleSim = new ArrayList<Sim>();
		for (Sim sim : listaSim) {
			if (sim.getNumero().equalsIgnoreCase(numero)) {
				listaDelleSim.add(sim);
			}
		}
		return listaDelleSim;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Sim sim : listaSim) {
			sb.append("----------------------\n");
			sb.append("         SIM          \n");
			sb.append(sim).append("\n");
			sb.append("----------------------\n");
		}
		return sb.toString().trim();
	}
}