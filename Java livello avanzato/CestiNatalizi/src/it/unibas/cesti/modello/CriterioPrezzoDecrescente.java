package it.unibas.cesti.modello;

import java.util.Comparator;

public class CriterioPrezzoDecrescente implements Comparator<Cesto> {

    @Override
    public int compare(Cesto o1, Cesto o2) {
        return o2.getPrezzo() - o1.getPrezzo();
    }

}
