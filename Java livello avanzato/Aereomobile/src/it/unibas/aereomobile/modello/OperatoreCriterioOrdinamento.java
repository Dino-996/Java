package it.unibas.aereomobile.modello;

import java.util.Comparator;

public class OperatoreCriterioOrdinamento implements Comparator<Aereomobile> {

    private final String criterio;

    public OperatoreCriterioOrdinamento(String  criterio) {
        this.criterio = criterio;
    }
    
    @Override
    public int compare(Aereomobile o1, Aereomobile o2) {
        int ordinamento = 0;
        if (criterio.equals(Costanti.ORDINAMENTO_PASSEGGERI_CERSCENTE)) {
            ordinamento = o1.getNumeroPasseggeri() - o2.getNumeroPasseggeri();
        }
        if (criterio.equals(Costanti.ORDINAMENTO_PASSEGGERI_DECRESCENTE)) {
            ordinamento = o2.getNumeroPasseggeri() - o1.getNumeroPasseggeri();
        }
        if (criterio.equals(Costanti.ORDINAMENTO_TIPOLOGIA_CERSCENTE)) {
            ordinamento = o1.getTipologia().compareTo(o2.getTipologia());
        }
        return ordinamento;
    }
}
