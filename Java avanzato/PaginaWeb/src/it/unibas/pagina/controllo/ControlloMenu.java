package it.unibas.pagina.controllo;

import it.unibas.pagina.Applicazione;
import it.unibas.pagina.modello.Archivio;
import it.unibas.pagina.modello.Costanti;
import it.unibas.pagina.modello.PaginaWeb;
import it.unibas.pagina.persistenza.DAOException;
import it.unibas.pagina.persistenza.IDAOArchivio;
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

    private class AzioneVerifica extends AbstractAction {

        public AzioneVerifica() {
            this.putValue(NAME, "Verifica archivio");
            this.putValue(SHORT_DESCRIPTION, "Verifica se in archivio esistono pagine web non aggiornate con annotazioni di colore rosso");
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt T"));
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_T);
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Archivio archivio = (Archivio) Applicazione.getIstance().getModello().getBean(Costanti.ARCHIVIO);
            PaginaWeb pagina = archivio.verificaArchivio();
            if (archivio.verificaArchivio() != null) {
                Applicazione.getIstance().getFrame().getMessaggio("<html><b>PAGINA CON IL MAGGIOR NUMERO DI ANNOTAZIONI ROSSE</b></html>" + archivio.verificaArchivio().toString() + "\nNumero di annotazioni rosse: " + pagina.contaColoreRosso());
            } else {
                Applicazione.getIstance().getFrame().getMessaggio("Nessuna pagina web trovata");
            }
        }
    }

    private class AzioneCarica extends AbstractAction {

        public AzioneCarica() {
            this.putValue(NAME, "Carica archivio");
            this.putValue(SHORT_DESCRIPTION, "Carica archivio pagine web");
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt C"));
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_C);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            IDAOArchivio dAOArchivio = Applicazione.getIstance().getiDaoArchivio();
            try {
                Archivio archivio = dAOArchivio.carica("");
                Applicazione.getIstance().getModello().putBean(Costanti.ARCHIVIO, archivio);
                Applicazione.getIstance().getFrame().getMessaggio("Caricato correttamente l'archivio contenente " + archivio.getListaPagine().size() + " pagine web");
                Applicazione.getIstance().getControlloPrincipale().getAzioneCerca().setEnabled(true);
                Applicazione.getIstance().getControlloPrincipale().getAzioneSeleziona().setEnabled(true);
                azioneVerifica.setEnabled(true);
            } catch (DAOException ex) {
                Applicazione.getIstance().getFrame().getErrore("Errore durante il caricamento dell'archivio" + ex.getLocalizedMessage());
            }
        }
    }

    private class AzioneEsci extends AbstractAction {

        public AzioneEsci() {
            this.putValue(NAME, "Esci");
            this.putValue(SHORT_DESCRIPTION, "Esci dall'applicazione");
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt E"));
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_E);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}
