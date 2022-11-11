package it.unibas.conto.modello;
import java.util.*;

public class Banca {
	private List<ContoCorrente> listaContoCorrente= new ArrayList<ContoCorrente>();

	public void addContoCorrente(ContoCorrente contoCorrente) {
		this.listaContoCorrente.add(contoCorrente);
	}

	public boolean contieneConti() {
		return !this.listaContoCorrente.isEmpty();
	}

	public int getNumeroConto(int somma) {
		somma = 0;
		for (ContoCorrente contoCorrente : listaContoCorrente) {
			somma = listaContoCorrente.size();
		}
		return somma + 1;
	}

	public ContoCorrente cercaPerConto(int numConto) {
		for (ContoCorrente contoCorrente : listaContoCorrente) {
			if (contoCorrente.getNumConto() == numConto) {
				return contoCorrente;
			}
		}
		return null;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("--------------------\n");
		sb.append("   CONTO CORRENTE   \n");
		sb.append("--------------------\n");
		if (contieneConti()) {
			for (ContoCorrente contoCorrente: listaContoCorrente) {
				sb.append(contoCorrente).append("\n");
				sb.append("--------------------\n");
			}
		}
		return sb.toString().trim();
	}
}