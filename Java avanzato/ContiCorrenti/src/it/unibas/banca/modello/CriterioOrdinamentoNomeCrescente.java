package it.unibas.banca.modello;

import java.util.Comparator;

public class CriterioOrdinamentoNomeCrescente implements Comparator<Conto> {

    @Override
    public int compare(Conto o1, Conto o2) {
        return o1.getIntestatario().compareTo(o2.getIntestatario());
    }
    
}
