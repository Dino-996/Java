package it.unibas.aereomobile.controllo;

import it.unibas.aereomobile.Applicazione;
import it.unibas.aereomobile.modello.Aereomobile;
import it.unibas.aereomobile.modello.Costanti;
import it.unibas.aereomobile.modello.Volo;
import it.unibas.aereomobile.vista.VistaVoli;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.AbstractAction;
import javax.swing.Action;
import static javax.swing.Action.ACCELERATOR_KEY;
import static javax.swing.Action.MNEMONIC_KEY;
import static javax.swing.Action.NAME;
import static javax.swing.Action.SHORT_DESCRIPTION;
import javax.swing.KeyStroke;

public class ControlloVoli {

    private final Action azioneAggiungi = new AzioneAggiungi();

    public Action getAzioneAggiungi() {
        return azioneAggiungi;
    }

    private class AzioneAggiungi extends AbstractAction {

        public AzioneAggiungi() {
            putValue(NAME, "Aggiungi volo");
            putValue(SHORT_DESCRIPTION, "Aggiungi volo per l'aereomobile selezionato");
            putValue(MNEMONIC_KEY, KeyEvent.VK_A);
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt A"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaVoli vista = Applicazione.getIstance().getVistaVoli();
            String anno = vista.getCampoAnno();
            String giorno = vista.getCampoGiorno();
            String mese = vista.getCampoMese();
            String ore = vista.getCampoOre();
            String minuti = vista.getCampoMinuti();
            String partenza = vista.getCampoPartenza();
            String arrivo = vista.getCampoArrivo();
            String durataVolo = vista.getDurataVolo();
            String convalida = errori(partenza, arrivo, durataVolo, anno, mese, giorno, ore, minuti);
            if (!convalida.isEmpty()) {
                Applicazione.getIstance().getFrame().getErrore(convalida);
                return;
            }
            int interoDurataVolo = Integer.parseInt(durataVolo);
            int interoGiorno = Integer.parseInt(giorno);
            int interoMese = Integer.parseInt(mese);
            int interoAnno = Integer.parseInt(anno);
            int interoOre = Integer.parseInt(ore);
            int interoMinuti = Integer.parseInt(minuti);
            Calendar dataUtente = new GregorianCalendar(interoAnno, interoMese - 1, interoGiorno, interoOre, interoMinuti);
            Aereomobile aereomobileSelezionato = (Aereomobile) Applicazione.getIstance().getModello().getBean(Costanti.AEREOMOBILE_SELEZIONATO);
            if (isUltimaManutenzioneUnAnno(dataUtente, aereomobileSelezionato.getDataUltimaManutenzione())) {
                Applicazione.getIstance().getFrame().getErrore("Errore: L'ultima manutenzione e' stata effettuata piu' di un anno prima della data di partenza");
                return;
            } else if (isUltimaManutenzioneSeiMesi(dataUtente, aereomobileSelezionato.getDataUltimaManutenzione())) {
                Applicazione.getIstance().getFrame().getErrore("Attenzione: L'ultima manutenzione e' stata effettuata piu' di sei mesi prima della data di partenza");
            }
            aereomobileSelezionato.addVolo(new Volo(dataUtente, partenza, arrivo, interoDurataVolo));
            vista.aggiornaTabella();
        }

        private String errori(String partenza, String arrivo, String durataVolo, String anno, String mese, String giorno, String ore, String minuti) {
            StringBuilder sb = new StringBuilder();
            if (partenza.isEmpty()) {
                sb.append("L'aereoporto di partenza e' obligatorio").append("\n");
            }
            if (arrivo.isEmpty()) {
                sb.append("L'aereoporto di arrivo e' obligatorio").append("\n");
            }
            if (durataVolo.isEmpty()) {
                sb.append("La durata del volo e' obligatoria").append("\n");
            } else {
                try {
                    int interoDurataVolo = Integer.parseInt(durataVolo);
                    if (interoDurataVolo <= 0) {
                        sb.append("Inserire una durata maggiore di 0").append("\n");
                    }
                } catch (NumberFormatException e) {
                    sb.append("Formato durata volo non valido").append("\n");
                }
            }
            try {
                int interoGiorno = Integer.parseInt(giorno);
                int interoMese = Integer.parseInt(mese);
                int interoAnno = Integer.parseInt(anno);
                int interoOre = Integer.parseInt(ore);
                int interoMinuti = Integer.parseInt(minuti);
                Calendar calendario = new GregorianCalendar();
                calendario.setLenient(false);
                calendario.set(interoAnno, interoMese - 1, interoGiorno, interoOre, interoMinuti);
                calendario.getTime();
            } catch (IllegalArgumentException e) {
                sb.append("Formato data non valido").append("\n");
            }
            return sb.toString().trim();
        }

        private boolean isUltimaManutenzioneUnAnno(Calendar dataUtente, Calendar ultimaManutenzione) {
            boolean verifica = false;
            Calendar calendar = new GregorianCalendar();
            Date date = new Date();
            date.setTime(ultimaManutenzione.getTimeInMillis());
            calendar.setTime(date);
            calendar.add(Calendar.YEAR, +1);
            if (dataUtente.getTime().after(calendar.getTime())) {
                verifica = true;
            }
            return verifica;
        }

        private boolean isUltimaManutenzioneSeiMesi(Calendar dataUtente, Calendar ultimaManutenzione) {
            boolean verifica = false;
            Calendar calendar = new GregorianCalendar();
            Date date = new Date();
            date.setTime(ultimaManutenzione.getTimeInMillis());
            calendar.setTime(date);
            calendar.add(Calendar.MONTH, +6);
            if (dataUtente.getTime().after(calendar.getTime())) {
                verifica = true;
            }
            return verifica;
        }
    }
}
