package it.unibas.aule.modello;

import java.util.Comparator;

public class ComparatoreNomeCrescente implements Comparator<Aula>{

    @Override
    public int compare(Aula o1, Aula o2) {
        return o1.getNome().compareTo(o2.getNome());
    }   
}
