package it.unibas.pietanze.controllo;

import it.unibas.pietanze.Applicazione;
import it.unibas.pietanze.modello.Archivio;
import it.unibas.pietanze.modello.Costanti;
import it.unibas.pietanze.persistenza.DAOException;
import it.unibas.pietanze.persistenza.IDAOArchivio;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;

public class ControlloMenu {
    
    private final Action azioneCarica = new AzioneCarica();
    private final Action azioneEsci = new AzioneEsci();
    
    public Action getAzioneCarica() {
        return this.azioneCarica;
    }
    
    public Action getAzioneEsci() {
        return this.azioneEsci;
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
            putValue(SHORT_DESCRIPTION, "Carica archivio pietanze");
            putValue(MNEMONIC_KEY, KeyEvent.VK_A);
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt A"));
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            IDAOArchivio daoArchivio = Applicazione.getIstance().getDaoArchivio();
            try {
                Archivio archivio = daoArchivio.carica("");
                Applicazione.getIstance().getModello().putBean(Costanti.ARCHIVIO, archivio);
                Applicazione.getIstance().getFrame().getMessaggio("Caricato correttamente l'archivio contenente " + archivio.getListaPietanza().size() + " pietanze");
                Applicazione.getIstance().getControlloPrincipale().getAzioneCerca().setEnabled(true);
                Applicazione.getIstance().getControlloPrincipale().getAzioneVerifica().setEnabled(true);
            } catch (DAOException ex) {
                Applicazione.getIstance().getFrame().getErrore("Impossibile caricare l'archivio: " + ex.getLocalizedMessage());
            }
        }
    }
}
