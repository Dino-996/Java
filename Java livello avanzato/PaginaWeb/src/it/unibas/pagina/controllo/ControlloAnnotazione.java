package it.unibas.pagina.controllo;

import it.unibas.pagina.Applicazione;
import it.unibas.pagina.modello.Annotazione;
import it.unibas.pagina.modello.Costanti;
import it.unibas.pagina.modello.PaginaWeb;
import it.unibas.pagina.vista.VistaAnnotazioni;
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

public class ControlloAnnotazione {

    private final Action azioneAggiungi = new AggiungiAnnotazione();

    public Action getAzioneAggiungi() {
        return azioneAggiungi;
    }

    private class AggiungiAnnotazione extends AbstractAction {

        public AggiungiAnnotazione() {
            this.putValue(NAME, "Aggiungi annotazione");
            this.putValue(SHORT_DESCRIPTION, "Aggingi una nuova annotazione");
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt G"));
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_G);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaAnnotazioni vista = Applicazione.getIstance().getVistaAnnotazioni();
            String parolaInizio = vista.getParolaInizio();
            String parolaFine = vista.getParolaFine();
            String colore = vista.getComboColore();
            String giorno = vista.getGiorno();
            String mese = vista.getMese();
            String anno = vista.getAnno();
            String ore = vista.getOre();
            String minuti = vista.getMinuti();
            String convalida = errori(parolaInizio, parolaFine, colore, giorno, mese, anno, ore, minuti);
            if (!convalida.isEmpty()) {
                Applicazione.getIstance().getFrame().getErrore(convalida);
                return;
            }
            int interoParolaInizio = Integer.parseInt(parolaInizio);
            int interoParolaFine = Integer.parseInt(parolaFine);
            int interoGiorno = Integer.parseInt(giorno);
            int interoMese = Integer.parseInt(mese);
            int interoAnno = Integer.parseInt(anno);
            int interoOre = Integer.parseInt(ore);
            int interoMinuti = Integer.parseInt(minuti);
            GregorianCalendar dataUltimaModifica = new GregorianCalendar(interoAnno, interoMese - 1, interoGiorno, interoOre, interoMinuti);
            PaginaWeb paginaSelezionata = (PaginaWeb) Applicazione.getIstance().getModello().getBean(Costanti.PAGINA_SELEZIONATA);
            //PUNTO3 - Scenario alternativo - Dati scorretti
            if (isCompatibile(paginaSelezionata.getNumeroParole(), interoParolaInizio, interoParolaFine)) {
                Applicazione.getIstance().getFrame().getErrore("Gli indici delle parole non sono compatibili con il numero di parole nel sistema");
                return;
            }
            //PUNTO3 - Scenario alternativo - Data ultimo aggiornamento
            if (isUltimoAggiornamento45giorni(paginaSelezionata.getDataOraUltimoAggiornamento(), dataUltimaModifica)) {
                Applicazione.getIstance().getFrame().getErrore("L'annotazione non puo' essere inserita 45 giorni dopo l'ultimo aggiornamento della pagina web");
                return;
            }
            paginaSelezionata.addAnnotazione(new Annotazione(interoParolaInizio, interoParolaFine, colore, dataUltimaModifica));
            vista.aggiornaTabella();
        }

        private boolean isCompatibile(int numeroParole, int indiceInizio, int indiceFine) {
            if (indiceInizio > numeroParole || indiceFine > numeroParole) {
                return true;
            }
            return indiceInizio > indiceFine;
        }

        private String errori(String parolaInizio, String parolaFine, String colore, String giorno, String mese, String anno, String ore, String minuti) {
            StringBuilder sb = new StringBuilder();
            if (parolaInizio.isEmpty()) {
                sb.append("Inserire la parola di inizio").append("\n");
            } else {
                try {
                    int interoParolaInizio = Integer.parseInt(parolaInizio);
                    if (interoParolaInizio < 0) {
                        sb.append("L'indice della parola di inizio non puo' essere minore di 0").append("\n");
                    }
                } catch (NumberFormatException e) {
                    sb.append("Il valore immesso non e' valido").append("\n");
                }
            }
            if (parolaFine.isEmpty()) {
                sb.append("Inserire la parola di fine").append("\n");
            } else {
                try {
                    int interoParolaFine = Integer.parseInt(parolaFine);
                    if (interoParolaFine <= 0) {
                        sb.append("L'indice della parola di fine non puo' essere minore o uguale a 0").append("\n");
                    }
                } catch (NumberFormatException e) {
                    sb.append("Il valore immesso non e' valido").append("\n");
                }
            }
            if (colore.isEmpty()) {
                sb.append("Seleziona un colore prima di continuare").append("\n");
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

        /**
         * PUNTO3 - Scenario alternativo - Data ultima modifica
         *
         * @param dataModificaPaginaWeb
         * @param dataModificaAnnotazione
         * @return true se l'annotazione e' stata inserita 45 giorni dopo l'ultimo aggiornamento della pagina web
         */
        private boolean isUltimoAggiornamento45giorni(Calendar dataModificaPaginaWeb, GregorianCalendar dataModificaAnnotazione) {
            Calendar calendar = new GregorianCalendar(dataModificaPaginaWeb.get(Calendar.YEAR), dataModificaPaginaWeb.get(Calendar.MONTH), dataModificaPaginaWeb.get(Calendar.DAY_OF_MONTH), dataModificaPaginaWeb.get(Calendar.HOUR), dataModificaPaginaWeb.get(Calendar.MINUTE));
            calendar.add(Calendar.DAY_OF_MONTH, +45);
            return calendar.getTime().before(dataModificaAnnotazione.getTime());
        }
    }
}
