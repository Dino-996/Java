package it.unibas.conto.modello;
import java.util.*;

public class ContoCorrente {
	private int numConto;
	private double saldo;
	private List<Utente> listaUtenti = new ArrayList<Utente>();

	public ContoCorrente(int numConto, double saldo) {
		this.numConto = numConto;
		this.saldo = saldo;
	}

	public void addUtente(Utente utente) {
		this.listaUtenti.add(utente);
	}

	public int getNumConto() {
		return this.numConto;
	}
	public void setNumConto(int numConto) {
		this.numConto = 0;
	}

	public double getSaldo() {
		return this.saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = 0;
	}

	public void setSaldoVersamento(double saldo) {
		this.saldo += saldo;
	}

	public void setSaldoPrelevamento(double saldo) {
		this.saldo -= saldo;
	}

	public String toString() {
	StringBuilder sb = new StringBuilder();
	sb.append("Numero conto: ").append(this.numConto).append("\n");
	sb.append("Saldo: ").append(this.saldo).append("€").append("\n");
	sb.append("--------------------\n");
	sb.append("       UTENTE       \n");
	sb.append("--------------------\n");
	for (Utente utente : listaUtenti) {
		sb.append(utente).append("\n");
		sb.append("--------------------\n");
	}
	return sb.toString().trim();
	}
}