package it.unibas.aereomobile.controllo;

import it.unibas.aereomobile.Applicazione;
import it.unibas.aereomobile.modello.Aereomobile;
import it.unibas.aereomobile.modello.Archivio;
import it.unibas.aereomobile.modello.Costanti;
import it.unibas.aereomobile.vista.VistaPrincipale;
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

    private class AzioneCerca extends AbstractAction {

        public AzioneCerca() {
            putValue(NAME, "Cerca aereomobile");
            putValue(SHORT_DESCRIPTION, "Cerca aereomobile in base a numero passeggeri e un criterio");
            putValue(MNEMONIC_KEY, KeyEvent.VK_C);
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt C"));
            setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vista = Applicazione.getIstance().getVistaPrincipale();
            String numeroPasseggeri = vista.getNumeroPasseggeri();
            boolean passeggeriCrescente = vista.isPostiCrescente();
            boolean passeggeriDecrescente = vista.isPostiDecrescente();
            boolean tipologiaCrescente = vista.isTipologiaCrescente();
            String convalida = errori(numeroPasseggeri);
            if (!convalida.isEmpty()) {
                Applicazione.getIstance().getFrame().getErrore(convalida);
                return;
            }
            int interoNumeroPasseggeri = Integer.parseInt(numeroPasseggeri);
            String criterio = Costanti.ORDINAMENTO_PASSEGGERI_CERSCENTE;
            if (passeggeriCrescente) {
                criterio = Costanti.ORDINAMENTO_PASSEGGERI_CERSCENTE;
            }
            if (passeggeriDecrescente) {
                criterio = Costanti.ORDINAMENTO_PASSEGGERI_DECRESCENTE;
            }
            else if (tipologiaCrescente) {
                criterio = Costanti.ORDINAMENTO_TIPOLOGIA_CERSCENTE;
            }
            Archivio archivio = (Archivio) Applicazione.getIstance().getModello().getBean(Costanti.ARCHIVIO__STRING);
            List<Aereomobile> listaFiltrata = archivio.cercaAereomobile(interoNumeroPasseggeri, criterio);
            Applicazione.getIstance().getModello().putBean(Costanti.LISTA_FILTRATA, listaFiltrata);
            vista.aggiornaTabella();
        }

        private String errori(String numero) {
            StringBuilder sb = new StringBuilder();
            if (numero.isEmpty()) {
                sb.append("Inserire un numero passeggeri prima di continuare").append("\n");
            } else {
                try {
                    int interoNumero = Integer.parseInt(numero);
                    if (interoNumero <= 0) {
                        sb.append("Inserire un numero maggiore di ").append(interoNumero).append("\n");
                    }
                } catch (NumberFormatException e) {
                    sb.append("Formato numero non valido").append("\n");
                }
            }
            return sb.toString().trim();
        }
    }

    private class AzioneVisualizza extends AbstractAction {

        public AzioneVisualizza() {
            putValue(NAME, "Visualizza voli");
            putValue(SHORT_DESCRIPTION, "Visualizza voli per l'aereomobile selezionato");
            putValue(MNEMONIC_KEY, KeyEvent.VK_I);
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt I"));
            setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vista = Applicazione.getIstance().getVistaPrincipale();
            int rigaSelezionata = vista.getRigaSelezionata();
            if (rigaSelezionata == -1) {
                Applicazione.getIstance().getFrame().getErrore("Selezionare un aereomobile prima di continuare");
                return;
            }
            List<Aereomobile> listaFiltrata = (List<Aereomobile>) Applicazione.getIstance().getModello().getBean(Costanti.LISTA_FILTRATA);
            Aereomobile aereomobileSelezionato = listaFiltrata.get(rigaSelezionata);
            Applicazione.getIstance().getModello().putBean(Costanti.AEREOMOBILE_SELEZIONATO, aereomobileSelezionato);
            Applicazione.getIstance().getVistaVoli().visualizza();
        }
    }
}
