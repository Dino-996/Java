package it.unibas.questionario.modello;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Archivio {

    private final static Logger logger = LoggerFactory.getLogger(Archivio.class);

    private List<Questionario> listaQuestionari = new ArrayList<>();

    public List<Questionario> getListaQuestionari() {
        return listaQuestionari;
    }

    public void setListaQuestionari(List<Questionario> listaQuestionari) {
        this.listaQuestionari = listaQuestionari;
    }

    public void addQuestionario(Questionario nuovoQuestionario) {
        this.listaQuestionari.add(nuovoQuestionario);
    }

    //PUNTO 2 - UTENTE CERCA QUESTIONARIO
    public List<Questionario> cercaQuestionario(String categoria, int difficolta) {
        List<Questionario> listaFiltrata = new ArrayList<>();
        for (Questionario questionario : this.listaQuestionari) {
            if (questionario.getArgomento().equals(categoria)) {
                if (questionario.getDifficolta() <= difficolta) {
                    listaFiltrata.add(questionario);
                }
            }
        }
        Collections.sort(listaFiltrata);
        logger.debug("PUNTO 2 - UTENTE CERCA QUESTIONARIO\n- Elementi contenuti in lista filtrata: " + listaFiltrata.size());
        return listaFiltrata;
    }

    //PUNTO 4 - UTENTE VERIFICA ARCHIVIO
    private List<Compilazione> getListaTutteCompilazioni() {
        List<Compilazione> listaFiltrata = new ArrayList<>();
        for (Questionario questionario : this.listaQuestionari) {
            listaFiltrata.addAll(questionario.getListaCompilazioni());
        }
        return listaFiltrata;
    }
    
    private int contaOccorrenze(int codiceNumerico, List<Compilazione> listaCompilazioni) {
        int conta = 0;
        for (Compilazione compilazione : listaCompilazioni) {
            if (compilazione.getCodiceNumerico() == codiceNumerico) {
                conta++;
            }
        }
        return conta;
    }

    public boolean verificaArchivio() {
        List<Compilazione> tutteCompilazioni = getListaTutteCompilazioni();
        for (Compilazione compilazione : tutteCompilazioni) {
            if (contaOccorrenze(compilazione.getCodiceNumerico(), tutteCompilazioni) > 1) {
                return true;
            }
        }
        return false;
    }
}
