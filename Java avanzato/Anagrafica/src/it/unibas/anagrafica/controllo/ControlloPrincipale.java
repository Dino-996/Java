package it.unibas.anagrafica.controllo;

import it.unibas.anagrafica.Applicazione;
import it.unibas.anagrafica.modello.Archivio;
import it.unibas.anagrafica.modello.Azienda;
import it.unibas.anagrafica.modello.Costanti;
import it.unibas.anagrafica.vista.VistaPrincipale;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import static javax.swing.Action.ACCELERATOR_KEY;
import static javax.swing.Action.MNEMONIC_KEY;
import static javax.swing.Action.NAME;
import static javax.swing.Action.SHORT_DESCRIPTION;
import javax.swing.KeyStroke;

public class ControlloPrincipale {

    private final Action azioneCerca = new AzioneCerca();
    private final Action azioneSeleziona = new AzioneSeleziona();

    public Action getAzioneCerca() {
        return this.azioneCerca;
    }

    public Action getAzioneSeleziona() {
        return this.azioneSeleziona;
    }

    private class AzioneCerca extends AbstractAction {

        public AzioneCerca() {
            putValue(NAME, "Cerca");
            putValue(SHORT_DESCRIPTION, "Cerca aziende in archivio");
            putValue(MNEMONIC_KEY, KeyEvent.VK_C);
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt C"));
            setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vista = Applicazione.getIstance().getVistaPrincipale();
            String citta = vista.getCitta();
            if (citta.isEmpty()) {
                Applicazione.getIstance().getFrame().getErrore("Inserire una citta' prima di continuare");
                return;
            }
            Archivio archivio = (Archivio) Applicazione.getIstance().getModello().getBean(Costanti.ARCHIVIO_STRING);
            List<Azienda> listaFiltrata = archivio.cercaAziendaPerSedeSociale(citta);
            if (listaFiltrata.isEmpty()) {
                Applicazione.getIstance().getFrame().getMessaggio("Nessun azienda trovata per la citta immessa");
                return;
            }
            Applicazione.getIstance().getModello().putBean(Costanti.LISTA_FILTRATA, listaFiltrata);
            vista.aggiornaTabella();
        }

    }

    private class AzioneSeleziona extends AbstractAction {

        public AzioneSeleziona() {
            putValue(NAME, "Visualizza");
            putValue(SHORT_DESCRIPTION, "Visualizza dipendenti in base all'azienda selezionata");
            putValue(MNEMONIC_KEY, KeyEvent.VK_V);
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt V"));
            setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vista = Applicazione.getIstance().getVistaPrincipale();
            int rigaSelezionata = vista.getRigaSelezionata();

            if (rigaSelezionata == -1) {
                Applicazione.getIstance().getFrame().getErrore("Selezionare un azienda prima di continuare");
                return;
            }
            List<Azienda> listaFiltrata = (List<Azienda>) Applicazione.getIstance().getModello().getBean(Costanti.LISTA_FILTRATA);
            Azienda aziendaSelezionata = listaFiltrata.get(rigaSelezionata);
            Applicazione.getIstance().getModello().putBean(Costanti.AZIENDA_SELEZIONATA, aziendaSelezionata);
            Applicazione.getIstance().getVistaDipendente().visualizza();
        }

    }
}
