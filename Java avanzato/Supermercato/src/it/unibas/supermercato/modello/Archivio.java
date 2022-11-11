package it.unibas.supermercato.modello;

import org.slf4j.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.slf4j.LoggerFactory;

public class Archivio {

    private static final Logger logger = LoggerFactory.getLogger(Archivio.class);

    private final List<Supermercato> listaSupermercati = new ArrayList<>();

    public List<Supermercato> getListaSupermercati() {
        return listaSupermercati;
    }

    public void addSupermercato(Supermercato supermercato) {
        this.listaSupermercati.add(supermercato);
    }

    /**
     * PUNTO 2 - Utente cerca supermercati
     *
     * @param indirizzo
     * @param citta
     * @param civico
     * @param criterio
     * @return
     */
    public List<Supermercato> cercaSupermercati(String indirizzo, String citta, int civico, String criterio) {
        List<Supermercato> listaFiltrata = new ArrayList<>();
        for (Supermercato supermercato : this.listaSupermercati) {
            if (supermercato.getVia().toUpperCase().contains(indirizzo) && supermercato.getCitta().equals(citta) && supermercato.getCivico() == civico) {
                listaFiltrata.add(supermercato);
            }
            if (criterio.equals(Costanti.CRITERIO_NOME_CRESCENTE)) {
                Collections.sort(listaFiltrata, new OperatoreOrdinamento(0));
            }
            if (criterio.equals(Costanti.CRITERIO_NOME_DECRESCENTE)) {
                Collections.sort(listaFiltrata, new OperatoreOrdinamento(1));
            }
            if (criterio.equals(Costanti.CRITERIO_PRODOTTI_CRESCENTE)) {
                Collections.sort(listaFiltrata, new OperatoreOrdinamento(2));
            }
            if (criterio.equals(Costanti.CRITERIO_PRODOTTI_DECRESCENTE)) {
                Collections.sort(listaFiltrata, new OperatoreOrdinamento(3));
            }
        }
        return listaFiltrata;
    }

    /**
     * PUNTO 4 - Utente verifica supermercati duplicati
     */
    public boolean verificaSupermercatiDuplicati() {
        boolean verifica = false;
        if (contaDuplicati() > 1) {
            verifica = true;
        }
        return verifica;
    }

    private boolean isDuplicati(String nome) {
        boolean verifica = false;
        for (Supermercato supermercato : this.listaSupermercati) {
            if (supermercato.getNome().equals(nome)) {
                verifica = true;
            }
        }
        return verifica;
    }

    private int contaDuplicati() {
        int conta = 0;
        for (Supermercato supermercato : this.listaSupermercati) {
            if (isDuplicati(supermercato.getNome())) {
                conta++;
            }
        }
        return conta;
    }

    /**
     * Utente verifica supermercato con media prezzi migliore (piu' conveniente)
     */
    public Supermercato supermercatoMigliore() {
        Supermercato altroSupermercato = null;
        for (Supermercato supermercato : this.listaSupermercati) {
            if (altroSupermercato == null || supermercato.getMediaPrezzi() > altroSupermercato.getMediaPrezzi()) {
                altroSupermercato = supermercato;
            }
        }
        return altroSupermercato;
    }

    /**
     * Punto 4 - Utente verifica prodotti duplicati
     *
     * @return
     */
    public boolean verificaProdottiDuplicati() {
        boolean verifica = false;
        for (Supermercato supermercato : this.listaSupermercati) {
            if (supermercato.contaDuplicati() > 1) {
                verifica = true;
            }
        }
        return verifica;
    }
}
