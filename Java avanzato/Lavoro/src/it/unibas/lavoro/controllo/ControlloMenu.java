package it.unibas.lavoro.controllo;

import it.unibas.lavoro.Applicazione;
import it.unibas.lavoro.modello.Archivio;
import it.unibas.lavoro.modello.Costanti;
import it.unibas.lavoro.modello.Offerta;
import it.unibas.lavoro.persistenza.DAOException;
import it.unibas.lavoro.persistenza.IDAOArchivio;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;

public class ControlloMenu {

    private final Action azioneEsci = new AzioneEsci();
    private final Action azioneCarica = new AzioneCarica();
    private final Action azioneVerificaOfferta = new AzioneVerificaOfferta();
    private final Action azioneVerificaArchivio = new AzioneVerificaArchivio();

    public Action getAzioneEsci() {
        return this.azioneEsci;
    }

    public Action getAzioneCarica() {
        return this.azioneCarica;
    }

    public Action getAzioneVerificaOfferta() {
        return this.azioneVerificaOfferta;
    }

    public Action getAzioneVerificaArchvio() {
        return this.azioneVerificaArchivio;
    }

    public class AzioneVerificaArchivio extends AbstractAction {

        public AzioneVerificaArchivio() {
            putValue(NAME, "Verifica archivio");
            putValue(SHORT_DESCRIPTION, "Verifica se l'offerta di lavoro che ha la media eta' candidati piu' alta e' anche l'offerta con la retribuzione maggiore");
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt X"));
            putValue(MNEMONIC_KEY, KeyEvent.VK_X);
            setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Archivio archivio = (Archivio) Applicazione.getIstance().getModello().getBean(Costanti.ARCHIVIO);
            boolean verifica = archivio.verificaArchivio();
            if (verifica) {
                Applicazione.getIstance().getFrame().getMessaggio("L'offerta di lavoro che ha la media eta candidati piu' alta e' anche l'offerta con la retribuzione maggiore");
            } else {
                Applicazione.getIstance().getFrame().getMessaggio("L'offerta di lavoro che ha la media eta candidati piu' alta NON e' anche l'offerta con la retribuzione maggiore");
            }
        }
    }

    public class AzioneVerificaOfferta extends AbstractAction {

        public AzioneVerificaOfferta() {
            putValue(NAME, "Verifica offerta");
            putValue(SHORT_DESCRIPTION, "Verifica se ci sono duplicati nelle offerte di lavoro");
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt V"));
            putValue(MNEMONIC_KEY, KeyEvent.VK_V);
            setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int rigaSelezionata = Applicazione.getIstance().getVistaPrincipale().getRigaSelezionata();
            if (rigaSelezionata == -1) {
                Applicazione.getIstance().getFrame().getErrore("Selezionare prima una riga!");
                return;
            }
            Archivio archivio = (Archivio) Applicazione.getIstance().getModello().getBean(Costanti.ARCHIVIO);
            List<Offerta> listaFiltrata = (List<Offerta>) Applicazione.getIstance().getModello().getBean(Costanti.LISTA_FILTRATA);
            Offerta offertaSelezionata = listaFiltrata.get(rigaSelezionata);
            if (archivio.verificaCodiceFiscalePerOffertaSelezionata(offertaSelezionata)) {
                Applicazione.getIstance().getFrame().getMessaggio("Domande con lo stesso codice fiscale: " + offertaSelezionata.contaDomandeDuplicate(offertaSelezionata));
            } else {
                Applicazione.getIstance().getFrame().getMessaggio("Non esistono domande duplicate");
            }
        }
    }

    public class AzioneCarica extends AbstractAction {

        public AzioneCarica() {
            putValue(NAME, "Carica");
            putValue(SHORT_DESCRIPTION, "Carica archivio offerte di lavoro");
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt A"));
            putValue(MNEMONIC_KEY, KeyEvent.VK_A);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            IDAOArchivio dAOArchivio = Applicazione.getIstance().getDaoArchivio();
            try {
                Archivio archivio = dAOArchivio.carica("");
                Applicazione.getIstance().getModello().putBean(Costanti.ARCHIVIO, archivio);
                Applicazione.getIstance().getFrame().getMessaggio("Caricato correttamente l'archivio contenente " + archivio.getListaOfferte().size() + " offerte di lavoro");
                Applicazione.getIstance().getControlloVistaPrincipale().getAzioneCerca().setEnabled(true);
                getAzioneVerificaArchvio().setEnabled(true);
                getAzioneVerificaOfferta().setEnabled(true);
            } catch (DAOException ex) {
                Applicazione.getIstance().getFrame().getErrore("Impossibile caricare l'archivio: " + ex.toString());
            }
        }
    }

    private class AzioneEsci extends AbstractAction {

        public AzioneEsci() {
            putValue(NAME, "Esci");
            putValue(SHORT_DESCRIPTION, "Esci dall'applicazione");
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt E"));
            putValue(MNEMONIC_KEY, KeyEvent.VK_E);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}
