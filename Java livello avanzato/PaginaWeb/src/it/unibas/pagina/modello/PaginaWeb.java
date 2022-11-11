package it.unibas.pagina.modello;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class PaginaWeb implements Comparable<PaginaWeb> {

    private final String indirizzoUnivoco;
    private final String titolo;
    private final Calendar dataOraUltimoAggiornamento;
    private final int numeroParole;
    private final List<Annotazione> listaAnnotazioni = new ArrayList<>();

    public PaginaWeb(String indirizzoUnivoco, String titolo, Calendar dataOraUltimoAggiornamento, int numeroParole) {
        this.indirizzoUnivoco = indirizzoUnivoco;
        this.titolo = titolo;
        this.dataOraUltimoAggiornamento = dataOraUltimoAggiornamento;
        this.numeroParole = numeroParole;
    }

    public String getIndirizzoUnivoco() {
        return indirizzoUnivoco;
    }

    public String getTitolo() {
        return titolo;
    }

    public Calendar getDataOraUltimoAggiornamento() {
        return dataOraUltimoAggiornamento;
    }

    public int getNumeroParole() {
        return numeroParole;
    }

    public List<Annotazione> getListaAnnotazioni() {
        return listaAnnotazioni;
    }
    
    public void addAnnotazione(Annotazione annotazione) {
        this.listaAnnotazioni.add(annotazione);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Indirizzo: ").append(indirizzoUnivoco).append("\n");
        sb.append("Titolo: ").append(titolo).append("\n");
        sb.append("Data: ").append(FormattaData.formattaDataOra(dataOraUltimoAggiornamento.getTime())).append("\n");
        sb.append("Parole: ").append(numeroParole).append("\n");
        return sb.toString().trim();
    }

    //PUNTO4 - Utente verifica archivio    
    public int contaColoreRosso() {
        int conta = 0;
        for (Annotazione annotazione : this.listaAnnotazioni) {
            if (annotazione.getColore().equals(Costanti.COLORE_ROSSO)) {
                conta++;
            }
        }
        return conta;
    }

    private boolean isAnnotazioniNonAggiornate(Annotazione annotazione, Date dataAggiornamentoPaginaWeb) {
        return annotazione.getDataOraAnnotazione().getTime().before(dataAggiornamentoPaginaWeb);
    }

    public int contaAnnotazioniNonAggiornate(Date dataAggiornamentoPaginaWeb) {
        int conta = 0;
        for (Annotazione annotazione : this.listaAnnotazioni) {
            if (isAnnotazioniNonAggiornate(annotazione, dataAggiornamentoPaginaWeb)) {
                conta++;
            }
        }
        return conta;
    }

    @Override
    public int compareTo(PaginaWeb o) {
        return o.dataOraUltimoAggiornamento.compareTo(this.dataOraUltimoAggiornamento);
    }
}
