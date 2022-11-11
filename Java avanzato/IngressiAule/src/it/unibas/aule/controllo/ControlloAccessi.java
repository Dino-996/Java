package it.unibas.aule.controllo;

import it.unibas.aule.Applicazione;
import it.unibas.aule.modello.Accesso;
import it.unibas.aule.modello.Aula;
import it.unibas.aule.modello.Costanti;
import it.unibas.aule.vista.VistaAccessi;
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

public class ControlloAccessi {

    private final Action azioneAggiungi = new AzioneAggiungi();

    public Action getAzioneAggiungi() {
        return azioneAggiungi;
    }

    private class AzioneAggiungi extends AbstractAction {

        public AzioneAggiungi() {
            this.putValue(NAME, "Aggiungi accesso");
            this.putValue(SHORT_DESCRIPTION, "Aggiungi un nuovo accesso in aula");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_A);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt A"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaAccessi vista = Applicazione.getIstance().getVistaAccessi();
            String matricola = vista.getMatricola();
            String nome = vista.getCampoNome();
            String tempoPermanenza = vista.getPermanenza();
            String motivazione = vista.getComboCategoria();
            String giorno = vista.getGiorno();
            String mese = vista.getMese();
            String anno = vista.getAnno();
            String ora = vista.getOre();
            String minuti = vista.getMinuti();
            String errori = convalida(matricola, nome, tempoPermanenza, motivazione, giorno, mese, anno, ora, minuti);
            if (!errori.isEmpty()) {
                Applicazione.getIstance().getFrame().getErrore(errori);
                return;
            }
            double realePermanenza = Double.parseDouble(tempoPermanenza);
            int interoGiorno = Integer.parseInt(giorno);
            int interoMese = Integer.parseInt(mese);
            int interoAnno = Integer.parseInt(anno);
            int interoOra = Integer.parseInt(ora);
            int interoMinuti = Integer.parseInt(minuti);
            int totaleUtente = interoOra + interoMinuti;
            
            Calendar dataOggi = new GregorianCalendar();
            int oraOggi = dataOggi.get(Calendar.HOUR_OF_DAY);
            int minutiOggi = dataOggi.get(Calendar.MINUTE);
            int totaleOggi = oraOggi + minutiOggi;
            
            //Millisecondi della data di oggi
            Date millisecondiDataOggi = new Date();
            millisecondiDataOggi.setTime(totaleOggi);
            
            //Millisecondi della data che ha inserito l'utente
            Date millisecondiDataUtente = new Date();
            millisecondiDataUtente.setTime(totaleUtente);
            
            if (millisecondiDataUtente.after(millisecondiDataOggi)) {
                Applicazione.getIstance().getFrame().getMessaggio("Orario scorretto: l’ora inserita è successiva al momento dell’inserimento");
                return;
            }
            Calendar dataUtente = new GregorianCalendar(interoAnno, interoMese - 1, interoGiorno, interoOra, interoMinuti);
            Aula aulaSelezionata = (Aula) Applicazione.getIstance().getModello().getBeans(Costanti.AULA_SELEZIONATA);
            aulaSelezionata.addAccesso(new Accesso(matricola, nome, realePermanenza, motivazione, dataUtente));
            vista.aggiornaTabella();
        }

        private String convalida(String matricola, String nome, String tempoPermanenza, String motivazione, String giorno, String mese, String anno, String ora, String minuti) {
            StringBuilder er = new StringBuilder();
            if (matricola.isEmpty()) {
                er.append("Inserire una matricola").append("\n");
            }
            if (nome.isEmpty()) {
                er.append("Inserire un nome").append("\n");
            }
            if (tempoPermanenza.isEmpty()) {
                er.append("Inserire un tempo di permanenza").append("\n");
            } else {
                try {
                    double realePermanenza = Double.parseDouble(tempoPermanenza);
                    if (realePermanenza < 0) {
                        er.append("Inserire un numero reale positivo").append("\n");
                    }
                } catch (NumberFormatException e) {
                    er.append("Formato tempo permanenza non valido").append("\n");
                }
            }
            if (motivazione.isEmpty()) {
                er.append("Scegliere una motivazione").append("\n");
            }
            try {
                int interoGiorno = Integer.parseInt(giorno);
                int interoMese = Integer.parseInt(mese);
                int interoAnno = Integer.parseInt(anno);
                int interoOra = Integer.parseInt(ora);
                int interoMinuti = Integer.parseInt(minuti);
                Calendar calendar = new GregorianCalendar();
                calendar.setLenient(false);
                calendar.set(interoAnno, interoMese - 1, interoGiorno, interoOra, interoMinuti);
                calendar.getTime();
            } catch (IllegalArgumentException e) {
                er.append("Formato data scorretto").append("\n");
            }
            return er.toString().trim();
        }
    }
}
