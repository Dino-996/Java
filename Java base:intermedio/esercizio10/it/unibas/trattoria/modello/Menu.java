package it.unibas.trattoria.modello;
import java.util.*;

public class Menu {

	private List<Pientanza> listaPietanze = new ArrayList<Pientanza>();

	public void addPietanza(Pientanza pietanza) {
		this.listaPietanze.add(pietanza);
	}

	public Pientanza cercaPiuCostosa() {
		Pientanza migliore = null;
		for (Pientanza pietanza : listaPietanze) {
			if (migliore == null) {
				migliore = pietanza;
				continue;
			}
			if (migliore.getPrezzo() < pietanza.getPrezzo()) {
				migliore = pietanza;
			}
		}
		return migliore;
	}

	public boolean contenePietanze() {
		return !this.listaPietanze.isEmpty();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("---------------\n");
		sb.append("      MENU     \n");
		if (contenePietanze()) {
			for (Pientanza pietanza : listaPietanze) {
				sb.append(pietanza).append("\n");
				sb.append("---------------\n");
			}
		}
		return sb.toString().trim();
	}
}