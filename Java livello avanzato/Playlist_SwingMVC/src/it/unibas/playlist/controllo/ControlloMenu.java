package it.unibas.playlist.controllo;

import it.unibas.playlist.Applicazione;
import it.unibas.playlist.modello.Archivio;
import it.unibas.playlist.modello.Costanti;
import it.unibas.playlist.modello.Playlist;
import it.unibas.playlist.persistenza.DAOException;
import it.unibas.playlist.persistenza.IDAOArchivio;
import it.unibas.playlist.vista.VistaPrincipale;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;

public class ControlloMenu {
    
    private Action azioneCarica = new AzioneCarica();
    private Action azioneEsci = new AzioneEsci();
    
    public Action getAzioneCarica() {
        return this.azioneCarica;
    }
    
    public Action getAzioneEsci() {
        return this.azioneEsci;
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
            this.putValue(Action.NAME, "Carica");
            this.putValue(Action.SHORT_DESCRIPTION, "Carica archivio");
            this.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_C);
            this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt C"));
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            IDAOArchivio daoArchivio = Applicazione.getIstance().getdAOArchivio();
            try {
                Archivio archivio = daoArchivio.carica("");
                Applicazione.getIstance().getModello().putBean(Costanti.ARCHIVIO, archivio);
                Applicazione.getIstance().getFrame().getMessaggioInformativo("Caricato l'archivio contenente " + archivio.getListaPlaylist().size() + " playlist");
                List<Playlist> playlists = archivio.getListaPlaylist();
                Applicazione.getIstance().getModello().putBean(Costanti.LISTA_FILTRATA, playlists);
                VistaPrincipale vistaPrincipale = Applicazione.getIstance().getVistaPrincipale();
                vistaPrincipale.aggiornaTabella();
                Applicazione.getIstance().getControlloPrincipale().getAzioneCaricaPlaylist().setEnabled(true);
                Applicazione.getIstance().getControlloPrincipale().getAzioneAggiungiPlaylist().setEnabled(true);
            } catch (DAOException exception) {
                Applicazione.getIstance().getFrame().getMessaggioErrore("Qualcosa è andato storto" + exception.getMessage());
            }
        }
        
    }
    
}
