package it.unibas.supermercato.modello;

import java.util.ArrayList;
import java.util.List;

public class Carrello {

    private final List<Prodotto> listaProdotto = new ArrayList<>();

    public List<Prodotto> getListaProdotto() {
        return listaProdotto;
    }

    public void addProdotto(Prodotto prodotto) {
        this.listaProdotto.add(prodotto);
    }

    public double getSommaProdotti(List<Prodotto> listaProdotti) {
        double somma = 0;
        for (Prodotto prodotto : listaProdotti) {
            somma += prodotto.getPrezzo();
        }
        return somma;
    }
    
    public List<Prodotto> aggiornaCarrello(Prodotto prodottoSelezionato) {
        List<Prodotto> listaFiltrata = new ArrayList<>();
        for (Prodotto prodotto : this.listaProdotto) {
            if (prodotto.getIdProdotto() == prodottoSelezionato.getIdProdotto()) {
                listaFiltrata.add(prodotto);
            }
        }
        return listaFiltrata;
    }
}
