package it.unibas.anagrafica.modello;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Archivio {

    private static final Logger logger = LoggerFactory.getLogger(Archivio.class);
    
    private List<Azienda> listaAziende = new ArrayList<>();

    public List<Azienda> getListaAziende() {
        return listaAziende;
    }

    public void setListaAziende(List<Azienda> listaAziende) {
        this.listaAziende = listaAziende;
    }

    public void addAzienda(Azienda azienda) {
        this.listaAziende.add(azienda);
    }
    /**
     * PUNTO 2 - UTENTE CERCA AZIENDA PER SEDE SOCIALE
     * @param sedeSociale
     * @return 
     */
    public List<Azienda> cercaAziendaPerSedeSociale(String sedeSociale) {
        List<Azienda> listaFiltrata = new ArrayList<>();
        for (Azienda azienda : this.listaAziende) {
            if (azienda.getSedeSociale().equalsIgnoreCase(sedeSociale)) {
                listaFiltrata.add(azienda);
            }
        }
        Collections.sort(listaFiltrata, new ComparatoreDenominazioneCrescente());
        logger.debug("PUNTO 2 - Elementi filtrati: {}", listaFiltrata.size() );
        return listaFiltrata;
    }

    /**
     * SCENARIO ALTERNATIVO - UTENTE VERIFICA DUPLICATI
     * @param dipendente
     * @return 
     */
    
    public boolean verificaDuplicati(Dipendente dipendente) {
        boolean verifica = false;
        for (Azienda azienda : this.listaAziende) {
            if (azienda.verificaCodiceFiscale(dipendente.getCodFiscale())) {
                verifica = true;
            }
        }
        logger.debug("SCENARIO ALTERNATIVO - Risultato della verifica: " + verifica);
        return verifica;
    }
    
    /**
     * PUNTO 4 - UTENTE VERIFICA ARCHIVIO
     * @return 
     */
    
    public boolean verificaArchivio() {
        List<Dipendente> listaDipendenti = tuttiDipendenti();
        for (Dipendente dipendente : listaDipendenti) {
            if (contaOccorrenze(dipendente.getCodFiscale(), listaDipendenti) > 1) {
                return true;
            }
        }
        return false;
    }

    public List<Dipendente> tuttiDipendenti() {
        List<Dipendente> listaFiltrata = new ArrayList<>();
        for (Azienda azienda : this.listaAziende) {
            listaFiltrata.addAll(azienda.getListaDipendenti());
        }
        logger.debug("PUNTO 4 - Elementi filtrati: {}", listaFiltrata);
        return listaFiltrata;
    }

    public int contaOccorrenze(String codiceFiscale, List<Dipendente> tuttiDipendenti) {
        int conta = 0;
        for (Dipendente dipendente : tuttiDipendenti) {
            if (dipendente.getCodFiscale().equalsIgnoreCase(codiceFiscale)) {
                conta++;
            }
        }
        logger.debug("PUNTO 4 - Occorrenze trovate: {}", conta);
        return conta;
    }
}
