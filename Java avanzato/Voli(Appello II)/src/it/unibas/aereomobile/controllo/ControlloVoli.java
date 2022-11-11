package it.unibas.aereomobile.controllo;

import it.unibas.aereomobile.Applicazione;
import it.unibas.aereomobile.modello.Aereomobile;
import it.unibas.aereomobile.modello.Costanti;
import it.unibas.aereomobile.modello.Volo;
import it.unibas.aereomobile.vista.VistaVoli;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;

public class ControlloVoli {

    private final Action azioneAggiungiVolo = new AzioneAggiungiVolo();

    public Action getAzioneAggiungiVolo() {
        return azioneAggiungiVolo;
    }

    private class AzioneAggiungiVolo extends AbstractAction {

        public AzioneAggiungiVolo() {
            this.putValue(NAME, "Aggiungi volo");
            this.putValue(SHORT_DESCRIPTION, "Aggiungi un nuovo volo");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_A);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt A"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaVoli vista = Applicazione.getIstance().getVistaVoli();
            String ore = vista.getOre();
            String minuti = vista.getMinuti();
            String giorno = vista.getGiorno();
            String mese = vista.getMese();
            String anno = vista.getAnno();
            String aereoportoPartenza = vista.getAereoportoPartenza();
            String aereoportoDestinazione = vista.getAereoportoDestinazione();
            String durataVolo = vista.getDurataVolo();
            String convalida = errori(aereoportoPartenza, aereoportoDestinazione, durataVolo, giorno, mese, anno, ore, minuti);
            if (!convalida.isEmpty()) {
                Applicazione.getIstance().getFrame().getErrore(convalida);
                return;
            }
            Calendar dataOggi = Calendar.getInstance();
            int interoDurataVolo = Integer.parseInt(durataVolo);
            int interoGiorno = Integer.parseInt(giorno);
            int interoMese = Integer.parseInt(mese);
            int interoAnno = Integer.parseInt(anno);
            int interoOre = Integer.parseInt(ore);
            int interoMinuti = Integer.parseInt(minuti);
            Calendar calendarioUtente = new GregorianCalendar(interoAnno, interoMese - 1, interoGiorno, interoOre, interoMinuti);
            Aereomobile aereomobileSelezionato = (Aereomobile) Applicazione.getIstance().getModello().getBean(Costanti.AEREOMOBILE_SELEZIONATO);
            if (calendarioUtente.before(dataOggi)) {
                Applicazione.getIstance().getFrame().getMessaggio("La data del nuovo volo non puo' essere nel passato. Riprova!");
                return;
            }
            if (verificaManutenzioneAnnuale(aereomobileSelezionato, calendarioUtente)) {
                Applicazione.getIstance().getFrame().getErrore("<html><b>L'ultima manutenzione e' stata eseguita piu' di un anno prima del volo inserito</b></html>");
                return;
            }
            if (verificaManutenzioneSemestrale(aereomobileSelezionato, calendarioUtente)) {
                Applicazione.getIstance().getFrame().getMessaggio("L'ultima manutenzione e' stata eseguita piu' di sei mesi prima del volo inserito");
            }
            aereomobileSelezionato.addVolo(new Volo(calendarioUtente, aereoportoPartenza, aereoportoDestinazione, interoDurataVolo));
            vista.aggiornaTabella();
        }

        private String errori(String aereoportoPartenza, String aereoportoDestinazione, String durataVolo, String giorno, String mese, String anno, String ore, String minuti) {
            StringBuilder sb = new StringBuilder();
            if (aereoportoPartenza.isEmpty()) {
                sb.append("Inserire un aereoporto di partenza").append("\n");
            }
            if (aereoportoDestinazione.isEmpty()) {
                sb.append("Inserire un aereoporto di destinazione").append("\n");
            }
            if (durataVolo.isEmpty()) {
                sb.append("Durata del volo").append("\n");
            } else {
                try {
                    int interoDurataVolo = Integer.parseInt(durataVolo);
                    if (interoDurataVolo <= 0) {
                        sb.append("La durata del volo non puo' durare 0 minuti o meno").append("\n");
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
                Calendar calendar = new GregorianCalendar();
                calendar.setLenient(false);
                calendar.set(interoAnno, interoMese - 1, interoGiorno, interoOre, interoMinuti);
                calendar.getTime();
            } catch (IllegalArgumentException e) {
                sb.append("Formato data non valido").append("\n");
            }
            return sb.toString().trim();
        }

        private boolean verificaManutenzioneAnnuale(Aereomobile aereomobile, Calendar dataVoloInserita) {
            Calendar ultimaManutenzione = new GregorianCalendar();
            ultimaManutenzione.setTime(aereomobile.getDataUltimaManutenzione().getTime());
            ultimaManutenzione.add(Calendar.YEAR, +1);
            return ultimaManutenzione.getTime().before(dataVoloInserita.getTime());
        }

        private boolean verificaManutenzioneSemestrale(Aereomobile aereomobile, Calendar dataVoloInserita) {
            Calendar ultimaManutenzione = new GregorianCalendar();
            ultimaManutenzione.setTime(aereomobile.getDataUltimaManutenzione().getTime());
            ultimaManutenzione.add(Calendar.MONTH, +6);
            return ultimaManutenzione.getTime().before(dataVoloInserita.getTime());
        }
    }
}
