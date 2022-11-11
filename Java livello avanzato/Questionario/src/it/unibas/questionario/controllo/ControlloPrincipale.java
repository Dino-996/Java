package it.unibas.questionario.controllo;

import it.unibas.questionario.Applicazione;
import it.unibas.questionario.modello.Archivio;
import it.unibas.questionario.modello.Costanti;
import it.unibas.questionario.modello.Questionario;
import it.unibas.questionario.vista.VistaPrincipale;
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
    private final Action azioneVerifica = new AzioneVerifica();

    public Action getAzioneCerca() {
        return this.azioneCerca;
    }

    public Action getAzioneVerifica() {
        return this.azioneVerifica;
    }

    private class AzioneVerifica extends AbstractAction {

        public AzioneVerifica() {
            putValue(NAME, "Verifica questionario");
            putValue(SHORT_DESCRIPTION, "Verifica se i risultati sono stati inseriti in ordine crescente di tempo");
            putValue(MNEMONIC_KEY, KeyEvent.VK_X);
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt X"));
            setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vista = Applicazione.getIstance().getVistaPrincipale();
            int rigaSelezionata = vista.getRigaSelezionata();
            if (rigaSelezionata == -1) {
                Applicazione.getIstance().getFrame().getErrore("Selezionare un questionario prima di continuare");
                return;
            }
            List<Questionario> listaFiltrata = (List<Questionario>) Applicazione.getIstance().getModello().getBeans(Costanti.LISTA_FILTRATA);
            Questionario questionarioSelezionato = listaFiltrata.get(rigaSelezionata);
            Applicazione.getIstance().getModello().putBeans(Costanti.QUESTIONARIO_SELEZIONATO, questionarioSelezionato);
            Archivio archivio = (Archivio) Applicazione.getIstance().getModello().getBeans(Costanti.ARCHIVIO);
            int crescente = questionarioSelezionato.contaOccorrenze(questionarioSelezionato);
            if (crescente > 1) {
                Applicazione.getIstance().getFrame().getMessaggio("I risultati sono stati inseriti in ordine crescente di tempo");
            } else {
                Applicazione.getIstance().getFrame().getMessaggio("I risultati NON sono stati inseriti in ordine crescente di tempo");
            }
        }
    }

    private class AzioneCerca extends AbstractAction {

        public AzioneCerca() {
            putValue(NAME, "Cerca questionario");
            putValue(SHORT_DESCRIPTION, "Cerca questionario in base a un argomento e difficolta'");
            putValue(MNEMONIC_KEY, KeyEvent.VK_C);
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt C"));
            setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vista = Applicazione.getIstance().getVistaPrincipale();
            String difficolta = vista.getDifficolta();
            String categoria = vista.getComboCategoria();
            String convalida = errori(difficolta, categoria);
            if (!convalida.isEmpty()) {
                Applicazione.getIstance().getFrame().getErrore(convalida);
                return;
            }
            int interoDifficolta = Integer.parseInt(difficolta);
            Archivio archivio = (Archivio) Applicazione.getIstance().getModello().getBeans(Costanti.ARCHIVIO);
            List<Questionario> listaFiltrata = archivio.cercaQuestionario(categoria, interoDifficolta);
            if (listaFiltrata.isEmpty()) {
                Applicazione.getIstance().getFrame().getErrore("Nessun questionario trovato per i parametri inseriti");
                return;
            }
            Applicazione.getIstance().getModello().putBeans(Costanti.LISTA_FILTRATA, listaFiltrata);
            vista.aggiornaTabella();
        }

        private String errori(String difficolta, String categoria) {
            StringBuilder errori = new StringBuilder();
            if (difficolta.isEmpty()) {
                errori.append("Inserisci una difficolta'").append("\n");
            } else {
                try {
                    int interoDifficolta = Integer.parseInt(difficolta);
                    if (interoDifficolta < 1 || interoDifficolta > 5) {
                        errori.append("Inserire una difficolta' compresa tra 0 e 5").append("\n");
                    }
                } catch (NumberFormatException e) {
                    errori.append("Formato difficolta' non valido").append("\n");
                }
            }
            if (categoria.isEmpty()) {
                errori.append("Inserisci una categoria").append("\n");
            }
            return errori.toString().trim();
        }
    }
}
