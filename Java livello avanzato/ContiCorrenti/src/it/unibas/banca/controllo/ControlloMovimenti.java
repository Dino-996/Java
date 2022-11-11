package it.unibas.banca.controllo;

import it.unibas.banca.Applicazione;
import it.unibas.banca.modello.Conto;
import it.unibas.banca.modello.Costanti;
import it.unibas.banca.modello.Movimento;
import it.unibas.banca.vista.VistaMovimenti;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;

public class ControlloMovimenti {

    private final Action azioneAggiungi = new AzioneAggiungi();

    public Action getAzioneAggiungi() {
        return azioneAggiungi;
    }

    private class AzioneAggiungi extends AbstractAction {

        public AzioneAggiungi() {
            putValue(NAME, "Aggiungi");
            putValue(SHORT_DESCRIPTION, "Aggiungi movimento al conto corrente");
            putValue(MNEMONIC_KEY, KeyEvent.VK_G);
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt G"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaMovimenti vista = Applicazione.getInstance().getVistaMovimenti();
            String giorno = vista.getGiorno();
            String mese = vista.getMese();
            String anno = vista.getAnno();
            String ore = vista.getOra();
            String minuti = vista.getMinuti();
            String importo = vista.getCampoImporto();
            String tipologia = vista.getComboTipologia();
            String convalida = errori(importo, tipologia, giorno, mese, anno, ore, minuti);
            if (!convalida.isEmpty()) {
                Applicazione.getInstance().getFrame().getError(convalida);
                return;
            }
            double interoImporto = Double.parseDouble(importo);
            int interoGiorno = Integer.parseInt(giorno);
            int interoMese = Integer.parseInt(mese);
            int interoAnno = Integer.parseInt(anno);
            int interoOre = Integer.parseInt(ore);
            int interoMinuti = Integer.parseInt(minuti);
            Calendar dataUtente = new GregorianCalendar(interoAnno, interoMese - 1, interoGiorno, interoOre, interoMinuti);
            //Creo un oggetto date per estrarre l'ora e i minuti della data che inserisce l'utente
            Date oraMinuti = new Date();
            oraMinuti.setTime(dataUtente.get(Calendar.HOUR_OF_DAY) + dataUtente.get(Calendar.MINUTE));
            //Creo un oggetto date dell'orario di chiusura
            Date chiusura = new Date();
            chiusura.setTime(20 + 30);
            //Creo un oggetto date dell'orario di apertura
            Date apertura = new Date();
            apertura.setTime(8 + 30);
            if (dataUtente.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || dataUtente.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                Applicazione.getInstance().getFrame().getError("La banca e' aperta dal lunedi al venerdi dalle 08:30 alle 20:30");
                return;
            }
            Calendar dataOggi = new GregorianCalendar();
            int lunedi = dataOggi.get(Calendar.MONDAY);
            int venerdi = dataOggi.get(Calendar.FRIDAY);
            if (dataUtente.get(Calendar.DAY_OF_WEEK) <  lunedi || dataUtente.get(Calendar.DAY_OF_WEEK) > venerdi) {
                if (oraMinuti.before(apertura) || oraMinuti.after(chiusura)) {
                Applicazione.getInstance().getFrame().getError("La banca e' aperta dal lunedi al venerdi dalle 08:30 alle 20:30");
                return;
                }
            }
            Conto conto = (Conto) Applicazione.getInstance().getModello().getBeans(Costanti.CONTO_SELEZIONATO);
            Movimento movimento = new Movimento(dataUtente, interoImporto, tipologia);
            conto.addMovimento(movimento);
            vista.aggiornaTabella();
        }

        private String errori(String importo, String tipologia, String giorno, String mese, String anno, String ore, String minuti) {
            StringBuilder sb = new StringBuilder();
            if (importo.isEmpty()) {
                sb.append("L'importo non puo' essere vuoto").append("\n");
            } else {
                try {
                    double interoImporto = Double.parseDouble(importo);
                    if (interoImporto < 0) {
                        sb.append("L'importo non puo' essere negativo").append("\n");
                    }
                } catch (NumberFormatException e) {
                    sb.append("Formato importo non valido").append("\n");;
                }
            }
            if (tipologia.isEmpty()) {
                sb.append("La tipologia non puo' essere vuota").append("\n");;
            }
            try {
                int interoGiorno = Integer.parseInt(giorno);
                int interoMese = Integer.parseInt(mese);
                int interoAnno = Integer.parseInt(anno);
                int interoOre = Integer.parseInt(ore);
                int interoMinuti = Integer.parseInt(minuti);
                Calendar calendar = new GregorianCalendar();
                calendar.setLenient(false);
                calendar.set(interoAnno, interoMese - 1, interoGiorno, interoOre, interoOre, interoMinuti);
                calendar.getTime();
            } catch (IllegalArgumentException e) {
                sb.append("Formato importo non valido").append("\n");;
            }
            return sb.toString().trim();
        }
    }
}
