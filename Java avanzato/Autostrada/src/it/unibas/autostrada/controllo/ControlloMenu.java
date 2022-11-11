package it.unibas.autostrada.controllo;

import it.unibas.autostrada.Applicazione;
import it.unibas.autostrada.modello.Archivio;
import it.unibas.autostrada.modello.Casello;
import it.unibas.autostrada.modello.Costanti;
import it.unibas.autostrada.persistenza.DAOException;
import it.unibas.autostrada.persistenza.IDAOArchivio;
import it.unibas.autostrada.vista.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;

public class ControlloMenu {

    private final Action azioneEsci = new AzioneEsci();
    private final Action azioneCarica = new AzioneCarica();
    private final Action azioneVerifica = new AzioneVerifica();
    private final Action azioneVerificaAccessi = new AzioneVerificaAccessi();

    public Action getAzioneEsci() {
        return this.azioneEsci;
    }

    public Action getAzioneCarica() {
        return this.azioneCarica;
    }

    public Action getAzioneVerifica() {
        return this.azioneVerifica;
    }

    public Action getAzioneVerificaAccessi() {
        return this.azioneVerificaAccessi;
    }

    private class AzioneVerificaAccessi extends AbstractAction {

        public AzioneVerificaAccessi() {
            this.putValue(Action.NAME, "Verifica accessi");
            this.putValue(Action.SHORT_DESCRIPTION, "Verifica se tutti i caselli successivi in quell'autostrada hanno almeno lo stesso numero di accessi di quello selezionato");
            this.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_S);
            this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt S"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Archivio archivio = (Archivio) Applicazione.getIstance().getModello().getBean(Costanti.ARCHIVIO);
            int rigaSelezionata = Applicazione.getIstance().getVistaPrincipale().getRigaSelezionata();
            if (rigaSelezionata == -1) {
                Applicazione.getIstance().getFrame().getErrore("Selezionare un casello prima di continuare");
                return;
            }
            List<Casello> listaFiltrata = (List<Casello>) Applicazione.getIstance().getModello().getBean(Costanti.LISTA_FILTRATA);
            Casello casello = listaFiltrata.get(rigaSelezionata);
            if (archivio.verificaAccessi(casello)) {
                Applicazione.getIstance().getFrame().getMessaggio("L'accesso piu' costoso e quello meno costoso sono stati effettuati con lo stesso tipo di pagamento");
            } else {
                Applicazione.getIstance().getFrame().getMessaggio("L'accesso piu' costoso e quello meno costoso NON sono stati effettuati con lo stesso tipo di pagamento");
            }
        }
    }

    private class AzioneVerifica extends AbstractAction {

        public AzioneVerifica() {
            this.putValue(Action.NAME, "Verifica caselli");
            this.putValue(Action.SHORT_DESCRIPTION, "Verifica se l'accesso piu' costoso e quello meno costoso sono stati effettuati con lo stesso tipo di pagamento");
            this.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_V);
            this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl V"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Archivio archivio = (Archivio) Applicazione.getIstance().getModello().getBean(Costanti.ARCHIVIO);
            int rigaSelezionata = Applicazione.getIstance().getVistaPrincipale().getRigaSelezionata();
            if (rigaSelezionata == -1) {
                Applicazione.getIstance().getFrame().getErrore("Selezionare un casello prima di continuare");
                return;
            }
            List<Casello> listaFiltrata = (List<Casello>) Applicazione.getIstance().getModello().getBean(Costanti.LISTA_FILTRATA);
            Casello casello = listaFiltrata.get(rigaSelezionata);
            if (archivio.verificaArchivio(casello) != null) {
                Applicazione.getIstance().getFrame().getMessaggio("I caselli successivi a quello selezionato hanno almeno lo stesso numero di accessi di quello selezionato");
            } else {
                Applicazione.getIstance().getFrame().getMessaggio("I caselli successivi a quello selezionato NON hanno almeno lo stesso numero di accessi di quello selezionato");

            }
        }

    }

    private class AzioneCarica extends AbstractAction {

        public AzioneCarica() {
            this.putValue(Action.NAME, "Carica");
            this.putValue(Action.SHORT_DESCRIPTION, "Carica archivio");
            this.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_A);
            this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt A"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Frame avviso = Applicazione.getIstance().getFrame();
            IDAOArchivio daoArchivio = Applicazione.getIstance().getDaoArchivio();
            try {
                Archivio archivio = daoArchivio.carica("");
                avviso.getMessaggio("Caricato correttamente l'archivio contenente " + archivio.getListaCaselli().size() + " Caselli");
                Applicazione.getIstance().getModello().putBean(Costanti.ARCHIVIO, archivio);
                Applicazione.getIstance().getControlloPrincipale().getAzioneCerca().setEnabled(true);
                Applicazione.getIstance().getControlloMenu().getAzioneVerifica().setEnabled(true);
            } catch (DAOException ex) {
                avviso.getErrore("Impossibile caricare l'archivio: " + ex.toString());
            }
        }
    }

    private class AzioneEsci extends AbstractAction {

        public AzioneEsci() {
            this.putValue(Action.NAME, "Esci");
            this.putValue(Action.SHORT_DESCRIPTION, "Esci dall'applicazione");
            this.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_E);
            this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt E"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}
