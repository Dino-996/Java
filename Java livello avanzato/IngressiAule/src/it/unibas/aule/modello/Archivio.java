package it.unibas.aule.modello;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Archivio {

    private static final Logger logger = LoggerFactory.getLogger(Archivio.class);

    private List<Aula> listaAule = new ArrayList<>();

    public List<Aula> getListaAule() {
        return listaAule;
    }

    public void setListaAule(List<Aula> listaAule) {
        this.listaAule = listaAule;
    }

    public void addAula(Aula aula) {
        this.listaAule.add(aula);
    }

    /**
     * PUNTO 2 - UTENTE CERCA AULE PER PIANO
     *
     * @param piano
     * @return la listaFiltrata in base al piano selezionato in ordine crescente
     * di nome;
     */
    public List<Aula> cercaAulePerPiano(int piano) {
        List<Aula> listaFiltrata = new ArrayList<>();
        for (Aula aula : this.listaAule) {
            if (aula.getPiano() <= piano) {
                listaFiltrata.add(aula);
            }
        }
        Collections.sort(listaFiltrata);
        return listaFiltrata;
    }

    /**
     * PUNTO 4 - UTENTE VERIFICA ARCHIVIO
     *
     * @return false se non trova (in tutto l'archivio) accessi di domenica
     */
    public boolean verificaArchivio() {
        List<Accesso> tuttiAccessi = getListaTuttiAccessi();
        for (Accesso accesso : tuttiAccessi) {
            if (contaOccorrenze(accesso.getMatricola(), tuttiAccessi) > 1) {
                return true;
            }
        }
        return false;
    }
    /**
    * PUNTO 4 - METODO CHE AGGIUNGE AD UNA LISTA TUTTI GLI ACCESSI
    * 
    * @return 
    */
    private List<Accesso> getListaTuttiAccessi() {
        List<Accesso> listaFiltrata = new ArrayList<>();
        for (Aula aula : this.listaAule) {
            listaFiltrata.addAll(aula.getListaAccessi());
        }
        logger.debug("PUNTO 4 - UTENTE VERIFICA ARCHIVIO - Dimensione accessi: {} | Accessi {}", listaFiltrata.size(), listaFiltrata);
        return listaFiltrata;
    }
    /**
     * PUNTO 4 - METODO CHE VERIFICA IL NUMERO DI ACCESSI DUPLICATI IN BASE ALLA MATRICOLA E SE AVVENGONO DI DOMENICA
     * 
     * @param matricola
     * @param tuttiAccessi
     * @return 
     */
    public int contaOccorrenze(String matricola, List<Accesso> tuttiAccessi) {
        int conta = 0;
        for (Accesso accesso : tuttiAccessi) {
            int verificaAccesso = accesso.getDataOra().get(Calendar.DAY_OF_WEEK);
            logger.debug("PUNTO 4 - UTENTE VERIFICA ARCHIVIO - Verifica accessi: {}", verificaAccesso);
            if (accesso.getMatricola().equalsIgnoreCase(matricola) && verificaAccesso == Calendar.SUNDAY) {
                logger.debug("PUNTO 4 - UTENTE VERIFICA ARCHIVIO - Matricola: {} | altraMatricola: {}", accesso.getMatricola(), matricola);
                conta++;
            }
        }
        logger.debug("PUNTO 4 - UTENTE VERIFICA ARCHIVIO - Valore di conta: {}", conta);
        return conta;
    }
}
