package it.unibas.file.controllo;

import it.unibas.file.Applicazione;
import it.unibas.file.modello.Archivio;
import it.unibas.file.modello.Costanti;
import it.unibas.file.persistenza.DAOException;
import it.unibas.file.persistenza.IDAOArchivio;
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
        return azioneCarica;
    }

    public Action getAzioneEsci() {
        return azioneEsci;
    }

    public Action getAzioneVerifica() {
        return azioneVerifica;
    }

    private class AzioneVerifica extends AbstractAction {

        public AzioneVerifica() {
            this.putValue(NAME, "Verifica archivio");
            this.putValue(SHORT_DESCRIPTION, "Verifica se nell'archivio tutte le cartelle con almeno tre file hanno i file inseriti in maniere decrescente di dimensione");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_V);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt V"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Archivio archivio = (Archivio) Applicazione.getIstance().getModello().getBean(Costanti.ARCHIVIO);
            if (archivio.verificaArchivio()) {
                Applicazione.getIstance().getFrame().getMessaggio("In archivio tutte le cartelle con almeno tre file hanno i file inseriti in maniere decrescente di dimensione");
            } else {
                Applicazione.getIstance().getFrame().getMessaggio("In archivio tutte le cartelle con almeno tre file NON hanno i file inseriti in maniere decrescente di dimensione");
            }
        }
    }

    private class AzioneCarica extends AbstractAction {

        public AzioneCarica() {
            this.putValue(NAME, "Carica cartelle");
            this.putValue(SHORT_DESCRIPTION, "Carica cartelle dall'archivio");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_C);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt C"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            IDAOArchivio dAOArchivio = Applicazione.getIstance().getdAOArchivio();
            Archivio archivio;
            try {
                archivio = dAOArchivio.carica("");
                Applicazione.getIstance().getModello().putBean(Costanti.ARCHIVIO, archivio);
                Applicazione.getIstance().getFrame().getMessaggio("Caricato correttamente l'archivio contenente " + archivio.getListaCartelle().size() + " cartelle");
                Applicazione.getIstance().getControlloPrincipale().getAzioneCerca().setEnabled(true);
                Applicazione.getIstance().getControlloPrincipale().getAzioneSeleziona().setEnabled(true);
                azioneVerifica.setEnabled(true);
            } catch (DAOException ex) {
                Applicazione.getIstance().getFrame().getErrore("Archivio non caricato: " + ex.getLocalizedMessage());
            }

        }
    }

    private class AzioneEsci extends AbstractAction {

        public AzioneEsci() {
            this.putValue(NAME, "Esci");
            this.putValue(SHORT_DESCRIPTION, "Esci dall'applicazione");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_E);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt E"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}
