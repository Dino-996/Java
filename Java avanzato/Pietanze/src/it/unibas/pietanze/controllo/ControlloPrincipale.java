package it.unibas.pietanze.controllo;

import it.unibas.pietanze.Applicazione;
import it.unibas.pietanze.modello.Archivio;
import it.unibas.pietanze.modello.Costanti;
import it.unibas.pietanze.modello.Pietanza;
import it.unibas.pietanze.vista.VistaPrincipale;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;

public class ControlloPrincipale {

    private final Action azioneCerca = new AzioneCerca();
    private final Action azioneVerifica = new AzioneVerifica();

    public Action getAzioneCerca() {
        return this.azioneCerca;
    }
    
    public Action getAzioneVerifica() {
        return this.azioneVerifica;
    }

    private class AzioneCerca extends AbstractAction {

        public AzioneCerca() {
            putValue(NAME, "Cerca pietanza");
            putValue(SHORT_DESCRIPTION, "Cerca pietanze per categoria");
            putValue(MNEMONIC_KEY, KeyEvent.VK_C);
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt C"));
            setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vista = Applicazione.getIstance().getVista();
            String categoria = vista.getComboCategoria();
            if (categoria.isEmpty()) {
                Applicazione.getIstance().getFrame().getErrore("Scegliere una categoria prima di continuare");
                return;
            }
            Archivio archivio = (Archivio) Applicazione.getIstance().getModello().getBean(Costanti.ARCHIVIO);
            List<Pietanza> listaFiltrata = archivio.cercaPerCategoria(categoria);
            Applicazione.getIstance().getModello().putBean(Costanti.LISTA_FILTRATA, listaFiltrata);
            vista.aggiornaTabella();
        }
    }

    private class AzioneVerifica extends AbstractAction {

        public AzioneVerifica() {
            putValue(NAME, "Cerca pietanza caloricamente simile");
            putValue(SHORT_DESCRIPTION, "Cerca la pietanza più vicina come numero di calorie, in valore assoluto, a quella selezionata");
            putValue(MNEMONIC_KEY, KeyEvent.VK_X);
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt X"));
            setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vista = Applicazione.getIstance().getVista();
            int rigaSelezionata = vista.getRigaSelezionata();
            if (rigaSelezionata == -1) {
                Applicazione.getIstance().getFrame().getErrore("Selezionare una pietanza prima di continuare");
                return;
            }
            List<Pietanza> listaFiltrata = (List<Pietanza>) Applicazione.getIstance().getModello().getBean(Costanti.LISTA_FILTRATA);
            Pietanza pietanzaSelezionata = listaFiltrata.get(rigaSelezionata);
            Applicazione.getIstance().getModello().putBean(Costanti.PIETANZA_SELEZIONATA, pietanzaSelezionata);
            Archivio archivio = (Archivio) Applicazione.getIstance().getModello().getBean(Costanti.ARCHIVIO);
            Pietanza pietanzaSimile = archivio.cercaPietanzaCaloricamenteSimile(pietanzaSelezionata);
            if (pietanzaSimile == null) {
                Applicazione.getIstance().getFrame().getErrore("Non esiste alcuna pietanza simile");
                return;
            }
            Applicazione.getIstance().getFrame().getMessaggio("La pietanza piu' simile a " + pietanzaSelezionata.getNome() + " e' " + pietanzaSimile.getNome());
        }
    }
}
