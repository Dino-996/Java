package it.unibas.pietanze.modello;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Archivio {

    private static final Logger logger = LoggerFactory.getLogger(Archivio.class);

    private List<Pietanza> listaPietanza = new ArrayList<>();

    public void addPietanza(Pietanza pietanza) {
        this.listaPietanza.add(pietanza);
    }

    public List<Pietanza> getListaPietanza() {
        return listaPietanza;
    }

    public void setListaPietanza(List<Pietanza> listaPietanza) {
        this.listaPietanza = listaPietanza;
    }

    //PUNTO 1 - UTENTE CERCA PIETANZA
    public List<Pietanza> cercaPerCategoria(String categoria) {
        List<Pietanza> listaFiltrata = new ArrayList<>();
        for (Pietanza pietanza : this.listaPietanza) {
            if (pietanza.getCategoria().equals(categoria)) {
                listaFiltrata.add(pietanza);
            }
        }
        return listaFiltrata;
    }

    //PUNTO 2 - UTENTE CERCA PIETANZA CALORICAMENTE SIMILE (Da aggiustare)
    public Pietanza cercaPietanzaCaloricamenteSimile(Pietanza pietanza) {
        Pietanza pietanzaSimile = null;
        for (Pietanza altraPietanza : this.listaPietanza) {
            if (!altraPietanza.getNome().equals(pietanza.getNome())) {
                if (pietanzaSimile == null || 
                        (Math.abs(altraPietanza.getKcal() - pietanza.getKcal())) < Math.abs(pietanzaSimile.getKcal() - pietanza.getKcal())) {
                    pietanzaSimile = altraPietanza;
                }
            }
        }
        return pietanzaSimile;
    }
}
