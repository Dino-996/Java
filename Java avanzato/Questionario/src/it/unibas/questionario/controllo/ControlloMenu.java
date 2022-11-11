package it.unibas.questionario.controllo;

import it.unibas.questionario.Applicazione;
import it.unibas.questionario.modello.Archivio;
import it.unibas.questionario.modello.Costanti;
import it.unibas.questionario.persistenza.DAOException;
import it.unibas.questionario.persistenza.IDAOArchivio;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;

public class ControlloMenu {

    private final Action azioneCarica = new AzioneCarica();
    private final Action azioneEsci = new AzioneEsci();
    private final Action azioneVerifica = new AzioneVerifica();

    public Action getAzioneCarica() {
        return this.azioneCarica;
    }

    public Action getAzioneEsci() {
        return this.azioneEsci;
    }

    public Action getAzioneVerifica() {
        return this.azioneVerifica;
    }

    private class AzioneVerifica extends AbstractAction {

        public AzioneVerifica() {
            putValue(NAME, "Verifica archivio");
            putValue(SHORT_DESCRIPTION, "Verifica il numero di risposte duplicate in base al codice numerico in tutto l'archivio");
            putValue(MNEMONIC_KEY, KeyEvent.VK_V);
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt V"));
            setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Archivio archivio = (Archivio) Applicazione.getIstance().getModello().getBeans(Costanti.ARCHIVIO);
            if (archivio.verificaArchivio()) {
                Applicazione.getIstance().getFrame().getMessaggio("Esistono compilazioni duplicate");
            } else {
                Applicazione.getIstance().getFrame().getMessaggio("Non esistono compilazioni duplicate");
            }
        }
    }

    private class AzioneEsci extends AbstractAction {

        public AzioneEsci() {
            putValue(NAME, "Esci");
            putValue(SHORT_DESCRIPTION, "Esci dall'applicazione");
            putValue(MNEMONIC_KEY, KeyEvent.VK_E);
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt E"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    private class AzioneCarica extends AbstractAction {

        public AzioneCarica() {
            putValue(NAME, "Carica archivio");
            putValue(SHORT_DESCRIPTION, "Carica archivio questionari");
            putValue(MNEMONIC_KEY, KeyEvent.VK_A);
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt A"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            IDAOArchivio daoArchivio = Applicazione.getIstance().getDaoArchivio();
            try {
                Archivio archivio = daoArchivio.carica("");
                Applicazione.getIstance().getModello().putBeans(Costanti.ARCHIVIO, archivio);
                Applicazione.getIstance().getFrame().getMessaggio("Caricato archivio contenente " + archivio.getListaQuestionari().size() + " questionario");
                Applicazione.getIstance().getControlloPrincipale().getAzioneCerca().setEnabled(true);
                Applicazione.getIstance().getControlloPrincipale().getAzioneVerifica().setEnabled(true);
                azioneVerifica.setEnabled(true);
            } catch (DAOException ex) {
                Applicazione.getIstance().getFrame().getErrore("Archivio non caricato: " + ex.getMessage());
            }
        }

    }
}
