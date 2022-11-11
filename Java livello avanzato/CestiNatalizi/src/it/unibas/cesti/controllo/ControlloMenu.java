package it.unibas.cesti.controllo;

import it.unibas.cesti.Applicazione;
import it.unibas.cesti.modello.Archivio;
import it.unibas.cesti.modello.Costanti;
import it.unibas.cesti.persistenza.DAOException;
import it.unibas.cesti.persistenza.IDAOArchivio;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;

public class ControlloMenu {

    private final Action azioneEsci = new AzioneEsci();
    private final Action azioneCarica = new AzioneCarica();
    private final Action azioneVerifica = new AzioneVerifica();

    public Action getAzioneEsci() {
        return azioneEsci;
    }

    public Action getAzioneCarica() {
        return azioneCarica;
    }

    public Action getAzioneVerifica() {
        return azioneVerifica;
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

    private class AzioneCarica extends AbstractAction {

        public AzioneCarica() {
            this.putValue(Action.NAME, "Carica archivio");
            this.putValue(Action.SHORT_DESCRIPTION, "Carica archivio contenente i cesti");
            this.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_X);
            this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt X"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            IDAOArchivio dAOArchivio = Applicazione.getIstance().getdAOArchivio();

            try {
                Archivio archivio = dAOArchivio.carica("");
                Applicazione.getIstance().getFrame().getMessaggio("Caricato correttamente l'archivio contenente " + archivio.getListaCesti().size() + " cesti");
                Applicazione.getIstance().getModello().putBean(Costanti.ARCHIVIO, archivio);
                Applicazione.getIstance().getControlloPrincipale().getAzioneCerca().setEnabled(true);
                Applicazione.getIstance().getControlloPrincipale().getAzioneVisualizza().setEnabled(true);
                azioneVerifica.setEnabled(true);
            } catch (DAOException ex) {
                Applicazione.getIstance().getFrame().getErrore("Archivio non caricato correttamente: " + ex.getLocalizedMessage());

            }
        }

    }

    private class AzioneVerifica extends AbstractAction {

        public AzioneVerifica() {
            this.putValue(Action.NAME, "Verifica archivio");
            this.putValue(Action.SHORT_DESCRIPTION, "Verifica quanti cesti hanno prodotti duplicati");
            this.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_V);
            this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt V"));
            setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Archivio archvio = (Archivio) Applicazione.getIstance().getModello().getBean(Costanti.ARCHIVIO);
            Applicazione.getIstance().getFrame().getMessaggio("Cesti duplicati in archivio: " + archvio.verificaArchivio());
        }
    }
}
