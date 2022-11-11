package it.unibas.laurea.modello;
import java.util.*;

public class PianoStudi {

	private List<Insegnamento> listaInsegnamenti = new ArrayList<Insegnamento>();

	public void addInsegnamento(Insegnamento insegnamento) {
		this.listaInsegnamenti.add(insegnamento);
	}

	public boolean nonContieneInsegnamenti() {
		return this.listaInsegnamenti.isEmpty();
	}

	public Insegnamento cercaPerNome(String nome) {
		for (Insegnamento insegnamento : listaInsegnamenti) {
			if (insegnamento.getNome().equalsIgnoreCase(nome)) {
				return insegnamento;
			}
		}
		return null;
	}

	public boolean contieneInsegnamenti() {
		return !this.listaInsegnamenti.isEmpty();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("-----------------------\n");
		sb.append("   LISTA INSEGNAMENTI  \n");
		sb.append("-----------------------\n");
		if (contieneInsegnamenti()) {
			for (Insegnamento insegnamento : listaInsegnamenti) {
				sb.append(insegnamento).append("\n");
				sb.append("-----------------------\n");
			}
		}
		return sb.toString().trim();
	}
}