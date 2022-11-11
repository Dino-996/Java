package it.unibas.anagrafica.controllo;

import it.unibas.anagrafica.Applicazione;
import it.unibas.anagrafica.modello.Archivio;
import it.unibas.anagrafica.modello.Azienda;
import it.unibas.anagrafica.modello.Costanti;
import it.unibas.anagrafica.modello.Dipendente;
import it.unibas.anagrafica.vista.VistaDipendente;
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

public class ControlloDipendente {

    private final Action azioneAggiungi = new AzioneAggiungi();

    public Action getAzioneAggiungi() {
        return azioneAggiungi;
    }

    private class AzioneAggiungi extends AbstractAction {

        public AzioneAggiungi() {
            putValue(NAME, "Aggiungi");
            putValue(SHORT_DESCRIPTION, "Aggiungi dipendente");
            putValue(MNEMONIC_KEY, KeyEvent.VK_A);
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt A"));

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaDipendente vista = Applicazione.getIstance().getVistaDipendente();
            String codiceFiscale = vista.getCampoCodiceFiscale();
            String nome = vista.getNome();
            String cognome = vista.getCognome();
            String sesso = vista.getComboSesso();
            String giorno = vista.getGiorno();
            String mese = vista.getCampoMese();
            String anno = vista.getCampoAnno();
            String convalida = errori(codiceFiscale, nome, cognome, sesso, giorno, mese, anno);
            if (!convalida.isEmpty()) {
                Applicazione.getIstance().getFrame().getErrore(convalida);
                return;
            }
            int interoGiorno = Integer.parseInt(giorno);
            int interoMese = Integer.parseInt(mese);
            int interoAnno = Integer.parseInt(anno);
            Calendar dataUtente = new GregorianCalendar(interoGiorno, interoMese - 1, interoAnno);
            Dipendente dipendente = new Dipendente(codiceFiscale, nome, cognome, dataUtente, sesso);
            Archivio archivio = (Archivio) Applicazione.getIstance().getModello().getBean(Costanti.ARCHIVIO_STRING);
            if (archivio.verificaDuplicati(dipendente)) {
                Applicazione.getIstance().getFrame().getErrore("Per il concorso selezionato esiste già una domanda con lo stesso codice fiscale");
                return;
            }
            Azienda aziendaSelezionata = (Azienda) Applicazione.getIstance().getModello().getBean(Costanti.AZIENDA_SELEZIONATA);
            aziendaSelezionata.addDipendente(dipendente);
            vista.aggiornaTabella();
        }

        private String errori(String codiceFiscale, String nome, String cognome, String sesso, String giorno, String mese, String anno) {
            StringBuilder sb = new StringBuilder();
            if (codiceFiscale.isEmpty()) {
                sb.append("Inserire il codice fiscale").append("\n");
            }
            if (nome.isEmpty()) {
                sb.append("Inserire il nome").append("\n");
            }
            if (cognome.isEmpty()) {
                sb.append("Inserire il cognome").append("\n");
            }
            if (sesso.isEmpty()) {
                sb.append("Inserire il sesso").append("\n");
            }
            try {
                int interoGiorno = Integer.parseInt(giorno);
                int interoMese = Integer.parseInt(mese);
                int interoAnno = Integer.parseInt(anno);
                Calendar calendar = new GregorianCalendar();
                calendar.setLenient(false);
                calendar.set(interoAnno, interoMese - 1, interoGiorno);
                calendar.getTime();
            } catch (IllegalArgumentException e) {
                sb.append("Formato data non valido").append("\n");
            }
            return sb.toString().trim();
        }

    }
}
