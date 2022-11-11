package it.unibas.playlist.controllo;

import it.unibas.playlist.Applicazione;
import it.unibas.playlist.modello.Archivio;
import it.unibas.playlist.modello.Costanti;
import it.unibas.playlist.modello.Playlist;
import it.unibas.playlist.vista.VistaPlaylist;
import it.unibas.playlist.vista.VistaPrincipale;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;

public class ControlloPlaylist {

    private final Action azioneAggiungiPlaylist = new AzioneAggiungiPlaylist();

    public Action getAzioneAggiungiPlaylist() {
        return this.azioneAggiungiPlaylist;
    }

    private class AzioneAggiungiPlaylist extends AbstractAction {

        public AzioneAggiungiPlaylist() {
            this.putValue(Action.NAME, "OK");
            this.putValue(Action.SHORT_DESCRIPTION, "Crea una nuova playlist");
            this.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_P);
            this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctr alt P"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vistaPrincipale = Applicazione.getIstance().getVistaPrincipale();
            VistaPlaylist vista = Applicazione.getIstance().getVistaPlaylist();
            String nomePlaylist = vista.getNomePlaylist();
            String nomeProprietario = vista.getPropietario();
            String giorno = vista.getCampoTestoGiorno();
            String mese = vista.getCampoTestoMese();
            String anno = vista.getCampoTestoAnno();
            String ore = vista.getCampoTestoOre();
            String minuti = vista.getCampoTestoMinuti();
            String convalida = errori(nomePlaylist, nomeProprietario, giorno, mese, anno, ore, minuti);
            if (!convalida.isEmpty()) {
                Applicazione.getIstance().getFrame().getMessaggioErrore(convalida);
                return;
            }
            int interoGiorno = Integer.parseInt(giorno);
            int interoMese = Integer.parseInt(mese);
            int interoAnno = Integer.parseInt(anno);
            int interoOre = Integer.parseInt(ore);
            int interoMinuti = Integer.parseInt(minuti);
            Playlist nuovaPlaylist = new Playlist(nomePlaylist, nomeProprietario, new GregorianCalendar(interoAnno, interoMese - 1, interoGiorno, interoOre, interoMinuti));
            Archivio archivio = (Archivio) Applicazione.getIstance().getModello().getBean(Costanti.ARCHIVIO);
            if (archivio.isDuplicato(nuovaPlaylist)) {
                Applicazione.getIstance().getFrame().getMessaggioErrore("Playlist già esistente");
                return;
            }
            archivio.addPlaylist(nuovaPlaylist);
            vistaPrincipale.aggiornaTabella();
        }
    }

    private String errori(String nomePlaylist, String nomeProprietario, String giorno, String mese, String anno, String ore, String minuti) {
        StringBuilder sb = new StringBuilder();
        if (nomePlaylist.isEmpty()) {
            sb.append("Inserire il nome della playlist\n");
        }
        if (nomeProprietario.isEmpty()) {
            sb.append("Inserire il nome del proprietario\n");
        }
        try {
            int interoGiorno = Integer.parseInt(giorno);
            int interoMese = Integer.parseInt(mese);
            int interoAnno = Integer.parseInt(anno);
            int interoOre = Integer.parseInt(ore);
            int interoMinuti = Integer.parseInt(minuti);
            Calendar calendar = new GregorianCalendar();
            calendar.setLenient(true);
            calendar.set(interoAnno, interoMese - 1, interoGiorno, interoOre, interoMinuti);
            Date date = calendar.getTime();
            Date dataAttuale = new Date();
            if (date.before(dataAttuale)) {
                sb.append("La data non può essere nel passato\n");
            }
        } catch (NumberFormatException e) {
            sb.append("Il formato della data inserita non è valido\n");
        }
        return sb.toString().trim();
    }
}
