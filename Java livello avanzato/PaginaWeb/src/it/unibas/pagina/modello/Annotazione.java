package it.unibas.pagina.modello;

import java.util.Calendar;

public class Annotazione {

    private final int indiceParolaIniziale;
    private final int indiceParolaFinale;
    private final String colore;
    private final Calendar DataOraAnnotazione;

    public Annotazione(int indiceParolaIniziale, int indiceParolaFinale, String colore, Calendar DataOraAnnotazione) {
        this.indiceParolaIniziale = indiceParolaIniziale;
        this.indiceParolaFinale = indiceParolaFinale;
        this.colore = colore;
        this.DataOraAnnotazione = DataOraAnnotazione;
    }

    public int getIndiceParolaIniziale() {
        return indiceParolaIniziale;
    }

    public int getIndiceParolaFinale() {
        return indiceParolaFinale;
    }

    public String getColore() {
        return colore;
    }

    public Calendar getDataOraAnnotazione() {
        return DataOraAnnotazione;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Inizio: ").append(indiceParolaIniziale).append("\n");
        sb.append("Fine: ").append(indiceParolaFinale).append("\n");
        sb.append("Colore utilizzato: ").append(colore).append("\n");
        sb.append("Data annotazione: ").append(FormattaData.formattaDataOra(DataOraAnnotazione.getTime())).append("\n");
        return sb.toString().trim();
    }
}
