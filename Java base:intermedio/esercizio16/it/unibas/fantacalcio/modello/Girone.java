package it.unibas.fantacalcio.modello;
import java.util.*;

public class Girone {
    private int numero; 
    private String stagione;
    private String data;
    private List<Giocatore> listaGiocatori = new ArrayList<Giocatore>();

 public Girone(int numero, String stagione, String data) {
 	this.numero = numero;
 	this.stagione = stagione;
 	this.data = data;
 }

 public void addGiocatore(Giocatore giocatore) {
 	this.listaGiocatori.add(giocatore);
 }

 public int getNumero() {
    return this.numero;
 }

 public Giocatore mediaVotiGiocatori(String ruolo) {
        for (Giocatore giocatore : listaGiocatori) {
         if (giocatore.getRuolo().equals(ruolo)) {
             return giocatore;
            }
        }
        return null;
    }


 public Giocatore leggiGiocatoreMigliore(String ruolo) {
        List<Giocatore> listaRuolo = filtraPerRuolo(ruolo);
        if (listaRuolo.isEmpty()) {
            return null;
        }
        Giocatore votoMax = null;
        for (Giocatore giocatore : listaRuolo) {
            if (votoMax == null) {
                votoMax = giocatore;
                continue;
            }
            if (votoMax.getVoto() < giocatore.getVoto()) {
                votoMax = giocatore;
            }
        }
        return votoMax;
    }

 public float getMedia() {
    float media = 0;
    for (Giocatore giocatore : listaGiocatori) {
        media += giocatore.getVoto();
    }
    return media / listaGiocatori.size();
 }

 public List<Giocatore> filtraPerRuolo(String ruolo) {
    List<Giocatore> cercaRuolo = new ArrayList<Giocatore>();
    for (Giocatore giocatore : listaGiocatori) {
        if (giocatore.getRuolo().equals(ruolo)) {
            cercaRuolo.add(giocatore);
        }
    }
    return cercaRuolo;
 }

 public String toString() {
 	StringBuilder sb = new StringBuilder();
 	sb.append("Numero: ").append(this.numero).append("\n");
 	sb.append("Stagione: ").append(this.stagione).append("\n");
 	sb.append("Data: ").append(this.data).append("\n");
    sb.append("------------\n");
    sb.append("  GIOCATORI \n");
    sb.append("------------\n");
 	for (Giocatore giocatore : listaGiocatori) {
 		sb.append(giocatore).append("\n");
        sb.append("------------\n");
 	}
 	return sb.toString().trim();
 }
}