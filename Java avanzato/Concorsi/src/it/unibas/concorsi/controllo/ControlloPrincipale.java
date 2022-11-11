package it.unibas.concorsi.controllo;

import it.unibas.concorsi.Applicazione;
import it.unibas.concorsi.modello.Archivio;
import it.unibas.concorsi.modello.Concorso;
import it.unibas.concorsi.modello.Costanti;
import it.unibas.concorsi.vista.VistaPrincipale;
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
    private final Action azioneVisualizzaDomande = new AzioneVisualizzaDomande();

    public Action getAzioneCerca() {
        return this.azioneCerca;
    }

    public Action getAzioneVisualizzaDomande() {
        return azioneVisualizzaDomande;
    }

    private class AzioneVisualizzaDomande extends AbstractAction {

        public AzioneVisualizzaDomande() {
            this.putValue(NAME, "Visualizza domande");
            this.putValue(SHORT_DESCRIPTION, "Visualizza le domande presentate per il concorso selezionato");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_V);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt V"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vista = Applicazione.getIstance().getVistaPrincipale();
            int rigaSelezionata = vista.getRigaSelezionata();
            if (rigaSelezionata == -1) {
                Applicazione.getIstance().getFrame().getErrore("Selezionare un concorso prima di continuare");
                return;
            }
            List<Concorso> listaFiltrata = (List<Concorso>) Applicazione.getIstance().getModello().getBean(Costanti.LISTA_FILTRATA);
            Concorso concorsoSelezionato = listaFiltrata.get(rigaSelezionata);
            Applicazione.getIstance().getModello().putBean(Costanti.CONCORSO_SELEZIONATO, concorsoSelezionato);
            Applicazione.getIstance().getVistaDomanda().visualizza();
        }
    }

    private class AzioneCerca extends AbstractAction {

        public AzioneCerca() {
            this.putValue(NAME, "Cerca concorso");
            this.putValue(SHORT_DESCRIPTION, "Cerca un concorso in base alla regione e il criterio di ordinamento");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_C);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt C"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vista = Applicazione.getIstance().getVistaPrincipale();
            String regione = vista.getCampoRegione();
            boolean criterioDataCrescente = vista.getDataCrescente();
            boolean criterioNumeroPostiDecrescente = vista.getNumeroPostiDecrescente();
            if (regione.isEmpty()) {
                Applicazione.getIstance().getFrame().getErrore("Inserire una regione prima di continuare");
                return;
            }
            String criterio = "";
            if (criterioDataCrescente) {
                criterio = Costanti.CRITERIO_DATA_CRESCENTE;
            }
            if (criterioNumeroPostiDecrescente) {
                criterio = Costanti.CRITERIO_POSTI_DECRESCENTE;
            }
            Archivio archivio = (Archivio) Applicazione.getIstance().getModello().getBean(Costanti.ARCHVIO);
            List<Concorso> listaFiltrata = archivio.cercaConcorsoPerRegione(regione, criterio);
            if (listaFiltrata.isEmpty()) {
                Applicazione.getIstance().getFrame().getMessaggio("Nessun concorso attivo per la regione inserita");
                return;
            }
            Applicazione.getIstance().getModello().putBean(Costanti.LISTA_FILTRATA, listaFiltrata);
            vista.aggiornaTabella();
        }
    }
}