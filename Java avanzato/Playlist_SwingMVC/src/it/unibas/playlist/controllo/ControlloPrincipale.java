package it.unibas.playlist.controllo;

import it.unibas.playlist.Applicazione;
import it.unibas.playlist.modello.Archivio;
import it.unibas.playlist.modello.Costanti;
import it.unibas.playlist.modello.Playlist;
import it.unibas.playlist.vista.VistaBrano;
import it.unibas.playlist.vista.VistaPlaylist;
import it.unibas.playlist.vista.VistaPrincipale;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;

public class ControlloPrincipale {

    private final Action azioneCaricaPlaylist = new AzioneCaricaPlaylist();
    private final Action azioneAggiungiPlaylist = new AzioneAggiungiPlaylist();

    public Action getAzioneCaricaPlaylist() {
        return this.azioneCaricaPlaylist;
    }
    
    public Action getAzioneAggiungiPlaylist() {
        return this.azioneAggiungiPlaylist;
    }
    
    private class AzioneAggiungiPlaylist extends AbstractAction {

        public AzioneAggiungiPlaylist() {
            this.putValue(Action.NAME, "Aggiungi playlist");
            this.putValue(Action.SHORT_DESCRIPTION, "Aggiungi una nuova playlist");
            this.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_B);
            this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctr alt B"));
            setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPlaylist vista = Applicazione.getIstance().getVistaPlaylist();
            vista.visualizza();
        }
        
    }


    private class AzioneCaricaPlaylist extends AbstractAction {

        public AzioneCaricaPlaylist() {
            this.putValue(Action.NAME, "Carica brani in playlist");
            this.putValue(Action.SHORT_DESCRIPTION, "Carica i brani contenuti nella playlist");
            this.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_X);
            this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctr alt X"));
            setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vista = Applicazione.getIstance().getVistaPrincipale();
            int rigaSelezionata = vista.getRigaSelezionata();
            if (rigaSelezionata == -1) {
                Applicazione.getIstance().getFrame().getMessaggioErrore("Selezionare prima una playlist");
                return;
            }
            List<Playlist> listaFiltrata = (List<Playlist>) Applicazione.getIstance().getModello().getBean(Costanti.LISTA_FILTRATA);
            Playlist playlist = listaFiltrata.get(rigaSelezionata);
            Applicazione.getIstance().getModello().putBean(Costanti.LISTA_BRANI, playlist);
            VistaBrano brano = Applicazione.getIstance().getVistaBrano();
            brano.visualizza();

        }
    }
}
