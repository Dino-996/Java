package it.unibas.anagrafica.modello;

import java.util.Comparator;

public class ComparatoreDenominazioneCrescente implements Comparator<Azienda>{

    @Override
    public int compare(Azienda o1, Azienda o2) {
        return o2.getDenominazione().compareTo(o1.getDenominazione());
    }
    
}
