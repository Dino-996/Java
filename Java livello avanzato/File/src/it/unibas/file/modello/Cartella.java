package it.unibas.file.modello;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Cartella implements Comparable<Cartella> {

    private final static Logger logger = LoggerFactory.getLogger(Cartella.class);

    private final String percorso;
    private final Calendar dataCreazione;
    private final String nomeCreatore;
    private final List<File> listaFile = new ArrayList<>();

    public Cartella(String percorso, Calendar dataCreazione, String nomeCreatore) {
        this.percorso = percorso;
        this.dataCreazione = dataCreazione;
        this.nomeCreatore = nomeCreatore;
    }

    public String getPercorso() {
        return percorso;
    }

    public Calendar getDataCreazione() {
        return dataCreazione;
    }

    public String getNomeCreatore() {
        return nomeCreatore;
    }

    public List<File> getListaFile() {
        return this.listaFile;
    }

    public void addFile(File file) {
        this.listaFile.add(file);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cartella{");
        sb.append("percorso=").append(percorso);
        sb.append(", dataCreazione=").append(dataCreazione);
        sb.append(", nomeCreatore=").append(nomeCreatore);
        sb.append('}');
        return sb.toString();
    }

    public int getDimensione() {
        int dimensione = 0;
        for (File file : this.listaFile) {
            dimensione += file.getDimensione();
        }
        return dimensione;
    }

    public boolean isDecrescente() {
        boolean verifica = true;
        for (int i = 0; i < this.listaFile.size() - 1; i++) {
            File file = this.listaFile.get(i);
            File altroFile = this.listaFile.get(i + 1);
            if (file.getDimensione() < altroFile.getDimensione()) {
                logger.debug("CARTELLA - PUNTO 4 - File: {} | AltroFile: {}", file.getDimensione(), altroFile.getDimensione());
                verifica = false;
            }
        }
        logger.debug("CARTELLA - PUNTO 4 - Risultato della verifica: {}", verifica);
        return verifica;
    }

    @Override
    public int compareTo(Cartella o) {
        return o.getDimensione() - this.getDimensione();
    }
}
