package it.unibas.cesti.controllo;

import it.unibas.cesti.Applicazione;
import it.unibas.cesti.modello.Archivio;
import it.unibas.cesti.modello.Cesto;
import it.unibas.cesti.modello.Costanti;
import it.unibas.cesti.vista.VistaPrincipale;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;

public class ControlloPrincipale {

    private final Action azioneCerca = new AzioneCerca();
    private final Action azioneVisualizza = new AzioneVisulizza();

    public Action getAzioneCerca() {
        return azioneCerca;
    }

    public Action getAzioneVisualizza() {
        return azioneVisualizza;
    }

    private class AzioneCerca extends AbstractAction {

        public AzioneCerca() {
            this.putValue(Action.NAME, "Cerca cesti");
            this.putValue(Action.SHORT_DESCRIPTION, "Cerca cesti in archivio");
            this.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_C);
            this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt C"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Archivio archivio = (Archivio) Applicazione.getIstance().getModello().getBean(Costanti.ARCHIVIO);
            VistaPrincipale vista = Applicazione.getIstance().getVistaPrincipale();
            String tipologia = vista.getTipologia();
            if (tipologia.isEmpty()) {
                Applicazione.getIstance().getFrame().getErrore("Selezionare una tipologia");
                return;
            }
            String criterio = "";
            if (vista.isNomeCrescente()) {
                criterio = Costanti.CRITERIO_NOME_CRESCENTE;
            }
            if (vista.isPrezzoCrescente()) {
                criterio = Costanti.CRITERIO_PREZZO_CRESCENTE;
            }
            if (vista.isPrezzoDecrescente()) {
                criterio = Costanti.CRITERIO_PREZZO_DECRESCENTE;
            }
            List<Cesto> listaFiltrata = archivio.cercaCesto(tipologia, criterio);
            Applicazione.getIstance().getModello().putBean(Costanti.LISTA_FILTRATA, listaFiltrata);
            if (listaFiltrata.isEmpty()) {
                Applicazione.getIstance().getFrame().getErrore("Nessun risultato per la tipologia selezionata");
                return;
            }
            vista.inizializzaTabella();
        }

    }

    private class AzioneVisulizza extends AbstractAction {

        public AzioneVisulizza() {
            this.putValue(Action.NAME, "Visualizza prodotti");
            this.putValue(Action.SHORT_DESCRIPTION, "Visulizza prodotti nel cesto selezionato");
            this.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_V);
            this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt V"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vista = Applicazione.getIstance().getVistaPrincipale();
            int rigaSelezionata = vista.getRigaSelezionata();
            if (rigaSelezionata == -1) {
                Applicazione.getIstance().getFrame().getErrore("Selezionare un cesto dalla tabella");
                return;
            }
            List<Cesto> listaFiltrata = (List<Cesto>) Applicazione.getIstance().getModello().getBean(Costanti.LISTA_FILTRATA);
            Cesto cestoSelezionato = listaFiltrata.get(rigaSelezionata);
            Applicazione.getIstance().getModello().putBean(Costanti.CESTO_SELEZIONATO, cestoSelezionato);
            Applicazione.getIstance().getVistaProdotto().visualizza();
        }

    }
}
