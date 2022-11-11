package it.unibas.telefonia.modello;
import java.util.*;

public class Sim {

	private String numeroTelefono;
	private double credito;
	private int chiamateEffettuate;
	private List<Telefonata> listaTelefonate = new ArrayList<Telefonata>();

	public Sim(String numeroTelefono, double credito, int chiamateEffettuate) {
		this.numeroTelefono = numeroTelefono;
		this.credito = credito;
		this.chiamateEffettuate = chiamateEffettuate;
	}

	public void addTelefonata(Telefonata telefonata) {
		this.listaTelefonate.add(telefonata);
	}

	public boolean contieneTelefonate() {
		return !this.listaTelefonate.isEmpty();
	}

	public String getNumero() {
		return this.numeroTelefono;
	}

	public int getMinutiTotali() {
		int somma = 0;
		for (Telefonata telefonata : listaTelefonate) {
			somma += telefonata.convertiInMinuti();
		}
		return somma;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Numero di telefono: ").append(this.numeroTelefono).append("\n");
		sb.append("Credito residuo: ").append(this.credito).append("€").append("\n");
		sb.append("Chiamate effettuate: ").append(this.chiamateEffettuate).append("\n");
		if (contieneTelefonate()) {
			for (Telefonata telefonata : listaTelefonate) {
				sb.append("----------------------\n");
				sb.append("        CHIAMATE      \n");
				sb.append(telefonata).append("\n");
				sb.append("----------------------\n");
			}
		}
		return sb.toString().trim();
	}
}