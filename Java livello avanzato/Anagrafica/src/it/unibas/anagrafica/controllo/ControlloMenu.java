package it.unibas.anagrafica.controllo;

import it.unibas.anagrafica.Applicazione;
import it.unibas.anagrafica.modello.Archivio;
import it.unibas.anagrafica.modello.Costanti;
import it.unibas.anagrafica.persistenza.DAOException;
import it.unibas.anagrafica.persistenza.IDAOArchivio;
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

    private class AzioneCarica extends AbstractAction {

        public AzioneCarica() {
            putValue(NAME, "Carica archivio");
            putValue(SHORT_DESCRIPTION, "Carica archivio aziende");
            putValue(MNEMONIC_KEY, KeyEvent.VK_E);
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt E"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                IDAOArchivio dAOArchivio = Applicazione.getIstance().getIdaoArchivio();
                Archivio archivio = dAOArchivio.carica("");
                Applicazione.getIstance().getModello().putBean(Costanti.ARCHIVIO_STRING, archivio);
                Applicazione.getIstance().getFrame().getMessaggio("Caricato correttamente l'archivio contenente " + archivio.getListaAziende().size() + " aziende");
                Applicazione.getIstance().getControlloPrincipale().getAzioneCerca().setEnabled(true);
                Applicazione.getIstance().getControlloPrincipale().getAzioneSeleziona().setEnabled(true);
                azioneVerifica.setEnabled(true);
            } catch (DAOException ex) {
                Applicazione.getIstance().getFrame().getErrore("Impossibile caricare l'archivio: " + ex.getStackTrace());
            }
        }

    }

    private class AzioneEsci extends AbstractAction {

        public AzioneEsci() {
            putValue(NAME, "Esci");
            putValue(SHORT_DESCRIPTION, "Esci dall'applicazione");
            putValue(MNEMONIC_KEY, KeyEvent.VK_X);
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt X"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }

    }

    private class AzioneVerifica extends AbstractAction {

        public AzioneVerifica() {
            putValue(NAME, "Verifica archivio");
            putValue(SHORT_DESCRIPTION, "Verifica in tutto l'archivio se esistono dipendenti duplicati");
            putValue(MNEMONIC_KEY, KeyEvent.VK_V);
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt V"));
            setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Archivio archivio = (Archivio) Applicazione.getIstance().getModello().getBean(Costanti.ARCHIVIO_STRING);
            if (archivio.verificaArchivio()) {
                Applicazione.getIstance().getFrame().getMessaggio("In archivio esistono dipendenti con lo stesso codice fiscale");

            } else {
                Applicazione.getIstance().getFrame().getMessaggio("In archivio NON esistono dipendenti con lo stesso codice fiscale");

            }
        }

    }
}
