package it.unibas.aereomobile.modello;

import java.util.Comparator;


public class OperatoreOrdinamentoTipologia implements Comparator<Aereomobile> {

    private final int scelta;
    
    public OperatoreOrdinamentoTipologia(int scelta) {
        this.scelta = scelta;
    }

    @Override
    public int compare(Aereomobile o1, Aereomobile o2) {
        //Ordinamento passeggeri crescente
        if (scelta == 0) {
           return o1.getNumPasseggeri() - o2.getNumPasseggeri();
        }
        //Ordinamento passeggeri decrescente
        if (scelta == 1) {
            return o2.getNumPasseggeri() - o1.getNumPasseggeri();
        }
        //Ordinamento tipologia crescente
        if (scelta == 2) {
            return o1.getTipologia().compareTo(o2.getTipologia());
        }
        return 0;
    }

}
