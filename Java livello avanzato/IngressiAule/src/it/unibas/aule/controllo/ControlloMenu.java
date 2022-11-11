package it.unibas.aule.controllo;

import it.unibas.aule.Applicazione;
import it.unibas.aule.modello.Archivio;
import it.unibas.aule.modello.Costanti;
import it.unibas.aule.persistenza.DAOException;
import it.unibas.aule.persistenza.IDAOArchivio;
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
    
    private class AzioneCarica extends AbstractAction {
        
        public AzioneCarica() {
            this.putValue(NAME, "Carica archivio");
            this.putValue(SHORT_DESCRIPTION, "Carica archivio delle aule");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_X);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt X"));
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                IDAOArchivio dAOArchivio = Applicazione.getIstance().getDaoArchivio();
                Archivio archivio = dAOArchivio.carica("");
                Applicazione.getIstance().getModello().putBeans(Costanti.ARCHIVIO, archivio);
                Applicazione.getIstance().getFrame().getMessaggio("Caricato correttamente archivio contenente " + archivio.getListaAule().size() + " aule");
                Applicazione.getIstance().getControlloPrincipale().getAzioneCerca().setEnabled(true);
                Applicazione.getIstance().getControlloPrincipale().getAzioneSelezionata().setEnabled(true);
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
    
    private class AzioneVerifica extends AbstractAction {
        
        public AzioneVerifica() {
            this.putValue(NAME, "Verifica archivio");
            this.putValue(SHORT_DESCRIPTION, "Verifica se ci sono accessi duplicati di domenica in archivio");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_V);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt V"));
            this.setEnabled(false);
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            Archivio archivio = (Archivio) Applicazione.getIstance().getModello().getBeans(Costanti.ARCHIVIO);
            if (archivio.verificaArchivio()) {
                Applicazione.getIstance().getFrame().getMessaggio("In archivio esistono accessi duplicati di domenica");
            } else {
                Applicazione.getIstance().getFrame().getMessaggio("In archivio NON esistono accessi duplicati di domenica");
            }
        }
    }
}
