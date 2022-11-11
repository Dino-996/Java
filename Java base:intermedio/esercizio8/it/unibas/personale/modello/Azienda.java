package it.unibas.personale.modello;
import java.util.*;

public class Azienda {
	private String nome;
	private List<Dipendente> listaDipendenti = new ArrayList<Dipendente>();

	public Azienda(String nome) {
		this.nome = nome;
	}

	public void addDipendente(Dipendente dipendente) {
		this.listaDipendenti.add(dipendente);
	}

	public boolean contieneDipendenti() {
		return !this.listaDipendenti.isEmpty();
	}

	public Dipendente cercaPerNome(String nome) {
		for (Dipendente dipendente : listaDipendenti) {
			if (dipendente.getNome().equalsIgnoreCase(nome)) {
				return dipendente;
			}
		}
		return null;
	}

	public List<Dipendente> cercaPerTipologia(String tipologia) {
		List<Dipendente> listaNuova = new ArrayList<Dipendente>();
		for (Dipendente dipendente : listaDipendenti) {
			if (dipendente.getUfficio().equals(tipologia)) {
				listaNuova.add(dipendente);
			}
		}
		return listaNuova;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nome azienda: ").append(this.nome).append("\n");
		if (contieneDipendenti()) {
			sb.append("********************************\n");
			sb.append("        LISTA DIPENDENTI        \n");
			sb.append("********************************\n");
			for (Dipendente dipendente : listaDipendenti) {
				sb.append(dipendente).append("\n");
				sb.append("********************************\n");
			}
		}
		return sb.toString().trim();
	}
}