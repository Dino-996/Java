package it.unibas.banca.modello;

import java.util.Comparator;

public class CriterioOrdinamentoDataCrescente implements Comparator<Conto> {

    @Override
    public int compare(Conto o1, Conto o2) {
        return o1.getDataApertura().compareTo(o2.getDataApertura());
    }
    
}
