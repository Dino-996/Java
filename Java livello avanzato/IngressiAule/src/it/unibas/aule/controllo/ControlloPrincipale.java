package it.unibas.aule.controllo;

import it.unibas.aule.Applicazione;
import it.unibas.aule.modello.Archivio;
import it.unibas.aule.modello.Aula;
import it.unibas.aule.modello.Costanti;
import it.unibas.aule.vista.VistaPrincipale;
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
    private final Action azioneSelezionata = new AzioneSeleziona();

    public Action getAzioneCerca() {
        return azioneCerca;
    }

    public Action getAzioneSelezionata() {
        return azioneSelezionata;
    }

    private class AzioneCerca extends AbstractAction {

        public AzioneCerca() {
            this.putValue(NAME, "Cerca aula");
            this.putValue(SHORT_DESCRIPTION, "Cerca aula in base al piano");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_C);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt C"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vista = Applicazione.getIstance().getVistaPrincipale();
            String piano = vista.getPiano();
            if (piano.isEmpty()) {
                Applicazione.getIstance().getFrame().getErrore("Inseire un piano prima di continuare");
                return;
            }
            int interoPiano = Integer.parseInt(piano);
            try {
                if (interoPiano < 0) {
                    Applicazione.getIstance().getFrame().getErrore("Il piano deve essere un intero positivo");
                    return;
                }
            } catch (NumberFormatException ex) {
                Applicazione.getIstance().getFrame().getErrore("Formato numero non valido");
            }
            Archivio archivio = (Archivio) Applicazione.getIstance().getModello().getBeans(Costanti.ARCHIVIO);
            List<Aula> listaFiltrata = archivio.cercaAulePerPiano(interoPiano);
            if (listaFiltrata.isEmpty()) {
                Applicazione.getIstance().getFrame().getErrore("Nussun aula trovata per il piano immesso");
            }
            Applicazione.getIstance().getModello().putBeans(Costanti.LISTA_FILTRATA, listaFiltrata);
            vista.aggiornaTabella();
        }
    }

    private class AzioneSeleziona extends AbstractAction {

        public AzioneSeleziona() {
            this.putValue(NAME, "Visualizza accessi");
            this.putValue(SHORT_DESCRIPTION, "Visualizza gli accessi effettuati per l'aula selezionata");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_T);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt T"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vista = Applicazione.getIstance().getVistaPrincipale();
            int rigaSelezionata = vista.getRigaSelezionata();
            if(rigaSelezionata == -1) {
                Applicazione.getIstance().getFrame().getErrore("Selezionare un aula prima di continuare");
                return;
            }
            List<Aula> listaFiltrata = (List<Aula>) Applicazione.getIstance().getModello().getBeans(Costanti.LISTA_FILTRATA);
            Aula aulaSelezionata = listaFiltrata.get(rigaSelezionata);
            Applicazione.getIstance().getModello().putBeans(Costanti.AULA_SELEZIONATA, aulaSelezionata);
            Applicazione.getIstance().getVistaAccessi().visualizza();
        }
    }
}
