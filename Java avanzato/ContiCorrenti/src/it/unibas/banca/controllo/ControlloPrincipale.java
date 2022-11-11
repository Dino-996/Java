package it.unibas.banca.controllo;

import it.unibas.banca.Applicazione;
import it.unibas.banca.modello.Archivio;
import it.unibas.banca.modello.Conto;
import it.unibas.banca.modello.Costanti;
import it.unibas.banca.vista.VistaPrincipale;
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
    private final Action azioneVisualizza = new AzioneVisualizza();

    public Action getAzioneCerca() {
        return azioneCerca;
    }

    public Action getAzioneVisualizza() {
        return azioneVisualizza;
    }

    private class AzioneVisualizza extends AbstractAction {

        public AzioneVisualizza() {
            putValue(NAME, "Visualizza movimenti");
            putValue(SHORT_DESCRIPTION, "Visualizza movimenti per il conto corrente selezionato");
            putValue(MNEMONIC_KEY, KeyEvent.VK_V);
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt V"));
            setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vista = Applicazione.getInstance().getVistaPrincipale();
            int rigaSelezionata = vista.getRigaSelezionata();
            if (rigaSelezionata == -1) {
                Applicazione.getInstance().getFrame().getError("Selezionare un conto corrente prima di continuare");
                return;
            }
            List<Conto> listaFiltrata = (List<Conto>) Applicazione.getInstance().getModello().getBeans(Costanti.LISTA_FILTRATA);
            Conto contoSelezionato = listaFiltrata.get(rigaSelezionata);
            Applicazione.getInstance().getModello().putBeans(Costanti.CONTO_SELEZIONATO, contoSelezionato);
            Applicazione.getInstance().getVistaMovimenti().visualizza();
        }
    }

    private class AzioneCerca extends AbstractAction {

        public AzioneCerca() {
            putValue(NAME, "Cerca conto corrente");
            putValue(SHORT_DESCRIPTION, "Cerca un conto corrente in base al criterio di ordinamento");
            putValue(MNEMONIC_KEY, KeyEvent.VK_C);
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt C"));
            setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vista = Applicazione.getInstance().getVistaPrincipale();
            boolean ordinamentoDataCrescente = vista.isRadioDataCrescente();
            String criterio;
            if (ordinamentoDataCrescente) {
                criterio = Costanti.ORDINAMENTO_DATA_CRESCENTE;
            } else {
                criterio = Costanti.ORDINAMENTO_INTESTATARIO_CRESCENTE;
            }
            Archivio archivio = (Archivio) Applicazione.getInstance().getModello().getBeans(Costanti.ARCHIVIO);
            List<Conto> listaFiltrata = archivio.cercaContiCorrenti(criterio);
            if (listaFiltrata.isEmpty()) {
                Applicazione.getInstance().getFrame().getMessage("Nessun conto corrente trovato");
                return;
            }
            Applicazione.getInstance().getModello().putBeans(Costanti.LISTA_FILTRATA, listaFiltrata);
            vista.aggiornaTabella();
        }
    }
}
