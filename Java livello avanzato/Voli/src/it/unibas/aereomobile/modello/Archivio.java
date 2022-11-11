package it.unibas.aereomobile.modello;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Archivio {

    private static final Logger logger = LoggerFactory.getLogger(Archivio.class);

    private List<Aereomobile> listaAereomobili = new ArrayList<>();

    public List<Aereomobile> getListaAereomobili() {
        return listaAereomobili;
    }

    public void setListaAereomobili(List<Aereomobile> listaAereomobili) {
        this.listaAereomobili = listaAereomobili;
    }

    public void addAereomobile(Aereomobile aereomobile) {
        listaAereomobili.add(aereomobile);
    }

    //Punto 2 - Utente cerca aereomobili
    public List<Aereomobile> listaFiltrata(String criterio, int numeroPasseggeri) {
        List<Aereomobile> listaAereomobiliFiltrata = new ArrayList<>();
        for (Aereomobile aereomobile : this.listaAereomobili) {
            if (aereomobile.getNumPasseggeri() >= numeroPasseggeri) {
                listaAereomobiliFiltrata.add(aereomobile);
            }
        }
        if (criterio.equals(Costanti.ORDINA_PASSEGGERI_CRESCENTE)) {
            Collections.sort(listaAereomobiliFiltrata, new OperatoreOrdinamentoTipologia(0));
        }
        if (criterio.equals(Costanti.ORDINA_PASSEGGERI_DECRESCENTE)) {
            Collections.sort(listaAereomobiliFiltrata, new OperatoreOrdinamentoTipologia(1));
        }
        if (criterio.equals(Costanti.ORDINA_TIPOLOGIA_CRESCENTE)) {
            Collections.sort(listaAereomobiliFiltrata, new OperatoreOrdinamentoTipologia(2));
        }
        logger.debug("Aereomobili aggiunti nella lista filtrata: {}", listaAereomobiliFiltrata.size());
        return listaAereomobiliFiltrata;
    }

    //Verifico l'aereomobile con la media voli piu alta
    public double verificaArchivio() {
        double media = 0.0;
        for (Aereomobile aereomobile : listaAereomobili) {
            if (aereomobile.isStessoAereoporto()) {
                media = aereomobile.calcolaMedia();
            }
        }
        logger.debug("Aereomobile con media voli piu alta: {}", media);
        return media;
    }
}
