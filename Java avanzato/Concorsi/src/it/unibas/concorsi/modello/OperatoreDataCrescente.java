package it.unibas.concorsi.modello;

import java.util.Comparator;

public class OperatoreDataCrescente implements Comparator<Concorso> {

    @Override
    public int compare(Concorso o1, Concorso o2) {
        return o1.getDataOraConcorso().compareTo(o2.getDataOraConcorso());
    }
}
