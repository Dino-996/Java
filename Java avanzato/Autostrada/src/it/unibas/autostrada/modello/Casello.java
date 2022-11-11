package it.unibas.autostrada.modello;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Casello {

    private static final Logger logger = LoggerFactory.getLogger(Casello.class);

    private String codiceUnivoco;
    private String nomeAutostrada;
    private double posizioneInKm;
    private List<Accesso> listaAccessi = new ArrayList<>();

    public Casello(String codiceUnivoco, String nomeAutostrada, double posizioneInKm) {
        this.codiceUnivoco = codiceUnivoco;
        this.nomeAutostrada = nomeAutostrada;
        this.posizioneInKm = posizioneInKm;
    }

    public String getCodiceUnivoco() {
        return codiceUnivoco;
    }

    public void setCodiceUnivoco(String codiceUnivoco) {
        this.codiceUnivoco = codiceUnivoco;
    }

    public String getNomeAutostrada() {
        return nomeAutostrada;
    }

    public void setNomeAutostrada(String nomeAutostrada) {
        this.nomeAutostrada = nomeAutostrada;
    }

    public double getPosizioneInKm() {
        return posizioneInKm;
    }

    public void setPosizioneInKm(double posizioneInKm) {
        this.posizioneInKm = posizioneInKm;
    }

    public List<Accesso> getListaAccessi() {
        return listaAccessi;
    }

    public void setListaAccessi(List<Accesso> listaAccessi) {
        this.listaAccessi = listaAccessi;
    }

    public void addAccesso(Accesso accesso) {
        this.listaAccessi.add(accesso);
    }

    //*** INIZIO QUARTO PUNTO
    public Accesso getAccessoPiuCostoso() {
        Accesso accesso = null;
        for (Accesso altroAccesso : this.listaAccessi) {
            if (accesso == null) {
                accesso = altroAccesso;
                continue;
            }

            if (accesso.getCostoPedaggio() < altroAccesso.getCostoPedaggio()) {
                accesso = altroAccesso;
            }
        }
        logger.debug("Accesso piu' costoso: {}", accesso);
        return accesso;
    }

    public Accesso getAccessoMenoCostoso() {
        Accesso accesso = null;
        for (Accesso altroAccesso : this.listaAccessi) {

            if (accesso == null) {
                accesso = altroAccesso;
                continue;
            }

            if (accesso.getCostoPedaggio() > altroAccesso.getCostoPedaggio()) {
                accesso = altroAccesso;
            }
        }
        logger.debug("Accesso meno costoso: {}", accesso);
        return accesso;
    }

    public boolean verificaCasello(Casello casello) {
        return casello.getAccessoPiuCostoso().getTipoPagamento().equals(casello.getAccessoMenoCostoso().getTipoPagamento());
    }
    //*** FINE QUARTO PUNTO
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Casello{");
        sb.append("codiceUnivoco=").append(codiceUnivoco);
        sb.append(", nomeAutostrada=").append(nomeAutostrada);
        sb.append(", posizioneInKm=").append(posizioneInKm);
        sb.append('}');
        return sb.toString();
    }
}
