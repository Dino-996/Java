package it.unibas.cesti.modello;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Cesto {

    private static final Logger logger = LoggerFactory.getLogger(Cesto.class);

    private final String nome;
    private final int prezzo;
    private final String tipologia;
    private final List<Prodotto> listaProdotti = new ArrayList<>();

    public Cesto(String nome, int prezzo, String tipologia) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.tipologia = tipologia;
    }

    public String getNome() {
        return nome;
    }

    public int getPrezzo() {
        return prezzo;
    }

    public String getTipologia() {
        return tipologia;
    }

    public List<Prodotto> getListaProdotti() {
        return listaProdotti;
    }

    public void addProdotto(Prodotto prodotto) {
        this.listaProdotti.add(prodotto);
    }

    /**
     * PUNTO 4 - UTENTE VERIFICA ARCHIVIO
     *
     * @param nome
     * @param tipologia
     * @return
     */
    public boolean isDuplicato(String nome, String tipologia) {
        for (Prodotto prodotto : listaProdotti) {
            if (prodotto.getNome().equals(nome) && prodotto.getTipologia().equals(tipologia)) {
                logger.debug("PUNTO 4 - Prodotto: {} - Nome: {} - Tipologia: {}", prodotto, nome, tipologia);
                logger.debug("---------------------------------------------------------------------------------------------------");
                return true;
            }
        }
        return false;
    }

    public int contaOccorrenze() {
        int conta = 0;
        for (Prodotto prodotto : listaProdotti) {
            if (isDuplicato(prodotto.getNome(), prodotto.getTipologia())) {
                conta++;
            }
        }
        logger.debug("PUNTO 4 - contaOccorrenze(): {}", conta);
        return conta;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cesto{");
        sb.append("nome=").append(nome);
        sb.append(", prezzo=").append(prezzo);
        sb.append(", tipologia=").append(tipologia);
        sb.append('}');
        return sb.toString();
    }
}
