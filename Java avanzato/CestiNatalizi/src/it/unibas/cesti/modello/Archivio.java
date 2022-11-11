package it.unibas.cesti.modello;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Archivio {

    private static final Logger logger = LoggerFactory.getLogger(Archivio.class);

    private final List<Cesto> listaCesti = new ArrayList<>();

    public List<Cesto> getListaCesti() {
        return listaCesti;
    }

    public void addCesto(Cesto cesto) {
        this.listaCesti.add(cesto);
    }

    /**
     * PUNTO 2 - UTENTE CERCA CESTO NATALIZIO
     *
     * @param tipologia
     * @param criterio
     * @return
     */
    public List<Cesto> cercaCesto(String tipologia, String criterio) {
        List<Cesto> listaFiltrata = new ArrayList<>();
        for (Cesto cesto : this.listaCesti) {
            if (cesto.getTipologia().equals(tipologia)) {
                listaFiltrata.add(cesto);
            }
        }
        if (criterio.equals(Costanti.CRITERIO_PREZZO_CRESCENTE)) {
            Collections.sort(listaFiltrata, new CriterioPrezzoCrescente());
        }
        if (criterio.equals(Costanti.CRITERIO_PREZZO_DECRESCENTE)) {
            Collections.sort(listaFiltrata, new CriterioPrezzoDecrescente());
        }
        if (criterio.equals(Costanti.CRITERIO_NOME_CRESCENTE)) {
            Collections.sort(listaFiltrata, new CriterioNomeCrescente());
        }
        return listaFiltrata;
    }

    /**
     * PUNTO 4 - UTENTE VERIFICA ARCHIVIO
     *
     * @return
     */
    public int verificaArchivio() {
        int conta = 0;
        for (Cesto cesto : this.listaCesti) {
            if (cesto.contaOccorrenze() > 1) {
                conta++;
            }
        }
        logger.debug("verificaArchivio(): {}", conta);
        return conta;
    }
}
