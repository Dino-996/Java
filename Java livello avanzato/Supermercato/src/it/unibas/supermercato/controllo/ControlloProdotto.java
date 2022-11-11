package it.unibas.supermercato.controllo;

import it.unibas.supermercato.Applicazione;
import it.unibas.supermercato.modello.Carrello;
import it.unibas.supermercato.modello.Costanti;
import it.unibas.supermercato.modello.Prodotto;
import it.unibas.supermercato.modello.Supermercato;
import it.unibas.supermercato.vista.VistaProdotto;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import static javax.swing.Action.ACCELERATOR_KEY;
import static javax.swing.Action.MNEMONIC_KEY;
import static javax.swing.Action.NAME;
import static javax.swing.Action.SHORT_DESCRIPTION;
import javax.swing.KeyStroke;

public class ControlloProdotto {

    private final Action azioneAggiungi = new AzioneAggiungi();

    public Action getAzioneAggiungi() {
        return azioneAggiungi;
    }

    private class AzioneAggiungi extends AbstractAction {

        public AzioneAggiungi() {
            this.putValue(NAME, "Aggiungi al carrello");
            this.putValue(SHORT_DESCRIPTION, "Aggiungi il prodotto selezionato al carrello");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_A);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt A"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaProdotto vista = Applicazione.getIstance().getVistaProdotto();
            int prodottoSelezionato = vista.getProdottoSelezionato();
            if (prodottoSelezionato == -1) {
                Applicazione.getIstance().getFrame().getMessaggio("Selezionare un prodotto per aggiungerlo al carrello");
                return;
            }
            Supermercato supermercatoSelezionato = (Supermercato) Applicazione.getIstance().getModello().getBean(Costanti.SUPERMERCATO_SELEZIONATO);
            Prodotto prodotto = supermercatoSelezionato.getListaProdotti().get(prodottoSelezionato);
            Carrello carrello = (Carrello) Applicazione.getIstance().getModello().getBean(Costanti.CARRELLO);
            carrello.addProdotto(prodotto);
            vista.aggiornaTabellaCarrello();
        }
    }
}
