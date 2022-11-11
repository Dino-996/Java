package it.unibas.pagina.controllo;

import it.unibas.pagina.Applicazione;
import it.unibas.pagina.modello.Archivio;
import it.unibas.pagina.modello.Costanti;
import it.unibas.pagina.modello.PaginaWeb;
import it.unibas.pagina.vista.VistaPrincipale;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import static javax.swing.Action.ACCELERATOR_KEY;
import static javax.swing.Action.MNEMONIC_KEY;
import static javax.swing.Action.NAME;
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
    
    private class AzioneSeleziona extends AbstractAction {

        public AzioneSeleziona() {
            this.putValue(NAME, "Visualizza annotazioni");
            this.putValue(SHORT_DESCRIPTION, "Visualizza annotazioni pagina web");
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt V"));
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_V);
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vista = Applicazione.getIstance().getVistaPrincipale();
            int rigaSelezionata = vista.rigaSelezionata();
            if (rigaSelezionata==-1) {
                Applicazione.getIstance().getFrame().getErrore("Selezionare una pagina web");
                return;
            }
            List<PaginaWeb> listaFiltrata = (List<PaginaWeb>) Applicazione.getIstance().getModello().getBean(Costanti.LISTA_FILTRATA);
            PaginaWeb paginaSelezionata = listaFiltrata.get(rigaSelezionata);
            Applicazione.getIstance().getModello().putBean(Costanti.PAGINA_SELEZIONATA, paginaSelezionata);
            Applicazione.getIstance().getVistaAnnotazioni().visualizza();
        }
    }

    private class AzioneCerca extends AbstractAction {

        public AzioneCerca() {
            this.putValue(NAME, "Cerca in archivio");
            this.putValue(SHORT_DESCRIPTION, "Cerca pagina web");
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt X"));
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_X);
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vista = Applicazione.getIstance().getVistaPrincipale();
            String indirizzo = vista.getIndirizzo();
            if (indirizzo.isEmpty()) {
                Applicazione.getIstance().getFrame().getErrore("Il campo di ricerca e' vuoto, riprova");
                return;
            }
            Archivio archivio = (Archivio) Applicazione.getIstance().getModello().getBean(Costanti.ARCHIVIO);
            List<PaginaWeb> listaFiltrata = archivio.cercaPagineWeb(indirizzo);
            if (listaFiltrata.isEmpty()) {
                Applicazione.getIstance().getFrame().getMessaggio("L'indirizzo inserito non ha prodotto nessun risultato");
                return;
            }
            Applicazione.getIstance().getModello().putBean(Costanti.LISTA_FILTRATA, listaFiltrata);
            vista.aggiornaTabella();
        }

    }
}
