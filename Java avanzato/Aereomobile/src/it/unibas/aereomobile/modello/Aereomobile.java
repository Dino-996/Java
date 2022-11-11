package it.unibas.aereomobile.modello;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Aereomobile extends FormattaDataAstratta {

    private static final Logger logger = LoggerFactory.getLogger(Aereomobile.class);

    private final String codice;
    private final int numeroPasseggeri;
    private final String tipologia;
    private final Calendar dataUltimaManutenzione;
    private final List<Volo> listaVoli = new ArrayList<>();

    public Aereomobile(String codice, int numeroPasseggeri, String tipologia, Calendar dataUltimaManutenzione) {
        this.codice = codice;
        this.numeroPasseggeri = numeroPasseggeri;
        this.tipologia = tipologia;
        this.dataUltimaManutenzione = dataUltimaManutenzione;
    }

    public String getCodice() {
        return codice;
    }

    public int getNumeroPasseggeri() {
        return numeroPasseggeri;
    }

    public String getTipologia() {
        return tipologia;
    }

    public Calendar getDataUltimaManutenzione() {
        return dataUltimaManutenzione;
    }

    public List<Volo> getListaVoli() {
        return listaVoli;
    }

    public void addVolo(Volo volo) {
        this.listaVoli.add(volo);
    }

    /**
     * METODO PER FORMATTARE LE DATE - formattaData
     *
     * @return
     */
    private String formattaData() {
        return super.dataFormattata(this.dataUltimaManutenzione);
    }

    /**
     * PUNTO 4 - isStessaPartenza
     *
     * @param aereoportoDiPartenza
     * @return
     */
    private boolean isStessaPartenza(String aereoportoDiPartenza) {
        boolean verifica = true;
        for (Volo volo : this.listaVoli) {
            if (!volo.getAereoportoPartenza().equals(aereoportoDiPartenza)) {
                verifica = false;
            }
        }
        logger.debug("Punto 4 - Risultato della verifica: {}", verifica);
        return verifica;
    }

    /**
     * PUNTO 4 - contaOccorrenze
     *
     * @return conta
     */
    public int contaOccorrenze() {
        int conta = 0;
        for (Volo volo : this.listaVoli) {
            if (isStessaPartenza(volo.getAereoportoPartenza())) {
                conta++;
            }
        }
        return conta;
    }

    /**
     * PUNTO 4 - getMediaDurataVolo
     *
     * @return media / listaVoli.size()
     */
    public double getMediaDurataVolo() {
        double media = 0.0;
        for (Volo volo : listaVoli) {
            media += volo.getDurataVoloMinuti();
        }
        return media / listaVoli.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Codice: ").append(this.codice).append("\n");
        sb.append("Numero passeggeri: ").append(this.numeroPasseggeri).append("\n");
        sb.append("Tipologia: ").append(this.tipologia).append("\n");
        sb.append("Ultima manutenzione: ").append(formattaData()).append("\n");
        return sb.toString().trim();
    }
}
