package it.unibas.banca.controllo;

import it.unibas.banca.Applicazione;
import it.unibas.banca.modello.Archivio;
import it.unibas.banca.modello.Costanti;
import it.unibas.banca.persistenza.DAOException;
import it.unibas.banca.persistenza.IDAOArchivio;
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
            putValue(SHORT_DESCRIPTION, "Cerca conti correnti da archivio");
            putValue(MNEMONIC_KEY, KeyEvent.VK_X);
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt X"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            IDAOArchivio daoArchivio = Applicazione.getInstance().getDaoArchivio();
            try {
                Archivio archivio = daoArchivio.carica("");
                Applicazione.getInstance().getFrame().getMessage("Caricato correttamente l'archivio contenente " + archivio.getListaConti().size() + " conti correnti");
                Applicazione.getInstance().getModello().putBeans(Costanti.ARCHIVIO, archivio);
                Applicazione.getInstance().getControlloPrincipale().getAzioneCerca().setEnabled(true);
                Applicazione.getInstance().getControlloPrincipale().getAzioneVisualizza().setEnabled(true);
                azioneVerifica.setEnabled(true);
            } catch (DAOException ex) {
                Applicazione.getInstance().getFrame().getMessage("Errore durante il caricamento dell'archivio: " + ex.getLocalizedMessage());

            }
        }

    }

    private class AzioneVerifica extends AbstractAction {

        public AzioneVerifica() {
            putValue(NAME, "Verifica archivio");
            putValue(SHORT_DESCRIPTION, "Verifica se nell'archivio esistono conti correnti con lo stesso nome sottoscritti nella stessa data");
            putValue(MNEMONIC_KEY, KeyEvent.VK_V);
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt V"));
            setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Archivio archivio = (Archivio) Applicazione.getInstance().getModello().getBeans(Costanti.ARCHIVIO);
            if (archivio.verificaArchivio()) {
                Applicazione.getInstance().getFrame().getMessage("Ci sono piu conto correnti con lo stesso nome e cognome sottoscritti nella stessa data");
            } else {
                Applicazione.getInstance().getFrame().getMessage("NON ci sono conto correnti con lo stesso nome e cognome sottoscritti nella stessa data");
            }
        }
    }
}
