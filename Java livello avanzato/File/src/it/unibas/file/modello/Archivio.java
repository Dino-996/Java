package it.unibas.file.modello;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Archivio {

    private final static Logger logger = LoggerFactory.getLogger(Archivio.class);

    private final List<Cartella> listaCartelle = new ArrayList<>();

    public List<Cartella> getListaCartelle() {
        return this.listaCartelle;
    }

    public void addCartella(Cartella cartella) {
        this.listaCartelle.add(cartella);
    }

    /**
     * PUNTO 2 - UTENTE CERCA CARTELLA
     * @param nome
     * @param numero
     * @return
     */
    public List<Cartella> cercaCartella(String nome, int numero) {
        List<Cartella> listaFiltrata = new ArrayList<>();
        for (Cartella cartella : listaCartelle) {
            if (cartella.getNomeCreatore().equalsIgnoreCase(nome)) {
                if (cartella.getListaFile().size() <= numero) {
                    listaFiltrata.add(cartella);
                }
            }
        }
        Collections.sort(listaFiltrata);
        return listaFiltrata;
    }

    /**
     * PUNTO 4 - UTENTE VERIFICA ARCHIVIO
     * @return
     */
    public boolean verificaArchivio() {
        List<Cartella> cartellaFiltrata = cartellaFiltrata();
        boolean verifica = false;
        if (contaOccorrenze(cartellaFiltrata) == listaCartelle.size()) {
            verifica = true;

        }
        logger.debug("ARCHIVIO - PUNTO 4 - Risultato della verifica in archivio: {}", verifica);
        return verifica;
    }

    private List<Cartella> cartellaFiltrata() {
        List<Cartella> cartellaFiltrata = new ArrayList<>();
        for (Cartella cartella : this.listaCartelle) {
            if (cartella.getListaFile().size() >= 3) {
                cartellaFiltrata.add(cartella);
            }
        }
        logger.debug("ARCHIVIO - PUNTO 4 - Cartelle filtrate: {}", cartellaFiltrata.size());
        return cartellaFiltrata;
    }

    private int contaOccorrenze(List<Cartella> listaFiltrata) {
        int conta = 0;
        for (Cartella cartella : listaFiltrata) {
            if (cartella.isDecrescente()) {
                conta++;
            }
        }
        logger.debug("ARCHIVIO - PUNTO 4 - Valore di conta: {}", conta);
        return conta;
    }
}
