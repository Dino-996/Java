package it.unibas.playlist.controllo;

import it.unibas.playlist.Applicazione;
import it.unibas.playlist.modello.Brano;
import it.unibas.playlist.modello.Costanti;
import it.unibas.playlist.modello.Playlist;
import it.unibas.playlist.vista.VistaBrano;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;

public class ControlloBrani {

    private final Action azioneAggiungiBrano = new AzioneAggiungiBrano();

    public Action getAzioneAggiungiBrano() {
        return this.azioneAggiungiBrano;
    }

    private class AzioneAggiungiBrano extends AbstractAction {

        public AzioneAggiungiBrano() {
            this.putValue(Action.NAME, "Aggiungi brano");
            this.putValue(Action.SHORT_DESCRIPTION, "Aggiungi un nuovo brano alla playlist");
            this.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_D);
            this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt D"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaBrano vistaBrano = Applicazione.getIstance().getVistaBrano();
            String nomeBrano = vistaBrano.getNomeBrano();
            String nomeArtista = vistaBrano.getNomeArtista();
            String categoria = vistaBrano.getCategoria();
            String durataInSecondi = vistaBrano.getDurata();
            String convalida = errori(nomeBrano, nomeArtista, categoria, durataInSecondi);
            if (!convalida.isEmpty()) {
                Applicazione.getIstance().getFrame().getMessaggioErrore(convalida);
                return;
            }
            int interoDurata = Integer.parseInt(durataInSecondi);
            Playlist playlist = (Playlist) Applicazione.getIstance().getModello().getBean(Costanti.LISTA_BRANI);
            Brano brano = new Brano(nomeBrano, nomeArtista, categoria, interoDurata);
            playlist.addBrano(brano);
            vistaBrano.aggiornaDati();
            
        }

    }
    
    private String errori(String nomeBrano, String nomeArtista, String categoria, String durataSecondi) {
        StringBuilder sb = new StringBuilder();
        if (nomeBrano.isEmpty()) {
            sb.append("Inserire nome artista\n");
        }
        if (nomeArtista.isEmpty()) {
            sb.append("Inserire nome brano\n");
        }
        if (categoria.isEmpty()) {
            sb.append("Scegliere una categoria\n");
        }
        if (durataSecondi.isEmpty()) {
            sb.append("Inserire durata brano\n");
        } else {
            try {
                int interoDurata = Integer.parseInt(durataSecondi);
                if (interoDurata < 30 || interoDurata > 300) {
                    sb.append("Inserire una durata compresa tra 30 e 300 secondi\n");
                }
            } catch (NumberFormatException e) {
                sb.append("Valore inserito non valido\n");
            }
        }
        return sb.toString().trim();
    }

}
