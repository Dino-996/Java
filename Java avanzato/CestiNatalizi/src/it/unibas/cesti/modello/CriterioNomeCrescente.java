package it.unibas.cesti.modello;

import java.util.Comparator;

public class CriterioNomeCrescente implements Comparator<Cesto> {

    @Override
    public int compare(Cesto o1, Cesto o2) {
        return o1.getNome().compareTo(o2.getNome());
    }

}
