package it.unibas.supermercato.modello;

import java.util.Comparator;

public class OperatoreOrdinamento implements Comparator<Supermercato>{

    private final int numero;

    public OperatoreOrdinamento(int numero) {
        this.numero = numero;
    }

    @Override
    public int compare(Supermercato o1, Supermercato o2) {
        int ordinamento = 0;
        if (this.numero == 0) {
            ordinamento =  o1.getNome().compareTo(o2.getNome()); //NOME CRESCENTE
        }
        if (this.numero == 1) {
            ordinamento =  o2.getNome().compareTo(o1.getNome()); //NOME DECRESCENTE
        }
        if (this.numero == 2) {
            ordinamento =  o1.getListaProdotti().size() - o2.getListaProdotti().size(); //LISTA PRODOTTI CRESCENTE
        }
        if (this.numero == 3) {
            ordinamento =  o2.getListaProdotti().size() - o1.getListaProdotti().size(); //LISTA PRODOTTI DECRESCENTE
        }
        return ordinamento;
    }   
}
