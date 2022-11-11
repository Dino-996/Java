package it.unibas.autostrada.modello;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Archivio {

    private static final Logger logger = LoggerFactory.getLogger(Archivio.class);

    private List<Casello> listaCaselli = new ArrayList<>();

    public void addCasello(Casello casello) {
        this.listaCaselli.add(casello);
    }

    public List<Casello> getListaCaselli() {
        return listaCaselli;
    }

    public void setListaCaselli(List<Casello> listaCaselli) {
        this.listaCaselli = listaCaselli;
    }

    //Punto2
    public List<Casello> cercaPerNomeAutostrada(String nomeAutostrada) {
        List<Casello> listaFiltrata = new ArrayList<>();
        for (Casello casello : this.listaCaselli) {
            if (casello.getNomeAutostrada().equalsIgnoreCase(nomeAutostrada)) {
                listaFiltrata.add(casello);
            }
        }
        return listaFiltrata;
    }

    //Punto3
    public Casello verificaArchivio(Casello caselloSelezionato) {
        Casello altroCasello = null;
        for (Casello casello : this.listaCaselli) {
            if (casello.getPosizioneInKm() > caselloSelezionato.getPosizioneInKm()) {
                if (casello.getListaAccessi().size() >= caselloSelezionato.getListaAccessi().size()) {
                    logger.debug("Casello: {} | CaselloSelezionato: {}", casello, caselloSelezionato);
                    altroCasello = casello;
                }
            }
        }
        return altroCasello;
    }

    public boolean verificaAccessi(Casello caselloSelezionato) {
        for (Casello casello : this.listaCaselli) {
            if (casello.verificaCasello(caselloSelezionato)) {
                return true;
            }
        }
        return false;
    }
}
