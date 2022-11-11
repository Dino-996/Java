package it.unibas.aereomobile.modello;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Archivio {

    private static final Logger logger = LoggerFactory.getLogger(Archivio.class);

    private final List<Aereomobile> listaAereomobili = new ArrayList<>();

    public List<Aereomobile> getListaAereomobili() {
        return listaAereomobili;
    }

    public void addAereomobile(Aereomobile aereomobile) {
        this.listaAereomobili.add(aereomobile);
    }

    /**
     * *************************************************************************
     * PUNTO 2 - UTENTE CERCA AEREOMOBIL. 
     * Descrizione: L'utente sceglie un
     * numero minimo di passeggeri e un criterio di ordinamento, il criterio
     * puo' essere "passeggeri cerscente", "passeggeri decrecente" o "tipologia
     * crescente"
     *
     * @param numeroMinimoPasseggeri
     * @param criterioOrdinamento
     * @return
     */
    public List<Aereomobile> cercaAereomobile(int numeroMinimoPasseggeri, String criterioOrdinamento) {
        List<Aereomobile> listaFiltrata = new ArrayList<>();
        for (Aereomobile aereomobile : this.listaAereomobili) {
            if (aereomobile.getNumeroPasseggeri() >= numeroMinimoPasseggeri) {
                listaFiltrata.add(aereomobile);
            }
        }
        Collections.sort(listaFiltrata, new OperatoreCriterioOrdinamento(criterioOrdinamento));
        logger.debug("Punto 2 - Utente cerca aereomobile - Numero passeggeri immesso: {} - Criterio scelto: {} - Elementi in lista filtrata: {}", numeroMinimoPasseggeri, criterioOrdinamento, listaFiltrata.size());
        return listaFiltrata;
    }

    /**
     * *************************************************************************
     * PUNTO 4 - UTENTE VERIFICA ARCHIVIO.
     * Descrizione: L'utente chiede al
     * sistema tramite una voce del menu' di cercare tutti gli aeeomobili che
     * hanno la media della durata dei viaggi piu' alta
     *
     * @return
     */
    public Aereomobile verificaArchivio() {
        Aereomobile aereomobileMediaDurataAlta = null;
        List<Aereomobile> aereomobiliCercati = listaAereomobiliConAlmenoDueViaggi();
        for (Aereomobile aereomobile : aereomobiliCercati) {
            if (aereomobileMediaDurataAlta == null || aereomobile.getMediaDurataVolo() > aereomobileMediaDurataAlta.getMediaDurataVolo()) {
                aereomobileMediaDurataAlta = aereomobile;
            }
        }
        logger.debug("Punto 4 - Aereomobile con la media durata piu' alta: {}", aereomobileMediaDurataAlta);
        return aereomobileMediaDurataAlta;
    }

    private List<Aereomobile> listaAereomobiliConAlmenoDueViaggi() {
        List<Aereomobile> listaFiltrata = new ArrayList<>();
        for (Aereomobile aereomobile : this.listaAereomobili) {
            if (aereomobile.getListaVoli().size() >= 2 && aereomobile.contaOccorrenze() > 1) {
                listaFiltrata.add(aereomobile);
            }
        }
        logger.debug("Punto 4 - Elementi in lista filtrata: {}", listaFiltrata.size());
        return listaFiltrata;
    }
}
