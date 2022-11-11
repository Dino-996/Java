package it.unibas.concorsi.modello;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Archivio {

    private static final Logger logger = LoggerFactory.getLogger(Archivio.class);

    private List<Concorso> listaConcorso = new ArrayList<>();

    public List<Concorso> getListaConcorso() {
        return listaConcorso;
    }

    public void setListaConcorso(List<Concorso> listaConcorso) {
        this.listaConcorso = listaConcorso;
    }

    public void addConcorso(Concorso concorso) {
        this.listaConcorso.add(concorso);
    }

    //PUNTO 2 - UTENTE CERCA CONCORSO PER REGIONE
    public List<Concorso> cercaConcorsoPerRegione(String regione, String criterio) {
        List<Concorso> listaFiltrata = new ArrayList<>();
        for (Concorso concorso : this.listaConcorso) {
            if (concorso.getRegione().equalsIgnoreCase(regione)) {
                listaFiltrata.add(concorso);
            }
        }
        if (criterio.equals(Costanti.CRITERIO_DATA_CRESCENTE)) {
            Collections.sort(listaFiltrata, new OperatoreDataCrescente());
        }
        if (criterio.equals(Costanti.CRITERIO_POSTI_DECRESCENTE)) {
            Collections.sort(listaFiltrata, new OperatoreNumeroPostiDecrescente());
        }
        logger.debug("PUNTO 2 - Elementi contenuti in lista filtrata: {}", listaFiltrata.size());
        return listaFiltrata;
    }

    //SCENARIO ALTERNATIVO 2 - PARTECIPAZIONE IMPOSSIBILE
    public boolean verificaDuplicati(Concorso concorsoSelezionato, Domanda domanda) {
        List<Concorso> listaRegioniNonUguali = verificaRegioniDiverse(concorsoSelezionato);
        int interoConcorsoSelezionato = concorsoSelezionato.getDataOraConcorso().get(Calendar.DAY_OF_MONTH);
        for (Concorso concorso : listaRegioniNonUguali) {
            int interoConcorso = concorso.getDataOraConcorso().get(Calendar.DAY_OF_MONTH);
            if (interoConcorsoSelezionato == interoConcorso) { 
                //LA VERIFICA DELLO STESSO GIORNO VA A BUON FINE MA NON ESSENDOCI DOMANDE DUPLICATE(SICCOME NELLA LISTA FILTRATA IO ACQUISISCO SOLO LE REGIONI DIVERSE) RITORNA SEMPRE FALSE
                if (concorso.contaOccorrenze(domanda) > 0) {
                    logger.debug("SCENARIO ALTERNATIVO 2 - Giorno del concorso selezionato: {} | Giorno del concorso: {}", interoConcorsoSelezionato, interoConcorso);
                    return true;
                }
            }
        }
        return false;
    }

    //METODO PER VERIFICARE REGIONI DIVERSE
    private List<Concorso> verificaRegioniDiverse(Concorso concorsoSelezionato) {
        List<Concorso> listaFiltrata = new ArrayList<>();
        for (Concorso concorso : this.listaConcorso) {
            if (!concorso.getRegione().equalsIgnoreCase(concorsoSelezionato.getRegione())) {
                listaFiltrata.add(concorso);
            }
        }
        logger.debug("SCENARIO ALTERNATIVO 2 - Elementi contenuti in listaFiltrata: {}", listaFiltrata.size());
        return listaFiltrata;
    }
}
