package it.unibas.banca.modello;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Archivio {

    private static final Logger logger = LoggerFactory.getLogger(Archivio.class);

    private final List<Conto> listaConti = new ArrayList<>();

    public List<Conto> getListaConti() {
        return this.listaConti;
    }

    public void addConto(Conto conto) {
        this.listaConti.add(conto);
    }

    /**
     * PUNTO 2 - UTENTE CERCA CONTI CORRENTI Il sistema deve mostrare in una
     * tabella la lista dei conti correnti sottoscritti prima della data odierna
     *
     * @param criterio
     * @return
     */
    public List<Conto> cercaContiCorrenti(String criterio) {
        List<Conto> listaFiltrata = new ArrayList<>();
        Calendar dataOggi = new GregorianCalendar();
        for (Conto conto : this.listaConti) {
            if (conto.getDataApertura().getTime().before(dataOggi.getTime())) {
                listaFiltrata.add(conto);
            }
        }
        if (criterio.equals(Costanti.ORDINAMENTO_INTESTATARIO_CRESCENTE)) {
            Collections.sort(listaFiltrata, new CriterioOrdinamentoNomeCrescente());
        }
        if (criterio.equals(Costanti.ORDINAMENTO_DATA_CRESCENTE)) {
            Collections.sort(listaFiltrata, new CriterioOrdinamentoDataCrescente());
        }
        logger.debug("PUNTO 2 - UTENTE CERCA CONTI CORRENTI - Dimensione listaFiltrata: {}", listaFiltrata.size());
        return listaFiltrata;
    }

    /**
     * PUNTO 4 - UTENTE VERIFICA ARCHIVIO Il sistema deve mostrare se ci sono
     * conti correnti sottoscritti dallo stesso intestatario nella stessa data
     *
     * @return
     */
    public boolean verificaArchivio() {
        boolean valore = false;
        for (Conto conto : this.listaConti) {
            if (contaOccorrenze(conto.getDataApertura(), conto.getIntestatario()) > 1) {
                valore = true;
            }
        }
        logger.debug("PUNTO 4 - UTENTE VERIFICA ARCHIVIO - Valore restituito: {}", valore);
        return valore;
    }

    public int contaOccorrenze(Calendar aperturaConto, String intestatario) {
        int conta = 0;
        for (Conto conto : this.listaConti) {
            if (conto.getDataApertura().equals(aperturaConto) && conto.getIntestatario().equals(intestatario)) {
                conta++;
            }
        }
        logger.debug("PUNTO 4 - UTENTE VERIFICA ARCHIVIO - Conti duplicati: {}", conta);
        return conta;
    }
}
