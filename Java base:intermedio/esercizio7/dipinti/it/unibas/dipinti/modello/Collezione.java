package it.unibas.dipinti.modello;
import java.util.*;

public class Collezione {

	private List<Dipinti> listaDipinti = new ArrayList<Dipinti>();
	
	public void addDipinto(Dipinti dipinti) {
		this.listaDipinti.add(dipinti);
	} 

	public boolean contieneDipinti() {
		return !this.listaDipinti.isEmpty();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("---------------------\n");
		sb.append("    LISTA DIPINTI    \n");
		sb.append("---------------------\n");
		if (contieneDipinti()) {
			for (Dipinti dipinti : listaDipinti) {
			sb.append(dipinti).append("\n");
			sb.append("---------------------\n");
			}
		}
		return sb.toString().trim();
	}
}