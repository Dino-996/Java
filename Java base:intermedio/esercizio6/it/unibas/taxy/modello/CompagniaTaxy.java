package it.unibas.taxy.modello;
import java.util.*;

public class CompagniaTaxy {

	private String nome;
	private String numero;
	private List<Taxy> listaTaxy = new ArrayList<Taxy>();

	public CompagniaTaxy(String nome, String numero) {
		this.nome = nome;
		this.numero = numero;
	}

	public void addTaxy(Taxy taxy) {
		this.listaTaxy.add(taxy);
	}

	public boolean contieneTaxy() {
		return !this.listaTaxy.isEmpty();
	}

	public float getMedia() {
		float media = 0;
		for (Taxy taxy : listaTaxy) {
			media += taxy.getChilometraggio();
		}
		return media / listaTaxy.size();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("------------------------\n");
		sb.append("        COMPAGNIA       \n");
		sb.append("------------------------\n");
		sb.append("Nome compagnia: ").append(this.nome).append("\n");
		sb.append("Numero di telefono: ").append(this.numero).append("\n");
		sb.append("------------------------\n");
		sb.append("       LISTA TAXY       \n");
		sb.append("------------------------\n");
		if (contieneTaxy()) {
			for (Taxy taxy : listaTaxy) {
				sb.append(taxy).append("\n");
				sb.append("------------------------\n");
			}
		}
		return sb.toString().trim();
	}
}