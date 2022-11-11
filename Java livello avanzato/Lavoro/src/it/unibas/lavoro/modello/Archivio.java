package it.unibas.lavoro.modello;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Archivio {

    private static final Logger logger = LoggerFactory.getLogger(Archivio.class);

    private List<Offerta> listaOfferte = new ArrayList<>();

    public void addOfferta(Offerta offerta) {
        this.listaOfferte.add(offerta);
    }

    public List<Offerta> getListaOfferte() {
        return listaOfferte;
    }

    public void setListaOfferte(List<Offerta> listaOfferte) {
        this.listaOfferte = listaOfferte;
    }

    //Punto 2 - UTENTE CERCA OFFERTA DI LAVORO
    public List<Offerta> cercaOffertaDiLavoro(String modalita, int retribuzioneAnnua) {
        List<Offerta> listaFiltrata = new ArrayList<>();
        for (Offerta offerta : this.listaOfferte) {
            if (offerta.getModalita().equals(modalita)) {
                if (offerta.getRetribuzioneAnnua() >= retribuzioneAnnua) {
                    listaFiltrata.add(offerta);
                }
            }
        }
        Collections.sort(listaFiltrata);
        logger.debug("PUNTO 2 - Dimensione lista filtrata: {}", listaFiltrata.size());
        return listaFiltrata;
    }

    //Punto 3 - UTENTE VERIFICA OFFERTA
    public boolean verificaCodiceFiscalePerOffertaSelezionata(Offerta offertaSelezionata) {
        for (Offerta offerta : this.listaOfferte) {
            if (offerta.contaOccorrenze(offertaSelezionata) > 1) {
                logger.debug("PUNTO 3 - Valore di conta occorrenze: {}", offerta.contaOccorrenze(offertaSelezionata));
                return true;
            }
        }
        return false;
    }

    //Punto 4 - UTENTE VERIFICA ARCHIVIO  
    public Offerta verificaMediaEtaAlta() {
        Offerta altraOfferta = null;
        for (Offerta offerta : this.listaOfferte) {

            if (altraOfferta == null) {
                altraOfferta = offerta;
            }

            if (offerta.getMediaEtaCandidati()> altraOfferta.getMediaEtaCandidati()) {
                altraOfferta = offerta;
            }
        }
        logger.debug("PUNTO 4 - Offerta con la media eta' piu alta: {} - Retribuzione: {} - Media eta': {}", altraOfferta.getDescrizione(), altraOfferta.getRetribuzioneAnnua(), altraOfferta.getMediaEtaCandidati());
        return altraOfferta;
    }

    public boolean verificaArchivio() {
        Offerta etaMediaPiuAlta = verificaMediaEtaAlta();
        if (etaMediaPiuAlta == null) {
            return false;
        }
        for (Offerta offerta : this.listaOfferte) {
            if (etaMediaPiuAlta.getRetribuzioneAnnua() < offerta.getRetribuzioneAnnua()) { //Se true si ferma subito quindi verifico la condizione in modo inverso!
                logger.debug("PUNTO 4 - Offerta media candidato alta: {} - Retribuzione ciclo: {}", etaMediaPiuAlta.getRetribuzioneAnnua(), offerta.getRetribuzioneAnnua());
                return false;
            }
        }
        return true;
    }
}
