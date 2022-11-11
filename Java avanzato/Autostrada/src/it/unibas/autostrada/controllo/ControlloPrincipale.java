package it.unibas.autostrada.controllo;

import it.unibas.autostrada.Applicazione;
import it.unibas.autostrada.modello.Archivio;
import it.unibas.autostrada.modello.Casello;
import it.unibas.autostrada.modello.Costanti;
import it.unibas.autostrada.vista.VistaPrincipale;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;

public class ControlloPrincipale {

    private final Action azioneCerca = new AzioneCerca();

    public Action getAzioneCerca() {
        return this.azioneCerca;
    }
    
    private class AzioneCerca extends AbstractAction {

        public AzioneCerca() {
            this.putValue(Action.NAME, "Cerca");
            this.putValue(Action.SHORT_DESCRIPTION, "Cerca autostrada in base al nome");
            this.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_C);
            this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt C"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vista = Applicazione.getIstance().getVistaPrincipale();
            String autostradaInserita = vista.getCampoCasello();
            if (autostradaInserita.isEmpty()) {
                Applicazione.getIstance().getFrame().getErrore("Inserire un autostrada prima di continuare");
                return;
            }
            Archivio archivio = (Archivio) Applicazione.getIstance().getModello().getBean(Costanti.ARCHIVIO);
            List<Casello> listaFiltrata = archivio.cercaPerNomeAutostrada(autostradaInserita);
            if (archivio.cercaPerNomeAutostrada(autostradaInserita).isEmpty()) {
                Applicazione.getIstance().getFrame().getErrore("Nessun risultato per l'autostrada inserita");
                return;
            }
            Applicazione.getIstance().getModello().putBean(Costanti.LISTA_FILTRATA, listaFiltrata);
            vista.aggiornaTabella();
        }
    }
}
