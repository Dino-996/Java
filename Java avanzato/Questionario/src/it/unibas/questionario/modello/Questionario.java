package it.unibas.questionario.modello;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Questionario implements Comparable<Questionario> {

    private static final Logger logger = LoggerFactory.getLogger(Questionario.class);

    private String codiceUnivoco;
    private String descrizione;
    private int difficolta;
    private String argomento;
    private List<Compilazione> listaCompilazioni = new ArrayList<>();

    public Questionario(String codiceUnivoco, String descrizione, int difficolta, String argomento) {
        this.codiceUnivoco = codiceUnivoco;
        this.descrizione = descrizione;
        this.difficolta = difficolta;
        this.argomento = argomento;
    }

    public String getCodiceUnivoco() {
        return codiceUnivoco;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public int getDifficolta() {
        return difficolta;
    }

    public String getArgomento() {
        return argomento;
    }

    public void setCodiceUnivoco(String codiceUnivoco) {
        this.codiceUnivoco = codiceUnivoco;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setDifficolta(int difficolta) {
        this.difficolta = difficolta;
    }

    public void setArgomento(String argomento) {
        this.argomento = argomento;
    }

    public List<Compilazione> getListaCompilazioni() {
        return listaCompilazioni;
    }

    public void setListaCompilazioni(List<Compilazione> listaCompilazioni) {
        this.listaCompilazioni = listaCompilazioni;
    }

    public void addCompilazione(Compilazione nuovaCompilazione) {
        listaCompilazioni.add(nuovaCompilazione);
    }

    public int getCompilazioniPositive() {
        int conta = 0;
        for (Compilazione compilazione : this.listaCompilazioni) {
            if (compilazione.isEsito()) {
                conta++;
            }
        }
        return conta;
    }

    //PUNTO 3 - UTENTE VERIFICA QUESTIONARIO
    public boolean isTempoCompilazioneCrescente(Questionario questionario) {
        for (int i = 0; i < questionario.getListaCompilazioni().size() - 1; i++) {
            Compilazione compilazione = questionario.getListaCompilazioni().get(i);
            Compilazione compilazioneSuccessiva = questionario.getListaCompilazioni().get(i + 1);
            logger.debug("PUNTO 3 - UTENTE VERIFICA QUESTIONARIO - Tempo compilazione: {} | Tempo compilazione successiva: {}", compilazione.getTempoCompilazione(), compilazioneSuccessiva.getTempoCompilazione());
            if (compilazione.getTempoCompilazione() > compilazioneSuccessiva.getTempoCompilazione()) {
                return false;
            }
        }
        return true;
    }

    public int contaOccorrenze(Questionario questionario) {
        int conta = 0;
        for (Compilazione compilazione : questionario.getListaCompilazioni()) {
            if (isTempoCompilazioneCrescente(questionario)) {
                conta++;
            }
        }
        logger.debug("PUNTO 3 - UTENTE VERIFICA QUESTIONARIO - Valori letti in ordine crescente: {}", conta);
        return conta;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Codice univoco: ").append(this.codiceUnivoco).append("\n");
        sb.append("Descrizione: ").append(this.descrizione).append("\n");
        sb.append("Difficolta': ").append(this.difficolta).append("\n");
        return sb.toString().trim();
    }

    @Override
    public int compareTo(Questionario o) {
        return this.difficolta - o.getDifficolta();
    }
}
