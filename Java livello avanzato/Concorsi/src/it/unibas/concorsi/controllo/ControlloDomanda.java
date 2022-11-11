package it.unibas.concorsi.controllo;

import it.unibas.concorsi.Applicazione;
import it.unibas.concorsi.modello.Archivio;
import it.unibas.concorsi.modello.Concorso;
import it.unibas.concorsi.modello.Costanti;
import it.unibas.concorsi.modello.Domanda;
import it.unibas.concorsi.vista.VistaDomanda;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.AbstractAction;
import javax.swing.Action;
import static javax.swing.Action.ACCELERATOR_KEY;
import static javax.swing.Action.MNEMONIC_KEY;
import static javax.swing.Action.NAME;
import static javax.swing.Action.SHORT_DESCRIPTION;
import javax.swing.KeyStroke;

public class ControlloDomanda {

    private final Action azioneAggiungiDomanda = new AzioneAggiungiDomanda();

    public Action getAzioneAggiungiDomanda() {
        return this.azioneAggiungiDomanda;
    }

    private class AzioneAggiungiDomanda extends AbstractAction {

        public AzioneAggiungiDomanda() {
            this.putValue(NAME, "Aggiungi domanda");
            this.putValue(SHORT_DESCRIPTION, "Aggiungi una nuova domanda al concorso selezionato");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_A);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt A"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaDomanda vista = Applicazione.getIstance().getVistaDomanda();
            String codiceFiscale = vista.getCodiceFiscale();
            String sesso = vista.getComboSesso();
            String giorno = vista.getCampoGiorno();
            String mese = vista.getCampoMese();
            String anno = vista.getCampoAnno();
            String convalida = errori(codiceFiscale, sesso, giorno, mese, anno);
            if (!convalida.isEmpty()) {
                Applicazione.getIstance().getFrame().getErrore(convalida);
                return;
            }
            int interoGiorno = Integer.parseInt(giorno);
            int interoMese = Integer.parseInt(mese);
            int interoAnno = Integer.parseInt(anno);
            Calendar dataUtente = new GregorianCalendar(interoAnno, interoMese - 1, interoGiorno);
            Concorso concorsoSelezionato = (Concorso) Applicazione.getIstance().getModello().getBean(Costanti.CONCORSO_SELEZIONATO);
            Archivio archivio = (Archivio) Applicazione.getIstance().getModello().getBean(Costanti.ARCHVIO);
            if (concorsoSelezionato.verificaDuplicati(codiceFiscale)) {
                Applicazione.getIstance().getFrame().getErrore("Domanda gia' presentata per il concorso scelto");
                return;
            }
            Domanda domanda = new Domanda(codiceFiscale, sesso, dataUtente);
            if (archivio.verificaDuplicati(concorsoSelezionato, domanda)) {
                Applicazione.getIstance().getFrame().getMessaggio("Partecipazione impossibile: Inserire un nuovo codice fiscale");
                return;
            }
            concorsoSelezionato.addDomanda(domanda);
            vista.aggiornaTabella();
        }

        private String errori(String codiceFiscale, String sesso, String giorno, String mese, String anno) {
            StringBuilder error = new StringBuilder();
            if (codiceFiscale.isEmpty()) {
                error.append("Inserire un codice fiscale").append("\n");
            } else if (codiceFiscale.length() < 6 || codiceFiscale.length() > 6) {
                error.append("Il codice fiscale inserito deve essere essattamente di 6 caratteri").append("\n");
            }
            if (sesso.isEmpty()) {
                error.append("Scegliere un sesso").append("\n");
            }
            try {
                int interoGiorno = Integer.parseInt(giorno);
                int interoMese = Integer.parseInt(mese);
                int interoAnno = Integer.parseInt(anno);
                Calendar dataOggi = new GregorianCalendar();
                Calendar calendar = new GregorianCalendar();
                calendar.setLenient(false);
                calendar.set(interoAnno, interoMese - 1, interoGiorno);
                calendar.getTime();
                if (calendar.getTime().after(dataOggi.getTime())) {
                    error.append("La data inserita non puo' essere nel futuro").append("\n");
                }
                if (calendar.getTime().before(dataOggi.getTime())) {
                    error.append("La data inserita non puo' essere nel passato").append("\n");
                }
            } catch (IllegalArgumentException e) {
                error.append("Formato data non valido").append("\n");
            }
            return error.toString().trim();
        }
    }
}
