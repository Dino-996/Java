package it.unibas.fantacalcio.modello;
import java.util.*;

public class Fantacalcio {
	private List<Girone> listaGironi = new ArrayList<Girone>();

	public void addGirone(Girone girone) {
		this.listaGironi.add(girone);
	}

	public Girone leggiNumero(int numero) {
		for (Girone girone : listaGironi) {
			if (girone.getNumero() == numero) {
				return girone;
			}
		}
		return null;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("----------\n");
		sb.append("  GIRONE  \n");
		sb.append("----------\n");
		for (Girone girone : listaGironi) {
			sb.append(girone).append("\n");
			sb.append("------------\n");
		}
		return sb.toString().trim();
	}
}