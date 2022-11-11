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
    private final Action azioneVerifica = new AzioneVerifica();
    private final Action azioneEsci = new AzioneEsci();

    public Action getAzioneCarica() {
        return azioneCarica;
    }

    public Action getAzioneVerifica() {
        return azioneVerifica;
    }

    public Action getAzioneEsci() {
        return azioneEsci;
    }

    private class AzioneVerifica extends AbstractAction {

        public AzioneVerifica() {
            this.putValue(NAME, "Verifica archivio");
            this.putValue(SHORT_DESCRIPTION, "Verifica se nell'archivio esistono aereomobili che hanno eseguito almeno 2 viaggi, e che\n"
                    + "sono partiti sempre dallo stesso aeroporto. Tra questi calcola l’aeromobile che la media della durata\n"
                    + "dei viaggi più alta");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_V);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt V"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Archivio archivio = (Archivio) Applicazione.getIstance().getModello().getBean(Costanti.ARCHIVIO);
            double verifica = archivio.verificaArchivio();
            if (verifica != 0.0) {
                Applicazione.getIstance().getFrame().getMessaggio("Media durata viaggi più alta: \n" + archivio.verificaArchivio());
            } else {
                Applicazione.getIstance().getFrame().getMessaggio("Non e' possibile calcolare la media voli automobili");
            }
        }
    }

    private class AzioneCarica extends AbstractAction {

        public AzioneCarica() {
            this.putValue(NAME, "Carica archivio");
            this.putValue(SHORT_DESCRIPTION, "Carica l'archivio degli aereomobili");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_E);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt C"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            IDAOArchivio daoArchivio = Applicazione.getIstance().getDaoArchivio();
            try {
                Archivio archivio = daoArchivio.carica("");
                Applicazione.getIstance().getModello().putBean(Costanti.ARCHIVIO, archivio);
                Applicazione.getIstance().getFrame().getMessaggio("Caricato correttamente l'archivio contenente " + archivio.getListaAereomobili().size() + " aereomobili");
                Applicazione.getIstance().getControlloPrincipale().getAzioneCerca().setEnabled(true);
                Applicazione.getIstance().getControlloPrincipale().getAzioneSeleziona().setEnabled(true);
                azioneVerifica.setEnabled(true);
            } catch (DAOException ex) {
                Applicazione.getIstance().getFrame().getErrore("Impossibile caricare l'archivio: " + ex.getMessage());
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
