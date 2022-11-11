package it.unibas.aereomobile.controllo;

import it.unibas.aereomobile.Applicazione;
import it.unibas.aereomobile.modello.Aereomobile;
import it.unibas.aereomobile.modello.Archivio;
import it.unibas.aereomobile.modello.Costanti;
import it.unibas.aereomobile.persistenza.DAOException;
import it.unibas.aereomobile.persistenza.IDAOArchivio;
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
            putValue(SHORT_DESCRIPTION, "Carica l'archivio degli aereomobili");
            putValue(MNEMONIC_KEY, KeyEvent.VK_X);
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt X"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            IDAOArchivio daoArcvhivio = Applicazione.getIstance().getDaoArchivio();
            try {
                Archivio archivio = daoArcvhivio.carica("");
                Applicazione.getIstance().getModello().putBean(Costanti.ARCHIVIO__STRING, archivio);
                Applicazione.getIstance().getFrame().getMessaggio("Caricato correttamente l'archivio contenente " + archivio.getListaAereomobili().size() + " aereomobili");
                Applicazione.getIstance().getControlloPrincipale().getAzioneCerca().setEnabled(true);
                Applicazione.getIstance().getControlloPrincipale().getAzioneVisualizza().setEnabled(true);
                azioneVerifica.setEnabled(true);
            } catch (DAOException ex) {
                Applicazione.getIstance().getFrame().getErrore("Attenzione: Archivio non caricato " + ex.getLocalizedMessage());
            }
        }
    }

    private class AzioneVerifica extends AbstractAction {

        public AzioneVerifica() {
            putValue(NAME, "Verifica archivio");
            putValue(SHORT_DESCRIPTION, "Verifica tra tutti gli aereomobili che hanno effettuato 2 voli e che sono partiti dallo stesso aereoporto quello che ha la media durata viaggi piu' alta");
            putValue(MNEMONIC_KEY, KeyEvent.VK_V);
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt V"));
            setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Archivio archivio = (Archivio) Applicazione.getIstance().getModello().getBean(Costanti.ARCHIVIO__STRING);
            Aereomobile aereomobileTrovato = archivio.verificaArchivio();
            if (archivio.verificaArchivio() != null) {
                Applicazione.getIstance().getFrame().getMessaggio("Aereomobile trovato:" + aereomobileTrovato + "\nMedia durata dei viaggi: " + aereomobileTrovato.getMediaDurataVolo() + " minuti");
            } else {
                Applicazione.getIstance().getFrame().getMessaggio("Nessun aereomobile trovato");
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
}
